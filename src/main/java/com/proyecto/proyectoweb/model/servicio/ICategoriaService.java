package com.proyecto.proyectoweb.model.servicio;

import java.util.List;

import com.proyecto.proyectoweb.model.entidad.Categoria;

public interface ICategoriaService{
    public void guardarCategoria(Categoria categoria);
    public List<Categoria> cargarCategorias();
    public Categoria busCategoria(Long id);
    public void eliminarCategoria(Long id);
}
