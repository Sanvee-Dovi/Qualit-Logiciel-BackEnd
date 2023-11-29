import esiea.dao.ReponseVoiture;
import esiea.dao.VoitureDAO;
import esiea.metier.Voiture;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;

public class TestVoitureDao {
    @InjectMocks
    private VoitureDAO instance;
    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    private VoitureDAO vDao;

    @Test
    public void testModifierVoiture() throws SQLException {
        int id = 1;
        Voiture nouvelleVoiture = new Voiture();
        nouvelleVoiture.setMarque("NouvelleMarque");
        nouvelleVoiture.setModele("NouveauModele");
        nouvelleVoiture.setFinition("NouvelleFinition");
        nouvelleVoiture.setKm(10000);
        nouvelleVoiture.setAnnee(2023);
        nouvelleVoiture.setPrix(25000);

        //Simulation de la préparation de la requête
        Mockito.when(connection.prepareStatement(Mockito.anyString())).thenReturn(preparedStatement);

        //Exécution de la méthode à tester
        instance.modifierVoiture(id, nouvelleVoiture);

        //Vérification de  si la méthode PreparedStatement a été appelée avec les bonnes valeurs
        Mockito.verify(preparedStatement).setString(1, "NouvelleMarque");
        Mockito.verify(preparedStatement).setString(2, "NouveauModele");
        Mockito.verify(preparedStatement).setString(3, "NouvelleFinition");
        Mockito.verify(preparedStatement).setInt(5, 10000);
        Mockito.verify(preparedStatement).setInt(6, 2023);
        Mockito.verify(preparedStatement).setInt(7, 25000);
        Mockito.verify(preparedStatement).setInt(8, 1); // ID de la voiture
        Mockito.verify(preparedStatement).executeQuery();
    }

    @Test
    public void testRechercherVoitures() throws SQLException {
        String saisie = "9";
        int mini = 0;
        int nbVoitures = 10;

        // Création de l' ensemble de critères attendus pour la recherche
        Map<String, String> criteresAttendus = new HashMap<>();
        criteresAttendus.put("id", "1"); // Remplacez par les critères attendus
        Voiture voiture1 = new Voiture();
        Voiture voiture2 = new Voiture();
        Voiture voiture3 = new Voiture();
        Voiture[] voituresAttendues = {voiture1, voiture2, voiture3};
        ReponseVoiture reponseAttendue = new ReponseVoiture();
        reponseAttendue.setData(voituresAttendues);
        reponseAttendue.setVolume(voituresAttendues.length);
        Mockito.when(vDao.getVoitures((HashMap<String, String>) Mockito.eq(criteresAttendus), Mockito.eq(mini), Mockito.eq(nbVoitures)))
                .thenReturn(reponseAttendue);
        ReponseVoiture resultat = instance.rechercherVoitures(saisie, mini, nbVoitures);

        // Vérification du resultat  obtenu avec des assertions
        assertArrayEquals(voituresAttendues, resultat.getData());
    }

}
