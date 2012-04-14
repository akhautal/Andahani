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
public class CSVtallentaja implements TallentajaRajapinta {

    public void tallenna(Viite viite) {
        try {
            FileWriter writer = new FileWriter("viitteet.csv", true);
            
            String[] kentat = {"millainenViite" ,"label", "author", "title", "year", "publisher", "booktitle", "pages", 
            "journal", "volume", "number",  "address"};
            int i = 0;
            while (i < kentat.length) {
                if (viite.onkoKenttaa(kentat[i])) {
                    writer.append(kentat[i]);
                    writer.append(",");
                    if (viite.onkoKenttaa(kentat[i])) {
                        if (viite.getTieto(kentat[i]) != null) {
                            writer.append("\"" + viite.getTieto(kentat[i]) + "\"");
                            writer.append(",");
                        }
                    }

                }
                i++;
            }
            writer.append('\n');

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
