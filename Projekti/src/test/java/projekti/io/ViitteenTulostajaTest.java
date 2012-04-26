/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.io;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;
import projekti.Viite;

/**
 *
 * @author hanna
 */
public class ViitteenTulostajaTest {
    private ViitteenTulostaja tulostaja;
    
    public ViitteenTulostajaTest() {
        tulostaja = new ViitteenTulostaja();
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
     * Test of tulostaViitteet method, of class ViitteenTulostaja.
     */
    @Test
    public void viitteetTulostuvat() {
        Viite viite1 = new Viite();
        viite1.lisaaTietoa("millainenViite", "@book");
        viite1.lisaaTietoa("label", "testi");
        viite1.lisaaTietoa("author", "Pekka");
        Viite viite2 = new Viite();
        viite2.lisaaTietoa("millainenViite", "@article");
        viite2.lisaaTietoa("label", "testilabel");
        viite2.lisaaTietoa("author", "Matti");
        
        ArrayList<Viite> viitteet = new ArrayList<Viite>();
        viitteet.add(viite1);
        viitteet.add(viite2);
        String tuloste = tulostaja.annaTuloste(viitteet);
        assertEquals("millainenViite = @book"+ "\n" + "label = testi" + "\n" +
                        "author = Pekka" +  "\n" + "\n" +
                        "millainenViite = @article" + "\n" + "label = testilabel" + "\n"
                        + "author = Matti" + "\n\n" , tuloste);
    }
    
    @Test
    public void viitteetTulostuvatTagienKanssa() {
        Viite viite1 = new Viite();
        viite1.lisaaTietoa("millainenViite", "@book");
        viite1.lisaaTietoa("label", "testi");
        viite1.lisaaTietoa("author", "Pekka");
        viite1.lisaaTagi("tagi1");
        viite1.lisaaTagi("tagi2");
        Viite viite2 = new Viite();
        viite2.lisaaTietoa("millainenViite", "@article");
        viite2.lisaaTietoa("label", "testilabel");
        viite2.lisaaTietoa("author", "Matti");
        viite2.lisaaTagi("tagi1");
        
        ArrayList<Viite> viitteet = new ArrayList<Viite>();
        viitteet.add(viite1);
        viitteet.add(viite2);
        String tuloste = tulostaja.annaTuloste(viitteet);
        assertEquals("millainenViite = @book"+ "\n" + "label = testi" + "\n" +
                        "author = Pekka" + "\n" +  
                        "tagit: tagi1,tagi2." + "\n" + "\n" +
                        "millainenViite = @article" + "\n" + "label = testilabel" + "\n"
                        + "author = Matti" + "\n" 
                        + "tagit: tagi1." + "\n\n" , tuloste);
    }
}
