package com.proyecto.proyectoweb.model.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.proyectoweb.model.dao.ILoginDAO;
import com.proyecto.proyectoweb.model.entidad.Login;

@Service
public class LoginServiceImp implements ILoginService{

    @Autowired
    private ILoginDAO loginDAO;

    @Override
    public void guardarUsuario(Login login) {
        loginDAO.save(login);
    }

    @Override
    public List<Login> cargarUsuario() {
        return (List<Login>) loginDAO.findAll();
    }

    @Override
    public Login busUsuario(Long id) {
        return loginDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarUsuario(Long id) {
        loginDAO.deleteById(id);        
    }
    
}
