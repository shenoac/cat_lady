package org.acme.controller;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.acme.persistence.Cat;

@Slf4j
@Path("/hello")
public class CatResource {

    @GET
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    public String cat(@QueryParam("name") String name) {
        Cat cat = new Cat();
        cat.name = name;
        cat.persist();
        log.info("Persisted cat with name: {}", name);
        return "Hello " + name;
    }
}
