package com.proyecto.proyectoweb.controller.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.proyectoweb.model.entidad.Producto;
import com.proyecto.proyectoweb.model.servicio.IProductoService;

@Controller
@RequestMapping("/")
public class InicioController {

    @Autowired
    private IProductoService productoService;

    @RequestMapping("")
    public String inicio(){
        return "index";
    }
    //Shop
    @RequestMapping("shop")
    public String tienda(Model model){
        model.addAttribute("listaProductos", productoService.cargarProducto());
        return "shop";
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }
    @RequestMapping("contact")
    public String contactanos(){
        return "contact";
    }
    @PostMapping("cart")
    public String cart(){
        return "cart";
    }
    @RequestMapping("checkout")
    public String checkout(){
        return "checkout";
    }
    @RequestMapping("register")
    public String register(){
        return "register";
    }
    /*@RequestMapping("shop-single")
    public String single(){
        
        return "shop-single";
    }*/
    @RequestMapping("shop-single/{id}")
    public String single(@PathVariable Long id, Model model){
        Producto producto = new Producto();
        Optional<Producto> productoOptional = productoService.get(id);
        producto = productoOptional.get();
        model.addAttribute("producto", producto);
        
        return "shop-single";
    }
    @RequestMapping("thankyou")
    public String thankyou(){
        return "thankyou";
    }
    //SECCION
    @RequestMapping("caballeros")
    public String seccion01(Model model){
        model.addAttribute("listaHombres", productoService.cargarHombres());
        return "seccion/caballeros";
    }
    @RequestMapping("damas")
    public String seccion02(Model model){
        model.addAttribute("listaDamas", productoService.cargarDamas());
        return "seccion/damas";
    }
    @RequestMapping("infantil")
    public String seccion03(Model model){
        model.addAttribute("listaNinos", productoService.cargarNinos());
        return "seccion/infantil";
    }
    //CATEGORIA
    @RequestMapping("zapato")
    public String categoria01(Model model){
        model.addAttribute("listaZapatos", productoService.cargarZapatos());
        return "categoria/zapatos";
    }
    @RequestMapping("zapatilla")
    public String categoria02(Model model){
        model.addAttribute("listaZapatillas", productoService.cargarZapatillas());
        return "categoria/zapatillas";
    }
    @RequestMapping("botines")
    public String categoria03(Model model){
        model.addAttribute("listaBotines", productoService.cargarBotines());
        return "categoria/botines";
    }

    @RequestMapping("dashboard")
    public String dashboard(){
        return "layout/dashboard";
    }
}
