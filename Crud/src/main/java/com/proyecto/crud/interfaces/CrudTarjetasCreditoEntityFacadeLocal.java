package com.proyecto.crud.interfaces;

import com.proyecto.crud.entities.CrudTarjetasCreditoEntity;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CrudTarjetasCreditoEntityFacadeLocal {

    void create(CrudTarjetasCreditoEntity crudTarjetasCreditoEntity);

    void edit(CrudTarjetasCreditoEntity crudTarjetasCreditoEntity);

    void remove(CrudTarjetasCreditoEntity crudTarjetasCreditoEntity);

    CrudTarjetasCreditoEntity find(Object id);

    List<CrudTarjetasCreditoEntity> findAll();

    List<CrudTarjetasCreditoEntity> findRange(int[] range);
    
    List<CrudTarjetasCreditoEntity> findByIdClient(short id);

    int count();

    public CrudTarjetasCreditoEntity findByNumeroTarjeta(String strNumeroTarjeta);
    
}
