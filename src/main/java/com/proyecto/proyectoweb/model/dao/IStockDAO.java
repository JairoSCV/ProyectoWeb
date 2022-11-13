package com.proyecto.proyectoweb.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.proyectoweb.model.entidad.Stock;

public interface IStockDAO extends CrudRepository<Stock,Long>{
    
}
