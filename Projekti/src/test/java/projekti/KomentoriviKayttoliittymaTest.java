/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author dasha
 */
public class KomentoriviKayttoliittymaTest {
    
    KomentoriviKayttoliittyma komentoriviKayttoliittyma;
    
//    IOrajapinta ioStub = new IOrajapinta() {
//
//        public void tulosta(String tuloste) {
//            throw new UnsupportedOperationException("Not supported yet.");
//        }
//
//        public String lue() {
//            throw new UnsupportedOperationException("Not supported yet.");
//        }
//        
//    }
    komentoriviIO io; 
            
    TiedostonkasittelijaRajapinta tallentajaStub = new TiedostonkasittelijaRajapinta() {

        public void tallenna(Viite viite) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public ArrayList<Viite> lueViitteet() {
            ArrayList<Viite> viitteet = new ArrayList<Viite>();
            
            String[][] ekaViite = {{"millainenViite", "2"},
                                   {"label", "Discworld"},
                                   {"author", "Pratchett, Terry"},
                                   {"title",  "Discworld"}};
            Viite eka = new Viite(ekaViite);

            String[][] tokaViite = {{"millainenViite", "1"},
                                    {"label", "Tokalabel"},
                                    {"author", "Larsson, Stieg"},
                                    {"title",  "Dragon Tattoo"},
                                    {"booktitle", "title"},
                                    {"journal", "-"},
                                    {"volume", "2"}, 
                                    {"number", "4"},
                                    {"year", "1995"},
                                    {"pages", "600"},
                                    {"publisher", "Weinerstrom"},
                                    {"address", "Helsinki, 07078, jokukatu 12c46"}};
            Viite toka = new Viite(tokaViite);
            
            viitteet.add(eka);
            viitteet.add(toka);
            return viitteet;
        }
        
    };
            
    public KomentoriviKayttoliittymaTest() {
        
        
    }
    
    @Before
    public void setUp() {
        io = new komentoriviIO();
        komentoriviKayttoliittyma = new KomentoriviKayttoliittyma(io, tallentajaStub);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testi() {
        
    }
    
    
    
    
    
    
    
    /**
     * Test of kaynnista method, of class KomentoriviKayttoliittyma.
     */
    @Test
    public void testKaynnista() {
        System.out.println("kaynnista");
        KomentoriviKayttoliittyma instance = null;
        instance.kaynnista();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of naytaOhjeet method, of class KomentoriviKayttoliittyma.
     */
    @Test
    public void testNaytaOhjeet() {
        System.out.println("naytaOhjeet");
        KomentoriviKayttoliittyma instance = null;
        instance.naytaOhjeet();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of annaViite method, of class KomentoriviKayttoliittyma.
     */
    @Test
    public void testAnnaViite() {
        System.out.println("annaViite");
        KomentoriviKayttoliittyma instance = null;
        Viite expResult = null;
        Viite result = instance.annaViite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
