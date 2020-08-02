/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.modelo.dao.impl;

import com.uisrael.gestionvisitas.modelo.dao.IClienteDao;
import com.uisrael.gestionvisitas.modelo.edentidad.Cliente;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author XTREME
 */
public class ClienteDaoImpl extends GenericaDaoImpl<Cliente> implements IClienteDao{

    public ClienteDaoImpl(Class<Cliente> entityClass) {
        super(entityClass);
    }
    
    
    @Override
    public void insertarCliente(Cliente cliente) {
       this.beginTransaction();
       this.create(cliente);
       this.commit();
    }

    @Override
    public List listarCliente() {
         TypedQuery<Cliente> lista;
        lista= entityManager.createQuery("SELECT clie FROM Cliente clie ",Cliente.class);
        return lista.getResultList();
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
           this.beginTransaction();
            //persistir en la base de datos
            this.update(cliente);
            //registra en la base de datos
            this.commit();
            this.closeTransaction();
            //cerrar la concecion
            System.err.println("Guardado: "+cliente.toString()); }

    @Override
    public void eliminarCliente(Cliente cliente) {
        this.beginTransaction();
        this.delete(cliente);
        this.commit();
        this.closeTransaction();
    }
}
