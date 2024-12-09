package cl.prestabanco.users_server.services;

import cl.prestabanco.users_server.entities.UsersEntity;
import cl.prestabanco.users_server.repositories.UsersRepository;
import cl.prestabanco.users_server.utils.functions.functions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersEntity saveUser(String rut, String nameUser, String firstLastnameUser, String secondLastnameUser, String emailUser, String phoneUser, String birthdayUser, String statusUser, String passwordUser, String typeUser, Integer idAddress) {
        if (rut == null || nameUser == null || firstLastnameUser == null || secondLastnameUser == null || emailUser == null || phoneUser == null || birthdayUser == null || statusUser == null || passwordUser == null || typeUser == null || idAddress == null) {
            return null;
        } else if (rut.isEmpty() || nameUser.isEmpty() || firstLastnameUser.isEmpty() || secondLastnameUser.isEmpty() || emailUser.isEmpty() || phoneUser.isEmpty() || birthdayUser.isEmpty() || statusUser.isEmpty() || passwordUser.isEmpty() || typeUser.isEmpty() || idAddress <= 0) {
            return null;
        }
        // Create a user object
        UsersEntity user = new UsersEntity();
        user.setRutUser(rut);
        user.setNameUser(nameUser);
        user.setFirstLastnameUser(firstLastnameUser);
        user.setSecondLastnameUser(secondLastnameUser);
        user.setEmailUser(emailUser);
        user.setPhoneUser(phoneUser);
        user.setBirthdayUser(functions.transformStringtoDate(birthdayUser));
        user.setStatusUser(statusUser);
        user.setPasswordUser(passwordUser);
        user.setTypeUser(typeUser);
        user.setIdAddress(idAddress);

        return usersRepository.save(user);

    }

    public UsersEntity findUser(Integer idUser) {
        return usersRepository.findById(idUser).orElse(null);
    }

    public UsersEntity login(String rutUser, String passwordUser) {
        if (rutUser == null || passwordUser == null) {
            return null;
        } else if (rutUser.isEmpty() || passwordUser.isEmpty()) {
            return null;
        }
        return usersRepository.findByRutUserAndPasswordUser(rutUser, passwordUser);
    }

    public Boolean applicantsAge(Integer idUser) {
        Integer age = usersRepository.getAge(idUser);
        return age < 70;
    }
}
