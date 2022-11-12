package com.proyecto.proyectoweb.model.servicio;

import java.util.List;

import com.proyecto.proyectoweb.model.entidad.Seccion;

public interface ISeccionService{
    public void guardarProveedor(Seccion seccion);
    public List<Seccion> cargarSeccion();
    public Seccion busSeccion(Long id);
    public void eliminarSeccion(Long id);
}
