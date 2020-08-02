/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.modelo.edentidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author XTREME
 */
@Entity
@Table(name = "tecnico")
public class Tecnico implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idTecnico")
    private int idTecnico;
    @Column(name="nombreTecnico")
    private String nombreTecnico;
    @Column(name="dirrecionTecnico")
    private String dirrecionTecnico;
    @Column(name="telefonoTecnico")
    private String telefonoTecnico;
    @Column(name="areaTecnico")
    private String areaTecnico;
    @Column(name="estadoTecnico")
    private String estadoTecnico;
    @Column(name = "tecnicoEliminado")
    private String tecnicoEliminado;
    
    @OneToMany(mappedBy = "tecnicoEdentidad")
    private List<VisitasTecnicas> tecnicoEdentidad = new ArrayList<>();
    

    public Tecnico() {
    }

    public Tecnico(int idTecnico, String nombreTecnico, String dirrecionTecnico, String telefonoTecnico, String areaTecnico, String estadoTecnico, String tecnicoEliminado) {
        this.idTecnico = idTecnico;
        this.nombreTecnico = nombreTecnico;
        this.dirrecionTecnico = dirrecionTecnico;
        this.telefonoTecnico = telefonoTecnico;
        this.areaTecnico = areaTecnico;
        this.estadoTecnico = estadoTecnico;
        this.tecnicoEliminado = tecnicoEliminado;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
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

    public String getTecnicoEliminado() {
        return tecnicoEliminado;
    }

    public void setTecnicoEliminado(String tecnicoEliminado) {
        this.tecnicoEliminado = tecnicoEliminado;
    }

    public List<VisitasTecnicas> getTecnicoEdentidad() {
        return tecnicoEdentidad;
    }

    public void setTecnicoEdentidad(List<VisitasTecnicas> tecnicoEdentidad) {
        this.tecnicoEdentidad = tecnicoEdentidad;
    }

    @Override
    public String toString() {
        return "Tecnico{" + "idTecnico=" + idTecnico + ", nombreTecnico=" + nombreTecnico + ", dirrecionTecnico=" + dirrecionTecnico + ", telefonoTecnico=" + telefonoTecnico + ", areaTecnico=" + areaTecnico + ", estadoTecnico=" + estadoTecnico + ", tecnicoEliminado=" + tecnicoEliminado + ", tecnicoEdentidad=" + tecnicoEdentidad + '}';
    }
}
