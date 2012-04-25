/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.toiminnot;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;
import projekti.Viite;
import projekti.io.StubIO;
import projekti.tiedostonkasittely.StubTK;

/**
 *
 * @author hanna
 */
public class TagiHakuTest {
    private StubIO io;
    private StubTK tk;
    private TagiHaku instance;
    
    public TagiHakuTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        tk = new StubTK();
        io = new StubIO();
        instance = new TagiHaku(io, tk);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of suorita method, of class TagiHaku.
     */
    @Test
    public void tagitTulostuvat() {
        Viite uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@book");
        uusi.lisaaTietoa("label", "testi");
        uusi.lisaaTietoa("author", "Pekka");
        uusi.lisaaTietoa("title", "Otsikko"); 
        uusi.lisaaTagi("tagi1");
        uusi.lisaaTagi("tagi2");
        tk.tallenna(uusi);
        
        uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@article");
        uusi.lisaaTietoa("label", "testilabel");
        uusi.lisaaTietoa("author", "Matti");
        uusi.lisaaTietoa("title", "Otsikko2");        
        uusi.lisaaTagi("tagi1");
        tk.tallenna(uusi);
        
        io = new StubIO("tagi1");
        instance = new TagiHaku(io, tk);
        instance.suorita();
        
        ArrayList<String> output = io.getOutput();
        assertEquals("Millä tagilla haluat hakea?", output.get(0));
        assertEquals("millainenViite = @book", output.get(1));
        assertEquals("label = testi", output.get(2));
        assertEquals("author = Pekka", output.get(3));
        assertEquals("title = Otsikko", output.get(4));
        assertEquals("tagit: tagi1,tagi2.", output.get(5));
        assertEquals("", output.get(6));
        assertEquals("millainenViite = @article", output.get(7));
        assertEquals("label = testilabel", output.get(8));
        assertEquals("author = Matti", output.get(9));
        assertEquals("title = Otsikko2", output.get(10));
        assertEquals("tagit: tagi1.", output.get(11));
        assertEquals("", output.get(12));
    }
    
    @Test
    public void vainTaginSisaltavatViitteetTulostuvat() {
        Viite uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@book");
        uusi.lisaaTietoa("label", "testi");
        uusi.lisaaTietoa("author", "Pekka");
        uusi.lisaaTietoa("title", "Otsikko"); 
        uusi.lisaaTagi("tagi1");
        uusi.lisaaTagi("tagi2");
        tk.tallenna(uusi);
        
        uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@article");
        uusi.lisaaTietoa("label", "testilabel");
        uusi.lisaaTietoa("author", "Matti");
        uusi.lisaaTietoa("title", "Otsikko2");        
        uusi.lisaaTagi("tagi1");
        tk.tallenna(uusi);
        
        uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@article");
        uusi.lisaaTietoa("label", "testilabel");
        uusi.lisaaTietoa("author", "Matti");
        uusi.lisaaTietoa("title", "Otsikko2");        
        uusi.lisaaTagi("testitagi");
        tk.tallenna(uusi);
        
        io = new StubIO("tagi1");
        instance = new TagiHaku(io, tk);
        instance.suorita();
        
        ArrayList<String> output = io.getOutput();
        assertEquals("Millä tagilla haluat hakea?", output.get(0));
        assertEquals("millainenViite = @book", output.get(1));
        assertEquals("label = testi", output.get(2));
        assertEquals("author = Pekka", output.get(3));
        assertEquals("title = Otsikko", output.get(4));
        assertEquals("tagit: tagi1,tagi2.", output.get(5));
        assertEquals("", output.get(6));
        assertEquals("millainenViite = @article", output.get(7));
        assertEquals("label = testilabel", output.get(8));
        assertEquals("author = Matti", output.get(9));
        assertEquals("title = Otsikko2", output.get(10));
        assertEquals("tagit: tagi1.", output.get(11));
        assertEquals("", output.get(12));
        assertEquals(13, output.size());
    }
    
    @Test
    public void testTyhjaListaaminen() {
        io = new StubIO("tagi1");
        instance = new TagiHaku(io, tk);
        instance.suorita(); 
        assertEquals("Millä tagilla haluat hakea?", io.getOutput().get(0));
        assertEquals("Viitteita ei ole tai tiedosto ei ole olemassa.\n", io.getOutput().get(1));
    }
    
    @Test
    public void olemattomallaTagillaEiLoydyMitaan() {
        Viite uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@book");
        uusi.lisaaTietoa("label", "testi");
        uusi.lisaaTietoa("author", "Pekka");
        uusi.lisaaTietoa("title", "Otsikko"); 
        uusi.lisaaTagi("tagi1");
        uusi.lisaaTagi("tagi2");
        tk.tallenna(uusi);
        
        io = new StubIO("tagi3");
        instance = new TagiHaku(io, tk);
        instance.suorita(); 
        assertEquals("Millä tagilla haluat hakea?", io.getOutput().get(0));
        assertEquals("Millään viitteellä ei ole tagia " + "tagi3" + ".", io.getOutput().get(1));
    }
    
    @Test
    public void testTiedostoEiOleOlemassa() {
        tk.poistaTiedosto();
        io = new StubIO("tagi1");
        instance = new TagiHaku(io, tk);
        
        instance.suorita();      
        assertEquals("Millä tagilla haluat hakea?", io.getOutput().get(0));
        assertEquals("Viitteita ei ole tai tiedosto ei ole olemassa.\n", io.getOutput().get(1));
    }
}
