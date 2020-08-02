/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.modelo.dao.impl;

import com.uisrael.gestionvisitas.modelo.dao.IVisitasTecnicasDao;
import com.uisrael.gestionvisitas.modelo.edentidad.VisitasTecnicas;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author XTREME
 */
public class VisitasTecnicasDaoImpl extends GenericaDaoImpl<VisitasTecnicas> implements IVisitasTecnicasDao{

    public VisitasTecnicasDaoImpl(Class<VisitasTecnicas> entityClass) {
        super(entityClass);
    }

        
    @Override
    public void insertarVisitasTecnicas(VisitasTecnicas nuevoVisitasTecnicas) {
      this.beginTransaction();
      this.create(nuevoVisitasTecnicas);
      this.commit();
      this.closeTransaction();
    }

    @Override
    public List listarVisitasTecnicas() {
         TypedQuery<VisitasTecnicas> lista;
        lista= entityManager.createQuery("SELECT vist FROM VisitasTecnicas vist ",VisitasTecnicas.class);
        return lista.getResultList();
    }

    @Override
    public List<VisitasTecnicas>  listarVisitasPendientes() {
         TypedQuery<VisitasTecnicas> listap;
        listap= entityManager.createQuery("SELECT vist FROM VisitasTecnicas vist where vist.estadoVisitaTec='pendiente' ",VisitasTecnicas.class);
        return listap.getResultList();
       }

    @Override
    public void actualizarVisitasTecnicas(VisitasTecnicas visitastecnicas) {
        this.beginTransaction();
        this.update(visitastecnicas);
        this.commit();
        this.closeTransaction(); 
        //cerrar la concecion
        System.err.println("Guardado: "+visitastecnicas.toString()); 
    }

    @Override
    public void eliminarVisitasTecnicas(VisitasTecnicas visitastecnicas) {
        this.beginTransaction();
      this.delete(visitastecnicas);
      this.commit();
      this.closeTransaction();
    }

    @Override
    public List<VisitasTecnicas> listarVisitasRealizados() {
       TypedQuery<VisitasTecnicas> listap;
        listap= entityManager.createQuery("SELECT vist FROM VisitasTecnicas vist where vist.estadoVisitaTec='realizado'",VisitasTecnicas.class);
        return listap.getResultList();
    }
    
}
