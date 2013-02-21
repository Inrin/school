

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Die Test-Klasse BenzaitenTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class BenzaitenTest
{
    /**
     * Konstruktor fuer die Test-Klasse BenzaitenTest
     */
    public BenzaitenTest()
    {
    }

    /**
     *  Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Gibt das Testgerüst wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void addTestANDgetNumberOfSongsTest()
    {
        Benzaiten benzaite2 = new Benzaiten();
        benzaite2.add("Inbound Part 3", "Joel Nielson", false, 186);
        assertEquals(1, benzaite2.getNumberOfSongs());
    }

    @Test
    public void removeTestANDgetNumberOfSongsTestANDaddTest()
    {
        Benzaiten benzaite1 = new Benzaiten();
        benzaite1.add("eins", "zwei", false, 180);
        assertEquals(1, benzaite1.getNumberOfSongs());
        benzaite1.remove(0);
        assertEquals(0, benzaite1.getNumberOfSongs());
    }

    @Test
    public void getNumberOfSongsByInterpreterTestANDaddTest()
    {
        Benzaiten benzaite2 = new Benzaiten();
        benzaite2.add("The Animal", "Disturbed", false, 253);
        assertEquals(1, benzaite2.getNumberOfSongsByInterpreter("Disturbed"));
    }

    @Test
    public void addTestANDgetSongsByInterpreterTest()
    {
        Benzaiten benzaite2 = new Benzaiten();
        benzaite2.add("Requiem for a Dream", "Lux Aeterna", false, 389);
        assertNotNull(benzaite2.getSongsByInterpreter("Lux Aeterna"));
    }

    @Test
    public void getSongsByStringTestANDaddTest()
    {
        Benzaiten benzaite1 = new Benzaiten();
        benzaite1.add("Master of Puppets", "Metallica", false, 512);
        assertNotNull(benzaite1.getSongsByString("Master"));
    }
}





