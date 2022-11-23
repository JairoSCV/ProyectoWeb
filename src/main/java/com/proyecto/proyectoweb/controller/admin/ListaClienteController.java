package com.proyecto.proyectoweb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.proyectoweb.model.entidad.Cliente;
import com.proyecto.proyectoweb.model.entidad.Persona;
import com.proyecto.proyectoweb.model.servicio.IClienteService;

@Controller
@RequestMapping("/lista-cliente")
public class ListaClienteController {
    @Autowired
    private IClienteService clienteService;
    
    @RequestMapping("/")
    public String inicio(Model model){
        Cliente cliente = new Cliente();
        Persona persona = new Persona();
        cliente.setPersona(persona);
        model.addAttribute("cliente", cliente);
        model.addAttribute("listaCliente", clienteService.cargarClientes());

        return "cliente/ListClient";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(Cliente cliente, Model model, RedirectAttributes flash){
        clienteService.guardarCliente(cliente);
        flash.addFlashAttribute("guardar", "Nuevo cliente registrado");
        return "redirect:/lista-cliente/";
    }

    
    @RequestMapping("/editar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model, RedirectAttributes attributes){
        Cliente cliente = null;
        if(id > 0){
            cliente = clienteService.busCliente(id);

            if(cliente == null){
                attributes.addFlashAttribute("editar","ATENCION: El DNI del cliente no existe!");
                return "redirect:/lista-cliente/";
            }
        }else{
            attributes.addFlashAttribute("editar", "ATENCION: Error con el DNI del cliente");
            return "redirect:/lista-cliente/";
        }

        model.addAttribute("cliente", cliente);
        model.addAttribute("listaCliente", clienteService.cargarClientes());

        return "cliente/ListClient";
    }

    
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes attributes){
        clienteService.eliminarCliente(id);
        attributes.addFlashAttribute("eliminar", "Cliente eliminado exitosamente");
        return "redirect:/lista-cliente/";    
    }
}
