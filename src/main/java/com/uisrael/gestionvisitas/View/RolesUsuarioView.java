/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.View;

import com.uisrael.gestionvisitas.controller.IRolesUsuarioController;
import com.uisrael.gestionvisitas.controller.impl.RolesUsuarioControllerImpl;
import com.uisrael.gestionvisitas.modelo.edentidad.RolesUsuario;
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
@ManagedBean (name = "rolesuserview")
@ViewScoped
public class RolesUsuarioView implements Serializable{
    
    private String nombreRoUser;
    private String tipo;
    private String tipoUsuario;
    private String url;
    private String estado;
    private RolesUsuario subroles;
    private RolesUsuario nuevoroles;
    private RolesUsuario nuevoRolesUsuarioAct;
    private IRolesUsuarioController rolescontroller;
    private List<RolesUsuario> listaroles;

    public RolesUsuarioView() {
    }
    
     @PostConstruct
      private void init(){
         System.err.println("inicio");
         ListarRolesUsuario();
         rolescontroller = new RolesUsuarioControllerImpl();
         nuevoRolesUsuarioAct = new RolesUsuario();
     }
    
    public void insertarRolesUsuario(){
      nuevoroles = new RolesUsuario();
      nuevoroles.setNombreRoUser(nombreRoUser);
      nuevoroles.setTipo(tipo);
      nuevoroles.setTipoUsuario(tipoUsuario); 
      nuevoroles.setUrl(url);
      nuevoroles.setSubroles(subroles);
      nuevoroles.setEstado(estado);
      try {
         rolescontroller.insertarRolesUsuario(nuevoroles);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Creado "));
         nuevo();
         ListarRolesUsuario();
         
       } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }  
    }
    
     public void ListarRolesUsuario(){
       rolescontroller = new RolesUsuarioControllerImpl();
      listaroles = rolescontroller.listarRolesUsuario();
      }

     public void antActualizar(RolesUsuario roluser) {
        System.out.println("Actualizado");
        nuevoRolesUsuarioAct = new RolesUsuario();
        this.nuevoRolesUsuarioAct = roluser;
        System.out.println("Actualizado" + roluser);
    }
     
    public void actualizarRolesUsuario(){
       try {
            rolescontroller.actualizarRolesUsuario(this.nuevoRolesUsuarioAct);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Actualizado"));
            ListarRolesUsuario();
            nuevo();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }
    }
    
     public void nuevo() {
        nombreRoUser = " ";
        tipo = " ";
        tipoUsuario = " ";
        url = " ";
        estado = " ";     
        RequestContext.getCurrentInstance().update("formRolUser");
    }
      private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
        RequestContext.getCurrentInstance().update("formRolUser");
    }
    
      public void eliminar(RolesUsuario rolesusuario) {
           rolesusuario.setEliminarRoles("S");
       try {
             rolescontroller.eliminarRolesUsuario(rolesusuario);
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Eliminado "));
             ListarRolesUsuario();
             nuevo();
           
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }
    }    

    public String getNombreRoUser() {
        return nombreRoUser;
    }

    public void setNombreRoUser(String nombreRoUser) {
        this.nombreRoUser = nombreRoUser;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public RolesUsuario getSubroles() {
        return subroles;
    }

    public void setSubroles(RolesUsuario subroles) {
        this.subroles = subroles;
    }

    public RolesUsuario getNuevoroles() {
        return nuevoroles;
    }

    public void setNuevoroles(RolesUsuario nuevoroles) {
        this.nuevoroles = nuevoroles;
    }

    public RolesUsuario getNuevoRolesUsuarioAct() {
        return nuevoRolesUsuarioAct;
    }

    public void setNuevoRolesUsuarioAct(RolesUsuario nuevoRolesUsuarioAct) {
        this.nuevoRolesUsuarioAct = nuevoRolesUsuarioAct;
    }

    public IRolesUsuarioController getRolescontroller() {
        return rolescontroller;
    }

    public void setRolescontroller(IRolesUsuarioController rolescontroller) {
        this.rolescontroller = rolescontroller;
    }

    public List<RolesUsuario> getListaroles() {
        return listaroles;
    }

    public void setListaroles(List<RolesUsuario> listaroles) {
        this.listaroles = listaroles;
    }
     

}
