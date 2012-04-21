/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import projekti.kayttoliittyma.KomentoriviKayttoliittyma;
import projekti.bibtex.BibtallentajaRajapinta;
import projekti.tiedostonkasittely.TiedostonkasittelijaRajapinta;
import projekti.io.IOrajapinta;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;
import projekti.toiminnot.Bib;

/**
 *
 * @author dasha
 */
public class KomentoriviKayttoliittymaTest {
    
    private KomentoriviKayttoliittyma instance;
    private ArrayList<String> input;
    private ArrayList<String> output;
        
    @Before
    public void setUp() {
        instance = new KomentoriviKayttoliittyma(ioStub, tkStub, bibStub);
        input = new ArrayList<String>();
        output = new ArrayList<String>();
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
        
        assertEquals("\"lisaa\" aloittaa uuden viitteen lisäyksen.", output.get(0));
        assertEquals("\"tagi\" aloittaa uuden tagin lisäyksen olemassaolevaan viitteeseen.", output.get(1));
        assertEquals("\"lopeta\" lopettaa.", output.get(2));
        assertEquals("\"lista\" listaa kaikki viitteet.", output.get(3));
        assertEquals("\"bib\" tulostaa kaikki viitteet bibtex-muodossa.", output.get(4));
        assertEquals("\n", output.get(5));
        assertEquals(output.size(), 6);
    }
    
    IOrajapinta ioStub = new IOrajapinta() {
 
        public void tulosta(String tuloste) {
            output.add(tuloste);
        }

        public String lue() {
            if(input.isEmpty()) return null;

            return input.remove(0);
        }
    };
            
    TiedostonkasittelijaRajapinta tkStub = new TiedostonkasittelijaRajapinta() {

        public void tallenna(Viite viite) {
        }

        public boolean labelOnOlemassa(String label) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void lisaaTagitTiedostoon(String label, ArrayList<String> tagit) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public ArrayList<Viite> lueViitteet() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    };
    
    BibtallentajaRajapinta bibStub = new BibtallentajaRajapinta() {

        public void tallenna(Viite viite, String tiedostonimi) {
         //   output = tiedostonimi;
        }
        
    };
}
