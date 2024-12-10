package cl.prestabanco.loans_server.models;

import cl.prestabanco.loans_server.entities.EvaluationsEntity;
import cl.prestabanco.loans_server.entities.LoansEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestsWithTypeLoan {
    private Integer idRequest;
    private String stateRequest;
    private String typeLoan;
    private String[] documentsRequired;
    private EvaluationsEntity evaluation;
    private LoansEntity loan;
}
