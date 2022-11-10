package com.proyecto.proyectoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {
    @RequestMapping("/")
    public String inicio(){
        return "index";
    }
    //Shop
    @RequestMapping("/shop")
    public String tienda(){
        return "shop";
    }
    @RequestMapping("/shop-page-2")
    public String tienda2(){
        return "shop-page-2";
    }
    @RequestMapping("/shop-page-3")
    public String tienda3(){
        return "shop-page-3";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/contact")
    public String contactanos(){
        return "contact";
    }
    @RequestMapping("/cart")
    public String cart(){
        return "cart";
    }
    @RequestMapping("/checkout")
    public String checkout(){
        return "checkout";
    }
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    @RequestMapping("/shop-single")
    public String single(){
        return "shop-single";
    }
    @RequestMapping("/thankyou")
    public String thankyou(){
        return "thankyou";
    }
    //SECCION
    @RequestMapping("/caballeros")
    public String seccion01(){
        return "seccion/caballeros";
    }
    @RequestMapping("/damas")
    public String seccion02(){
        return "seccion/damas";
    }
    @RequestMapping("/infantil")
    public String seccion03(){
        return "seccion/infantil";
    }
    //CATEGORIA
    @RequestMapping("/zapato")
    public String categoria01(){
        return "categoria/zapatos";
    }
    @RequestMapping("/zapatilla")
    public String categoria02(){
        return "categoria/zapatillas";
    }
    @RequestMapping("/botines")
    public String categoria03(){
        return "categoria/botines";
    }

    @RequestMapping("/dashboard")
    public String dashboard(){
        return "layout/dashboard";
    }
}
