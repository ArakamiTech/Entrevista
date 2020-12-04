package com.proyecto.crud.services;

import com.proyecto.crud.entities.CrudClientesEntity;
import com.proyecto.crud.interfaces.CrudClientesEntityFacadeLocal;
import com.proyecto.crud.interfaces.CrudTarjetasCreditoEntityFacadeLocal;
import com.proyecto.crud.security.Secured;
import com.proyecto.crud.util.Util;
import javax.ejb.EJB;
import javax.naming.AuthenticationException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

@Path("/clientes")
public class ClientesResource {

    @EJB
    private CrudClientesEntityFacadeLocal crudClientesEntityFacadeLocal;

    @EJB
    private CrudTarjetasCreditoEntityFacadeLocal crudTarjetasCreditoEntityFacadeLocal;

    @Context
    private UriInfo context;

    /**
     *
     * @param user
     * @param password
     * @return
     */
    @GET
    @Path("/login")
    public Response authenticateUser(@QueryParam("user") String user,
            @QueryParam("password") String password) {
        Util util = new Util();
        try {
            String roles = util.authenticate(user, password);
            String token = util.issueToken(user, roles);
            return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token).build();
        } catch (AuthenticationException e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    /**
     *
     * @param secContext
     * @param identificacion
     * @return
     */
    @GET
    @Path("/find")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Secured
    public CrudClientesEntity findClient(@Context SecurityContext secContext, @QueryParam("identificacion") String identificacion) {
        CrudClientesEntity client = crudClientesEntityFacadeLocal.findByIdentification(identificacion);
        return client;
    }

    /**
     *
     * @param secContext
     * @param client
     * @return
     */
    @POST
    @Path("/create")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Secured
    public Response create(@Context SecurityContext secContext, CrudClientesEntity client) {
        try {
            CrudClientesEntity clientObject = crudClientesEntityFacadeLocal.findByIdentification(client.getStrIdentificacion());
            if (clientObject == null) {
                crudClientesEntityFacadeLocal.create(client);
                return Response.ok(client).build();
            }
            return Response.status(Status.BAD_REQUEST).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    /**
     *
     * @param secContext
     * @param client
     * @return
     */
    @PUT
    @Path("/edit")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Secured
    public Response edit(@Context SecurityContext secContext, CrudClientesEntity client) {
        try {
            CrudClientesEntity clientObject = crudClientesEntityFacadeLocal.findByIdentification(client.getStrIdentificacion());
            if (clientObject != null) {
                clientObject.setStrNombre(client.getStrNombre());
                clientObject.setStrNumeroTelefono(client.getStrNumeroTelefono());
                crudClientesEntityFacadeLocal.edit(clientObject);
                return Response.ok(clientObject).build();
            }
            return Response.status(Status.BAD_REQUEST).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
