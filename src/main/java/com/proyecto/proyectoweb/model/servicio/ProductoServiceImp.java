package com.proyecto.proyectoweb.model.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.proyectoweb.model.dao.IProductoDAO;
import com.proyecto.proyectoweb.model.entidad.Producto;

@Service
public class ProductoServiceImp implements IProductoService{
    @Autowired
    private IProductoDAO productoDAO;

    @Override
    public String guardarProducto(Producto producto) {
        String rpta = "";
        try{
            productoDAO.save(producto);
            rpta="Se guardó el producto correctamente";
        }catch(Exception e){
            rpta=e.getMessage();
        }
        return rpta;
    }
    
}
