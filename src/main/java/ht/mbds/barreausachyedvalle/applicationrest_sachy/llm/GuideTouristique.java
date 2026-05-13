package ht.mbds.barreausachyedvalle.applicationrest_sachy.llm;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface GuideTouristique {


    @SystemMessage("""
            Tu es un guide touristique.
            Pour la ville ou le pays donné, indique exactement {{nb}} endroits à visiter,
            ainsi que le prix moyen d'un repas dans la devise du pays.
            N'utilise pas Markdown.
            Réponds uniquement en JSON avec exactement ce format :
            {
              "ville_ou_pays": "nom de la ville ou du pays",
              "endroits_a_visiter": ["endroit 1", "endroit 2"],
              "prix_moyen_repas": "<prix> <devise du pays>"
            }
            Ne mets aucun texte avant ou après le JSON.
            """)
    @UserMessage("Ville ou pays : {{villeOuPays}}. Nombre d'endroits : {{nb}}")
    String endroitsDeVisite(@V("villeOuPays") String villeOuPays, @V("nb") int nb);
}