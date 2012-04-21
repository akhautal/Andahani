/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.toiminnot;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;
import projekti.io.IOrajapinta;
import projekti.Viite;

/**
 *
 * @author dasha
 */
public class TuntematonTest {
    private String[] tulosteet = new String[10];
    
    public TuntematonTest() {
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
     * Test of suorita method, of class Tuntematon.
     */
    @Test
    public void testSuorita() {
        Tuntematon instance = new Tuntematon(ioStub);
        instance.suorita();
        assertEquals("Sallitut komennot: lisaa, listaa, bib, tagi ja lopeta.", tulosteet[0]);
        assertNull(tulosteet[1]);
    }
    
    IOrajapinta ioStub = new IOrajapinta() {
        private int i = 0;

        public void tulosta(String tuloste) {
            tulosteet[i] = tuloste;
            i++;
        }

        public String lue() {
            return null;
        }
    };
}


