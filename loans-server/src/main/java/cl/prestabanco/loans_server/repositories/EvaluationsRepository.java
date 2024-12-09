package cl.prestabanco.loans_server.repositories;

import cl.prestabanco.loans_server.entities.EvaluationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationsRepository extends JpaRepository<EvaluationsEntity, Integer> {
}

