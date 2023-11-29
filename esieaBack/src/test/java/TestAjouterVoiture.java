import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;
import esiea.api.VoitureAPI;
public class TestAjouterVoiture {

    @Test
    public void testAjouterVoiture() {
        VoitureAPI api = new VoitureAPI();
        String saisieJson = "{\"id\":15,\"marque\":\"Citroën\",\"modele\":\"C4 Picasso\",\"finition\":\"Feel\",\"carburant\":\"D\",\"km\":78000,\"annee\":2017,\"prix\":15500}";// votre JSON de test ici
        String result = api.ajouterVoiture(saisieJson);

        JSONObject Json = new JSONObject(result);
        //verifications du resultat via une assertion
        assertTrue(Json.getBoolean("succes"));
    }

    @Test
    public void testAjouterVoitureFalse() {
        VoitureAPI api = new VoitureAPI();
        String saisieJson = "{\"id\":15,\"marque\":\"Citroën\",\"modele\":\"C4 Picasso\",\"finition\":\"Feel\",\"carburant\":\"Diesel\",\"km\":78000,\"annee\":2017,\"prix\":15500}";// votre JSON de test ici
        String result = api.ajouterVoiture(saisieJson);

        JSONObject Json = new JSONObject(result);
        //verifications du resultat via une assertion
        assertFalse(Json.getBoolean("succes"));
    }
}