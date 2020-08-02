/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.controller.impl;

import com.uisrael.gestionvisitas.controller.IClienteController;
import com.uisrael.gestionvisitas.modelo.dao.IClienteDao;
import com.uisrael.gestionvisitas.modelo.dao.impl.ClienteDaoImpl;
import com.uisrael.gestionvisitas.modelo.edentidad.Cliente;
import java.util.List;

/**
 *
 * @author XTREME
 */
public class ClienteControllerImpl implements IClienteController{

    @Override
    public void insertarCliente(Cliente nuevoCliente) {
        try {
         IClienteDao clientedao = new ClienteDaoImpl(Cliente.class);
         clientedao.insertarCliente(nuevoCliente);
         } catch (Exception e) {
            System.err.println("ERROR:" + e);
        }
    }

    @Override
    public List listarCliente() {
        try {
        IClienteDao clientedao = new ClienteDaoImpl(Cliente.class);
        return clientedao.listarCliente();
        } catch (Exception e) {
            System.err.println("ERROR:" + e);
            return null;
        }
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
         try {
            System.out.println("Se procede a Actualizar Cliente");
         IClienteDao clientedao = new ClienteDaoImpl(Cliente.class);
         clientedao.actualizarCliente(cliente);
         System.out.println("Carrera actualizado");
        } catch (Exception e) {
            System.out.println("El carrera que deseas actualizar no existe");
        }
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
         try {
            System.out.println("Se procede a eliminar Cliente logicamente");
          IClienteDao clientedao = new ClienteDaoImpl(Cliente.class);
          clientedao.eliminarCliente(cliente);
          System.out.println("Carrera eliminado");

        } catch (Exception e) {
            System.out.println("El carrera que deseas eliminar no existe");
        }
    }
    
}
