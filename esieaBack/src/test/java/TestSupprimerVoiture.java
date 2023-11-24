import org.junit.Test;
import static org.junit.Assert.*;
import esiea.api.VoitureAPI;


public class TestSupprimerVoiture {

    @Test
    public void testSupprimerVoiture() {
        VoitureAPI api = new VoitureAPI();
        String id = "15"; // Remplacez par l'ID de la voiture que vous souhaitez supprimer
        String result = api.supprimerVoiture(id);
        // Assurez-vous que le résultat est correct en fonction de vos attentes
        assertTrue(result.contains("succes"));
    }
}