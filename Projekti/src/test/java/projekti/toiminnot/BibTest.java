/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.toiminnot;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;
import projekti.BibtallentajaRajapinta;
import projekti.IOrajapinta;
import projekti.TiedostonkasittelijaRajapinta;
import projekti.Viite;

/**
 *
 * @author dasha
 */
public class BibTest {
    
    private Bib instance;
    private ArrayList<String> input = new ArrayList<String>();
    //ArrayList<String> output = new ArrayList<String>();
    private String output;
    
    @Before
    public void setUp() {
        input = new ArrayList<String>();
        output = null;
        instance = new Bib(ioStub, tallentajaStub, bibStub);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void tiedostoLuodaanJosAnnetuTiedostonNimiOnKelvollinen() {
        input.add("oikeanimi.bib");
                
        String expResult = "oikeanimi.bib";
        instance.suorita();
        String result = output;
        assertEquals(result, expResult);
    }
    
    @Test
    public void tiedostoaEiLuodaJosAnnetunTiedostonNiminLoppuOnVaarin1() {
        input.add("vaaranimi.bi");
        input.add("oikea.bib");
        
        String expResult = "oikea.bib";
        instance.suorita();
        String result = output;
        assertEquals(result, expResult);
    }
    
    @Test
    public void tiedostoaEiLuodaJosAnnetunTiedostonNiminLoppuOnVaarin2() {
        input.add("vaaranimi");
        input.add("oikeanimi.bib");
        
        String expResult = "oikeanimi.bib";
        instance.suorita();
        String result = output;
        assertEquals(result, expResult);
    }
    
    @Test
    public void tiedostoaEiLuodaJosAnnetunTiedostonNiminLoppuOnVaarin3() {
        input.add("vaaranimi.doc");
        input.add("oikeanimi.bib");
        
        String expResult = "oikeanimi.bib";
        instance.suorita();
        String result = output;
        assertEquals(result, expResult);
    }
        
    @Test
    public void tiedostoaEiLuodaJosAnnetunTiedostonNiminAlussaOnPiste() {
        input.add(".vaaranimi.doc");
        input.add("oikeanimi.bib");
        
        String expResult = "oikeanimi.bib";
        instance.suorita();
        String result = output;
        assertEquals(result, expResult);
    }
    
    @Test
    public void tiedostoaEiLuodaJosAnnettuTiedostonNimiSisaltaaKiellettyMerkki() {
        input.add("vaaranimi*.doc");
        input.add("oikeanimi.bib");
        
        String expResult = "oikeanimi.bib";
        instance.suorita();
        String result = output;
        assertEquals(result, expResult);
    }
    
    @Test
    public void tiedostoaEiLuodaJosAnnettuTiedostonNimiOnTyhja() {
        input.add("");
        input.add("oikeanimi.bib");
        
        String expResult = "oikeanimi.bib";
        instance.suorita();
        String result = output;
        assertEquals(result, expResult);
    }
    
    
    IOrajapinta ioStub = new IOrajapinta() {
 
        public void tulosta(String tuloste) {
        
        }

        public String lue() {
            if(input.isEmpty()) return null;

            return input.remove(0);
        }
    };
            
    TiedostonkasittelijaRajapinta tallentajaStub = new TiedostonkasittelijaRajapinta() {

        public void tallenna(Viite viite) {}

        public ArrayList<Viite> lueViitteet() {
            ArrayList<Viite> viitteet = new ArrayList<Viite>();
            
            String[][] eka = {{"millainenViite", "2"},
                              {"label", "Discworld"},
                              {"author", "Pratchett, Terry"},
                              {"title",  "Discworld"}};
            
            viitteet.add(new Viite(eka));
            return viitteet;
        }

        public boolean labelOnOlemassa(String label) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void lisaaTagitTiedostoon(String label, ArrayList<String> tagit) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    };
    
    BibtallentajaRajapinta bibStub = new BibtallentajaRajapinta() {

        public void tallenna(Viite viite, String tiedostonimi) {
            output = tiedostonimi;
        }
        
    };
}
