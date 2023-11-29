import org.junit.Test;
import static org.junit.Assert.*;
import esiea.api.VoitureAPI;


public class TestSupprimerVoiture {

    @Test
    public void testSupprimerVoiture() {
        VoitureAPI api = new VoitureAPI();
        String id = "15";
        String result = api.supprimerVoiture(id);
        assertTrue(result.contains("succes"));
    }
}