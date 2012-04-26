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
    public ViitteenTulostaja(){
        
    }
    public ViitteenTulostaja(IOrajapinta io){
       
    }
    
    public String annaTuloste(ArrayList<Viite> viitteet){
        int i = 0, j = 0;
        String[][] tiedot;
        String output = "";
        while(i < viitteet.size()){
            tiedot = viitteet.get(i).annaTiedot();
            while(j < tiedot.length){
                if(!tiedot[j][1].equals("")){
                    output += tiedot[j][0] + " = " + tiedot[j][1];
                    output += "\n";
                }
                j++;
            }
            
            ArrayList<String> tagit = viitteet.get(i).getTags();
            if(!tagit.isEmpty()){
                output += annaTagit(tagit);
            }
            else{
                output = output.substring(0, output.length()-1);
            }
            
            output += "\n\n";
            j = 0;
            i++;
        }
        return output;
    }
    

    
    private String annaTagit(ArrayList<String> tagit) {
        String output = "tagit: ";
        for(String tagi: tagit) {
            output += tagi + ",";
        }
        
        output = output.substring(0, output.length()-1);
        output += ".";
        return output;
    } 
    
}
