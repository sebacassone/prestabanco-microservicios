package cl.prestabanco.loans_server.controllers;

import cl.prestabanco.loans_server.entities.LoansEntity;
import cl.prestabanco.loans_server.services.LoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/loans")
@CrossOrigin("*")
public class LoansController {
    @Autowired
    private LoansService loansService;

    @PostMapping("/calculate-loan")
    public ResponseEntity<LoansEntity> calculateLoan(@RequestBody LoansEntity loan) {
        try {
            LoansEntity response = loansService.calculateLoan(loan);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/save-loan")
    public ResponseEntity<LoansEntity> saveLoan(@RequestBody LoansEntity loan) {
        try {
            System.out.println(loan);
            LoansEntity response = loansService.saveLoan(loan);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/get-loan/{idRequest}")
    public ResponseEntity<LoansEntity> getLoanByIdRequest(@PathVariable("idRequest") Integer idRequest) {
        try {
            LoansEntity response = loansService.getLoanByIdRequest(idRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
