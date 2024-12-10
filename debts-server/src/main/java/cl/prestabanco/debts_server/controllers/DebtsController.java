package cl.prestabanco.debts_server.controllers;

import cl.prestabanco.debts_server.services.DebtsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/debts")
public class DebtsController {

    @Autowired
    private DebtsService debtsService;

    @GetMapping("/has-unpaid-debts-morocities/{idUser}")
    public ResponseEntity<Boolean> hasUnpaidDebtsMorocities(@PathVariable("idUser") Integer idUser) {
        try {
            Boolean response = debtsService.hasUnpaidDebtsOrMorocities(idUser);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/relation-debts-income/{idUser}/{quota}")
    public ResponseEntity<Boolean> relationDebtsIncome(@PathVariable("idUser") Integer idUser, @PathVariable("quota") Double quota) {
        try {
            Boolean response = debtsService.relationDebtsIncome(idUser, quota);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
