package com.proyecto.proyectoweb.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyecto.proyectoweb.model.entidad.Cliente;

public interface IClienteDAO extends CrudRepository<Cliente, Long>{
    
    @Query(value="select persona.dni, nombres, apellidos, celular, direccion, correo from persona inner join cliente on persona.dni = cliente.dni", nativeQuery = true)
    public List<Cliente> findAllClientes();
}
