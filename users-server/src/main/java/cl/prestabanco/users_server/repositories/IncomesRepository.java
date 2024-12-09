package cl.prestabanco.users_server.repositories;

import cl.prestabanco.users_server.entities.IncomesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncomesRepository extends JpaRepository<IncomesEntity, Integer> {
    List<IncomesEntity> findByJobIncomeUserJobIdUser(Integer idUser);
}

