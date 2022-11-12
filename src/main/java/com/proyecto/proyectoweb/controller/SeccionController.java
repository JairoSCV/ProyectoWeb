package com.proyecto.proyectoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyecto.proyectoweb.model.entidad.Seccion;
import com.proyecto.proyectoweb.model.servicio.ISeccionService;

@Controller
@RequestMapping("/lista-seccion")
public class SeccionController {
    @Autowired
    private ISeccionService seccionService;
    
    @RequestMapping("/")
    public String inicio(Model model){
        Seccion seccion = new Seccion();
        model.addAttribute("seccion", seccion);
        model.addAttribute("listaSeccion", seccionService.cargarSeccion());
        return "secciones/ListSeccion";
    }

      @RequestMapping(value = "/formulario", method = RequestMethod.POST)
      public String guardar(Seccion seccion){
        seccionService.guardarProveedor(seccion);
          return "redirect:/lista-seccion/";
      }
  
      /*Este método recibe la ruta y el ID de: line 71(categoria/index)*/
      @RequestMapping("/editar/{id}")
      public String editar(@PathVariable(value = "id") Long id, Model model){
        Seccion seccion = seccionService.busSeccion(id);
          model.addAttribute("seccion", seccion);
          model.addAttribute("listaSeccion", seccionService.cargarSeccion());
          return "secciones/ListSeccion";
      }
  
      @RequestMapping("/eliminar/{id}")
      public String eliminar(@PathVariable(value = "id") Long id){
          seccionService.eliminarSeccion(id);
          return "redirect:/lista-seccion/";
      } 
}
