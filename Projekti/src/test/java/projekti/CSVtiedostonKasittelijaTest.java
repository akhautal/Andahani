/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author dasha
 */
public class CSVtiedostonKasittelijaTest {
    
    public CSVtiedostonKasittelijaTest() {
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
     * Test of tallenna method, of class CSVtiedostonKasittelija.
     */
    @Test
    public void testTallenna() {
        System.out.println("tallenna");
        Viite viite = null;
        CSVtiedostonKasittelija instance = new CSVtiedostonKasittelija();
        instance.tallenna(viite);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lueViitteet method, of class CSVtiedostonKasittelija.
     */
    @Test
    public void testLueViitteet() {
        System.out.println("lueViitteet");
        CSVtiedostonKasittelija instance = new CSVtiedostonKasittelija();
        ArrayList expResult = null;
        ArrayList result = instance.lueViitteet();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
