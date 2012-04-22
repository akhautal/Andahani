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
public class ListaaminenTest {

    private StubIO io;
    private StubTK tk;
    private Listaaminen instance;
    
    @Before
    public void setUp() {
        tk = new StubTK();
        io = new StubIO();
        instance = new Listaaminen(io, tk);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of suorita method, of class Listaaminen.
     */
    @Test
    public void testListaaminen() {
        Viite uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@book");
        uusi.lisaaTietoa("label", "testi");
        uusi.lisaaTietoa("author", "Pekka");
        uusi.lisaaTietoa("title", "Otsikko");        
        tk.tallenna(uusi);
        
        uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@article");
        uusi.lisaaTietoa("label", "testilabel");
        uusi.lisaaTietoa("author", "Matti");
        uusi.lisaaTietoa("title", "Otsikko2");        
        tk.tallenna(uusi);
        
        instance = new Listaaminen(io, tk);
        instance.suorita();
        
        ArrayList<String> output = io.getOutput();
        assertEquals("millainenViite = @book", output.get(0));
        assertEquals("label = testi", output.get(1));
        assertEquals("author = Pekka", output.get(2));
        assertEquals("title = Otsikko", output.get(3));
        assertEquals("", output.get(4));
        assertEquals("millainenViite = @article", output.get(5));
        assertEquals("label = testilabel", output.get(6));
        assertEquals("author = Matti", output.get(7));
        assertEquals("title = Otsikko2", output.get(8));
        assertEquals("", output.get(9));
    }
    
    @Test
    public void testTyhjaListaaminen() {
        instance.suorita();      
        assertEquals("Viitteita ei ole tai tiedosto ei ole olemassa.\n", io.getOutput().get(0));
    }
    
    @Test
    public void testTiedostoEiOleOlemassa() {
        tk.poistaTiedosto();
        instance = new Listaaminen(io, tk);
        
        instance.suorita();      
        assertEquals("Viitteita ei ole tai tiedosto ei ole olemassa.\n", io.getOutput().get(0));
    }  
    
    @Test
    public void testListaaminenTagienKanssa() {

        Viite uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@book");
        uusi.lisaaTietoa("label", "testi");
        uusi.lisaaTietoa("author", "Pekka");
        uusi.lisaaTietoa("title", "Otsikko");
        uusi.lisaaTagi("tagi1");
        uusi.lisaaTagi("tagi2");
        uusi.lisaaTagi("tagi3");
        tk.tallenna(uusi);
        instance = new Listaaminen(io, tk);
        
        instance.suorita();
        ArrayList<String> output = io.getOutput();
        assertEquals("millainenViite = @book", output.get(0));
        assertEquals("label = testi", output.get(1));
        assertEquals("author = Pekka", output.get(2));
        assertEquals("title = Otsikko", output.get(3));
        assertEquals("tagit: tagi1,tagi2,tagi3.", output.get(4));
        assertEquals("", output.get(5));
    }
}

