package com.proyecto.proyectoweb.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.proyectoweb.model.entidad.Categoria;

public interface ICategoriaDAO extends CrudRepository<Categoria, Long>{
    public List<Categoria> findAllByOrderByNombre();
}
