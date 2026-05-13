package ht.mbds.barreausachyedvalle.applicationrest_sachy.resource;

import ht.mbds.barreausachyedvalle.applicationrest_sachy.llm.GuideTouristiqueService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path("/guide")
public class GuideTouristiqueResource {

    @Inject
    private GuideTouristiqueService guideTouristiqueService;

    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response endroitsDeVisite(
            @PathParam("ville_ou_pays") String villeOuPays,
            @QueryParam("nb") @DefaultValue("2") int nb) {

        String reponseJson =
                guideTouristiqueService.demanderGuide(villeOuPays, nb);

        Response.ResponseBuilder responseBuilder = Response.ok(reponseJson);
        responseBuilder.header("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
        responseBuilder.header("Pragma", "no-cache");
        responseBuilder.header("Expires", "0");
        responseBuilder.header("Access-Control-Allow-Origin", "*");
        return responseBuilder.build();

    }

}
