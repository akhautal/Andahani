/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author hanna
 */
public class KomentoriviKayttoliittymaTest {
    
    public KomentoriviKayttoliittymaTest() {
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

    /**
     * Test of naytaOhjeet method, of class KomentoriviKayttoliittyma.
     */
    @Test
    public void testNaytaOhjeet() {
        System.out.println("naytaOhjeet");
        KomentoriviKayttoliittyma instance = null;
        instance.naytaOhjeet();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of annaViite method, of class KomentoriviKayttoliittyma.
     */
    @Test
    public void testAnnaViite() {
        System.out.println("annaViite");
        KomentoriviKayttoliittyma instance = null;
        Viite expResult = null;
        Viite result = instance.annaViite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
