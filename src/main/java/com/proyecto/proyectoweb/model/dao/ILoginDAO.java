package com.proyecto.proyectoweb.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.proyectoweb.model.entidad.Login;

public interface ILoginDAO extends CrudRepository<Login, Long>{
    
}
