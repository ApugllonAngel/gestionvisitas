/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.View;

import com.uisrael.gestionvisitas.controller.IRolesUsuarioController;
import com.uisrael.gestionvisitas.controller.impl.RolesUsuarioControllerImpl;
import com.uisrael.gestionvisitas.modelo.edentidad.RolesUsuario;
import com.uisrael.gestionvisitas.modelo.edentidad.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author XTREME
 */
@Named
@SessionScoped
public class RolesControlView implements Serializable{
   
   private IRolesUsuarioController rolescontroller;
   private List<RolesUsuario> lista;
   private MenuModel  model;
   
    @PostConstruct
    public void init(){
      System.err.println("inicio");
      rolescontroller = new RolesUsuarioControllerImpl();
      ListarRolesUsuario();
      model = new DefaultMenuModel();
      establecerPermisos();
    }
   
   public void ListarRolesUsuario(){
       try{
      rolescontroller = new RolesUsuarioControllerImpl();
      lista = rolescontroller.listarRolesUsuario();
    } catch(Exception e){
      // mesaje jsf  
    }
   }
   
   
   public void establecerPermisos(){
     
       Usuario  use = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
       for(RolesUsuario rol: lista){
       if(rol.getTipo().equals("S")&& rol.getTipoUsuario().equals(use.getTipoUsuario())){
        DefaultSubMenu firstSubmenu = new DefaultSubMenu(rol.getNombreRoUser());
        for(RolesUsuario i: lista){
           RolesUsuario rolmenu = i.getSubroles();
           if(rolmenu != null){
              if(rolmenu.getIdRolesUsuario()== rol.getIdRolesUsuario()){
               DefaultMenuItem item = new DefaultMenuItem(i.getNombreRoUser());
               item.setUrl(i.getUrl());
               firstSubmenu.addElement(item);
               }
           }
        }
        model.addElement(firstSubmenu);
      }else {
         if(rol.getSubroles()== null && rol.getTipoUsuario().equals(use.getTipoUsuario())){
         DefaultMenuItem item = new DefaultMenuItem(rol.getNombreRoUser());
         item.setUrl(rol.getUrl());
         model.addElement(item);
       }
   }
       }
        
   }
    public void cerrarSeccion(){
    
    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
       
    }

    public IRolesUsuarioController getRolescontroller() {
        return rolescontroller;
    }

    public void setRolescontroller(IRolesUsuarioController rolescontroller) {
        this.rolescontroller = rolescontroller;
    }

    public List<RolesUsuario> getLista() {
        return lista;
    }

    public void setLista(List<RolesUsuario> lista) {
        this.lista = lista;
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }
   
   
}
