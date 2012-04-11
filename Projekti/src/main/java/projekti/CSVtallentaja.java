/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author hanna
 */
public class CSVtallentaja implements TallentajaRajapinta{
    public void tallenna(Viite viite){
        try
	{
	    FileWriter writer = new FileWriter("viitteet.csv", true);
 
            int i = 0;
            ArrayList<String> lisattava = viite.annaTiedot();
            while(i < lisattava.size()){
                writer.append("\"" + lisattava.get(i) + "\"");
                writer.append(",");
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
}
