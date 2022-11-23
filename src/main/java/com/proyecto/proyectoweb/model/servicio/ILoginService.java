package com.proyecto.proyectoweb.model.servicio;

import java.util.List;

import com.proyecto.proyectoweb.model.entidad.Login;

public interface ILoginService {
    public void guardarUsuario(Login login);
    public List<Login> cargarUsuario();
    public Login busUsuario(Long id);
    public void eliminarUsuario(Long id);
}
