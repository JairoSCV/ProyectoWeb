package com.proyecto.proyectoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.proyectoweb.model.entidad.Proveedor;
import com.proyecto.proyectoweb.model.servicio.IProveedorService;

@Controller
@RequestMapping("/lista-proveedor")
public class ListaProveedores {
    @Autowired
    private IProveedorService proveedorService;
    
    @RequestMapping("/")
    public String inicio(Model model){
        Proveedor proveedor = new Proveedor();
        model.addAttribute("proveedor", proveedor);
        model.addAttribute("listaProveedores", proveedorService.cargarProveedor());
        return "proveedor/ListProv";
    }

      @RequestMapping(value = "/formulario", method = RequestMethod.POST)
      public String guardar(Proveedor proveedor, RedirectAttributes attributes){
        proveedorService.guardarProveedor(proveedor);
        attributes.addFlashAttribute("guardar", "Nuevo proveedor registrado");
          return "redirect:/lista-proveedor/";
      }
  
      /*Este método recibe la ruta y el ID de: line 71(categoria/index)*/
      @RequestMapping("/editar/{id}")
      public String editar(@PathVariable(value = "id") Long id, Model model, RedirectAttributes attributes){
          Proveedor proveedor = null;
          if(id > 0){
            proveedor = proveedorService.busProveedor(id);
                if(proveedor == null){
                    attributes.addFlashAttribute("editar", "ATENCION: El número de este proveedor no existe!");
                    return "redirect:/lista-proveedor/";
                }
          }else{
            attributes.addFlashAttribute("editar", "ATENCION: Error con el número del proveedor!");
            return "redirect:/lista-proveedor/";
          }
          
          model.addAttribute("proveedor", proveedor);
          model.addAttribute("listaProveedores", proveedorService.cargarProveedor());
          return "proveedor/ListProv";
      }
  
      @RequestMapping("/eliminar/{id}")
      public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes attributes){
          proveedorService.eliminarProveedor(id);
        attributes.addFlashAttribute("eliminar", "Proveedor eliminado exitosamente");
          return "redirect:/lista-proveedor/";
      } 
}
