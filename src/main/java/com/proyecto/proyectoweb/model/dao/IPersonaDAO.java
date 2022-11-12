package com.proyecto.proyectoweb.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.proyectoweb.model.entidad.Persona;

public interface IPersonaDAO extends CrudRepository<Persona,Long>{
    public List<Persona> findAllByOrderById();
}
