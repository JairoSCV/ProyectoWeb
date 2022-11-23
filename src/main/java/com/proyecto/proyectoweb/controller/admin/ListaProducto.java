package com.proyecto.proyectoweb.controller.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.proyectoweb.model.entidad.Producto;
import com.proyecto.proyectoweb.model.servicio.ICategoriaService;
import com.proyecto.proyectoweb.model.servicio.IProductoService;
import com.proyecto.proyectoweb.model.servicio.IProveedorService;
import com.proyecto.proyectoweb.model.servicio.ISeccionService;
import com.proyecto.proyectoweb.model.servicio.IStockService;

@Controller
@RequestMapping("/lista-producto")
public class ListaProducto {
    
    @Autowired
    private ICategoriaService categoriaService;
    @Autowired
    private IProductoService productoService;
    @Autowired
    private ISeccionService seccionService;
    @Autowired
    private IProveedorService proveedorService;
    @Autowired
    private IStockService stockService;

    @RequestMapping("/")
    public String inicio(Model model){
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        model.addAttribute("listaProducto", productoService.cargarProducto());
        /*El objeto modelo se crea para enviar datos al controlador*/
        /*Carga las categorías y lo envía a la vista*/
        model.addAttribute("listaCategorias", categoriaService.cargarCategorias());
        model.addAttribute("listaSeccion", seccionService.cargarSeccion());
        model.addAttribute("listaProveedor", proveedorService.cargarProveedor());
        model.addAttribute("listaStock", stockService.cargarStock());
        return "producto/ListProducto";
    }


    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(Producto producto, Model model, RedirectAttributes flash){
        String rpta = productoService.guardarProducto(producto);
        flash.addFlashAttribute("mensaje",rpta);
        return "redirect:/lista-producto/";
    }

    
    @RequestMapping("/editar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model, RedirectAttributes attributes){
        Producto producto = null;
        if(id > 0){
            Optional<Producto> pOptional = productoService.get(id);
            producto = pOptional.get();            
            model.addAttribute("listaCategorias", categoriaService.cargarCategorias());
            model.addAttribute("listaSeccion", seccionService.cargarSeccion());
            model.addAttribute("listaProveedor", proveedorService.cargarProveedor());
            model.addAttribute("listaStock", stockService.cargarStock());
            
            if(producto == null){
                attributes.addFlashAttribute("editar","ATENCION: El ID del producto no existe!");
                return "redirect:/lista-producto/";
            }
        }else{
            attributes.addFlashAttribute("editar", "ATENCION: Error con el ID del producto");
            return "redirect:/lista-producto/";
        }

        model.addAttribute("producto", producto);
        model.addAttribute("listaProducto", productoService.cargarProducto());


        return "producto/ListProducto";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes attributes){
        productoService.delete(id);
        attributes.addFlashAttribute("eliminar", "Producto eliminado exitosamente");
        return "redirect:/lista-producto/";    
    }

}
