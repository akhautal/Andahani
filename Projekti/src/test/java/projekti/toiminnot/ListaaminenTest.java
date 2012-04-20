/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.toiminnot;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;
import projekti.Viite;

/**
 *
 * @author hanna
 */
public class ListaaminenTest {
    public static String[] tuloste = new String[10];
    
    public ListaaminenTest() {
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

    /**
     * Test of suorita method, of class Listaaminen.
     */
    @Test
    public void testSuorita() {
        Listaaminen instance = new Listaaminen(new ioStub2(), new tiedostoKasittelijaStub2());
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
}



class ioStub2 implements projekti.IOrajapinta{
    private int i = 0;
    
    public void tulosta(String tuloste) {
        ListaaminenTest.tuloste[i] = tuloste;
        System.out.println(ListaaminenTest.tuloste[i]);
        i++;
    }

    public String lue() {
        return null;
    }
    
}
class tiedostoKasittelijaStub2 implements projekti.TiedostonkasittelijaRajapinta{

    public void tallenna(Viite viite) {
    }

    public ArrayList<Viite> lueViitteet() {
        ArrayList<Viite> viitteet = new ArrayList<Viite>();
        
        Viite uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@book");
        uusi.lisaaTietoa("label", "testi");
        uusi.lisaaTietoa("author", "Pekka");
        uusi.lisaaTietoa("title", "Otsikko");
        
        viitteet.add(uusi);
        
        uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@article");
        uusi.lisaaTietoa("label", "testilabel");
        uusi.lisaaTietoa("author", "Matti");
        uusi.lisaaTietoa("title", "Otsikko2");
        
        viitteet.add(uusi);
        return viitteet;
    }

    public boolean labelOnOlemassa(String label) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void lisaaTagitTiedostoon(String label, ArrayList<String> tagit) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}