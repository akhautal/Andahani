/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.toiminnot;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;
import projekti.io.IOrajapinta;
import projekti.tiedostonkasittely.TiedostonkasittelijaRajapinta;
import projekti.Viite;

/**
 *
 * @author hanna
 */
public class ListaaminenTest {
    public static String[] tuloste = new String[10];
   // private ArrayList<Viite> tiedosto = new ArrayList<Viite>();
    private Listaaminen instance;
    
    @Before
    public void setUp() {
       // instance = new Listaaminen(ioStub, tiedostoKasittelijaStub);
        tuloste = new String[10];
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of suorita method, of class Listaaminen.
     */
    @Test
    public void testListaaminen() {
        
        tiedostoKasittelijaStub2 tkStub = new tiedostoKasittelijaStub2();
        instance = new Listaaminen(new ioStub2(), tkStub);
        
        ArrayList<Viite> viitteet = new ArrayList<Viite>();
        
        Viite uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@book");
        uusi.lisaaTietoa("label", "testi");
        uusi.lisaaTietoa("author", "Pekka");
        uusi.lisaaTietoa("title", "Otsikko");
        
        tkStub.tallenna(uusi);
        
        uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@article");
        uusi.lisaaTietoa("label", "testilabel");
        uusi.lisaaTietoa("author", "Matti");
        uusi.lisaaTietoa("title", "Otsikko2");
        
        tkStub.tallenna(uusi);
        
        instance.suorita();        
        assertEquals(tuloste[0], "millainenViite = @book");
        assertEquals(tuloste[1], "label = testi");
        assertEquals(tuloste[2], "author = Pekka");
        assertEquals(tuloste[3], "title = Otsikko");
        assertEquals(tuloste[4], "");
        assertEquals(tuloste[5], "millainenViite = @article");
        assertEquals(tuloste[6], "label = testilabel");
        assertEquals(tuloste[7], "author = Matti");
        assertEquals(tuloste[8], "title = Otsikko2");
        assertEquals(tuloste[9], "");
    }
    
    @Test
    public void testTyhjaListaaminen() {
         instance = new Listaaminen(new ioStub2(), new tiedostoKasittelijaStub2());
        instance.suorita();      
        assertEquals("Viitteita ei ole tai tiedosto ei ole olemassa.\n", tuloste[0]);
    }
    
    @Test
    public void testTiedostoEiOleOlemassa() {
        tiedostoKasittelijaStub2 tkStub = new tiedostoKasittelijaStub2();
        instance = new Listaaminen(new ioStub2(), tkStub);
        
        tkStub.poistaTiedosto();
        instance.suorita();      
        assertEquals("Viitteita ei ole tai tiedosto ei ole olemassa.\n", tuloste[0]);
    }  
    
    @Test
    public void testListaaminenTagienKanssa() {
        
        tiedostoKasittelijaStub2 tkStub = new tiedostoKasittelijaStub2();
        instance = new Listaaminen(new ioStub2(), tkStub);
               
        Viite uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@book");
        uusi.lisaaTietoa("label", "testi");
        uusi.lisaaTietoa("author", "Pekka");
        uusi.lisaaTietoa("title", "Otsikko");
        uusi.lisaaTagi("tagi1");
        uusi.lisaaTagi("tagi2");
        uusi.lisaaTagi("tagi3");
        tkStub.tallenna(uusi);
        
        instance.suorita();        
        assertEquals(tuloste[0], "millainenViite = @book");
        assertEquals(tuloste[1], "label = testi");
        assertEquals(tuloste[2], "author = Pekka");
        assertEquals(tuloste[3], "title = Otsikko");
        assertEquals(tuloste[4], "tagit: tagi1,tagi2,tagi3.");
        assertEquals(tuloste[5], "");
    }
}



class ioStub2 implements IOrajapinta {
    private int i = 0;

    public void tulosta(String tuloste) {
        ListaaminenTest.tuloste[i] = tuloste;
        i++;
    }

    public String lue() {
        return null;
    }
};


 class tiedostoKasittelijaStub2 implements projekti.tiedostonkasittely.TiedostonkasittelijaRajapinta {
        private ArrayList<Viite> tiedosto = new ArrayList<Viite>();

        public void tallenna(Viite viite) {
            tiedosto.add(viite);
        }

        public ArrayList<Viite> lueViitteet() {
            return tiedosto;
        }
        
        public void poistaTiedosto() {
            tiedosto = null;
        }
        
        public boolean labelOnOlemassa(String label) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void lisaaTagitTiedostoon(String label, ArrayList<String> tagit) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    };



