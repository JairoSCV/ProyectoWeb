package com.proyecto.proyectoweb.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.proyectoweb.model.entidad.Cliente;

public interface IClienteDAO extends CrudRepository<Cliente, Long>{
    
}
