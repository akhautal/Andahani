/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.toiminnot;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;
import projekti.IOrajapinta;
import projekti.TiedostonkasittelijaRajapinta;
import projekti.Viite;

/**
 *
 * @author dasha
 */
public class LisaaTagiTest {
    private ArrayList<String> input = new ArrayList<String>();
    public ArrayList<String> tagit = new ArrayList<String>();
    public String output = new String();
    
    public LisaaTagiTest() {
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
    
    @Test
    public void uusTest() {
        LisaaTagi instance = new LisaaTagi(ioStub, tkStub);
        
        //Adding one reference to the file
        Viite uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@book");
        uusi.lisaaTietoa("label", "testilabel");
        uusi.lisaaTietoa("author", "Pekka2");
        uusi.lisaaTietoa("title", "Otsikko4");
        tkStub.tallenna(uusi);
        
        //now trying to search for unexistant reference
        input.add("testilabel4");
        input.add("testilabel");
        input.add("tagi");
        input.add("tagi4");
        input.add("");
        
        instance.suorita();
        assertEquals("tagi", output);
    }
    
    IOrajapinta ioStub = new IOrajapinta() {
 
        public void tulosta(String tuloste) {
        
        }

        public String lue() {
            if(input.isEmpty()) return null;

            return input.remove(0);
        }
    };
    
    TiedostonkasittelijaRajapinta tkStub = new TiedostonkasittelijaRajapinta() {
        private ArrayList<Viite> tiedosto = new ArrayList<Viite>();

        public void tallenna(Viite viite) {
            tiedosto.add(viite);
        }

        public ArrayList<Viite> lueViitteet() {
            return tiedosto;
        }
        
        public boolean labelOnOlemassa(String label) {
            for(Viite viite: tiedosto) {
                if(viite.getLabel().equals(label)) return true;
            }
            return false;
        }

        public void lisaaTagitTiedostoon(String label, ArrayList<String> tagit) {
            output = tagit.get(0);
        }
    };
}