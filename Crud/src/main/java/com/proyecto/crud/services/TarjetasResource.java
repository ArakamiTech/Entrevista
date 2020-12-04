package com.proyecto.crud.services;

import com.proyecto.crud.entities.CrudClientesEntity;
import com.proyecto.crud.entities.CrudTarjetasCreditoEntity;
import com.proyecto.crud.interfaces.CrudClientesEntityFacadeLocal;
import com.proyecto.crud.interfaces.CrudTarjetasCreditoEntityFacadeLocal;
import com.proyecto.crud.security.Secured;
import com.proyecto.crud.util.Util;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/tarjetas")
public class TarjetasResource {

    @EJB
    private CrudTarjetasCreditoEntityFacadeLocal crudTarjetasCreditoEntityFacadeLocal;

    @EJB
    private CrudClientesEntityFacadeLocal crudClientesEntityFacadeLocal;

    @Context
    private UriInfo context;

    public TarjetasResource() {
    }

    /**
     *
     * @param secContext
     * @param tarjeta
     * @param identificacion
     * @return
     */
    @POST
    @Path("/create")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Secured
    public Response create(@Context SecurityContext secContext, CrudTarjetasCreditoEntity tarjeta, @QueryParam("identificacion") String identificacion) {
        try {
            CrudClientesEntity client = crudClientesEntityFacadeLocal.findByIdentification(identificacion);
            if (client != null) {
                Util util = new Util();
                tarjeta.setNumIdCliente(client);
                tarjeta.setStrNumeroTarjeta(util.generadorNumeroTarjeta());
                tarjeta.setStrCvv(tarjeta.getStrNumeroTarjeta().substring(0, 3));
                tarjeta.setDateFechaVencimiento(util.fechaVencimiento());
                CrudTarjetasCreditoEntity tarjetaObject = crudTarjetasCreditoEntityFacadeLocal.findByNumeroTarjeta(tarjeta.getStrNumeroTarjeta());
                if (tarjetaObject == null) {
                    crudTarjetasCreditoEntityFacadeLocal.create(tarjeta);
                    return Response.ok(tarjeta).build();
                }
            }
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (Exception e) {
            System.out.println("ERROR " + e);
            return Response.serverError().build();
        }
    }

    /**
     *
     * @param secContext
     * @param numeroTarjeta
     * @return
     */
    @GET
    @Path("/find")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Secured
    public CrudTarjetasCreditoEntity findByNumeroTarjeta(@Context SecurityContext secContext, @QueryParam("numeroTarjeta") String numeroTarjeta) {
        return crudTarjetasCreditoEntityFacadeLocal.findByNumeroTarjeta(numeroTarjeta);
    }

    /**
     *
     * @param secContext
     * @param identificacion
     * @return
     */
    @GET
    @Path("/findByIdentificationClient")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Secured
    public List<CrudTarjetasCreditoEntity> findByIdentificationClient(@Context SecurityContext secContext, @QueryParam("identificacion") String identificacion) {
        CrudClientesEntity client = crudClientesEntityFacadeLocal.findByIdentification(identificacion);
        if (client != null) {
            return crudTarjetasCreditoEntityFacadeLocal.findByIdClient(client.getNumIdCliente());
        } else {
            return null;
        }
    }

    /**
     *
     * @param secContext
     * @param tarjeta
     * @return
     */
    @PUT
    @Path("/edit")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Secured
    public Response edit(@Context SecurityContext secContext, CrudTarjetasCreditoEntity tarjeta) {
        try {
            CrudTarjetasCreditoEntity tarjetaObject = crudTarjetasCreditoEntityFacadeLocal.findByNumeroTarjeta(tarjeta.getStrNumeroTarjeta());
            CrudClientesEntity cliente = crudClientesEntityFacadeLocal.findByIdentification(tarjeta.getNumIdCliente().getStrIdentificacion());
            cliente.setStrNombre(tarjeta.getNumIdCliente().getStrNombre());
            cliente.setStrNumeroTelefono(tarjeta.getNumIdCliente().getStrNumeroTelefono());
            crudClientesEntityFacadeLocal.edit(cliente);
            if (tarjetaObject != null) {
                Util util = new Util();
                tarjetaObject.setStrNumeroTarjeta(util.generadorNumeroTarjeta());
                tarjetaObject.setStrCvv(tarjeta.getStrNumeroTarjeta().substring(0, 3));
                tarjetaObject.setDateFechaVencimiento(util.fechaVencimiento());
                tarjetaObject.setNumIdCliente(cliente);
                crudTarjetasCreditoEntityFacadeLocal.edit(tarjetaObject);
                return Response.ok(tarjetaObject).build();
            }
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
