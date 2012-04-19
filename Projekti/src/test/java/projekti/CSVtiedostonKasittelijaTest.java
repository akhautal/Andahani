/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import java.io.*;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author dasha
 */
public class CSVtiedostonKasittelijaTest {
    
    String tiedostonimi = "Testviitteet.csv";
    InputStream in;
    OutputStream out;
    String output;
    CSVtiedostonKasittelija kasittelija;
    
    IOrajapinta ioStub = new IOrajapinta() {
 
        public void tulosta(String tuloste) {
            output = tuloste;
        }

        public String lue() {
            return null;
        }
    };
    
    public CSVtiedostonKasittelijaTest() {
    }
    
    @Before
    public void setUp() throws FileNotFoundException, IOException {  
        output = null;
        
        File file = new File(tiedostonimi);  
          
        if (file.exists()) file.delete();  
              
        out = new BufferedOutputStream(new FileOutputStream(file));    
        out.write(new byte[0]);    
        out.close();
 
        kasittelija = new CSVtiedostonKasittelija(ioStub, tiedostonimi);
    }
    
    @After
    public void tearDown() {  
        File file = new File(tiedostonimi);  
        if (file.exists()) file.delete();  
    }
    
    @Test
    public void kasittelijaKirjoittaaViitteetOikein() throws FileNotFoundException, IOException {         
        Viite viite = new Viite();
        viite.lisaaTietoa("millainenViite", "@book");
        viite.lisaaTietoa("label", "testi");
        viite.lisaaTietoa("author", "Pekka");
        viite.lisaaTietoa("title", "Otsikko");       
        kasittelija.tallenna(viite);
        
        File file = new File(tiedostonimi);
        BufferedReader reader  = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF8"));
        String expResult = "@book;testi;Pekka;Otsikko;;;;;;;;;";
        String result = reader.readLine();
        assertEquals(expResult, result);
    }  
    
    @Test
    public void kasittelijaHuomaaJosTiedostoEiOleOlemassa() {
        File file = new File(tiedostonimi);
        if (file.exists()) file.delete();
      
        String expResult = "Couldn't read file.";
        kasittelija.lueViitteet();
        String result = output;
        assertEquals(expResult, result);
    }
}
