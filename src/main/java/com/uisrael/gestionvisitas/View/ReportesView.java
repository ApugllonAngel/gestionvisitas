/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.View;

import com.uisrael.gestionvisitas.controller.IVisitasTecnicasController;
import com.uisrael.gestionvisitas.controller.impl.VisitasTecnicasControllerImpl;
import com.uisrael.gestionvisitas.modelo.edentidad.VisitasTecnicas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author XTREME
 */
@ManagedBean (name = "Reporteview")
@ViewScoped
public class ReportesView implements Serializable{
    
    private IVisitasTecnicasController visitastecpencontroller;
    private List<VisitasTecnicas> listavistpendientes;
    private List<VisitasTecnicas> listavistrealizados;
    
    @PostConstruct
    public void init(){
     visitastecpencontroller  = new VisitasTecnicasControllerImpl();
    listavistpendientes= new ArrayList<>();
    listavistrealizados= new ArrayList<>();
    ListarVisitasPendietes();
    ListarVisitasRealizados();
    System.out.println("Se creo View...");
    }
    
      public void ListarVisitasPendietes(){
      try{
      visitastecpencontroller  = new VisitasTecnicasControllerImpl();
      listavistpendientes = visitastecpencontroller.listarVisitasPendientes();
      } catch (Exception e) {
            System.out.println("Error al mostrar las listas pendientes: "+e.getMessage());
        }
      }
      
      public void ListarVisitasRealizados(){
      try{
      visitastecpencontroller  = new VisitasTecnicasControllerImpl();
      listavistrealizados = visitastecpencontroller.listarVisitasRealizados();
      } catch (Exception e) {
            System.out.println("Error al mostrar las listas realizados: "+e.getMessage());
        }
      }

    public IVisitasTecnicasController getVisitastecpencontroller() {
        return visitastecpencontroller;
    }

    public void setVisitastecpencontroller(IVisitasTecnicasController visitastecpencontroller) {
        this.visitastecpencontroller = visitastecpencontroller;
    }

    public List<VisitasTecnicas> getListavistpendientes() {
        return listavistpendientes;
    }

    public void setListavistpendientes(List<VisitasTecnicas> listavistpendientes) {
        this.listavistpendientes = listavistpendientes;
    }

    public List<VisitasTecnicas> getListavistrealizados() {
        return listavistrealizados;
    }

    public void setListavistrealizados(List<VisitasTecnicas> listavistrealizados) {
        this.listavistrealizados = listavistrealizados;
    }

   
 }
