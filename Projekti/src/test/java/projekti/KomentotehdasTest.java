/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;
import projekti.toiminnot.Listaaminen;

/**
 *
 * @author dasha
 */
public class KomentotehdasTest {
    
    Komentotehdas komentotehdas;    
    ArrayList<String> input; 
    
    IOrajapinta ioStub = new IOrajapinta() {

        public void tulosta(String tuloste) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public String lue() {
            return input.remove(0);
        }
        
    };
            
    TiedostonkasittelijaRajapinta tallentajaStub = new TiedostonkasittelijaRajapinta() {

        public void tallenna(Viite viite) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public ArrayList<Viite> lueViitteet() {
            ArrayList<Viite> viitteet = new ArrayList<Viite>();
            
            String[][] eka = {{"millainenViite", "2"},
                                   {"label", "Discworld"},
                                   {"author", "Pratchett, Terry"},
                                   {"title",  "Discworld"}};

            String[][] toka = {{"millainenViite", "1"},
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
            
            String[][] kolmas = {{"millainenViite", "1"},
                                    {"label", "Tokalabel"},
                                    {"author", "Larsson, Stieg"},
                                    {"title",  "Dragon Tattoo"},
                                    {"journal", "-"},
                                    {"volume", "2"}, 
                                    {"number", "4"},
                                    {"year", "1995"},
                                    {"pages", "600"}};
            
            viitteet.add(new Viite(eka));
            viitteet.add(new Viite(toka));
            viitteet.add(new Viite(kolmas));
            return viitteet;
        }
        
    };
            
    @Before
    public void setUp() {
        input = new ArrayList<String>();
        komentotehdas = new Komentotehdas(ioStub, tallentajaStub);
    }
    
    @Test
    public void listaTesti() {
        input.add("lista");
        Listaaminen expResult = new Listaaminen(ioStub, tallentajaStub);
        Toiminta lista = komentotehdas.hae("lista");
        
        assertEquals(lista, expResult);
       
    }

    /**
     * Test of hae method, of class Komentotehdas.
     */
    @Test
    public void testHae() {
        System.out.println("hae");
        String operaatio = "";
        Komentotehdas instance = null;
        Toiminta expResult = null;
        Toiminta result = instance.hae(operaatio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
