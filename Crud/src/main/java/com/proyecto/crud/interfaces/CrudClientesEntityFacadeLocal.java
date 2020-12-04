package com.proyecto.crud.interfaces;

import com.proyecto.crud.entities.CrudClientesEntity;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CrudClientesEntityFacadeLocal {

    void create(CrudClientesEntity crudClientesEntity);

    void edit(CrudClientesEntity crudClientesEntity);

    void remove(CrudClientesEntity crudClientesEntity);

    CrudClientesEntity find(Object id);

    CrudClientesEntity findByIdentification(String id);

    List<CrudClientesEntity> findAll();

    List<CrudClientesEntity> findRange(int[] range);

    int count();
    
}
