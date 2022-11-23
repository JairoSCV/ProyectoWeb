package com.proyecto.proyectoweb.model.servicio;

import java.util.List;
import java.util.Optional;

import com.proyecto.proyectoweb.model.entidad.Producto;

public interface IProductoService {
    public String guardarProducto(Producto producto);
    public List<Producto> cargarProducto();
    public Optional<Producto> get(Long id);
    public Producto busProducto(Long id);
    public void delete(Long id);

    public List<Producto> cargarDamas();
    public List<Producto> cargarHombres();
    public List<Producto> cargarNinos();

    public List<Producto> cargarZapatos();
    public List<Producto> cargarZapatillas();
    public List<Producto> cargarBotines();

}
