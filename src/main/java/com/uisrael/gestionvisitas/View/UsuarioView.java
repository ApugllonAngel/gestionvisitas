/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.View;

import com.uisrael.gestionvisitas.controller.IUsuarioController;
import com.uisrael.gestionvisitas.controller.impl.UsuarioControllerImpl;
import com.uisrael.gestionvisitas.modelo.edentidad.Usuario;
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
@ManagedBean(name = "usuarioview")
@ViewScoped
public class UsuarioView implements Serializable{
    
    private String usuario;
    private String password;
    private String tipoUsuario;
    private Usuario nuevoUsuario;
    private Usuario nuevoUsuarioAct;
    private IUsuarioController usuariocontroller;
    private List<Usuario> listarUsuario;

    public UsuarioView() {
    }
    
    @PostConstruct
     private void init(){
       System.err.println("inicio");
       ListaUsuario();
       usuariocontroller = new UsuarioControllerImpl(); 
       nuevoUsuarioAct = new Usuario();
     }
    
     public void insertarUsuario(){
     
         nuevoUsuario = new Usuario();
         nuevoUsuario.setUsuario(usuario);
         nuevoUsuario.setPassword(password);
         nuevoUsuario.setTipoUsuario(tipoUsuario);
         try {
         usuariocontroller.insertarUsuario(nuevoUsuario);
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Creado "));
          ListaUsuario();
          nuevo();
          } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }    
     }
     
      public void ListaUsuario(){
      usuariocontroller = new UsuarioControllerImpl(); 
      listarUsuario=usuariocontroller.listarUsuario();
      }
      
       public void antActualizar(Usuario actusuario) {
        System.out.println("Actualizado");
        nuevoUsuarioAct = new Usuario();
        this.nuevoUsuarioAct = actusuario;
        System.out.println("Actualizado" + actusuario);
    }
     
    public void actualizarUsuario(){
       try {
            usuariocontroller.actualizarUsuario(this.nuevoUsuarioAct);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Actualizado"));
            ListaUsuario();
            nuevo();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }
    }
    
     public void nuevo() {
        usuario = "";
        password = "";
        tipoUsuario="";      
        RequestContext.getCurrentInstance().update("frmUsuario");
    }
      private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
        RequestContext.getCurrentInstance().update("frmUsuario");
    }
    
      public void eliminar(Usuario usuario) {
           usuario.setEleminarsuario("S");
       try {
             usuariocontroller.eliminarUsuario(usuario);
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Eliminado "));
             ListaUsuario();
             nuevo();
           
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }
    }      

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario getNuevoUsuario() {
        return nuevoUsuario;
    }

    public void setNuevoUsuario(Usuario nuevoUsuario) {
        this.nuevoUsuario = nuevoUsuario;
    }

    public Usuario getNuevoUsuarioAct() {
        return nuevoUsuarioAct;
    }

    public void setNuevoUsuarioAct(Usuario nuevoUsuarioAct) {
        this.nuevoUsuarioAct = nuevoUsuarioAct;
    }

    public IUsuarioController getUsuariocontroller() {
        return usuariocontroller;
    }

    public void setUsuariocontroller(IUsuarioController usuariocontroller) {
        this.usuariocontroller = usuariocontroller;
    }

    public List<Usuario> getListarUsuario() {
        return listarUsuario;
    }

    public void setListarUsuario(List<Usuario> listarUsuario) {
        this.listarUsuario = listarUsuario;
    }
          
      
}
