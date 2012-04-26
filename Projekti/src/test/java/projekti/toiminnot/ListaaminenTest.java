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
        tk.tallenna(uusi);
        
        uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@article");
        uusi.lisaaTietoa("label", "testilabel");
        uusi.lisaaTietoa("author", "Matti");
        tk.tallenna(uusi);
        
        io = new StubIO();
        instance = new Listaaminen(io, tk);
        instance.suorita();
        
        ArrayList<String> output = io.getOutput();
        //System.err.println(io.getOutput().get(0));
        assertEquals("millainenViite = @book"+ "\n" + "label = testi" + "\n" +
                        "author = Pekka" +  "\n" + "\n" +
                        "millainenViite = @article" + "\n" + "label = testilabel" + "\n"
                        + "author = Matti" + "\n\n" , output.get(0));
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
        uusi.lisaaTagi("tagi1");
        uusi.lisaaTagi("tagi2");
        tk.tallenna(uusi);
        
        uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@article");
        uusi.lisaaTietoa("label", "testilabel");
        uusi.lisaaTietoa("author", "Matti");       
        uusi.lisaaTagi("tagi1");
        tk.tallenna(uusi);
        
        io = new StubIO("tagi1");
        instance = new Listaaminen(io, tk);
        instance.suorita();
        
        ArrayList<String> output = io.getOutput();
        assertEquals("millainenViite = @book"+ "\n" + "label = testi" + "\n" +
                        "author = Pekka" + "\n" +  
                        "tagit: tagi1,tagi2." + "\n" + "\n" +
                        "millainenViite = @article" + "\n" + "label = testilabel" + "\n"
                        + "author = Matti" + "\n" 
                        + "tagit: tagi1." + "\n\n" , output.get(0)); 
    }
}

