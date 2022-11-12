package com.proyecto.proyectoweb.model.servicio;

import java.util.List;

import com.proyecto.proyectoweb.model.entidad.Persona;

public interface IPersonaService {
    public void guardarPersona(Persona persona);
    public List<Persona> cargarPersonas();
    public Persona busPersona(Long id);
    public void eliminarPersona(Long id);
}
