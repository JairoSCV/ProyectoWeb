package com.proyecto.proyectoweb.model.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.proyectoweb.model.dao.IPersonaDAO;
import com.proyecto.proyectoweb.model.entidad.Persona;

@Service
public class PersonaServiceImp implements IPersonaService{
    @Autowired
    private IPersonaDAO personaDAO;

    @Override
    public void guardarPersona(Persona persona) {
        personaDAO.save(persona);
    }

    @Override
    public List<Persona> cargarPersonas() {
        return personaDAO.findAllByOrderById();
    }

    @Override
    public Persona busPersona(Long id) {
        return personaDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarPersona(Long id) {
        personaDAO.deleteById(id);        
    }
    
}
