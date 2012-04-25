/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.io;

import java.util.ArrayList;
import projekti.Viite;

/**
 *
 * @author hanna
 */
public class ViitteenTulostaja {
    private IOrajapinta io;
   
    public ViitteenTulostaja(IOrajapinta io){
        this.io = io;
    }
    
    public void tulostaViitteet(ArrayList<Viite> viitteet){
        int i = 0, j = 0;
        String[][] tiedot;
        
        while(i < viitteet.size()){
            tiedot = viitteet.get(i).annaTiedot();
            while(j < tiedot.length){
                if(!tiedot[j][1].equals("")){
                    io.tulosta(tiedot[j][0] + " = " + tiedot[j][1]);
                }
                j++;
            }
            
            ArrayList<String> tagit = viitteet.get(i).getTags();
            if(!tagit.isEmpty()) tulostaTagit(tagit);
            
            io.tulosta("");
            
            j = 0;
            i++;
        }
    }
    
    private void tulostaTagit(ArrayList<String> tagit) {
        String output = "";
        for(String tagi: tagit) {
            output += tagi + ",";
        }
        io.tulosta("tagit: " + output.substring(0, output.length() - 1) + ".");
    }  
    
}
