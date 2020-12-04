package com.proyecto.crud.impl;

import com.proyecto.crud.entities.CrudTarjetasCreditoEntity;
import com.proyecto.crud.interfaces.AbstractFacade;
import com.proyecto.crud.interfaces.CrudTarjetasCreditoEntityFacadeLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CrudTarjetasCreditoEntityFacade extends AbstractFacade<CrudTarjetasCreditoEntity> implements CrudTarjetasCreditoEntityFacadeLocal {

    @PersistenceContext(unitName = "jdbcPetTracking")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CrudTarjetasCreditoEntityFacade() {
        super(CrudTarjetasCreditoEntity.class);
    }

    @Override
    public List<CrudTarjetasCreditoEntity> findByIdClient(short id) {
        return em.createNativeQuery("SELECT * FROM CRUD_TARJETAS_CREDITO WHERE NUM_ID_CLIENTE = " + id, CrudTarjetasCreditoEntity.class).getResultList();
    }

    @Override
    public CrudTarjetasCreditoEntity findByNumeroTarjeta(String strNumeroTarjeta) {
        try {
            return em.createNamedQuery("CrudTarjetasCreditoEntity.findByStrNumeroTarjeta", CrudTarjetasCreditoEntity.class).setParameter("strNumeroTarjeta", strNumeroTarjeta).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void create(CrudTarjetasCreditoEntity tarjeta) {
        try {
            em.persist(tarjeta);
        } catch (Exception e) {
        }
    }

}
