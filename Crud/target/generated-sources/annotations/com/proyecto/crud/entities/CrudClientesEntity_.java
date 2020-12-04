package com.proyecto.crud.entities;

import com.proyecto.crud.entities.CrudTarjetasCreditoEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-03T20:37:34")
@StaticMetamodel(CrudClientesEntity.class)
public class CrudClientesEntity_ { 

    public static volatile SingularAttribute<CrudClientesEntity, String> strNumeroTelefono;
    public static volatile SingularAttribute<CrudClientesEntity, Short> numIdCliente;
    public static volatile ListAttribute<CrudClientesEntity, CrudTarjetasCreditoEntity> crudTarjetasCreditoEntityList;
    public static volatile SingularAttribute<CrudClientesEntity, String> strIdentificacion;
    public static volatile SingularAttribute<CrudClientesEntity, String> strNombre;

}