package com.proyecto.proyectoweb.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lista-venta")
public class ListaVenta {
 
    @RequestMapping("/")
    public String inicio(){
        return "venta/ListVenta";
    }
}
