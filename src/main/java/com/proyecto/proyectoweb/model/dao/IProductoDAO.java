package com.proyecto.proyectoweb.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyecto.proyectoweb.model.entidad.Producto;

public interface IProductoDAO extends CrudRepository<Producto, Long>{

    //Secciones
    @Query(value = "SELECT * FROM producto WHERE id_seccion = 1", nativeQuery = true)
    public List<Producto> soloDamas();

    @Query(value = "SELECT * FROM producto WHERE id_seccion = 2", nativeQuery = true)
    public List<Producto> soloHombres();

    @Query(value = "SELECT * FROM producto WHERE id_seccion = 3", nativeQuery = true)
    public List<Producto> soloNinos();


    //Categorías
    @Query(value = "SELECT * FROM producto WHERE id_categoria = 1", nativeQuery = true)
    public List<Producto> soloZapatos();

    @Query(value = "SELECT * FROM producto WHERE id_categoria = 2", nativeQuery = true)
    public List<Producto> soloZapatillas();

    @Query(value = "SELECT * FROM producto WHERE id_categoria = 3", nativeQuery = true)
    public List<Producto> soloBotines();

    
}
