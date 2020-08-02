/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.modelo.edentidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author XTREME
 */
@Entity
@Table 
public class RolesUsuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRolesUsuaio")
    private int idRolesUsuario;
    
    @Column(name = "nombreUsuaio")
    private String nombreRoUser;
    
    @Column(name = "tipo")
    private String tipo;
    
    @Column(name = "tipoUsuaio")
    private String tipoUsuario;
    
    @ManyToOne
    @JoinColumn(name="idSubRoles")
    private RolesUsuario subroles;
    
    @Column(name = "url")
    private String url;
    
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "eliminarRoles")
    private String  eliminarRoles;

    public RolesUsuario() {
    }

    public RolesUsuario(int idRolesUsuario, String nombreRoUser, String tipo, String tipoUsuario, RolesUsuario subroles, String url, String estado, String eliminarRoles) {
        this.idRolesUsuario = idRolesUsuario;
        this.nombreRoUser = nombreRoUser;
        this.tipo = tipo;
        this.tipoUsuario = tipoUsuario;
        this.subroles = subroles;
        this.url = url;
        this.estado = estado;
        this.eliminarRoles = eliminarRoles;
    }

    public int getIdRolesUsuario() {
        return idRolesUsuario;
    }

    public void setIdRolesUsuario(int idRolesUsuario) {
        this.idRolesUsuario = idRolesUsuario;
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

    public RolesUsuario getSubroles() {
        return subroles;
    }

    public void setSubroles(RolesUsuario subroles) {
        this.subroles = subroles;
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

    public String getEliminarRoles() {
        return eliminarRoles;
    }

    public void setEliminarRoles(String eliminarRoles) {
        this.eliminarRoles = eliminarRoles;
    }

    @Override
    public String toString() {
        return "-" + subroles  ;
        
       
    }

   
}
