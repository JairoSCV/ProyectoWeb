package com.proyecto.proyectoweb.model.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.proyectoweb.model.dao.ICategoriaDAO;
import com.proyecto.proyectoweb.model.entidad.Categoria;

@Service
public class CategoriaServiceImp implements ICategoriaService{

    @Autowired
    private ICategoriaDAO categoriaDAO;

    @Override
    public void guardarCategoria(Categoria categoria) {
        categoriaDAO.save(categoria);
    }

    @Override
    public List<Categoria> cargarCategorias() {
        return categoriaDAO.findAllByOrderByNombre();
    }

    @Override
    public Categoria busCategoria(Long id) {
        return categoriaDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriaDAO.deleteById(id);
    }
    
}
