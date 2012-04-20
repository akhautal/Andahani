/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            FileWriter writer = new FileWriter(tiedostonimi, true);
            
            int i = 0;
            String[][] lisattava = viite.annaTiedot();
            while(i < lisattava.length){
                if(!lisattava[i][1].equals("")) writer.append(lisattava[i][1]);
                else writer.append("-");
                writer.append(";");
                i++;
            }
            
            ArrayList<String> tagit = viite.getTags();
            while(!tagit.isEmpty()) {
                writer.append(tagit.remove(0));
                writer.append(";");
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
                if(osa < 12) {
                     if(!str.equals("-")) viite.lisaaTietoa(kategoriat[osa][0], new String(str.getBytes(),"UTF-8"));
                }
                else viite.lisaaTagi(str);
                osa++;
            }
            viitteet.add(viite);
        }
        return viitteet;
    } 
    
   public void lisaaTagitTiedostoon(String label, ArrayList<String> tagit) {
      
        try {
            File file = new File(tiedostonimi);
            File tempfile = new File("tempfile.csv");
            if(tempfile.exists()) tempfile.delete();
            
            BufferedReader bufRdr  = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF8"));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("tempfile.csv", true),"UTF8"));

            String line;
            String toAdd = "";
            for(String tagi: tagit) {
                toAdd += tagi + ";";
            }
                
            while((line = bufRdr.readLine()) != null)
            {            
                StringTokenizer st = new StringTokenizer(line,";");

                if(st.countTokens() >= 2) {
                    String type = st.nextToken();
                    String luettuLabel = st.nextToken();
                    if(luettuLabel.equals(label)) {
                        line = line.replaceAll(line, line + toAdd);
                    }
                }
                writer.append(line + "\n");
            }                     
            bufRdr.close();
            writer.flush();
	    writer.close();
            
            tempfile.renameTo(file);
            
        } catch (Exception ex) {
            Logger.getLogger(CSVtiedostonKasittelija.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
   
    public boolean labelOnOlemassa(String label) {
        ArrayList<Viite> viitteet = lueViitteet();
        
        for(Viite viite: viitteet) {
            if(viite.getLabel().equals(label)) return true;
        }
        return false;
    }
}       


        
//    public Viite haeViite(String label) {
//        
//         ArrayList<Viite> viitteet;
//        
//        try {
//            File file = new File(tiedostonimi);
//            BufferedReader bufRdr  = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF8")); 
//            Viite luettuViite = new Viite();
//            String line;
//            int osa = 2;
//            String[][] kategoriat = (new Viite()).annaTiedot();
//        
//            while((line = bufRdr.readLine()) != null)
//            {
//                StringTokenizer st = new StringTokenizer(line,";");
//
//                if(st.countTokens() >= 2) {
//                    String type = st.nextToken();
//                    String luettuLabel = st.nextToken();
//                    if(luettuLabel.equals(label)) {
//                        
//                        luettuViite.lisaaTietoa(kategoriat[0][0], type);
//                        luettuViite.lisaaTietoa(kategoriat[1][0], luettuLabel);
//                        while (st.hasMoreTokens()) {
//                            String str = st.nextToken();
//                            if(osa < 12) {
//                                if(!str.equals("-")) luettuViite.lisaaTietoa(kategoriat[osa][0], new String(str.getBytes(),"UTF-8"));
//                            }
//                            else luettuViite.lisaaTagi(str);
//                    
//                            osa++;
//                        }  
//                        return luettuViite;
//                    }
//                }
//            }          
//            
//            bufRdr.close();
//        } catch (IOException ex) {
//            return null;
//        }
//          
//        return null;
//       
//    }
//    

   
