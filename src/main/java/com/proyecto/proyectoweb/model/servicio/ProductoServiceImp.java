package com.proyecto.proyectoweb.model.servicio;

import java.util.List;
import java.util.Optional;

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
        String rpta = "aa";
        try{
            productoDAO.save(producto);
            rpta="Se guardó el producto correctamente";
        }catch(Exception e){
            rpta=e.getMessage();
        }
        return rpta;
    }

    @Override
    public List<Producto> cargarProducto() {
        return (List<Producto>) productoDAO.findAll();
    }

    @Override
    public List<Producto> cargarDamas() {
        return (List<Producto>) productoDAO.soloDamas();
    }

    @Override
    public List<Producto> cargarHombres() {
        return (List<Producto>) productoDAO.soloHombres();    
    }

    @Override
    public List<Producto> cargarNinos() {
        return (List<Producto>) productoDAO.soloNinos();
    }

    @Override
    public List<Producto> cargarZapatos() {
        return (List<Producto>) productoDAO.soloZapatos();
    }

    @Override
    public List<Producto> cargarZapatillas() {
        return (List<Producto>) productoDAO.soloZapatillas();
    }

    @Override
    public List<Producto> cargarBotines() {
        return (List<Producto>) productoDAO.soloBotines();
    }

    @Override
    public Optional<Producto> get(Long id) {
        return productoDAO.findById(id);
    }

    @Override
    public void delete(Long id) {
        productoDAO.deleteById(id);
    }
  
}
