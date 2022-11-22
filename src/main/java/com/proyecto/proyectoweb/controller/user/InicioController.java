package com.proyecto.proyectoweb.controller.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.proyectoweb.model.entidad.DetalleVenta;
import com.proyecto.proyectoweb.model.entidad.Producto;
import com.proyecto.proyectoweb.model.entidad.Venta;
import com.proyecto.proyectoweb.model.servicio.IProductoService;

@Controller
@RequestMapping("/")
public class InicioController {

    @Autowired
    private IProductoService productoService;

    private final Logger log = LoggerFactory.getLogger(InicioController.class);

    //Para almacenar los detalles de la orden
    List<Venta> ventas = new ArrayList<Venta>();
    
    //Datos de la Orden
    DetalleVenta detalleVenta = new DetalleVenta();

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
    public String cart(@RequestParam Long id, @RequestParam Integer cantidad, Model model){
        Venta venta = new Venta();
        Producto producto = new Producto();
        double sumatotal = 0;
        
        Optional<Producto> optionalProducto = productoService.get(id);

        producto = optionalProducto.get();

        venta.setCantidad(cantidad);
        venta.setObservacion(producto.getNombre());
        venta.setTalla(producto.getStock().getTalla());
        double precioFinal= Math.round((producto.getPrecio()*cantidad)*100)/100d;
        venta.setMonto(precioFinal);
        venta.setProducto(producto);

        ventas.add(venta);

        sumatotal = ventas.stream().mapToDouble(dt->dt.getMonto()).sum();

        detalleVenta.setMonto_total(sumatotal);
        model.addAttribute("cart", ventas);
        model.addAttribute("orden", detalleVenta);
        return "cart";
    }

    //Quitar producto del carrito
    @RequestMapping("/delete/cart/{id}")
    public String borrarProductoCarrito(@PathVariable Long id, Model model){
        //Lista nueva de productos
        List<Venta> ordenesNueva = new ArrayList<Venta>();

        for(Venta venta: ventas){
            if(venta.getProducto().getId()!=id){
                ordenesNueva.add(venta);
            }
        }

        //poner la nueva lista con los productos restantes
        ventas=ordenesNueva;

        double sumaTotal = 0;
        sumaTotal = ventas.stream().mapToDouble(dt->dt.getMonto()).sum();
        detalleVenta.setMonto_total(sumaTotal);
        model.addAttribute("cart", ventas);
        model.addAttribute("orden", detalleVenta);
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
