package com.proyecto.proyectoweb.model.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.proyectoweb.model.dao.IClienteDAO;
import com.proyecto.proyectoweb.model.entidad.Cliente;

@Service
public class ClienteServiceImp implements IClienteService{

    @Autowired
    private IClienteDAO clienteDAO;

    @Override
    public void guardarCliente(Cliente cliente) {
        clienteDAO.save(cliente);        
    }

    @Override
    public List<Cliente> cargarClientes() {
        return (List<Cliente>) clienteDAO.findAll();
    }

    @Override
    public Cliente busCliente(Long id) {
        return clienteDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteDAO.deleteById(id);        
    }
    
}
