/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.View;

import com.uisrael.gestionvisitas.controller.IVisitasTecnicasController;
import com.uisrael.gestionvisitas.controller.impl.VisitasTecnicasControllerImpl;
import com.uisrael.gestionvisitas.modelo.edentidad.Cliente;
import com.uisrael.gestionvisitas.modelo.edentidad.Tecnico;
import com.uisrael.gestionvisitas.modelo.edentidad.VisitasTecnicas;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
@ManagedBean (name = "VisitasTecnicasCore")
@ViewScoped
public class VisitasTecnicasView implements Serializable{
    
    private Date fecharegistro;
    private String artefacto;
    private String marcaartefacto;
    private String daniotefacto;
    private Date fechavisitatec;
    private String hora;
    private String estadoVisitaTec;
     
    /* private String nombreCliente;
    private String dirrecionCliente;
    private String telefonoCliente;
    private String emailCliente;*/
    private Cliente cliente;
    /*private String nombreTecnico;
    private String dirrecionTecnico;
    private String telefonoTecnico;
    private String emailTecnico;
    private String estadoTecnico;*/
    private Tecnico tecnico;
    private VisitasTecnicas visitastecnicas;
    private VisitasTecnicas nuevoVisitasTecnicasAct;
    private IVisitasTecnicasController visitastecnicascontroller;
    private List<VisitasTecnicas> listarvisitastecnicas;
    
    public VisitasTecnicasView() {
    }
     
     @PostConstruct
    public void init(){
    System.out.println("Se creo View...");
    fecharegistro = new Date();
    fechavisitatec = new Date();
    cliente = new Cliente();
    tecnico = new Tecnico();
    visitastecnicas = new VisitasTecnicas();
    visitastecnicascontroller = new VisitasTecnicasControllerImpl();
    listarvisitastecnicas = new ArrayList<>();
    mostrarVisitasTecnicas();
    nuevoVisitasTecnicasAct = new VisitasTecnicas();
   
    }
    
     public void guardarVisitasTecnicas(){
     
        visitastecnicas.setFecharegistro(fecharegistro);
        visitastecnicas.setArtefacto(artefacto);
        visitastecnicas.setMarcaartefacto(marcaartefacto);
        visitastecnicas.setDaniotefacto(daniotefacto);
        visitastecnicas.setFechavisitatec(fechavisitatec);
        visitastecnicas.setHora(hora);
        visitastecnicas.setEstadoVisitaTec(estadoVisitaTec);
        visitastecnicas.setClienteEdentidad(cliente);
        visitastecnicas.setTecnicoEdentidad(tecnico);        
        
        try {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Creado "));
            visitastecnicascontroller.insertarVisitasTecnicas(visitastecnicas);
            mostrarVisitasTecnicas();
            nuevo();
          } catch (Exception e) {
              
            System.out.println("Error: "+e.getMessage());
        }
    }
     
     public void mostrarVisitasTecnicas(){
        try {
            listarvisitastecnicas = visitastecnicascontroller.listarVisitasTecnicas();
            
        } catch (Exception e) {
            System.out.println("Error listar visitas: "+e.getMessage());
        }
    }
     
     public void agregarCliente(int idc,String nombrec, String direccionc, String telefonoc, String referenciac ){
        cliente.setIdCliente(idc);
        cliente.setNombreCliente(nombrec);
        cliente.setTelefonoCliente(telefonoc);
        cliente.setDirrecionCliente(direccionc);
        cliente.setReferenciaCliente(referenciac);
        
    }
     
    public void agregarTecnico(int idt,String nombret, String direcciont, String telefonot, String areat ){
        tecnico.setIdTecnico(idt);
        tecnico.setNombreTecnico(nombret);
        tecnico.setTelefonoTecnico(telefonot);
        tecnico.setDirrecionTecnico(direcciont);
        tecnico.setAreaTecnico(areat);
        
    }
    
       
       public void antActualizarVisitas(VisitasTecnicas visitastec) {
        System.out.println("Actualizado");
        nuevoVisitasTecnicasAct = new VisitasTecnicas();
        this.nuevoVisitasTecnicasAct = visitastec;
        System.out.println("Actualizado" + visitastec);
    }
     
    public void actualizarVisitasTecnicas(){
       try {
            visitastecnicascontroller.actualizarVisitasTecnicas(this.nuevoVisitasTecnicasAct);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Actualizado"));
            mostrarVisitasTecnicas();
            nuevo();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }
    }
    
     public void nuevo() {
        
        artefacto = " ";
        marcaartefacto = " ";
        daniotefacto = " ";
        hora = " ";
        estadoVisitaTec = " "; 
             
        RequestContext.getCurrentInstance().update("frmVisitasTecnicas");
    }
      private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
        RequestContext.getCurrentInstance().update("frmVisitasTecnicas");
    }
    
      public void eliminarVisitasTecnicas(VisitasTecnicas visitastecnicas) {
           visitastecnicas.setVisitaeliminado("S");
       try {
             visitastecnicascontroller.eliminarVisitasTecnicas(visitastecnicas);
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Eliminado "));
             mostrarVisitasTecnicas();
             nuevo();
           
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }
    }      

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getArtefacto() {
        return artefacto;
    }

    public void setArtefacto(String artefacto) {
        this.artefacto = artefacto;
    }

    public String getMarcaartefacto() {
        return marcaartefacto;
    }

    public void setMarcaartefacto(String marcaartefacto) {
        this.marcaartefacto = marcaartefacto;
    }

    public String getDaniotefacto() {
        return daniotefacto;
    }

    public void setDaniotefacto(String daniotefacto) {
        this.daniotefacto = daniotefacto;
    }

    public Date getFechavisitatec() {
        return fechavisitatec;
    }

    public void setFechavisitatec(Date fechavisitatec) {
        this.fechavisitatec = fechavisitatec;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public String getEstadoVisitaTec() {
        return estadoVisitaTec;
    }

    public void setEstadoVisitaTec(String estadoVisitaTec) {
        this.estadoVisitaTec = estadoVisitaTec;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public VisitasTecnicas getVisitastecnicas() {
        return visitastecnicas;
    }

    public void setVisitastecnicas(VisitasTecnicas visitastecnicas) {
        this.visitastecnicas = visitastecnicas;
    }

    public VisitasTecnicas getNuevoVisitasTecnicasAct() {
        return nuevoVisitasTecnicasAct;
    }

    public void setNuevoVisitasTecnicasAct(VisitasTecnicas nuevoVisitasTecnicasAct) {
        this.nuevoVisitasTecnicasAct = nuevoVisitasTecnicasAct;
    }

    public IVisitasTecnicasController getVisitastecnicascontroller() {
        return visitastecnicascontroller;
    }

    public void setVisitastecnicascontroller(IVisitasTecnicasController visitastecnicascontroller) {
        this.visitastecnicascontroller = visitastecnicascontroller;
    }

    public List<VisitasTecnicas> getListarvisitastecnicas() {
        return listarvisitastecnicas;
    }

    public void setListarvisitastecnicas(List<VisitasTecnicas> listarvisitastecnicas) {
        this.listarvisitastecnicas = listarvisitastecnicas;
    }


   
}



