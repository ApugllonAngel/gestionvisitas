/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.controller.impl;

import com.uisrael.gestionvisitas.controller.IVisitasTecnicasController;
import com.uisrael.gestionvisitas.modelo.dao.IVisitasTecnicasDao;
import com.uisrael.gestionvisitas.modelo.dao.impl.VisitasTecnicasDaoImpl;
import com.uisrael.gestionvisitas.modelo.edentidad.VisitasTecnicas;
import java.util.List;

/**
 *
 * @author XTREME
 */
public class VisitasTecnicasControllerImpl implements IVisitasTecnicasController{

    @Override
    public void insertarVisitasTecnicas(VisitasTecnicas nuevoVisitasTecnicas) {
       try {
           IVisitasTecnicasDao visitastecnicasdao = new VisitasTecnicasDaoImpl(VisitasTecnicas.class);
           visitastecnicasdao.insertarVisitasTecnicas(nuevoVisitasTecnicas);
         } catch (Exception e) {
           System.err.println("ERROR:" + e);
       }
    }

    @Override
    public List listarVisitasTecnicas() {
       try {
            IVisitasTecnicasDao visitastecnicasdao = new VisitasTecnicasDaoImpl(VisitasTecnicas.class);
            return visitastecnicasdao.listarVisitasTecnicas();
          } catch (Exception e) {
            System.err.println("ERROR:" + e);
            return null;
        }
    
     }

    @Override
    public List<VisitasTecnicas> listarVisitasPendientes() {
        try {
            IVisitasTecnicasDao visitastecnicasdao = new VisitasTecnicasDaoImpl(VisitasTecnicas.class);
            return visitastecnicasdao.listarVisitasPendientes();
         }catch (Exception e) {
            System.err.println("ERROR:" + e);
            return null;
        }
    }

    @Override
    public void actualizarVisitasTecnicas(VisitasTecnicas visitastecnicas) {
          try {
            System.out.println("Se procede a Actualizar VisitasTecnicas");
            IVisitasTecnicasDao visitastecnicasdao = new VisitasTecnicasDaoImpl(VisitasTecnicas.class);
            visitastecnicasdao.actualizarVisitasTecnicas(visitastecnicas);
            System.out.println("Carrera actualizado");
        } catch (Exception e) {
           System.out.println("El carrera que desea actualizar no existe");
        }
    }

    @Override
    public void eliminarVisitasTecnicas(VisitasTecnicas visitastecnicas) {
        try {
             System.out.println("Se procede a eliminar visitastecnicas logicamente");
             IVisitasTecnicasDao visitastecnicasdao = new VisitasTecnicasDaoImpl(VisitasTecnicas.class);
             visitastecnicasdao.eliminarVisitasTecnicas(visitastecnicas);
             System.out.println("Carrera eliminado");
        } catch (Exception e) {
            System.out.println("El carrera que deseas eliminar no existe");
        }
    }

    @Override
    public List<VisitasTecnicas> listarVisitasRealizados() {
       try {
            IVisitasTecnicasDao visitastecnicasdao = new VisitasTecnicasDaoImpl(VisitasTecnicas.class);
            return visitastecnicasdao.listarVisitasRealizados();
         }catch (Exception e) {
            System.err.println("ERROR:" + e);
            return null;
         }
    }
}
