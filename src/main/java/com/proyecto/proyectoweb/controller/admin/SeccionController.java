package com.proyecto.proyectoweb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
      public String guardar(Seccion seccion, RedirectAttributes attributes){
        seccionService.guardarProveedor(seccion);
        attributes.addFlashAttribute("guardar", "Nueva sección registrada");
          return "redirect:/lista-seccion/";
      }
  
      /*Este método recibe la ruta y el ID de: line 71(categoria/index)*/
      @RequestMapping("/editar/{id}")
      public String editar(@PathVariable(value = "id") Long id, Model model, RedirectAttributes attributes){
        Seccion seccion = null;
        if(id>0){
          seccion = seccionService.busSeccion(id);
            if(seccion == null){
                attributes.addFlashAttribute("editar", "ATENCION: El ID de esta sección no existe!");
                return "redirect:/lista-seccion/";
              }
        }else{
          attributes.addFlashAttribute("editar", "ATENCION: Error con el ID de esta sección!");
          return "redirect:/lista-seccion/";
        }

          model.addAttribute("seccion", seccion);
          model.addAttribute("listaSeccion", seccionService.cargarSeccion());
          return "secciones/ListSeccion";
      }
  
      @RequestMapping("/eliminar/{id}")
      public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes attributes){
          seccionService.eliminarSeccion(id);
          attributes.addFlashAttribute("eliminar", "Sección removida exitosamente");
          return "redirect:/lista-seccion/";
      } 
}
