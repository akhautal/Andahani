/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;
import projekti.toiminnot.*;

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
            throw new UnsupportedOperationException("Not supported yet.");
        }
    };
            
    TiedostonkasittelijaRajapinta tallentajaStub = new TiedostonkasittelijaRajapinta() {

        public void tallenna(Viite viite) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public ArrayList<Viite> lueViitteet() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    };
            
    @Before
    public void setUp() {
        input = new ArrayList<String>();
        komentotehdas = new Komentotehdas(ioStub, tallentajaStub);
    }
    
    @Test
    public void lisaaTesti() {
        Lisaaminen expResult = new Lisaaminen(ioStub, tallentajaStub);
        Toiminta result = komentotehdas.hae("lisaa");        
        assertEquals(result.getClass(), expResult.getClass());
    }
     
    @Test
    public void listaTesti() {
        Listaaminen expResult = new Listaaminen(ioStub, tallentajaStub);
        Toiminta result = komentotehdas.hae("lista");        
        assertEquals(result.getClass(), expResult.getClass());
    }
    
    @Test
    public void lopetaTesti() {
        Lopeta expResult = new Lopeta(ioStub);
        Toiminta result = komentotehdas.hae("lopeta");        
        assertEquals(result.getClass(), expResult.getClass());
    }
     
    @Test
    public void bibTesti() {
        Bib expResult = new Bib(ioStub, tallentajaStub);
        Toiminta result = komentotehdas.hae("bib");        
        assertEquals(result.getClass(), result.getClass());
    }
      
    @Test
    public void tuntematonKomentoTesti() {
        Tuntematon expResult = new Tuntematon(ioStub);
        Toiminta result = komentotehdas.hae("unexistentcommand!");        
        assertEquals(result.getClass(), result.getClass());
    }
    
    @Test
    public void tyhjaKomentoTesti() {
        Tuntematon expResult = new Tuntematon(ioStub);
        Toiminta result = komentotehdas.hae("");        
        assertEquals(result.getClass(), result.getClass());
    }
}


//ArrayList<String> input; 
//    
//    IOrajapinta ioStub = new IOrajapinta() {
//
//        public void tulosta(String tuloste) {
//            throw new UnsupportedOperationException("Not supported yet.");
//        }
//
//        public String lue() {
//            return input.remove(0);
//        }
//        
//    };
//            
//    TiedostonkasittelijaRajapinta tallentajaStub = new TiedostonkasittelijaRajapinta() {
//
//        public void tallenna(Viite viite) {
//            throw new UnsupportedOperationException("Not supported yet.");
//        }
//
//        public ArrayList<Viite> lueViitteet() {
//            ArrayList<Viite> viitteet = new ArrayList<Viite>();
//            
//            String[][] eka = {{"millainenViite", "2"},
//                                   {"label", "Discworld"},
//                                   {"author", "Pratchett, Terry"},
//                                   {"title",  "Discworld"}};
//
//            String[][] toka = {{"millainenViite", "1"},
//                                    {"label", "Tokalabel"},
//                                    {"author", "Larsson, Stieg"},
//                                    {"title",  "Dragon Tattoo"},
//                                    {"booktitle", "title"},
//                                    {"journal", "-"},
//                                    {"volume", "2"}, 
//                                    {"number", "4"},
//                                    {"year", "1995"},
//                                    {"pages", "600"},
//                                    {"publisher", "Weinerstrom"},
//                                    {"address", "Helsinki, 07078, jokukatu 12c46"}};
//            
//            String[][] kolmas = {{"millainenViite", "1"},
//                                    {"label", "Tokalabel"},
//                                    {"author", "Larsson, Stieg"},
//                                    {"title",  "Dragon Tattoo"},
//                                    {"journal", "-"},
//                                    {"volume", "2"}, 
//                                    {"number", "4"},
//                                    {"year", "1995"},
//                                    {"pages", "600"}};
//            
//            viitteet.add(new Viite(eka));
//            viitteet.add(new Viite(toka));
//            viitteet.add(new Viite(kolmas));
//            return viitteet;
//        }
//        
//    };