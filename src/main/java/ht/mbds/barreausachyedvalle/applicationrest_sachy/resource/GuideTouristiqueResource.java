package ht.mbds.barreausachyedvalle.applicationrest_sachy.resource;

import ht.mbds.barreausachyedvalle.applicationrest_sachy.llm.GuideTouristiqueService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.inject.Inject;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RequestScoped
@Path("/guide")
public class GuideTouristiqueResource {

    @Inject
    private GuideTouristiqueService guideTouristiqueService;

    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String endroitsDeVisite(@PathParam("ville_ou_pays") String villeOuPays) {
        return guideTouristiqueService.demanderGuide(villeOuPays);
    }
}
