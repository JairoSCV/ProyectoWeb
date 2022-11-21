package com.proyecto.proyectoweb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String guardar(Categoria categoria, RedirectAttributes attributes){/*Enviamos esa categoria a la interfaz ICategoriaService, mediante inyeccion de dependencias*/
        categoriaService.guardarCategoria(categoria);
        attributes.addFlashAttribute("guardar", "Nueva categoría registrada");
        /*Una vez guardado, redireccionar a /categoria/ */
        return "redirect:/lista-categorias/";
    }

    @RequestMapping("/editar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model, RedirectAttributes attributes){
        /*Crea una categoría en base a la encontrada y la envía al form mediante Model*/

        Categoria categoria = null;
        if(id > 0){
            categoria = categoriaService.busCategoria(id);

            if(categoria == null){
                attributes.addFlashAttribute("editar", "ATENCION: El ID de la categoría no existe!");
                return "redirect:/lista-categorias/";
            }
        }else{
            attributes.addFlashAttribute("editar", "ATENCION: Error con el ID de la categoría!");
            return "redirect:/lista-categorias/";
        }
        
        model.addAttribute("categoria", categoria);
        model.addAttribute("listaCategorias", categoriaService.cargarCategorias());/*devuelva la lista de categorías*/        
        return "categorias/ListCategorias";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes attributes){
        /*Crea una categoría en base a la encontrada y la envía al form mediante Model*/
        categoriaService.eliminarCategoria(id);
        attributes.addFlashAttribute("eliminar", "Categoría eliminada exitosamente");
        return "redirect:/lista-categorias/";
    } 
}

