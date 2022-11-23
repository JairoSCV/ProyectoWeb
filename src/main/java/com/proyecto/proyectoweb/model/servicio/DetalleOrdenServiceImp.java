package com.proyecto.proyectoweb.model.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.proyectoweb.model.dao.IDetalleOrdenDAO;
import com.proyecto.proyectoweb.model.entidad.Venta;

@Service
public class DetalleOrdenServiceImp implements IDetalleOrdenService{

    @Autowired
    private IDetalleOrdenDAO detalleOrdenDAO;

    @Override
    public Venta save(Venta venta) {
        return detalleOrdenDAO.save(venta);
    }
    
}
