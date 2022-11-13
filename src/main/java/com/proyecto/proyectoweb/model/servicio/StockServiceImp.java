package com.proyecto.proyectoweb.model.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.proyectoweb.model.dao.IStockDAO;
import com.proyecto.proyectoweb.model.entidad.Stock;

@Service
public class StockServiceImp implements IStockService{
    @Autowired
    private IStockDAO stockDAO;

    @Override
    public void guardarStock(Stock stock) {
        stockDAO.save(stock);
    }

    @Override
    public List<Stock> cargarStock() {
        return (List<Stock>) stockDAO.findAll();
    }

    @Override
    public Stock busStock(Long id) {
        return stockDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarStock(Long id) {
        stockDAO.deleteById(id);   
    }
    
}
