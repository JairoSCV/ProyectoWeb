package com.proyecto.proyectoweb.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.proyectoweb.model.entidad.Seccion;

public interface ISeccionDAO extends CrudRepository<Seccion, Long>{
    public List<Seccion> findAllByOrderByNombre();
}
