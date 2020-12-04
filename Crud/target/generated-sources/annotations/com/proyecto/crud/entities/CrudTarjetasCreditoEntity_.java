package com.proyecto.crud.entities;

import com.proyecto.crud.entities.CrudClientesEntity;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-03T20:37:34")
@StaticMetamodel(CrudTarjetasCreditoEntity.class)
public class CrudTarjetasCreditoEntity_ { 

    public static volatile SingularAttribute<CrudTarjetasCreditoEntity, String> strNumeroTarjeta;
    public static volatile SingularAttribute<CrudTarjetasCreditoEntity, CrudClientesEntity> numIdCliente;
    public static volatile SingularAttribute<CrudTarjetasCreditoEntity, String> strCvv;
    public static volatile SingularAttribute<CrudTarjetasCreditoEntity, String> strTipoTarjeta;
    public static volatile SingularAttribute<CrudTarjetasCreditoEntity, Short> numIdTarjeta;
    public static volatile SingularAttribute<CrudTarjetasCreditoEntity, Date> dateFechaVencimiento;

}