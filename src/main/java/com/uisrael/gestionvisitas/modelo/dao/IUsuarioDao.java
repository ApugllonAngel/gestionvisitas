/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.modelo.dao;

import com.uisrael.gestionvisitas.modelo.edentidad.Usuario;
import java.util.List;

/**
 *
 * @author XTREME
 */
public interface IUsuarioDao {
    
    public void insertarUsuario (Usuario nuevoUsuario);
    public List listarUsuario();
    public Usuario iniciarSeccion (Usuario user);
    public void actualizarUsuario(Usuario usuario);
    public void eliminarUsuario(Usuario usuario);
    
}
