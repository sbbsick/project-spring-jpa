package com.exemplonelioalves.cursospring.controllers;

import com.exemplonelioalves.cursospring.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User user = new User(1L, "Silas", "silas@ggmail.com", "99999999", "12345");
        return ResponseEntity.ok().body(user);
    }
}
