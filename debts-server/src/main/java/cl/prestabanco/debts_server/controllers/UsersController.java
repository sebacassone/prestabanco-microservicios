package cl.prestabanco.debts_server.controllers;


import cl.prestabanco.debts_server.entities.UsersEntity;
import cl.prestabanco.debts_server.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/debts/user")
@CrossOrigin("*")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/register-user")
    public ResponseEntity<UsersEntity> registerUser(@RequestBody UsersEntity user) {
        try {
            // the user is saved in database
            UsersEntity response = usersService.saveUser(
                    user
            );

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}

