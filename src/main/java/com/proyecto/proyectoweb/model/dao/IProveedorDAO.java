package com.proyecto.proyectoweb.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.proyectoweb.model.entidad.Proveedor;

public interface IProveedorDAO extends CrudRepository<Proveedor,Long>{
    public List<Proveedor> findAllByOrderById();
}
