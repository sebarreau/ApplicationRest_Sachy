package ht.mbds.barreausachyedvalle.applicationrest_sachy;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@RequestScoped
@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
    @GET
    @Path("personnes/{nom}")
    @Produces("text/plain")
    public String helloPersonne(@PathParam("nom") String nom) {
        return "Hello, " + nom;
    }
}