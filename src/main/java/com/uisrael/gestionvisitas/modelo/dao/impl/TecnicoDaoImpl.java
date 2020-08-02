/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.modelo.dao.impl;

import com.uisrael.gestionvisitas.modelo.dao.ITecnicoDao;
import com.uisrael.gestionvisitas.modelo.edentidad.Tecnico;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author XTREME
 */
public class TecnicoDaoImpl extends GenericaDaoImpl<Tecnico> implements ITecnicoDao{

    public TecnicoDaoImpl(Class<Tecnico> entityClass) {
        super(entityClass);
    }
    
    
    @Override
    public void insertarTecnico(Tecnico nuevoTecnico) {
      this.beginTransaction();
      this.create(nuevoTecnico);
      this.commit();
    }

    @Override
    public List listarTecnico() {
        TypedQuery<Tecnico> lista;
        lista= entityManager.createQuery("SELECT tec FROM Tecnico tec ",Tecnico.class);
        return lista.getResultList();   
    }

    @Override
    public void actualizarTecnico(Tecnico tecnico) {
            this.beginTransaction();
            //persistir en la base de datos
            this.update(tecnico);
            //registra en la base de datos
            this.commit();
            this.closeTransaction();
            //cerrar la concecion
            System.err.println("Guardado: "+tecnico.toString()); 
    }

    @Override
    public void eliminarTecnico(Tecnico tecnico) {
       this.beginTransaction();
        this.delete(tecnico);
        this.commit();
        this.closeTransaction();}

   
    
}
