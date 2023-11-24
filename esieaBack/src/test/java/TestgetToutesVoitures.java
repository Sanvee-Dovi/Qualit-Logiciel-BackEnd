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
    private VoitureAPI instance; // Remplacez VotreClasseAVerifier par le nom de votre classe

    @Mock
    private VoitureDAO vDao; // Remplacez VoitureDAO par le type de votre classe de DAO

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetToutesVoitures() throws SQLException {
        int mini = 0;
        int nbVoitures = 10; // Remplacez ces valeurs par celles que vous souhaitez tester

        // Créez une liste simulée de voitures qui sera retournée par vDao.getVoitures
        Voiture voiture1 = new Voiture();
        // Initialisez les propriétés de la voiture 1 selon vos besoins
        Voiture voiture2 = new Voiture();
        // Initialisez les propriétés de la voiture 2 selon vos besoins
        Voiture voiture3 = new Voiture();
        // Initialisez les propriétés de la voiture 3 selon vos besoins
        List<Voiture> voituresAttendues = Arrays.asList(voiture1, voiture2, voiture3);

        // Créez un objet ReponseVoiture simulé
        ReponseVoiture reponseVoitureSimule = new ReponseVoiture();
        reponseVoitureSimule.setVoitures(voituresAttendues);

        // Définissez le comportement attendu de vDao.getVoitures pour retourner reponseVoitureSimule
        Mockito.when(vDao.getVoitures(null, mini, nbVoitures)).thenReturn(reponseVoitureSimule);

        ReponseVoiture resultat = instance.getToutesVoitures(mini, nbVoitures);

        // Vérifiez si le résultat obtenu correspond au résultat attendu
        // Vous pouvez personnaliser cette vérification en fonction de votre classe ReponseVoiture
        assertEquals(voituresAttendues, resultat.getVoitures());
    }


}
