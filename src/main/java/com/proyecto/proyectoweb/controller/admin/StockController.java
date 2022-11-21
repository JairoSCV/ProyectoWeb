package com.proyecto.proyectoweb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String guardar(Stock stock, RedirectAttributes attributes){/*Enviamos esa stock a la interfaz IstockService, mediante inyeccion de dependencias*/
        stockService.guardarStock(stock);
        attributes.addFlashAttribute("guardar", "Nuevo stock registrado");
        /*Una vez guardado, redireccionar a /stock/ */
        return "redirect:/lista-stock/";
    }

    @RequestMapping("/editar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model, RedirectAttributes attributes){
        /*Crea una categoría en base a la encontrada y la envía al form mediante Model*/
        Stock stock = null;
        if(id>0){
            stock = stockService.busStock(id);
            if(stock==null){
                attributes.addFlashAttribute("editar","ATENCION: El ID de este stock no existe!");
                return "redirect:/lista-stock/";
            }
        }else{
            attributes.addFlashAttribute("editar","ATENCION: Error con el ID de este stock!");
            return "redirect:/lista-stock/";
        }
        model.addAttribute("stock", stock);
        model.addAttribute("listaStock", stockService.cargarStock());/*devuelva la lista de categorías*/
        return "stocks/Liststocks";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes attributes){
        /*Crea una categoría en base a la encontrada y la envía al form mediante Model*/
        stockService.eliminarStock(id);
        attributes.addFlashAttribute("eliminar", "Stock removido exitosamente");
        return "redirect:/lista-stock/";
    } 
}
