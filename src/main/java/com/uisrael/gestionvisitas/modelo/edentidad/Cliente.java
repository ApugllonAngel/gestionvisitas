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
@Table(name = "cliente")
public class Cliente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCliente")
    private int idCliente;
    @Column(name="nombreCliente")
    private String nombreCliente;
    @Column(name="dirrecionCliente")
    private String dirrecionCliente;
    @Column(name="telefonoCliente")
    private String telefonoCliente;
    @Column(name="ReferenciaCliente")
    private String referenciaCliente;
    @Column(name = "clienteeliminado")
    private String clienteEliminado;
    
    @OneToMany(mappedBy = "clienteEdentidad")
    private List<VisitasTecnicas> clienteEdentidad = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(int idCliente, String nombreCliente, String dirrecionCliente, String telefonoCliente, String referenciaCliente, String clienteEliminado) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.dirrecionCliente = dirrecionCliente;
        this.telefonoCliente = telefonoCliente;
        this.referenciaCliente = referenciaCliente;
        this.clienteEliminado = clienteEliminado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public String getClienteEliminado() {
        return clienteEliminado;
    }

    public void setClienteEliminado(String clienteEliminado) {
        this.clienteEliminado = clienteEliminado;
    }

    public List<VisitasTecnicas> getClienteEdentidad() {
        return clienteEdentidad;
    }

    public void setClienteEdentidad(List<VisitasTecnicas> clienteEdentidad) {
        this.clienteEdentidad = clienteEdentidad;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + ", dirrecionCliente=" + dirrecionCliente + ", telefonoCliente=" + telefonoCliente + ", referenciaCliente=" + referenciaCliente + ", clienteEliminado=" + clienteEliminado + ", clienteEdentidad=" + clienteEdentidad + '}';
    }

   
}
