/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.modelo.dao;

import com.uisrael.gestionvisitas.modelo.edentidad.RolesUsuario;
import java.util.List;

/**
 *
 * @author XTREME
 */
public interface IRolesUsuarioDao {
    
     public void insertarRolesUsuario (RolesUsuario nuevoRolesUsuario);
     public List<RolesUsuario> listarRolesUsuario();
     public void actualizarRolesUsuario(RolesUsuario  rolesusuario);
     public void eliminarRolesUsuario(RolesUsuario  rolesusuario);    
}
