package cl.prestabanco.loans_server.services;

import cl.prestabanco.loans_server.entities.EvaluationsEntity;
import cl.prestabanco.loans_server.repositories.EvaluationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EvaluationsService {

    private final EvaluationsRepository evaluationsRepository;
    private final LoansService loansService;
    private final RestTemplate restTemplate;

    @Autowired
    public EvaluationsService(EvaluationsRepository evaluationsRepository, RestTemplate restTemplate, LoansService loansService) {
        this.evaluationsRepository = evaluationsRepository;
        this.restTemplate = restTemplate;
        this.loansService = loansService;
    }

    public EvaluationsEntity findEvaluation(Integer id) {
        return evaluationsRepository.findById(id).orElse(null);
    }

    public EvaluationsEntity saveEvaluation(EvaluationsEntity evaluation) {
        if (evaluation == null) {
            return null;
        }
        return evaluationsRepository.save(evaluation);
    }

    public EvaluationsEntity makeEvaluation(Integer idUser, Double quotaLoan, Double maximumAmountPercentage, String typeLoan) {
        // New evaluation
        EvaluationsEntity evaluation = new EvaluationsEntity();

        // Find the user and find the incomes of the user
        String usersUrl = "http://users-server/api/v1";
        String debtsServiceUrl = "http://debts-server/api/v1/debts";
        Double averageSalary = restTemplate.getForObject(usersUrl + "/incomes/avarage-salary/" + idUser, Double.class);
        if (averageSalary == 0.0) {
            return null;
        }

        // Calculate the quota income ratio
        double quotaIncome = quotaLoan / averageSalary * 100;

        Boolean hasUnpaidDebtsOrMorocities = restTemplate.getForObject(debtsServiceUrl + "/has-unpaid-debts-morocities/" + idUser, Boolean.class);
        Boolean seniorityEvaluation = restTemplate.getForObject(usersUrl + "/jobs/has-seniority/" + idUser, Boolean.class);
        Boolean relationDebtsIncome = restTemplate.getForObject(debtsServiceUrl + "/relation-debts-income/" + idUser + "/" + quotaLoan, Boolean.class);
        Boolean maximumFinancingAmount = loansService.maximumFinancingAmount(typeLoan, maximumAmountPercentage);
        Boolean applicantsAge = restTemplate.getForObject(usersUrl + "/user/applicants-age/" + idUser, Boolean.class);

        // Set the evaluation
        evaluation.setQuotaIncomeRatio(quotaIncome <= 35);
        evaluation.setCustomerCredit(Boolean.FALSE.equals(hasUnpaidDebtsOrMorocities));
        evaluation.setSeniorityEvaluation(seniorityEvaluation);
        evaluation.setDebtIncomeRatio(relationDebtsIncome);
        evaluation.setMaximumFinancingAmount(maximumFinancingAmount);
        evaluation.setAgeApplicant(applicantsAge);

        // Save the evaluation
        return saveEvaluation(evaluation);
    }
}
