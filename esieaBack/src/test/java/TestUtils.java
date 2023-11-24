import org.junit.Test;
import utils.StringUtils;

import static org.junit.Assert.*;

public class TestUtils {
    @Test
    public void testEstEntierAvecNombreEntier() {
        assertTrue(StringUtils.estEntier("123"));
    }

    @Test
    public void testEstEntierAvecNombreNegatif() {
        assertTrue(StringUtils.estEntier("-456"));
    }

    @Test
    public void testEstEntierAvecNombreDecimal() {
        assertFalse(StringUtils.estEntier("12.34"));
    }

    @Test
    public void testEstEntierAvecChaineNonNumerique() {
        assertFalse(StringUtils.estEntier("abc"));
    }

    @Test
    public void testNbOccurrenceAvecChaineVide() {
        assertEquals(0, StringUtils.nbOccurrence("", 'a'));
    }

    @Test
    public void testNbOccurrenceAvecCaractereNonPresent() {
        assertEquals(0, StringUtils.nbOccurrence("abcdef", 'g'));
    }

    @Test
    public void testNbOccurrenceAvecCaracterePresent() {
        assertEquals(3, StringUtils.nbOccurrence("banana", 'a'));
    }
}
