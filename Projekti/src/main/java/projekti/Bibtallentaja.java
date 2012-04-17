/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import java.io.*;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hanna
 */
public class Bibtallentaja {
    public void tallenna(Viite viite){
        try
	{

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("sigproc.bib", true),"UTF8"));

            int i = 0;
            String[][] lisattava = viite.annaTiedot();
            writer.append(lisattava[0][1]+"{");
            writer.append(lisattava[1][1]);
            while(i < lisattava.length+2){
                writer.append(lisattava[i][0] +" = ");
                writer.append(lisattava[i][1]);
                writer.append('\n');
                i++;
            }
            writer.append("}");
	    writer.append('\n');
 
	    writer.flush();
	    writer.close();
	}
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void tulosta() {
          try {
            
            File file = new File("sigproc.bib");
            Viite viite = new Viite();
            String[][] kategoriat = viite.annaTiedot();
            BufferedReader bufRdr  = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF8"));
              
            String line;
     
            //read each line of text file
            int osa;
            while((line = bufRdr.readLine()) != null)
            {
                    StringTokenizer st = new StringTokenizer(line,";");
                    osa = 0;
                    while (st.hasMoreTokens())
                    {
                        String str = st.nextToken();
                        if(!str.equals("\"\"")) {
                            str = kategoriat[osa][0] + " = " + str;
                            System.out.println(str.replace("\"", ""));
                        }    
                        osa++;
                    }
                System.out.println("");
            }
     
            bufRdr.close();
        } catch (IOException ex) {
            Logger.getLogger(CSVtallentaja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}   
   
