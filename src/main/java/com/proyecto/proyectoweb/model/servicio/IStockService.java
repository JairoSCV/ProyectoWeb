package com.proyecto.proyectoweb.model.servicio;

import java.util.List;

import com.proyecto.proyectoweb.model.entidad.Stock;

public interface IStockService{
    public void guardarStock(Stock stock);
    public List<Stock> cargarStock();/*List de java.util*/
    public Stock busStock(Long id);
    public void eliminarStock(Long id);
}
