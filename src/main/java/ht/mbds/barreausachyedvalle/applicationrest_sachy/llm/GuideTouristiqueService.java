package ht.mbds.barreausachyedvalle.applicationrest_sachy.llm;

import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GuideTouristiqueService {

    private final GuideTouristique guideTouristique;

    public GuideTouristiqueService() {

        String apiKey = System.getenv("GEMINI_KEY");

        GoogleAiGeminiChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-2.5-flash-lite")
                .build();

        guideTouristique = AiServices.create(GuideTouristique.class, model);
    }


    public String demanderGuide(String villeOuPays, int nb) {
        return guideTouristique.endroitsDeVisite(villeOuPays, nb);
    }
}