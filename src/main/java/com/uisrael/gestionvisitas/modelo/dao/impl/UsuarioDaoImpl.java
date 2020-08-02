/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.modelo.dao.impl;

import com.uisrael.gestionvisitas.modelo.dao.IUsuarioDao;
import com.uisrael.gestionvisitas.modelo.edentidad.Usuario;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author XTREME
 */
public class UsuarioDaoImpl extends GenericaDaoImpl<Usuario> implements IUsuarioDao{

    public UsuarioDaoImpl(Class<Usuario> entityClass) {
        super(entityClass);
    }

        
    @Override
    public void insertarUsuario(Usuario nuevoUsuario) {
        this.beginTransaction();
        this.create(nuevoUsuario);
        this.commit();
        this.closeTransaction(); 
    }

    @Override
    public List listarUsuario() {
        TypedQuery<Usuario> lista;
        lista= entityManager.createQuery("SELECT use FROM Usuario use ",Usuario.class);
        return lista.getResultList();
    }
    
    
    @Override
    public void actualizarUsuario(Usuario usuario) {
        this.beginTransaction();
            //persistir en la base de datos
            this.update(usuario);
            //registra en la base de datos
            this.commit();
            this.closeTransaction();
            //cerrar la concecion
            System.err.println("Guardado: "+usuario.toString()); 
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
       this.beginTransaction();
        this.delete(usuario);
        this.commit();
        this.closeTransaction();
    }
    

    @Override
    public Usuario  iniciarSeccion (Usuario user) {
      
       Usuario  usuario = null;
        String consulta;
        try{
            consulta = "select use from Usuario use where use.usuario = ?1 and use.password =?2";
            Query query = entityManager.createQuery(consulta,Usuario.class);
            query.setParameter(1, user.getUsuario());
            query.setParameter(2, user.getPassword());
            List<Usuario> lista = query.getResultList();
            if(!lista.isEmpty()){
                usuario = lista.get(0);
            
            }
        
        }catch (Exception e){
           throw e;
        } finally{
           entityManager.close();
        }
       return usuario; 
    }
    
}
