/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.View;

import com.uisrael.gestionvisitas.controller.ITecnicoController;
import com.uisrael.gestionvisitas.controller.impl.TecnicoControllerImpl;
import com.uisrael.gestionvisitas.modelo.edentidad.Tecnico;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author XTREME
 */
@ManagedBean(name = "TecnicoCore")
@ViewScoped
public class TecnicoView implements Serializable{
    
    private String nombreTecnico;
    private String dirrecionTecnico;
    private String telefonoTecnico;
    private String areaTecnico;
    private String estadoTecnico;
    private Tecnico nuevoTecnico;
    private Tecnico nuevoTecnicoAct;
    private ITecnicoController tecnicocontroller;
    private List<Tecnico> listarTecnico;

    public TecnicoView() {
    }
    
        
    @PostConstruct
    private void init(){
         System.err.println("inicio");
         ListaTecnico();
         tecnicocontroller = new TecnicoControllerImpl();
         nuevoTecnicoAct = new Tecnico();
    }
     public void insertarTecnico(){
     
         nuevoTecnico = new Tecnico();
         nuevoTecnico.setNombreTecnico(nombreTecnico);
         nuevoTecnico.setDirrecionTecnico(dirrecionTecnico);
         nuevoTecnico.setTelefonoTecnico(telefonoTecnico);
         nuevoTecnico.setAreaTecnico(areaTecnico);
         nuevoTecnico.setEstadoTecnico(estadoTecnico);
         try {
         tecnicocontroller.insertarTecnico(nuevoTecnico);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Creado "));
             nuevo();
             ListaTecnico();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }
              
     }
    
    public void ListaTecnico(){
      tecnicocontroller = new TecnicoControllerImpl();
      listarTecnico=tecnicocontroller.listarTecnico();
      }
    
    public void eliminar(Tecnico tecnico) {
           tecnico.setAreaTecnico("S");
       try {
             tecnicocontroller.eliminarTecnico(tecnico);
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Eliminado "));
             ListaTecnico();
             nuevo();
           
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }
    }
    
     public void antActualizar(Tecnico tecnico) {
        System.out.println("Actualizado");
        nuevoTecnicoAct = new Tecnico();
        this.nuevoTecnicoAct = tecnico;
        System.out.println("Actualizado" + tecnico);
    }
     
     public void actualizarTecnico(){
       try {
            tecnicocontroller.actualizarTecnico(this.nuevoTecnicoAct);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Actualizado"));
            ListaTecnico();
            nuevo();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }
    }
    
     public void nuevo() {
        nombreTecnico = "";
        dirrecionTecnico = "";
        telefonoTecnico="";
        areaTecnico="";
        estadoTecnico="";
        
        RequestContext.getCurrentInstance().update("frmTecnico");
    }
      private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
        RequestContext.getCurrentInstance().update("frmTecnico");
    }

    public String getNombreTecnico() {
        return nombreTecnico;
    }

    public void setNombreTecnico(String nombreTecnico) {
        this.nombreTecnico = nombreTecnico;
    }

    public String getDirrecionTecnico() {
        return dirrecionTecnico;
    }

    public void setDirrecionTecnico(String dirrecionTecnico) {
        this.dirrecionTecnico = dirrecionTecnico;
    }

    public String getTelefonoTecnico() {
        return telefonoTecnico;
    }

    public void setTelefonoTecnico(String telefonoTecnico) {
        this.telefonoTecnico = telefonoTecnico;
    }

    public String getAreaTecnico() {
        return areaTecnico;
    }

    public void setAreaTecnico(String areaTecnico) {
        this.areaTecnico = areaTecnico;
    }

    public String getEstadoTecnico() {
        return estadoTecnico;
    }

    public void setEstadoTecnico(String estadoTecnico) {
        this.estadoTecnico = estadoTecnico;
    }

    public Tecnico getNuevoTecnico() {
        return nuevoTecnico;
    }

    public void setNuevoTecnico(Tecnico nuevoTecnico) {
        this.nuevoTecnico = nuevoTecnico;
    }

    public Tecnico getNuevoTecnicoAct() {
        return nuevoTecnicoAct;
    }

    public void setNuevoTecnicoAct(Tecnico nuevoTecnicoAct) {
        this.nuevoTecnicoAct = nuevoTecnicoAct;
    }

    public ITecnicoController getTecnicocontroller() {
        return tecnicocontroller;
    }

    public void setTecnicocontroller(ITecnicoController tecnicocontroller) {
        this.tecnicocontroller = tecnicocontroller;
    }

    public List<Tecnico> getListarTecnico() {
        return listarTecnico;
    }

    public void setListarTecnico(List<Tecnico> listarTecnico) {
        this.listarTecnico = listarTecnico;
    }
    

   
}
