package com.proyecto.proyectoweb.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/autenticacion")
    public String login(){
        return "login";
    }
}
