/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.View;

import com.uisrael.gestionvisitas.controller.IClienteController;
import com.uisrael.gestionvisitas.controller.impl.ClienteControllerImpl;
import com.uisrael.gestionvisitas.modelo.edentidad.Cliente;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;

/**
 *
 * @author XTREME
 */
@ManagedBean(name = "Clientecore")
@ViewScoped
public class ClienteView implements Serializable{
    
    
    private String nombreCliente;
    private String dirrecionCliente;
    private String telefonoCliente;
    private String referenciaCliente;
    private Cliente nuevoCliente;
    private Cliente nuevoClienteAct;
    private IClienteController clientecontroller;
    private List<Cliente> listarCliente;

    public ClienteView() {
    }
    
     @PostConstruct
     public void init(){
     System.err.println("inicio");  
     clientecontroller = new ClienteControllerImpl(); 
     ListaCliente();
     nuevoClienteAct = new Cliente();
        }
    
    public void insertarCliente(){
     
         nuevoCliente = new Cliente();
         nuevoCliente.setNombreCliente(nombreCliente);
         nuevoCliente.setDirrecionCliente(dirrecionCliente);
         nuevoCliente.setTelefonoCliente(telefonoCliente);
         nuevoCliente.setReferenciaCliente(referenciaCliente);
         nuevoCliente.setClienteEliminado("N");
         try {
         clientecontroller.insertarCliente(nuevoCliente);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Creado "));
            nuevo();
         ListaCliente();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }
              
     }
    
    public void ListaCliente(){
      clientecontroller = new ClienteControllerImpl();
      listarCliente=clientecontroller.listarCliente();
      }
    
   
    
     public void eliminar(Cliente cliente) {
           cliente.setClienteEliminado("S");
       try {
             clientecontroller.eliminarCliente(cliente);
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Eliminado "));
             ListaCliente();
             nuevo();
           
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }
    }

    public void antActualizar(Cliente cliente) {
        System.out.println("Actualizado");
        nuevoClienteAct = new Cliente();
        this.nuevoClienteAct = cliente;
        System.out.println("Actualizado" + cliente);
    }
     
    public void actualizarCliente(){
       try {
            clientecontroller.actualizarCliente(this.nuevoClienteAct);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Actualizado"));
            ListaCliente();
            nuevo();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }
    }
    
     public void nuevo() {
        nombreCliente = "";
        dirrecionCliente = "";
        telefonoCliente="";
        referenciaCliente="";
        
        RequestContext.getCurrentInstance().update("frmCliente");
    }
      private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
        RequestContext.getCurrentInstance().update("frmCliente");
    }
    
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDirrecionCliente() {
        return dirrecionCliente;
    }

    public void setDirrecionCliente(String dirrecionCliente) {
        this.dirrecionCliente = dirrecionCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getReferenciaCliente() {
        return referenciaCliente;
    }

    public void setReferenciaCliente(String referenciaCliente) {
        this.referenciaCliente = referenciaCliente;
    }

    
    public Cliente getNuevoCliente() {
        return nuevoCliente;
    }

    public void setNuevoCliente(Cliente nuevoCliente) {
        this.nuevoCliente = nuevoCliente;
    }

    public IClienteController getClientecontroller() {
        return clientecontroller;
    }

    public void setClientecontroller(IClienteController clientecontroller) {
        this.clientecontroller = clientecontroller;
    }

    public List<Cliente> getListarCliente() {
        return listarCliente;
    }

    public void setListarCliente(List<Cliente> listarCliente) {
        this.listarCliente = listarCliente;
    }

    public Cliente getNuevoClienteAct() {
        return nuevoClienteAct;
    }

    public void setNuevoClienteAct(Cliente nuevoClienteAct) {
        this.nuevoClienteAct = nuevoClienteAct;
    } 

 }
