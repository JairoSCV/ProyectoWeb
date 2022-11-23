package com.proyecto.proyectoweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.proyectoweb.model.entidad.Login;
import com.proyecto.proyectoweb.model.servicio.ILoginService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final Logger log = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private ILoginService loginService;
    
    @RequestMapping("/registro")
    public String create(){
        return "register";
    }

    @PostMapping("/save")
    public String save(Login login){
        log.info("Usuario registro: {}", login);
        login.setCargo("USER");
        loginService.guardarUsuario(login);

        return "redirect:/";
    }
}
