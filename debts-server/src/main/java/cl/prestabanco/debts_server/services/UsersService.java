package cl.prestabanco.debts_server.services;

import cl.prestabanco.debts_server.entities.UsersEntity;
import cl.prestabanco.debts_server.repositories.UsersRepository;
import cl.prestabanco.debts_server.utils.functions.functions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersEntity saveUser(UsersEntity usersEntity) {
        return usersRepository.save(usersEntity);
    }
}
