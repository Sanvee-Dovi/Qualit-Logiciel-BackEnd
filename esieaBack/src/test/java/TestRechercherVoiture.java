import esiea.api.VoitureAPI;
import esiea.dao.ReponseVoiture;
import esiea.dao.VoitureDAO;
import esiea.metier.Voiture;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

public class TestRechercherVoiture {
    @InjectMocks
    private VoitureAPI instance;
    @Mock
    private VoitureDAO vDao;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetReponse() throws SQLException {
        String param = "id";
        int mini = 0;
        int nbVoitures = 10;

        Voiture voiture1 = new Voiture();
        Voiture voiture2 = new Voiture();
        Voiture voiture3 = new Voiture();
        List<Voiture> voituresAttendues = Arrays.asList(voiture1, voiture2, voiture3);
        ReponseVoiture reponseAttendue = new ReponseVoiture();
        reponseAttendue.setData(voituresAttendues.toArray(new Voiture[0]));

        Mockito.when(vDao.rechercherVoitures(Mockito.eq(param), Mockito.eq(mini), Mockito.eq(nbVoitures)))
                .thenReturn(reponseAttendue);
        ReponseVoiture resultat = instance.getReponse(param, mini, nbVoitures);
        Voiture[] resultatVoitures = resultat.getData();
        assertEquals(voituresAttendues.size(), resultatVoitures.length);
        for (int i = 0; i < voituresAttendues.size(); i++) {
            Voiture expectedVoiture = voituresAttendues.get(i);
            Voiture actualVoiture = resultatVoitures[i];
            assertEquals(expectedVoiture.getMarque(), actualVoiture.getMarque());
            assertEquals(expectedVoiture.getModele(), actualVoiture.getModele());
        }
    }
}
