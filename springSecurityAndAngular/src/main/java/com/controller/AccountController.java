package com.controller;

import com.entities.User;
import com.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("account")
public class AccountController{

        public static final Logger logger = LoggerFactory.getLogger(AccountController.class);


        @Autowired
        private UserService userService;

    /**}
     * controller para guardar nuevos usuarios
     * @param newUser es el nuevo usuario que se guardará validadon si no existe la cuenta
     * @return
     */
        @CrossOrigin
        @RequestMapping(value = "/register", method = RequestMethod.POST)
        public ResponseEntity<?> createUser(@RequestBody User newUser) {
            if (userService.getUserByUserName(newUser.getUsername()) != null) {
                return new ResponseEntity("El nombre de usuario " + newUser.getUsername() + " ya existe", HttpStatus.CONFLICT);
            }
            newUser.setRole("USER");
            return new ResponseEntity<User>(userService.saveUser(newUser), HttpStatus.CREATED);
        }

    /**
     * Controller para el login de usuarios
     * @param principal
     * @return
     */
        @CrossOrigin
        @RequestMapping("/login")
        public Principal user(Principal principal) {
            logger.info("user logged "+principal);
            return principal;
        }

}
