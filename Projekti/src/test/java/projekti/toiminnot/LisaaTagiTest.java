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
public class LisaaTagiTest {
    
    private StubIO io;
    private StubTK tk;
    private LisaaTagi instance;
    public ArrayList<String> tagit = new ArrayList<String>();

    @Before
    public void setUp() {
        io = new StubIO();
        
        
        tk = new StubTK();
        instance = new LisaaTagi(io, tk);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void lisaaTagiTest() {
        tk = new StubTK();
        Viite uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@book");
        uusi.lisaaTietoa("label", "testilabel");
        uusi.lisaaTietoa("author", "Pekka2");
        uusi.lisaaTietoa("title", "Otsikko4");
        tk.tallenna(uusi);
        
        io = new StubIO("testlabel4", "testilabel", "tagi", "tagi4");
        instance = new LisaaTagi(io, tk);

        instance.suorita();
        assertEquals("tagi", tk.annaTagit().get(0));
        assertEquals(2, tk.annaTagit().size());
    }
}