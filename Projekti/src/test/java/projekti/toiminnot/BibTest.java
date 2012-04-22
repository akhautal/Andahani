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
public class BibTest {
    
    private StubIO io;
    private StubTK tk;
    private StubBib bib;
    private Bib instance;
    
    @Before
    public void setUp() {
        io = new StubIO();
        
        //Need to be non-empty folder, else Bib will not write to folder
        tk = new StubTK();
        Viite uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@book");
        uusi.lisaaTietoa("label", "testilabel");
        uusi.lisaaTietoa("author", "Pekka2");
        uusi.lisaaTietoa("title", "Otsikko4");
        tk.tallenna(uusi);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void tiedostoLuodaanJosAnnetuTiedostonNimiOnKelvollinen() {
        io = new StubIO("bib", "oikeanimi.bib");
        bib = new StubBib();
        instance = new Bib(io, tk, bib);
            
        String expResult = "oikeanimi.bib";
        instance.suorita();
        String result = bib.annaTiedostonimet().get(0);
        
        assertEquals(expResult, result);
        assertEquals(1, bib.annaTiedostonimet().size());
    }
    
    @Test
    public void tiedostoaEiLuodaJosAnnetunTiedostonNiminLoppuOnVaarin1() {
        io = new StubIO("vaaranimi.bi", "oikeanimi.bib");
        bib = new StubBib();
        instance = new Bib(io, tk, bib);
        
        String expResult = "oikeanimi.bib";
        instance.suorita();
        String result = bib.annaTiedostonimet().get(0);
        
        assertEquals(expResult, result);
        assertEquals(1, bib.annaTiedostonimet().size());
    }
    
    @Test
    public void tiedostoaEiLuodaJosAnnetunTiedostonNiminLoppuOnVaarin2() {
        io = new StubIO("vaaranimi", "oikeanimi.bib");
        bib = new StubBib();
        instance = new Bib(io, tk, bib);
        
        String expResult = "oikeanimi.bib";
        instance.suorita();
        String result = bib.annaTiedostonimet().get(0);
        
        assertEquals(expResult, result);
        assertEquals(1, bib.annaTiedostonimet().size());
    }
    
    @Test
    public void tiedostoaEiLuodaJosAnnetunTiedostonNiminLoppuOnVaarin3() {
        io = new StubIO("vaaranimi.doc", "oikeanimi.bib");
        bib = new StubBib();
        instance = new Bib(io, tk, bib);
        
        String expResult = "oikeanimi.bib";
        instance.suorita();
        String result = bib.annaTiedostonimet().get(0);
        
        assertEquals(expResult, result);
        assertEquals(1, bib.annaTiedostonimet().size());
    }
        
    @Test
    public void tiedostoaEiLuodaJosAnnetunTiedostonNiminAlussaOnPiste() {
        io = new StubIO(".vaaranimi", "oikeanimi.bib");
        bib = new StubBib();
        instance = new Bib(io, tk, bib);
        
        String expResult = "oikeanimi.bib";
        instance.suorita();
        String result = bib.annaTiedostonimet().get(0);
        
        assertEquals(expResult, result);
        assertEquals(1, bib.annaTiedostonimet().size());
    }
    
    @Test
    public void tiedostoaEiLuodaJosAnnettuTiedostonNimiSisaltaaKiellettyMerkki() {
        io = new StubIO("vaaranimi*", "oikeanimi.bib");
        bib = new StubBib();
        instance = new Bib(io, tk, bib);
        
        String expResult = "oikeanimi.bib";
        instance.suorita();
        String result = bib.annaTiedostonimet().get(0);
        
        assertEquals(expResult, result);
        assertEquals(1, bib.annaTiedostonimet().size());
    }
    
    @Test
    public void tiedostoaEiLuodaJosAnnettuTiedostonNimiOnTyhja() {
        io = new StubIO("", "oikeanimi.bib");
        bib = new StubBib();
        instance = new Bib(io, tk, bib);
        
        String expResult = "oikeanimi.bib";
        instance.suorita();
        String result = bib.annaTiedostonimet().get(0);
        
        assertEquals(expResult, result);
        assertEquals(1, bib.annaTiedostonimet().size());
    }
}
