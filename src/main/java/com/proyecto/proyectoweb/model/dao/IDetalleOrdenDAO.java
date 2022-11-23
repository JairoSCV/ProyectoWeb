package com.proyecto.proyectoweb.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.proyectoweb.model.entidad.Venta;
@Repository
public interface IDetalleOrdenDAO extends CrudRepository<Venta, Long>{
    
}
