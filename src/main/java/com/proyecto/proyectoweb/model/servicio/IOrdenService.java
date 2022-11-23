package com.proyecto.proyectoweb.model.servicio;

import java.util.List;

import com.proyecto.proyectoweb.model.entidad.DetalleVenta;

public interface IOrdenService {
    List<DetalleVenta> findAll();
    DetalleVenta save (DetalleVenta detalleVenta);
}
