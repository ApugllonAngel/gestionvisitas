/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.modelo.edentidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author XTREME
 */
@Entity
@Table(name = "vistastecnicas")
public class VisitasTecnicas implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idVisitasTecnicas")
    private int idVisitasTecnicas;
    
    @Temporal(TemporalType.DATE)
    private Date fecharegistro;
    
    @Column(name="artefacto")
    private String artefacto;
    
    @Column(name="marcaartefacto")
    private String marcaartefacto;
    
    @Column(name="daniotefacto")
    private String daniotefacto;
    
    @Temporal(TemporalType.DATE)
    private Date fechavisitatec;
    
    @Column(name="hora")
    private String hora;
    
    @Column(name="estadoVisitaTec")
    private String estadoVisitaTec;
    
     @Column(name="visitaeliminado")
    private String visitaeliminado;
    
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name="idTecnico")
   private Tecnico tecnicoEdentidad;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name="idCliente")
   private Cliente clienteEdentidad;
   
    
    public VisitasTecnicas() {
    }

    public VisitasTecnicas(int idVisitasTecnicas, Date fecharegistro, String artefacto, String marcaartefacto, String daniotefacto, Date fechavisitatec, String hora, String estadoVisitaTec, String visitaeliminado, Tecnico tecnicoEdentidad, Cliente clienteEdentidad) {
        this.idVisitasTecnicas = idVisitasTecnicas;
        this.fecharegistro = fecharegistro;
        this.artefacto = artefacto;
        this.marcaartefacto = marcaartefacto;
        this.daniotefacto = daniotefacto;
        this.fechavisitatec = fechavisitatec;
        this.hora = hora;
        this.estadoVisitaTec = estadoVisitaTec;
        this.visitaeliminado = visitaeliminado;
        this.tecnicoEdentidad = tecnicoEdentidad;
        this.clienteEdentidad = clienteEdentidad;
    }

    public int getIdVisitasTecnicas() {
        return idVisitasTecnicas;
    }

    public void setIdVisitasTecnicas(int idVisitasTecnicas) {
        this.idVisitasTecnicas = idVisitasTecnicas;
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

    public String getVisitaeliminado() {
        return visitaeliminado;
    }

    public void setVisitaeliminado(String visitaeliminado) {
        this.visitaeliminado = visitaeliminado;
    }

    public Tecnico getTecnicoEdentidad() {
        return tecnicoEdentidad;
    }

    public void setTecnicoEdentidad(Tecnico tecnicoEdentidad) {
        this.tecnicoEdentidad = tecnicoEdentidad;
    }

    public Cliente getClienteEdentidad() {
        return clienteEdentidad;
    }

    public void setClienteEdentidad(Cliente clienteEdentidad) {
        this.clienteEdentidad = clienteEdentidad;
    }

    @Override
    public String toString() {
        return "VisitasTecnicas{" + "idVisitasTecnicas=" + idVisitasTecnicas + ", fecharegistro=" + fecharegistro + ", artefacto=" + artefacto + ", marcaartefacto=" + marcaartefacto + ", daniotefacto=" + daniotefacto + ", fechavisitatec=" + fechavisitatec + ", hora=" + hora + ", estadoVisitaTec=" + estadoVisitaTec + ", visitaeliminado=" + visitaeliminado + ", tecnicoEdentidad=" + tecnicoEdentidad + ", clienteEdentidad=" + clienteEdentidad + '}';
    }
  }
