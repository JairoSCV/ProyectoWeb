package com.proyecto.proyectoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyecto.proyectoweb.model.entidad.Proveedor;
import com.proyecto.proyectoweb.model.servicio.IProveedorService;

@Controller
@RequestMapping("/lista-proveedor")
public class ListaProveedores {
    private IProveedorService proveedorService;
    
    @RequestMapping("/")
    public String inicio(Model model){
        Proveedor proveedor = new Proveedor();
        model.addAttribute("proveedor", proveedor);
        model.addAttribute("listaProveedores", proveedorService.cargarProveedor());
        return "proveedor/ListProv";
    }

      /*Este método es para guardar el formulario, explicacion: line 20(categoria/index)*/
      @RequestMapping(value = "/formulario", method = RequestMethod.POST)
      public String guardar(Proveedor proveedor){/*Enviamos esa categoria a la interfaz ICategoriaService, mediante inyeccion de dependencias*/
        proveedorService.guardarProveedor(proveedor);
          /*Una vez guardado, redireccionar a /categoria/ */
          return "redirect:/lista-proveedor/";
      }
  
      /*Este método recibe la ruta y el ID de: line 71(categoria/index)*/
      @RequestMapping("/editar/{id}")
      public String editar(@PathVariable(value = "id") Long id, Model model){
          Proveedor proveedor = proveedorService.busProveedor(id);
          model.addAttribute("proveedor", proveedor);
          model.addAttribute("listaProveedores", proveedorService.cargarProveedor());
          return "proveedor/ListProv";
      }
  
      @RequestMapping("/eliminar/{id}")
      public String eliminar(@PathVariable(value = "id") Long id){
          proveedorService.eliminarProveedor(id);
          return "redirect:/lista-proveedor/";
      } 
}
