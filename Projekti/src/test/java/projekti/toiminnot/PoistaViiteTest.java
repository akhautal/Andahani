/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.toiminnot;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;
import projekti.Viite;
import projekti.bibtex.StubBib;
import projekti.io.StubIO;
import projekti.tiedostonkasittely.StubTK;

/**
 *
 * @author dasha
 */
public class PoistaViiteTest {
    
    private PoistaViite instance;
    private StubIO io;
    private StubTK tk;
    
    @Before
    public void setUp() {
        
        io = new StubIO();
        tk = new StubTK();
        
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
                
        instance = new PoistaViite(io, tk);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void poistaViiteJosHaettuViiteOnOlemassaTesti() {
       
        io = new StubIO("testilabel");
        
        instance = new PoistaViite(io, tk);
        instance.suorita();
        ArrayList<String> output = io.getOutput();
        assertEquals("Viite poistettiin", output.get(1));
    }
    
    @Test
    public void poistaViiteJosHaettuViiteEiOleOlemassaTesti() {
  
        io = new StubIO("vaaralabel", "testi");
        
        instance = new PoistaViite(io, tk);
        instance.suorita();
        ArrayList<String> output = io.getOutput();
        assertEquals("Viite ei ole olemassa! Anna toinen label:", output.get(1));
    }
    
    @Test
    public void poistaViiteJosTiedostoEiOleOlemassaTesti() {
  
        io = new StubIO("vaaralabel", "testi");
        tk.poistaTiedosto();
        instance = new PoistaViite(io, tk);
        
        instance.suorita();
        ArrayList<String> output = io.getOutput();
        assertEquals("Viitteita ei ole tai tiedostoa ei ole olemassa.\n", output.get(0));
    }
    
    @Test
    public void poistaViiteJosTiedostoOnTyhjaTesti() {
  
        io = new StubIO("vaaralabel", "testi");
        tk = new StubTK();
        instance = new PoistaViite(io, tk);
        
        instance.suorita();
        ArrayList<String> output = io.getOutput();
        assertEquals("Viitteita ei ole tai tiedostoa ei ole olemassa.\n", output.get(0));
    }
}
