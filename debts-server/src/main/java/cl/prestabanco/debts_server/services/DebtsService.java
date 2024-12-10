package cl.prestabanco.debts_server.services;

import cl.prestabanco.debts_server.models.DebtsWithMorosityDTO;
import cl.prestabanco.debts_server.repositories.DebtsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class DebtsService {
    private final DebtsRepository debtsRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public DebtsService(DebtsRepository debtsRepository, RestTemplate restTemplate) {
        this.debtsRepository = debtsRepository;
        this.restTemplate = restTemplate;
    }

    public Boolean hasUnpaidDebtsOrMorocities(Integer idUser) {
        if (idUser == null || idUser <= 0) {
            return false;
        }
        // Variable to store the result
        Boolean hasUnpaidDebtsOrMorocities = false;

        // Recover debts without delinquency
        List<DebtsWithMorosityDTO> debtsWithoutMorosity = debtsRepository.findUnpaidDebtsWithoutMorosity(idUser);
        if (debtsWithoutMorosity == null) {
            debtsWithoutMorosity = new ArrayList<>();
        }

        // Recover delinquent debts
        List<DebtsWithMorosityDTO> debtsWithMorosity = debtsRepository.findUnpaidDebtsWithMorosity(idUser);
        if (debtsWithMorosity == null) {
            debtsWithMorosity = new ArrayList<>();
        }

        // Combines both lists
        debtsWithoutMorosity.addAll(debtsWithMorosity);

        if (!debtsWithoutMorosity.isEmpty()) {
            hasUnpaidDebtsOrMorocities = true;
        }

        return hasUnpaidDebtsOrMorocities;
    }

    public Boolean relationDebtsIncome (Integer idUser, Double quota){
        if (idUser <= 0 || quota <= 0){
            return null;
        }
        // Get debts from the user
        Float debtTotal = debtsRepository.getSumAmountDebt(idUser);
        Double avarageSalary = restTemplate.getForObject("http://users-server/api/v1/incomes/average-salary/" + idUser, Double.class);
        if (debtTotal == null) {
            debtTotal = 0f;
        }
        if (avarageSalary == 0) {
            return false;
        }
        return ((debtTotal + quota) / avarageSalary) <= 0.5f;
    }
}
