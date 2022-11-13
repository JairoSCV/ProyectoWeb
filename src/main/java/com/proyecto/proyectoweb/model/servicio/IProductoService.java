package com.proyecto.proyectoweb.model.servicio;

import java.util.List;

import com.proyecto.proyectoweb.model.entidad.Producto;

public interface IProductoService {
    public String guardarProducto(Producto producto);
    public List<Producto> cargarProducto();
}
