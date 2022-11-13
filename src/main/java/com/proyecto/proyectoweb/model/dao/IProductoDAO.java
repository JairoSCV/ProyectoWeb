package com.proyecto.proyectoweb.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.proyectoweb.model.entidad.Producto;

public interface IProductoDAO extends CrudRepository<Producto, Long>{
    
}
