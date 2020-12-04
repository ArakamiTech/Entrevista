package com.proyecto.crud.impl;

import com.proyecto.crud.entities.CrudClientesEntity;
import com.proyecto.crud.interfaces.AbstractFacade;
import com.proyecto.crud.interfaces.CrudClientesEntityFacadeLocal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CrudClientesEntityFacade extends AbstractFacade<CrudClientesEntity> implements CrudClientesEntityFacadeLocal {

    @PersistenceContext(unitName = "jdbcPetTracking")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CrudClientesEntityFacade() {
        super(CrudClientesEntity.class);
    }

    @Override
    public CrudClientesEntity findByIdentification(String id) {
        try {
            return em.createNamedQuery("CrudClientesEntity.findByStrIdentificacion", CrudClientesEntity.class).setParameter("strIdentificacion", id).getSingleResult();
        } catch (Exception e) {
            return null;
        }   
    }
    
    @Override
    public void create(CrudClientesEntity client) {
        try {
            em.persist(client);
        } catch (Exception e) {        
        }   
    }

}
