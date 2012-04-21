/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.toiminnot;

import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import projekti.Viite;
import projekti.io.StubIO;
import projekti.tiedostonkasittely.StubTK;

/**
 *
 * @author hanna
 */
public class LisaaminenTest { 
    private StubIO io;
    private StubTK tk;
    private Lisaaminen instance;
    
    @Before
    public void setUp() {
        tk = new StubTK();
        io = new StubIO();
        instance = new Lisaaminen(io, tk);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of suorita method, of class Lisaaminen.
     */
    @Test
    public void viiteLisataanEiTagejaTest() {
        tk = new StubTK();
        io = new StubIO("1", "testilabel", "Pekka", "Otsikko");
        instance = new Lisaaminen(io, tk);

        instance.suorita();
        
        String[][] lisatytTiedot = tk.lueViitteet().get(0).annaTiedot();
        assertEquals(lisatytTiedot[0][1], "@inproceedings");
        assertEquals(lisatytTiedot[1][1], "testilabel");
        assertEquals(lisatytTiedot[2][1], "Pekka");
        assertEquals(lisatytTiedot[3][1], "Otsikko");
        assertEquals(lisatytTiedot[4][1], "");
        assertEquals(lisatytTiedot[11][1], "");
    }
    
    @Test
    public void viiteLisataanTagejaTest() {
        tk = new StubTK();
        io = new StubIO("2", "testilabel", "Pekka", "Otsikko", "","","","","","","","","tagi1", "tagi2");
        instance = new Lisaaminen(io, tk);
        
        instance.suorita();
        String[][] lisatytTiedot = tk.lueViitteet().get(0).annaTiedot();
        ArrayList<String> tagit = tk.lueViitteet().get(0).getTags();
        assertEquals(lisatytTiedot[0][1], "@book");
        assertEquals(lisatytTiedot[1][1], "testilabel");
        assertEquals(lisatytTiedot[2][1], "Pekka");
        assertEquals(lisatytTiedot[3][1], "Otsikko");
        assertEquals(lisatytTiedot[4][1], "");
        assertEquals(lisatytTiedot[11][1], "");
        assertEquals("tagi1", tagit.get(0));
        assertEquals("tagi2", tagit.get(1));
        assertEquals(2, tagit.size());
    }
    
    @Test
    public void millainenViiteOnVaarinTageja() {
        tk = new StubTK();
        io = new StubIO("4", "abc", "", "3", "testilabel","Pekka","Otsikko","","","","","","","","", "tagi1", "tagi2");
        instance = new Lisaaminen(io, tk);

        instance.suorita();
        String[][] lisatytTiedot = tk.lueViitteet().get(0).annaTiedot();
        ArrayList<String> tagit = tk.lueViitteet().get(0).getTags();
        assertEquals(lisatytTiedot[0][1], "@article");
        assertEquals(lisatytTiedot[1][1], "testilabel");
        assertEquals(lisatytTiedot[2][1], "Pekka");
        assertEquals(lisatytTiedot[3][1], "Otsikko");
        assertEquals(lisatytTiedot[4][1], "");
        assertEquals(lisatytTiedot[11][1], "");
        assertEquals("tagi1", tagit.get(0));
        assertEquals("tagi2", tagit.get(1));
        assertEquals(2, tagit.size());
    }
    
    @Test
    public void labelOnJoOlemassaTest() {
        tk = new StubTK();
        Viite uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@book");
        uusi.lisaaTietoa("label", "testilabel");
        uusi.lisaaTietoa("author", "Pekka2");
        uusi.lisaaTietoa("title", "Otsikko4");
        tk.tallenna(uusi);
        
        io = new StubIO("3", "testilabel", "testilabel2", "Pekka","Otsikko","","","","","","","","", "tagi1", "tagi2");
        instance = new Lisaaminen(io, tk);
 
        instance.suorita();
        String[][] lisatytTiedot = tk.lueViitteet().get(1).annaTiedot();
        ArrayList<String> tagit = tk.lueViitteet().get(1).getTags();
        assertEquals(lisatytTiedot[0][1], "@article");
        assertEquals(lisatytTiedot[1][1], "testilabel2");
        assertEquals(lisatytTiedot[2][1], "Pekka");
        assertEquals(lisatytTiedot[3][1], "Otsikko");
        assertEquals(lisatytTiedot[4][1], "");
        assertEquals(lisatytTiedot[11][1], "");
        assertEquals("tagi1", tagit.get(0));
        assertEquals("tagi2", tagit.get(1));
        assertEquals(2, tagit.size());
    }
}
