package com.proyecto.proyectoweb.model.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.proyectoweb.model.dao.IOrdenDAO;
import com.proyecto.proyectoweb.model.entidad.DetalleVenta;

@Service
public class OrdenServiceImp implements IOrdenService{
    @Autowired
    private IOrdenDAO ordenDAO;

    @Override
    public DetalleVenta save(DetalleVenta detalleVenta) {
        return ordenDAO.save(detalleVenta);
    }

    @Override
    public List<DetalleVenta> findAll() {
        return (List<DetalleVenta>) ordenDAO.findAll();
    }

    
}
