/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.modelo.dao;

import com.uisrael.gestionvisitas.modelo.edentidad.Cliente;
import java.util.List;

/**
 *
 * @author XTREME
 */
public interface IClienteDao {
    public void insertarCliente (Cliente cliente);
    public List listarCliente();
    public void actualizarCliente(Cliente cliente);
    public void eliminarCliente(Cliente cliente);
    
}
