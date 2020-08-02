/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.controller.impl;

import com.uisrael.gestionvisitas.controller.ITecnicoController;
import com.uisrael.gestionvisitas.modelo.dao.ITecnicoDao;
import com.uisrael.gestionvisitas.modelo.dao.impl.TecnicoDaoImpl;
import com.uisrael.gestionvisitas.modelo.edentidad.Tecnico;
import java.util.List;

/**
 *
 * @author XTREME
 */
public class TecnicoControllerImpl implements ITecnicoController{

    @Override
    public void insertarTecnico(Tecnico tecnico) {
        try {
        ITecnicoDao tecnicodao = new TecnicoDaoImpl(Tecnico.class);
        tecnicodao.insertarTecnico(tecnico);
        } catch (Exception e) {
            System.err.println("ERROR:" + e);
        }
    }

    @Override
    public List listarTecnico() {
        try {
       ITecnicoDao tecnicodao = new TecnicoDaoImpl(Tecnico.class);
       return tecnicodao.listarTecnico();
       } catch (Exception e) {
            System.err.println("ERROR:" + e);
            return null;
        }
    }

    @Override
    public void actualizarTecnico(Tecnico tecnico) {
        try {
            System.out.println("Se procede a Actualizar Tecnico");
        ITecnicoDao tecnicodao = new TecnicoDaoImpl(Tecnico.class);
        tecnicodao.actualizarTecnico(tecnico);
        System.out.println("Carrera eliminado");
        } catch (Exception e) {
            System.out.println("El carrera que deseas actualizar no existe");
        }
    }

    @Override
    public void eliminarTecnico(Tecnico tecnico) {
        try {
            System.out.println("Se procede a eliminar Tecnico logicamente");
         ITecnicoDao tecnicodao = new TecnicoDaoImpl(Tecnico.class);
        tecnicodao.eliminarTecnico(tecnico);
        System.out.println("Carrera eliminado");

        } catch (Exception e) {
            System.out.println("El carrera que deseas eliminar no existe");
        }
    }

   
    
}
