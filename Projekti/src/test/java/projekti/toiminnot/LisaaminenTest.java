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
 * @author hanna
 */
public class LisaaminenTest {
    public static Viite tuloste;
    private ArrayList<String> input = new ArrayList<String>();
    private String output;
    
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
        input.clear();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of suorita method, of class Lisaaminen.
     */
    @Test
    public void viiteLisataanEiTagejaTest() {
        tiedostoKasittelijaStub tkStub = new tiedostoKasittelijaStub();
        Lisaaminen instance = new Lisaaminen(ioStub, tkStub);
        
        input.add("1");
        input.add("testilabel");
        input.add("Pekka");
        input.add("Otsikko");
        input.add("");
        input.add("");
        input.add("");
        input.add("");
        input.add("");
        input.add("");
        input.add("");
        input.add("");
        input.add("");

        instance.suorita();
        
        String[][] lisatytTiedot = tkStub.lueViitteet().get(0).annaTiedot();
        assertEquals(lisatytTiedot[0][1], "@inproceedings");
        assertEquals(lisatytTiedot[1][1], "testilabel");
        assertEquals(lisatytTiedot[2][1], "Pekka");
        assertEquals(lisatytTiedot[3][1], "Otsikko");
        assertEquals(lisatytTiedot[4][1], "");
        assertEquals(lisatytTiedot[11][1], "");
    }
    
    @Test
    public void viiteLisataanTagejaTest() {
        tiedostoKasittelijaStub tkStub = new tiedostoKasittelijaStub();
        Lisaaminen instance = new Lisaaminen(ioStub, tkStub);
        
        input.add("2");
        input.add("testilabel");
        input.add("Pekka");
        input.add("Otsikko");
        input.add("");
        input.add("");
        input.add("");
        input.add("");
        input.add("");
        input.add("");
        input.add("");
        input.add("");
        input.add("tagi1");
        input.add("tagi2");
        input.add("");
        
        instance.suorita();
        String[][] lisatytTiedot = tkStub.lueViitteet().get(0).annaTiedot();
        ArrayList<String> tagit = tkStub.lueViitteet().get(0).getTags();
        assertEquals(lisatytTiedot[0][1], "@book");
        assertEquals(lisatytTiedot[1][1], "testilabel");
        assertEquals(lisatytTiedot[2][1], "Pekka");
        assertEquals(lisatytTiedot[3][1], "Otsikko");
        assertEquals(lisatytTiedot[4][1], "");
        assertEquals(lisatytTiedot[11][1], "");
        assertEquals("tagi1", tagit.get(0));
        assertEquals("tagi2", tagit.get(1));
        assertEquals(2, tagit.size());
    }
    
    @Test
    public void millainenViiteOnVaarinTageja() {
        tiedostoKasittelijaStub tkStub = new tiedostoKasittelijaStub();
        Lisaaminen instance = new Lisaaminen(ioStub, tkStub);
        
        input.add("4");
        input.add("abc");
        input.add("");
        input.add("3");
        input.add("testilabel");
        input.add("Pekka");
        input.add("Otsikko");
        input.add("");
        input.add("");
        input.add("");
        input.add("");
        input.add("");
        input.add("");
        input.add("");
        input.add("");
        input.add("tagi1");
        input.add("tagi2");
        input.add("");
        
        instance.suorita();
        String[][] lisatytTiedot = tkStub.lueViitteet().get(0).annaTiedot();
        ArrayList<String> tagit = tkStub.lueViitteet().get(0).getTags();
        assertEquals(lisatytTiedot[0][1], "@article");
        assertEquals(lisatytTiedot[1][1], "testilabel");
        assertEquals(lisatytTiedot[2][1], "Pekka");
        assertEquals(lisatytTiedot[3][1], "Otsikko");
        assertEquals(lisatytTiedot[4][1], "");
        assertEquals(lisatytTiedot[11][1], "");
        assertEquals("tagi1", tagit.get(0));
        assertEquals("tagi2", tagit.get(1));
        assertEquals(2, tagit.size());
    }
    
    @Test
    public void labelOnJoOlemassaTest() {
        tiedostoKasittelijaStub tkStub = new tiedostoKasittelijaStub();
        Lisaaminen instance = new Lisaaminen(ioStub, tkStub);
        
        Viite uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@book");
        uusi.lisaaTietoa("label", "testilabel");
        uusi.lisaaTietoa("author", "Pekka2");
        uusi.lisaaTietoa("title", "Otsikko4");
        tkStub.tallenna(uusi);
        
        //yksi viite
        input.add("3");
        input.add("testilabel");
        input.add("");
        input.add("testilabel2");
        input.add("Pekka");
        input.add("Otsikko");
        input.add("");
        input.add("");
        input.add("");
        input.add("");
        input.add("");
        input.add("");
        input.add("");
        input.add("");
        input.add("tagi1");
        input.add("tagi2");
        input.add("");
 
        instance.suorita();
        String[][] lisatytTiedot = tkStub.lueViitteet().get(1).annaTiedot();
        ArrayList<String> tagit = tkStub.lueViitteet().get(1).getTags();
        assertEquals(lisatytTiedot[0][1], "@article");
        assertEquals(lisatytTiedot[1][1], "testilabel2");
        assertEquals(lisatytTiedot[2][1], "Pekka");
        assertEquals(lisatytTiedot[3][1], "Otsikko");
        assertEquals(lisatytTiedot[4][1], "");
        assertEquals(lisatytTiedot[11][1], "");
        assertEquals("tagi1", tagit.get(0));
        assertEquals("tagi2", tagit.get(1));
        assertEquals(2, tagit.size());
    }
    
    
    IOrajapinta ioStub = new IOrajapinta() {
 
        public void tulosta(String tuloste) {
        
        }

        public String lue() {
            if(input.isEmpty()) return null;

            return input.remove(0);
        }
    };
}

 class tiedostoKasittelijaStub implements projekti.tiedostonkasittely.TiedostonkasittelijaRajapinta {
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

