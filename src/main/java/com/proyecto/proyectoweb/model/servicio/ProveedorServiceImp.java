package com.proyecto.proyectoweb.model.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.proyectoweb.model.dao.IProveedorDAO;
import com.proyecto.proyectoweb.model.entidad.Proveedor;

@Service
public class ProveedorServiceImp implements IProveedorService{
    @Autowired
    private IProveedorDAO proveedorDAO;

    @Override
    public void guardarProveedor(Proveedor proveedor) {
        proveedorDAO.save(proveedor);
    }

    @Override
    public List<Proveedor> cargarProveedor() {
        return proveedorDAO.findAllByOrderById();
    }

    @Override
    public Proveedor busProveedor(Long id) {
        return proveedorDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarProveedor(Long id) {
        proveedorDAO.deleteById(id);
    }
    
}
