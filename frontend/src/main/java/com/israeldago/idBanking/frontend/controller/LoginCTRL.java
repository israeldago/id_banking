package com.israeldago.idBanking.frontend.controller;

import com.israeldago.idBanking.backend.common.exceptions.AppException;
import com.israeldago.idBanking.backend.itf.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginCTRL {

    @Autowired
    private AuthenticationService authService;

    @GetMapping("/")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView logMeIn(@RequestParam String username, @RequestParam String password, ModelAndView modelAndView){
        try {
             modelAndView.addObject("loggedIn", authService.authenticateBy(username, password))
                         .setViewName("main");
        }catch (AppException ex){
            modelAndView.addObject("errorMessage", ex.getMessage())
                        .setViewName("login");
        }
        return modelAndView;
    }

}
