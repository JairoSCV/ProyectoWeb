package com.proyecto.proyectoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyecto.proyectoweb.model.entidad.Stock;
import com.proyecto.proyectoweb.model.servicio.IStockService;

@Controller
@RequestMapping("/lista-stock")
public class StockController {
    @Autowired
    private IStockService stockService;

    @RequestMapping("/")
    public String inicio(Model model){
        Stock stock = new Stock();
        model.addAttribute("stock", stock);
        model.addAttribute("listaStock", stockService.cargarStock());
        return "stocks/Liststocks";
    }

    @RequestMapping(value = "/formulario", method = RequestMethod.POST)
    public String guardar(Stock stock){/*Enviamos esa stock a la interfaz IstockService, mediante inyeccion de dependencias*/
        stockService.guardarStock(stock);
        /*Una vez guardado, redireccionar a /stock/ */
        return "redirect:/lista-stock/";
    }

    @RequestMapping("/editar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model){
        /*Crea una categoría en base a la encontrada y la envía al form mediante Model*/
        Stock stock = stockService.busStock(id);
        model.addAttribute("stock", stock);
        model.addAttribute("listaStock", stockService.cargarStock());/*devuelva la lista de categorías*/
        return "stocks/Liststocks";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        /*Crea una categoría en base a la encontrada y la envía al form mediante Model*/
        stockService.eliminarStock(id);
        return "redirect:/lista-stock/";
    } 
}
