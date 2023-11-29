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
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class TestgetToutesVoitures  {

    @InjectMocks
    private VoitureAPI instance;

    @Mock
    private VoitureDAO vDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetToutesVoitures() throws SQLException {
        int mini = 0;
        int nbVoitures = 10;
        Voiture voiture1 = new Voiture();
        Voiture voiture2 = new Voiture();
        Voiture voiture3 = new Voiture();
        List<Voiture> voituresAttendues = Arrays.asList(voiture1, voiture2, voiture3);
        //Création  d'un objet ReponseVoiture simulé
        ReponseVoiture reponseVoitureSimule = new ReponseVoiture();
        reponseVoitureSimule.setVoitures(voituresAttendues);
        Mockito.when(vDao.getVoitures(null, mini, nbVoitures)).thenReturn(reponseVoitureSimule);
        ReponseVoiture resultat = instance.getToutesVoitures(mini, nbVoitures);
        //verifications de la reponse du resultat via une assertio
        assertEquals(voituresAttendues, resultat.getVoitures());
    }
}
