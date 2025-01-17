package cl.prestabanco.loans_server.repositories;

import cl.prestabanco.loans_server.entities.LoansEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoansRepository extends JpaRepository<LoansEntity, Integer> {
    @Query(value = "SELECT * FROM loans l INNER JOIN requests r ON l.id_loan = r.id_lean WHERE r.id_request = :idRequest", nativeQuery = true)
    LoansEntity findLoanByIdRequest(@Param("idRequest") Integer id_request);
}
