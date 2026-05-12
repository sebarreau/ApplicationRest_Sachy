package ht.mbds.barreausachyedvalle.applicationrest_sachy;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public Response hello() {
        return Response.ok("Hello, World!").build();
    }

    @GET
    @Path("personnes/{nom}")
    @Produces("text/plain")
    public Response helloPersonne(@PathParam("nom") String nom) {
       // return Response.ok("Hello, " + nom).build();
        return Response.serverError()
                .entity("Internal Server Error")
                .build();
    }
}