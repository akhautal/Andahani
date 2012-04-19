/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.toiminnot;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;
import projekti.Viite;

/**
 *
 * @author hanna
 */
public class LisaaminenTest {
    public static Viite tuloste;
    
    public LisaaminenTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of suorita method, of class Lisaaminen.
     */
    @Test
    public void viiteLisataan() {
        Lisaaminen instance = new Lisaaminen(new ioStub(), new tiedostoKasittelijaStub());
        instance.suorita();
        String[][] lisatytTiedot = tuloste.annaTiedot();
        assertEquals(lisatytTiedot[0][1], "@inproceedings");
        assertEquals(lisatytTiedot[1][1], "testilabel");
        assertEquals(lisatytTiedot[2][1], "Pekka");
        assertEquals(lisatytTiedot[3][1], "Otsikko");
        assertEquals(lisatytTiedot[4][1], "");
        assertEquals(lisatytTiedot[11][1], "");
    }
}

class ioStub implements projekti.IOrajapinta{
    private String[] tuloste = {"1", "testilabel", "Pekka", "Otsikko", "", "", 
        "", "", "", "", "", ""};
    private int i = 0;
    
    public void tulosta(String tuloste) {
        //System.out.println(tuloste);
    }

    public String lue() {
        String syote = tuloste[i];
        i++;
        return syote;
    }
    
}
class tiedostoKasittelijaStub implements projekti.TiedostonkasittelijaRajapinta{

    public void tallenna(Viite viite) {
        LisaaminenTest.tuloste = viite;
    }

    public ArrayList<Viite> lueViitteet() {
        return null;
    }
    
}