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
 * @author dasha
 */
public class TagiHakuTest {
    
    private StubIO io;
    private StubTK tk;
    private TagiHaku instance;
    
    @Before
    public void setUp() {
        io = new StubIO();
        tk = new StubTK();
        instance = new TagiHaku(io, tk);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void tagiHakuJosTiedostoOnTyhjaTesti() {
        io = new StubIO("tagi");
        instance = new TagiHaku(io, tk);
        
        instance.suorita();
        
        ArrayList<String> result = io.getOutput();
        assertEquals("Viitteita ei ole tai tiedosto ei ole olemassa.\n", result.get(0));     
    }
    
    @Test
    public void tagiHakuJosTiedostoEiOleOlemassaTesti() {
        io = new StubIO("tagi");
        tk.poistaTiedosto();
        instance = new TagiHaku(io, tk);
        
        instance.suorita();
        
        ArrayList<String> result = io.getOutput();
        assertEquals("Viitteita ei ole tai tiedosto ei ole olemassa.\n", result.get(0));     
    }
    
    @Test
    public void tagiHakuJosTiedostoOnEpatyhjaJaTagiOnOlemassaTesti() {
        io = new StubIO("tagi");
        
        tk = new StubTK();
        Viite uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@book");
        uusi.lisaaTietoa("label", "testilabel");
        uusi.lisaaTietoa("author", "Pekka2");
        uusi.lisaaTagi("tagi");
        tk.tallenna(uusi);
        
        uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@inproceedings");
        uusi.lisaaTietoa("label", "label2");
        uusi.lisaaTietoa("author", "Dasha");
        uusi.lisaaTagi("tagi");
        tk.tallenna(uusi);
        
        instance = new TagiHaku(io, tk);
        
        instance.suorita();
        
        ArrayList<String> result = io.getOutput();
        assertEquals("millainenViite = @book", result.get(1)); 
        assertEquals("label = testilabel", result.get(2)); 
        assertEquals("author = Pekka2", result.get(3)); 
        assertEquals("tagit: tagi.", result.get(4));
        
        assertEquals("millainenViite = @inproceedings", result.get(6)); 
        assertEquals("label = label2", result.get(7)); 
        assertEquals("author = Dasha", result.get(8)); 
        assertEquals("tagit: tagi.", result.get(9));
    }
    
    @Test
    public void tagiEiLoydyTiedostossaTesti() {
        io = new StubIO("tagi2");
        
        tk = new StubTK();
        Viite uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@book");
        uusi.lisaaTietoa("label", "testilabel");
        uusi.lisaaTietoa("author", "Pekka2");
        uusi.lisaaTagi("tagi");
        tk.tallenna(uusi);
        
        instance = new TagiHaku(io, tk);
        
        instance.suorita();
        
        ArrayList<String> result = io.getOutput();
        assertEquals("Millään viitteellä ei ole tagia tagi2.", result.get(1) );
    }
}
