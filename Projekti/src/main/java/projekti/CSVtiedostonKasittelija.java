/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author hanna
 */
public class CSVtiedostonKasittelija implements TiedostonkasittelijaRajapinta{
    private String tiedostonimi;
    public CSVtiedostonKasittelija(String tiedostonimi){
        this.tiedostonimi = tiedostonimi;
    }
    
    public void tallenna(Viite viite){
        try
	{
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tiedostonimi, true),"UTF8"));

            int i = 0;
            String[][] lisattava = viite.annaTiedot();
            while(i < lisattava.length){
                writer.append(lisattava[i][1]);
                writer.append(";");
                i++;
            }
            
	    writer.append('\n');
 
	    writer.flush();
	    writer.close();
	}
        catch (IOException e){
            e.printStackTrace();
        }
    }

    
    public ArrayList<Viite> lueViitteet() {
        ArrayList<Viite> viitteet;
        
        try {
            File file = new File(tiedostonimi);
            BufferedReader bufRdr  = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF8")); 
             viitteet = lueTiedosto(bufRdr);
            bufRdr.close();
        } catch (IOException ex) {
            return null;
        }
          
        return viitteet;
    }
    
    private ArrayList<Viite> lueTiedosto(BufferedReader bufRdr) throws IOException {
        ArrayList<Viite> viitteet = new ArrayList<Viite>();
        Viite viite; 
        String line;
        int osa;
        String[][] kategoriat = (new Viite()).annaTiedot();
        
        while((line = bufRdr.readLine()) != null)
        {
            StringTokenizer st = new StringTokenizer(line,";");
            osa = 0;
            viite = new Viite();

            while (st.hasMoreTokens())
            {
                String str = st.nextToken();
                viite.lisaaTietoa(kategoriat[osa][0], new String(str.getBytes(),"UTF-8"));
                osa++;
            }
            viitteet.add(viite);
        }
        return viitteet;
    } 
    

}   
   
