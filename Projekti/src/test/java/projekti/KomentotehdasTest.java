/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import projekti.bibtex.StubBib;
import projekti.io.StubIO;
import projekti.tiedostonkasittely.StubTK;
import projekti.toiminnot.*;

/**
 *
 * @author dasha
 */
public class KomentotehdasTest {
    
    private StubIO io;
    private StubTK tk;
    private StubBib bib;
    private Komentotehdas komentotehdas;    
            
    @Before
    public void setUp() {
        io = new StubIO();
        tk = new StubTK();
        bib = new StubBib();
        komentotehdas = new Komentotehdas(io, tk, bib);
    }
    
    @Test
    public void lisaaTesti() {
        Lisaaminen expResult = new Lisaaminen(io, tk);
        Toiminta result = komentotehdas.hae("lisaa");        
        assertEquals(expResult.getClass(), expResult.getClass());
    }
     
    @Test
    public void listaTesti() {
        Listaaminen expResult = new Listaaminen(io, tk);
        Toiminta result = komentotehdas.hae("lista");        
        assertEquals(expResult.getClass(), expResult.getClass());
    }
    
    @Test
    public void lopetaTesti() {
        Lopeta expResult = new Lopeta(io);
        Toiminta result = komentotehdas.hae("lopeta");        
        assertEquals(expResult.getClass(), expResult.getClass());
    }
     
    @Test
    public void bibTesti() {
        Bib expResult = new Bib(io, tk, bib);
        Toiminta result = komentotehdas.hae("bib");        
        assertEquals(expResult.getClass(), result.getClass());
    }
      
    @Test
    public void tuntematonKomentoTesti() {
        Tuntematon expResult = new Tuntematon(io);
        Toiminta result = komentotehdas.hae("unexistentcommand!");        
        assertEquals(expResult.getClass(), result.getClass());
    }
    
    @Test
    public void tyhjaKomentoTesti() {
        Tuntematon expResult = new Tuntematon(io);
        Toiminta result = komentotehdas.hae("");        
        assertEquals(expResult.getClass(), result.getClass());
    }
}