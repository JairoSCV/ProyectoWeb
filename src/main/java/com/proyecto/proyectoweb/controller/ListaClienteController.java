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
        model.addAttribute("listaPersona", clienteService.cargarClientes());

        return "cliente/ListClient";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(Cliente cliente, Model model, RedirectAttributes flash){
        clienteService.guardarCliente(cliente);
        return "redirect:/lista-cliente/";
    }

}
