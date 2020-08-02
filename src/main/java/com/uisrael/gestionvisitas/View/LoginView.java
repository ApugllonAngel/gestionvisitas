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
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author XTREME
 */
@ManagedBean(name = "loginview")
@ViewScoped
public class LoginView implements Serializable{
    
     private String usuario;
    private String password;
    private String tipoUsuario;
    private Usuario users;
    private IUsuarioController usuariocontroller;

    public LoginView() {
    }
    
    @PostConstruct
    private void init(){
    System.err.println("iniciologin");
    usuariocontroller = new UsuarioControllerImpl(); 
    users = new Usuario();
     
        }
    
    
      
      public String iniciaseccion(){
          
          Usuario user;
          String redireccion= null;
       try{
            user = usuariocontroller.iniciarSeccion(users);
            if(user!= null){
             //Almacena en Seccion  
             FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",user);
            redireccion = "/protegido/principal?faces-redicect=true";
            }else{
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "aviso","Credenciales incorrecto"));
            }
            
            }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso1","Error"));
            }
            return redireccion;
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

   

    public IUsuarioController getUsuariocontroller() {
        return usuariocontroller;
    }

    public void setUsuariocontroller(IUsuarioController usuariocontroller) {
        this.usuariocontroller = usuariocontroller;
    }

   
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario getUser() {
        return users;
    }

    public void setUser(Usuario user) {
        this.users = user;
    }

    public Usuario getUsers() {
        return users;
    }

    public void setUsers(Usuario users) {
        this.users = users;
    }

}
