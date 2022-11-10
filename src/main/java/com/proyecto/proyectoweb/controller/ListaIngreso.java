package com.proyecto.proyectoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lista-ingresos")
public class ListaIngreso {
    
    @RequestMapping("/")
    public String inicio(){
        return "ingresos/ListIngresos";
    }
}
