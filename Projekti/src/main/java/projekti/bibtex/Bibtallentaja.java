/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.bibtex;

import java.io.*;
import projekti.Viite;

/**
 *
 * @author hanna
 */
public class Bibtallentaja implements BibtallentajaRajapinta {
    public void tallenna(Viite viite, String tiedostonimi){
        try
	{
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tiedostonimi, true),"UTF8"));

            int i = 2;
            String[][] lisattava = viite.annaTiedot();
            writer.append(lisattava[0][1]+"{");
            writer.append(lisattava[1][1]);
            writer.append(",\n");
            while(i < lisattava.length){
                if(!lisattava[i][1].equals("")){
                    writer.append(lisattava[i][0] +" = {");
                    writer.append(tarkistaAakkoset(lisattava[i][1]));
                    writer.append("},");
                    writer.append('\n');
                }
                i++;
            }
            writer.append("}");
	    writer.append('\n');
 
	    writer.flush();
	    writer.close();
	}
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    private String tarkistaAakkoset(String lisattava){
        lisattava = lisattava.replace("ö", "\\\"{o}");
        lisattava = lisattava.replace("Ö", "\\\"{O}");
        lisattava = lisattava.replace("ä", "\\\"{a}");
        lisattava = lisattava.replace("Ä", "\\\"{A}");
        return lisattava;
    }
}   
   
