package com.proyecto.proyectoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lista-proveedor")
public class ListaProveedores {
    
    @RequestMapping("/")
    public String inicio(){
        return "proveedor/ListProv";
    }
}
