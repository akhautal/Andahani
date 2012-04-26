/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.tiedostonkasittely;

import java.io.*;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.*;
import projekti.Viite;

/**
 *
 * @author hanna
 */
public class CSVtiedostonKasittelijaTest {
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        File file = new File("testi2.csv");
        if(file.exists()) file.delete();
    }

    /**
     * Test of tallenna method, of class CSVtiedostonKasittelija.
     */
    @Test
    public void testTallenna() {
        Viite uusi = new Viite();
        CSVtiedostonKasittelija instance = new CSVtiedostonKasittelija("testi2.csv");
        
        uusi.lisaaTietoa("millainenViite", "@book");
        uusi.lisaaTietoa("label", "testi");
        uusi.lisaaTietoa("author", "Pekka");
        uusi.lisaaTietoa("title", "Otsikko");
        instance.tallenna(uusi);
        
        String rivi = null;
        try {
            FileInputStream fstream = new FileInputStream("testi2.csv");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            rivi = br.readLine();
            br.close();
            File file = new File("testi.csv");
            file.delete();
        } catch (Exception e) {
        }
        assertEquals(rivi, "@book;testi;Pekka;Otsikko;-;-;-;-;-;-;-;-;");
    }

    @Test
    public void viitteidenLuku(){
        Viite uusi = new Viite();
        CSVtiedostonKasittelija instance = new CSVtiedostonKasittelija("testi2.csv");
        
        uusi.lisaaTietoa("millainenViite", "@book");
        uusi.lisaaTietoa("label", "testi");
        uusi.lisaaTietoa("author", "Pekka");
        uusi.lisaaTietoa("title", "Otsikko");
        instance.tallenna(uusi);
        uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@article");
        uusi.lisaaTietoa("label", "testilabel");
        uusi.lisaaTietoa("author", "Matti");
        uusi.lisaaTietoa("title", "Otsikko2");
        instance.tallenna(uusi);
        
        ArrayList<Viite> viitteet = instance.lueViitteet();
        
        try{
            File file = new File("testi.csv");
            file.delete();
        }catch(Exception e){
            
        }
        assertEquals(viitteet.size(), 2);
        
        assertEquals(viitteet.get(0).annaTiedot()[0][1], "@book");
        assertEquals(viitteet.get(0).annaTiedot()[1][1], "testi");
        assertEquals(viitteet.get(0).annaTiedot()[2][1], "Pekka");
        assertEquals(viitteet.get(0).annaTiedot()[3][1], "Otsikko");
        assertEquals(viitteet.get(0).annaTiedot()[4][1], "");
        assertEquals(viitteet.get(0).annaTiedot()[10][1], "");
        
        assertEquals(viitteet.get(1).annaTiedot()[0][1], "@article");
        assertEquals(viitteet.get(1).annaTiedot()[1][1], "testilabel");
        assertEquals(viitteet.get(1).annaTiedot()[2][1], "Matti");
        assertEquals(viitteet.get(1).annaTiedot()[3][1], "Otsikko2");
        assertEquals(viitteet.get(1).annaTiedot()[4][1], "");
        assertEquals(viitteet.get(1).annaTiedot()[10][1], "");
    }
    
    @Test
    public void testLisaaTagit() {
        Viite uusi = new Viite();
        CSVtiedostonKasittelija instance = new CSVtiedostonKasittelija("testi2.csv");
        
        uusi.lisaaTietoa("millainenViite", "@book");
        uusi.lisaaTietoa("label", "testi");
        uusi.lisaaTietoa("author", "Pekka");
        uusi.lisaaTietoa("title", "Otsikko");
        uusi.lisaaTagi("tagi1");
        instance.tallenna(uusi);
        
        ArrayList<String> tagit = new ArrayList<String>();
        tagit.add("lisattytagi");
        instance.lisaaTagitTiedostoon("testi", tagit);
                
        String rivi = null;
        try {
            FileInputStream fstream = new FileInputStream("testi2.csv");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            rivi = br.readLine();
            br.close();
            File file = new File("testi.csv");
            file.delete();
        } catch (Exception e) {
        }
        assertEquals(rivi, "@book;testi;Pekka;Otsikko;-;-;-;-;-;-;-;-;tagi1;lisattytagi;");
    }
    
    @Test
    public void testPoistaViite() {
        Viite uusi = new Viite();
        CSVtiedostonKasittelija instance = new CSVtiedostonKasittelija("testi2.csv");
        
        uusi.lisaaTietoa("millainenViite", "@inproceedings");
        uusi.lisaaTietoa("label", "poistetaan");
        uusi.lisaaTietoa("author", "Pekka2");
        uusi.lisaaTietoa("title", "Otsikko2");
        uusi.lisaaTagi("tagi1");
        instance.tallenna(uusi);
        
        uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@book");
        uusi.lisaaTietoa("label", "testi");
        uusi.lisaaTietoa("author", "Pekka");
        uusi.lisaaTietoa("title", "Otsikko");
        uusi.lisaaTagi("tagi1");
        instance.tallenna(uusi);
        
        instance.poistaViiteTiedostosta("poistetaan");
                
        String rivi = null;
        try {
            FileInputStream fstream = new FileInputStream("testi2.csv");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            rivi = br.readLine();
            br.close();
            File file = new File("testi.csv");
            file.delete();
        } catch (Exception e) {
        }
        assertEquals(rivi, "@book;testi;Pekka;Otsikko;-;-;-;-;-;-;-;-;tagi1;");
    }
}