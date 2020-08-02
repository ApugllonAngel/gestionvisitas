/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.View;


import com.uisrael.gestionvisitas.modelo.edentidad.Usuario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author XTREME
 */
@ManagedBean
@ViewScoped
public class PlantillaController implements Serializable{
    
    public void verficarSeccion(){
     
        try{
          FacesContext context = FacesContext.getCurrentInstance();
          Usuario use = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
        
          if(use == null){
             context.getExternalContext().redirect("./../permisos.xhtml");
          }
        }catch(Exception e){
            //log para guadar algun registro de de error
        }
    }
    
 }
    
