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
    private VoitureDAO instance; // Remplacez VotreClasse par le nom de votre classe

    @Mock
    private Connection connection; // Remplacez Connection par le type de votre connexion à la base de données

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
        int id = 1; // Remplacez par l'ID de la voiture que vous souhaitez modifier
        Voiture nouvelleVoiture = new Voiture();
        nouvelleVoiture.setMarque("NouvelleMarque");
        nouvelleVoiture.setModele("NouveauModele");
        nouvelleVoiture.setFinition("NouvelleFinition");
        nouvelleVoiture.setKm(10000);
        nouvelleVoiture.setAnnee(2023);
        nouvelleVoiture.setPrix(25000);

        // Simulez la préparation de la requête
        Mockito.when(connection.prepareStatement(Mockito.anyString())).thenReturn(preparedStatement);

        // Exécutez la méthode à tester
        instance.modifierVoiture(id, nouvelleVoiture);

        // Vérifiez si la méthode PreparedStatement a été appelée avec les bonnes valeurs
        Mockito.verify(preparedStatement).setString(1, "NouvelleMarque");
        Mockito.verify(preparedStatement).setString(2, "NouveauModele");
        Mockito.verify(preparedStatement).setString(3, "NouvelleFinition");
        Mockito.verify(preparedStatement).setInt(5, 10000);
        Mockito.verify(preparedStatement).setInt(6, 2023);
        Mockito.verify(preparedStatement).setInt(7, 25000);
        Mockito.verify(preparedStatement).setInt(8, 1); // ID de la voiture
        Mockito.verify(preparedStatement).executeQuery();

        // Vous pouvez ajouter d'autres assertions selon vos besoins pour vérifier le comportement de la méthode.
    }

    @Test
    public void testRechercherVoitures() throws SQLException {
        String saisie = "9"; // Remplacez par la saisie souhaitée (ID de voiture)
        int mini = 0;
        int nbVoitures = 10;

        // Créez un ensemble de critères attendus pour la recherche
        Map<String, String> criteresAttendus = new HashMap<>();
        criteresAttendus.put("id", "1"); // Remplacez par les critères attendus

        // Créez un ensemble de voitures simulées qui sera retourné par getVoitures
        Voiture voiture1 = new Voiture();
        // Initialisez les propriétés de la voiture 1 selon vos besoins
        Voiture voiture2 = new Voiture();
        // Initialisez les propriétés de la voiture 2 selon vos besoins
        Voiture voiture3 = new Voiture();
        // Initialisez les propriétés de la voiture 3 selon vos besoins
        Voiture[] voituresAttendues = {voiture1, voiture2, voiture3};

        // Créez un objet ReponseVoiture simulé pour représenter le résultat attendu
        ReponseVoiture reponseAttendue = new ReponseVoiture();
        reponseAttendue.setData(voituresAttendues);
        // Assurez-vous que la méthode getVolume est correctement initialisée dans reponseAttendue
        reponseAttendue.setVolume(voituresAttendues.length);

        // Simulez l'appel à getVoitures avec les critères attendus
        Mockito.when(vDao.getVoitures((HashMap<String, String>) Mockito.eq(criteresAttendus), Mockito.eq(mini), Mockito.eq(nbVoitures)))
                .thenReturn(reponseAttendue);

        // Exécutez la méthode à tester
        ReponseVoiture resultat = instance.rechercherVoitures(saisie, mini, nbVoitures);

        // Vérifiez si le résultat obtenu correspond au résultat attendu
        assertArrayEquals(voituresAttendues, resultat.getData());
    }

}
