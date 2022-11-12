package com.proyecto.proyectoweb.model.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.proyectoweb.model.dao.ISeccionDAO;
import com.proyecto.proyectoweb.model.entidad.Seccion;

@Service
public class SeccionSeriveImp implements ISeccionService{
    @Autowired
    private ISeccionDAO seccionDAO;

    @Override
    public void guardarProveedor(Seccion seccion) {
        seccionDAO.save(seccion);
    }

    @Override
    public List<Seccion> cargarSeccion() {
        return seccionDAO.findAllByOrderByNombre();
    }

    @Override
    public Seccion busSeccion(Long id) {
        return seccionDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarSeccion(Long id) {
        seccionDAO.deleteById(id);        
    }
    
}
