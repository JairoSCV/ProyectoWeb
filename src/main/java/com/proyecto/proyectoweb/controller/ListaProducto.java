package com.proyecto.proyectoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lista-producto")
public class ListaProducto {
    
    @RequestMapping("/")
    public String inicio(){
        return "producto/ListProducto";
    }
}
