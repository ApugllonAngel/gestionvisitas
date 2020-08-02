/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.controller;

import com.uisrael.gestionvisitas.modelo.edentidad.VisitasTecnicas;
import java.util.List;

/**
 *
 * @author XTREME
 */
public interface IVisitasTecnicasController {
     public void insertarVisitasTecnicas(VisitasTecnicas nuevoVisitasTecnicas);
    public List listarVisitasTecnicas();
    public List<VisitasTecnicas>  listarVisitasPendientes();
    public List<VisitasTecnicas> listarVisitasRealizados();
    public void actualizarVisitasTecnicas(VisitasTecnicas visitastecnicas);
    public void eliminarVisitasTecnicas(VisitasTecnicas visitastecnicas);
}
