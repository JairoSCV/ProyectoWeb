package com.proyecto.proyectoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.proyectoweb.model.entidad.Cliente;
import com.proyecto.proyectoweb.model.entidad.Persona;
import com.proyecto.proyectoweb.model.servicio.IClienteService;
import com.proyecto.proyectoweb.model.servicio.IPersonaService;

@Controller
@RequestMapping("/lista-cliente")
public class ListaClienteController {
    @Autowired
    private IClienteService clienteService;
    @Autowired
    private IPersonaService personaService;
    
    @RequestMapping("/")
    public String inicio(Model model){
        Persona persona = new Persona();
        Cliente cliente = new Cliente();
        persona.setCliente(cliente);
        model.addAttribute("persona", persona);
        model.addAttribute("listaPersona", personaService.cargarPersonas());

        /*Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        model.addAttribute("listaClientes", clienteService.cargarClientes());*/

        return "cliente/ListClient";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(Cliente cliente, Persona persona, Model model, RedirectAttributes flash){
        personaService.guardarPersona(persona);
        //clienteService.guardarCliente(cliente);
        return "redirect:/lista-cliente/";
    }

}
