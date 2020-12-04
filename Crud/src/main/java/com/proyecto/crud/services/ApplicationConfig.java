package com.proyecto.crud.services;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.proyecto.crud.security.RestSecurityFilter.class);
        resources.add(com.proyecto.crud.services.ClientesResource.class);
        resources.add(com.proyecto.crud.services.TarjetasResource.class);
    }
    
}
