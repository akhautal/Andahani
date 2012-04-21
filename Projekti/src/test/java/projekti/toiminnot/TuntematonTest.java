/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.toiminnot;

import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import projekti.io.StubIO;

/**
 *
 * @author dasha
 */
public class TuntematonTest {
    private String[] tulosteet = new String[10];
    private StubIO io = new StubIO();

    @Before
    public void setUp() {
        io = new StubIO();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of suorita method, of class Tuntematon.
     */
    @Test
    public void testSuorita() {
        Tuntematon instance = new Tuntematon(io);
        instance.suorita();
        ArrayList<String> output = io.getOutput();
        
        assertEquals("Sallitut komennot: lisaa, listaa, bib, tagi ja lopeta.", output.get(0));
        assertEquals(1, output.size());
    }
}


