/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.controller.impl;

import com.uisrael.gestionvisitas.controller.IRolesUsuarioController;
import com.uisrael.gestionvisitas.modelo.dao.IRolesUsuarioDao;
import com.uisrael.gestionvisitas.modelo.dao.impl.RolesUsuarioDaoImpl;
import com.uisrael.gestionvisitas.modelo.edentidad.RolesUsuario;
import java.util.List;

/**
 *
 * @author XTREME
 */
public class RolesUsuarioControllerImpl implements IRolesUsuarioController{

    @Override
    public void insertarRolesUsuario(RolesUsuario nuevoRolesUsuario) {
    try {
        IRolesUsuarioDao roluserdao = new RolesUsuarioDaoImpl(RolesUsuario.class);
        roluserdao.insertarRolesUsuario(nuevoRolesUsuario);
        } catch (Exception e) {
            System.err.println("ERROR:" + e);
        }
    }

    @Override
    public List<RolesUsuario> listarRolesUsuario() {
          try {
         IRolesUsuarioDao roluserdao = new RolesUsuarioDaoImpl(RolesUsuario.class);
         return roluserdao.listarRolesUsuario();
       } catch (Exception e) {
            System.err.println("ERROR:" + e);
            return null;
        }
    }

    @Override
    public void actualizarRolesUsuario(RolesUsuario rolesusuario) {
        try {
          System.out.println("Se procede a Actualizar RolesUsuario");
          IRolesUsuarioDao roluserdao = new RolesUsuarioDaoImpl(RolesUsuario.class);
          roluserdao.actualizarRolesUsuario(rolesusuario);
          System.out.println("Carrera actualizado");
         } catch (Exception e) {
            System.out.println("El carrera que desea actualizar no existe");
            }
        }

    @Override
    public void eliminarRolesUsuario(RolesUsuario rolesusuario) {
        try {
            System.out.println("Se procede a eliminar RolUser logicamente");
            IRolesUsuarioDao roluserdao = new RolesUsuarioDaoImpl(RolesUsuario.class);
            roluserdao.eliminarRolesUsuario(rolesusuario);
            System.out.println("Carrera eliminado");
        } catch (Exception e) {
            System.out.println("El carrera que deseas eliminar no existe");
        }
    }
    
}
