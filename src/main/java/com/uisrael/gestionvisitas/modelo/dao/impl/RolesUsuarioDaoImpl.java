/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.modelo.dao.impl;

import com.uisrael.gestionvisitas.modelo.dao.IRolesUsuarioDao;
import com.uisrael.gestionvisitas.modelo.edentidad.RolesUsuario;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author XTREME
 */
public class RolesUsuarioDaoImpl extends GenericaDaoImpl<RolesUsuario> implements IRolesUsuarioDao{

    public RolesUsuarioDaoImpl(Class<RolesUsuario> entityClass) {
        super(entityClass);
    }
    
    @Override
    public void insertarRolesUsuario(RolesUsuario nuevoRolesUsuario) {
       this.beginTransaction();
      this.create(nuevoRolesUsuario);
      this.commit();
    }

    @Override
    public List<RolesUsuario> listarRolesUsuario() {
        TypedQuery<RolesUsuario> lista;
        lista= entityManager.createQuery("SELECT rolu FROM RolesUsuario rolu ",RolesUsuario.class);
        return lista.getResultList();   
    }

    @Override
    public void actualizarRolesUsuario(RolesUsuario rolesusuario) {
            this.beginTransaction();
            //persistir en la base de datos
            this.update(rolesusuario);
            //registra en la base de datos
            this.commit();
            this.closeTransaction();
            //cerrar la concecion
            System.err.println("Guardado: "+rolesusuario.toString());}

    @Override
    public void eliminarRolesUsuario(RolesUsuario rolesusuario) {
            this.beginTransaction();
            //persistir en la base de datos
            this.delete(rolesusuario);
            //registra en la base de datos
            this.commit();
            this.closeTransaction();
    }
                
}
