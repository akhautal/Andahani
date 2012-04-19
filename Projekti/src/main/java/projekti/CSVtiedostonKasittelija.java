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
    public void tallenna(Viite viite){
        try
	{
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("viitteet.csv", true),"UTF8"));

            int i = 0;
            String[][] lisattava = viite.annaTiedot();
            while(i < lisattava.length){
                System.out.println("ö");
                System.out.println(lisattava[i][1]);
//                System.out.println(new String(lisattava[i][1].replace("ö", "\\\"{o}").getBytes(), "UTF-8"));
//                lisattava[i][1] = lisattava[i][1].replace("ö", "\\\"{o}");
//                
//                lisattava[i][1] = lisattava[i][1].replace("Ö", "\\\"{O}");
//                lisattava[i][1] = lisattava[i][1].replace("ä", "\\\"{a}");
//                lisattava[i][1] = lisattava[i][1].replace("Ä", "\\\"{A}");  
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
            File file = new File("viitteet.csv");
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
   
