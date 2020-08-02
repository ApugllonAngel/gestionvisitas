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
import javax.persistence.Table;

/**
 *
 * @author XTREME
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUsuario")
    private int idUsuario;
    @Column(name="usuario")
    private String usuario;
    @Column(name="password")
    private String password;
    @Column(name="tipoUsuario")
    private String tipoUsuario;
    
    @Column(name="eleminarusuario")
    private String eleminarsuario;
    
    public Usuario() {
    }

    public Usuario(int idUsuario, String usuario, String password, String tipoUsuario, String eleminarsuario) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
        this.eleminarsuario = eleminarsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getEleminarsuario() {
        return eleminarsuario;
    }

    public void setEleminarsuario(String eleminarsuario) {
        this.eleminarsuario = eleminarsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", usuario=" + usuario + ", password=" + password + ", tipoUsuario=" + tipoUsuario + ", eleminarsuario=" + eleminarsuario + '}';
    }
}
