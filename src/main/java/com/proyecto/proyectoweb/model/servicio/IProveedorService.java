package com.proyecto.proyectoweb.model.servicio;

import java.util.List;

import com.proyecto.proyectoweb.model.entidad.Proveedor;

public interface IProveedorService{
    public void guardarProveedor(Proveedor proveedor);
    public List<Proveedor> cargarProveedor();
    public Proveedor busProveedor(Long id);
    public void eliminarProveedor(Long id);
}
