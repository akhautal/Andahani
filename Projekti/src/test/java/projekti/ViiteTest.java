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
}
