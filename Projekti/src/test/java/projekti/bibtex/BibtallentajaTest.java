/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.bibtex;

import projekti.bibtex.Bibtallentaja;
import java.io.*;
import org.junit.*;
import projekti.Viite;
import static org.junit.Assert.*;

/**
 *
 * @author dasha
 */
public class BibtallentajaTest {
    
    Bibtallentaja bib; 
    
    @Before
    public void setUp() {
        bib = new Bibtallentaja();
    }
    
    @After
    public void tearDown() {
        File file = new File("testi.csv");
       // if(file.exists()) file.delete();
    }

    /**
     * Test of tallenna method, of class Bibtallentaja.
     */
    @Test (expected = FileNotFoundException.class)
    public void testTallennaJosTiedostoEiOleOlemassaTaiEiVoiLukea() throws UnsupportedEncodingException, FileNotFoundException {
        Viite uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@book");
        uusi.lisaaTietoa("label", "testilabel");
        uusi.lisaaTietoa("author", "Pekka2");
        uusi.lisaaTietoa("title", "Otsikko4");       
        bib.tallenna(uusi, "testi.csv");
       
        File file = new File("testi.csv");
        file.setReadable(false);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF8"));
    }

//    @Test
//    public void testTallennaJosTiedostoEiOleOlemassaTaiEiVoiLukea2() throws UnsupportedEncodingException, FileNotFoundException, IOException {
//        Viite uusi = new Viite();
//        uusi.lisaaTietoa("millainenViite", "@book");
//        uusi.lisaaTietoa("label", "testilabel");
//        uusi.lisaaTietoa("author", "Pekka2");
//        uusi.lisaaTietoa("title", "Otsikko4");       
//        bib.tallenna(uusi, "testi.csv");
//       
//        File file = new File("testi.csv");
//        file.setReadable(true);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF8"));
//        assertEquals("@book{testilabel,\n", reader.readLine());
//    }
    
    @Test
    public void tarkistaAakosetTest() {
    }
}
