package com.israeldago.idBanking.controller;

import com.israeldago.idBanking.itf.dtos.UserDTO;
import com.israeldago.idBanking.itf.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "users")
public class RestCTRL {

    @Autowired
    private AuthenticationService authService;

    @GetMapping(path = "/{username}")
    public UserDTO getUserBy(@PathVariable String username) {
        return authService.getUserBy(username);
    }

    @GetMapping(path = "/auth")
    public UserDTO authenticateBy(@RequestParam String username, @RequestParam String password) {
        return authService.authenticateBy(username, password);
    }

}
