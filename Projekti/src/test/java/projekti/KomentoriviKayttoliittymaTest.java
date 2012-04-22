/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import projekti.bibtex.StubBib;
import projekti.io.StubIO;
import projekti.kayttoliittyma.KomentoriviKayttoliittyma;
import projekti.tiedostonkasittely.StubTK;

/**
 *
 * @author dasha
 */
public class KomentoriviKayttoliittymaTest {
    
    private StubIO io;
    private StubTK tk;
    private StubBib bib;
    private KomentoriviKayttoliittyma instance;
      
    @Before
    public void setUp() {
        io = new StubIO();
        tk = new StubTK();
        bib = new StubBib();
        instance = new KomentoriviKayttoliittyma(io, tk, bib);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of kaynnista method, of class KomentoriviKayttoliittyma.
     */
    @Test
    public void testNaytaOhjeet() {
        instance.naytaOhjeet();
        ArrayList<String> output = io.getOutput();
        assertEquals("\"lisaa\" aloittaa uuden viitteen lisäyksen.", output.get(0));
        assertEquals("\"tagi\" aloittaa uuden tagin lisäyksen olemassaolevaan viitteeseen.", output.get(1));
        assertEquals("\"lopeta\" lopettaa.", output.get(2));
        assertEquals("\"lista\" listaa kaikki viitteet.", output.get(3));
        assertEquals("\"bib\" tulostaa kaikki viitteet bibtex-muodossa.", output.get(4));
        assertEquals("\n", output.get(5));
        assertEquals(output.size(), 6);
    }
}
