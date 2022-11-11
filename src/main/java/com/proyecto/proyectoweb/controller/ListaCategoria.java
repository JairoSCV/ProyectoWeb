package com.proyecto.proyectoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyecto.proyectoweb.model.entidad.Categoria;
import com.proyecto.proyectoweb.model.servicio.ICategoriaService;

@Controller
@RequestMapping("/lista-categorias")
public class ListaCategoria {
    @Autowired
    private ICategoriaService categoriaService;

    @RequestMapping("/")
    public String inicio(Model model){
        Categoria categoria = new Categoria();
        model.addAttribute("categoria", categoria);
        model.addAttribute("listaCategorias", categoriaService.cargarCategorias());
        return "categorias/ListCategorias";
    }

    @RequestMapping(value = "/formulario", method = RequestMethod.POST)
    public String guardar(Categoria categoria){/*Enviamos esa categoria a la interfaz ICategoriaService, mediante inyeccion de dependencias*/
        categoriaService.guardarCategoria(categoria);
        /*Una vez guardado, redireccionar a /categoria/ */
        return "redirect:/lista-categorias/";
    }

    @RequestMapping("/editar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model){
        /*Crea una categoría en base a la encontrada y la envía al form mediante Model*/
        Categoria categoria = categoriaService.busCategoria(id);
        model.addAttribute("categoria", categoria);
        model.addAttribute("listaCategorias", categoriaService.cargarCategorias());/*devuelva la lista de categorías*/
        return "categorias /ListCategorias";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        /*Crea una categoría en base a la encontrada y la envía al form mediante Model*/
        categoriaService.eliminarCategoria(id);
        return "redirect:/lista-categorias/";
    } 
}

