/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.controller.impl;

import com.uisrael.gestionvisitas.controller.IUsuarioController;
import com.uisrael.gestionvisitas.modelo.dao.IUsuarioDao;
import com.uisrael.gestionvisitas.modelo.dao.impl.UsuarioDaoImpl;
import com.uisrael.gestionvisitas.modelo.edentidad.Usuario;
import java.util.List;

/**
 *
 * @author XTREME
 */
public class UsuarioControllerImpl implements IUsuarioController{

    @Override
    public void insertarUsuario(Usuario nuevoUsuario) {
        try {
        IUsuarioDao usuariodao = new UsuarioDaoImpl(Usuario.class);
        usuariodao.insertarUsuario(nuevoUsuario);
        } catch (Exception e) {
            System.err.println("ERROR:" + e);
        }
    }

    @Override
    public List listarUsuario() {
         try {
        IUsuarioDao usuariodao = new UsuarioDaoImpl(Usuario.class);
        return usuariodao.listarUsuario(); 
        } catch (Exception e) {
            System.err.println("ERROR:" + e);
            return null;
        }
    }

    @Override
    public Usuario iniciarSeccion(Usuario user) {
        IUsuarioDao usuariodao = new UsuarioDaoImpl(Usuario.class);
        return usuariodao.iniciarSeccion(user);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        try {
            System.out.println("Se procede a Actualizar Usuario");
            IUsuarioDao usuariodao = new UsuarioDaoImpl(Usuario.class);
            usuariodao.actualizarUsuario(usuario);
            System.out.println("Carrera actualizado");
        } catch (Exception e) {
           System.out.println("El carrera que desea actualizar no existe");
        }
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
         try {
             System.out.println("Se procede a eliminar Cliente logicamente");
             IUsuarioDao usuariodao = new UsuarioDaoImpl(Usuario.class);
             usuariodao.eliminarUsuario(usuario);
             System.out.println("Carrera eliminado");
        } catch (Exception e) {
            System.out.println("El carrera que deseas eliminar no existe");
        }
    }
    
}
