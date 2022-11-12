package com.proyecto.proyectoweb.model.servicio;

import java.util.List;

import com.proyecto.proyectoweb.model.entidad.Cliente;

public interface IClienteService {
    public void guardarCliente(Cliente cliente);
    public List<Cliente> cargarClientes();
    public Cliente busCliente(Long id);
    public void eliminarCliente(Long id);
}
