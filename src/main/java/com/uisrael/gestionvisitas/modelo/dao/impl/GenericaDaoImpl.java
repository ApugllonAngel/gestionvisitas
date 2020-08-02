/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.modelo.dao.impl;








import com.uisrael.gestionvisitas.modelo.dao.IGenericDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;


/**
 *
 * @author master
 * @param <T>
 */
public class GenericaDaoImpl<T> implements IGenericDao<T>{
  private Class<T> entityClass;
   
    protected static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.uisrael_GestionVisitas_war_Gestionv1PU");
    protected EntityManager entityManager;

    public GenericaDaoImpl() 
    {
        entityManager = emf.createEntityManager();
    }
    
    public GenericaDaoImpl(Class<T>entityClass)
    {
        this.entityClass = entityClass;
        entityManager = emf.createEntityManager();
    }
    
    //Definimos el CRUD
@Override
    public T create(T t) {
        this.entityManager.persist(t);
        return t;

    }

   @Override
    public T read(Object id) {
        return this.entityManager.find(entityClass, id);
    }

   @Override
    public T update(T t) {
        return this.entityManager.merge(t);
    }

   @Override
    public void delete(T t) {
        t = this.entityManager.merge(t);
        this.entityManager.remove(t);
    }

   @Override
    public void beginTransaction() {
        if (!entityManager.getTransaction().isActive()) {
            entityManager = emf.createEntityManager();
        }
        entityManager.getTransaction().begin();
    }

   @Override
    public void commit() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().commit();
        }
    }

   @Override
    public void rollback() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

   @Override
    public void closeTransaction() {
        entityManager.close();
    }

   @Override
    public void commitAndCloseTransaction() {
        commit();
        closeTransaction();
    }

   @Override
    public void flush() {
        entityManager.flush();
    }

   @Override
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = 
                this.entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return this.entityManager.createQuery(cq).getResultList();
    }
    
}
