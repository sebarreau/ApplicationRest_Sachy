package ht.mbds.barreausachyedvalle.applicationrest_sachy.llm;

import dev.langchain4j.service.SystemMessage;

public interface GuideTouristique {

    @SystemMessage("""
        Tu es un guide touristique.
        Pour la ville ou le pays donné, réponds uniquement en JSON.
        Donne exactement 2 endroits à visiter, pas plus.
        Respecte exactement ce format :
        {
          "ville_ou_pays": "nom de la ville ou du pays",
          "endroits_a_visiter": ["endroit 1", "endroit 2"],
          "prix_moyen_repas": "<prix> <devise du pays>"
        }
        Ne mets aucun texte avant ou après le JSON.
        """)
    String endroitsDeVisite(String villeOuPays);
}