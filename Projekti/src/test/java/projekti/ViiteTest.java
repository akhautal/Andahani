/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.*;

/**
 *
 * @author hanna
 */
public class ViiteTest {
    
    public ViiteTest() {
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

    
    @Test
    public void kelvollinenTietoMeneeViitteeseen() {
        Viite viite = new Viite();
        viite.lisaaTietoa("author", "Pekka");
        String[][] tiedot = viite.annaTiedot();
        
        assertEquals(tiedot[2][1], "Pekka");
    }

   
    @Test
    public void kelvollinenTietoEiMeneVaaraanPaikkaan() {
        Viite viite = new Viite();
        viite.lisaaTietoa("author", "Pekka");
        String[][] tiedot = viite.annaTiedot();
        int i = 0;
        boolean tietoaVaarassaPaikassa = false;
        while(i < tiedot.length){
            if(i != 2 && tiedot[i][0].equals("Pekka")){
                tietoaVaarassaPaikassa = true;
            }
            i++;
        }
        
        assertTrue(!tietoaVaarassaPaikassa);
    }

    
    @Test
    public void epakelpoTietoEiMeneViitteeseen() {
        Viite viite = new Viite();
        viite.lisaaTietoa("olematonKentta", "Pekka");
        String[][] tiedot = viite.annaTiedot();
        int i = 0;
        boolean tietoaVaarassaPaikassa = false;
        while(i < tiedot.length){
            if(tiedot[i][0].equals("Pekka")){
                tietoaVaarassaPaikassa = true;
            }
            i++;
        }
        
        assertTrue(!tietoaVaarassaPaikassa);
    }
    
    @Test
    public void labelPalautetaanOikein() {
        Viite viite = new Viite();
        viite.lisaaTietoa("label", "testilabel");
        
        assertEquals(viite.getLabel(), "testilabel");
    }
    
    @Test
    public void viitteeseenVoiLisataTagi() {
        Viite viite = new Viite();
        viite.lisaaTagi("tagi");
        assertEquals(viite.getTags().get(0), "tagi");
        assertEquals(viite.getTags().size(), 1);
    }
    
    @Test
    public void eiVoiLisataJoOlemassaolevaTagi() {
        Viite viite = new Viite();
        viite.lisaaTagi("tagi");
        viite.lisaaTagi("tagi");
        assertEquals(viite.getTags().size(), 1);
    }
    
    @Test
    public void kayttajaVoiPoistaTagi() {
        Viite viite = new Viite();
        viite.lisaaTagi("tagi");
        viite.poistaTagi("tagi");
        assertEquals(viite.getTags().size(), 0);
    }
    
    @Test
    public void kayttajaEiVoiPoistaTagiJokaEiOleOlemassa() {
        Viite viite = new Viite();
        viite.lisaaTagi("tagi");
        viite.poistaTagi("tagi10");
        assertEquals(viite.getTags().size(), 1);
    }
    
    @Test
    public void kayttajaVoiHakeaTagi() {
        Viite viite = new Viite();
        viite.lisaaTagi("tagi");
        boolean result = viite.hasTag("tagi");
        assertTrue(result);
    }
    
    @Test
    public void tiedotPalautetaanOikein() {
        Viite viite = new Viite();
        viite.lisaaTietoa("millainenViite", "@book");
        viite.lisaaTietoa("label", "testilabel");
        viite.lisaaTietoa("author", "Pekka2");
        viite.lisaaTietoa("title", "Otsikko4");
        viite.lisaaTietoa("address", "address 1");
        
        String[][] tiedot = viite.annaTiedot();
        assertEquals("@book", tiedot[0][1]);
        assertEquals("testilabel", tiedot[1][1]);
        assertEquals("Pekka2", tiedot[2][1]);
        assertEquals("Otsikko4", tiedot[3][1]);
        assertEquals("address 1", tiedot[11][1]);
    }
}
