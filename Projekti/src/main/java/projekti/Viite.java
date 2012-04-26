/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import java.util.ArrayList;

/**
 *
 * @author hanna
 */
public class Viite {
   
    private ArrayList<String> tagit = new ArrayList<String>();
    private String[][] tiedot = {
        {"millainenViite", ""},
        {"label", ""},
        {"author", ""},
        {"title",  ""},
        {"booktitle", ""},
        {"journal", ""},
        {"volume", ""}, 
        {"number", ""},
        {"year", ""},
        {"pages", ""},
        {"publisher", ""},
        {"address", ""}
    };
    
    public Viite() {};
    
    public void lisaaTietoa(String command, String syote){
       for(int i = 0; i < 12; i++) {
           if(tiedot[i][0].equals(command)) tiedot[i][1] = syote; 
       }
    }
    
    public void lisaaTagi(String tagi) {
        if(!tagit.contains(tagi)) tagit.add(tagi);
    }
    
    public void poistaTagi(String tagi) {
        if(tagit.contains(tagi)) tagit.remove(tagi);
    }
    
    public String getLabel(){
        return tiedot[1][1];
    }
    
    public boolean hasTag(String tagi) {
        return tagit.contains(tagi); 
    }
    
    public ArrayList<String> getTags() {
        return tagit;
    }
    
    public String[][] annaTiedot(){
        return tiedot;
    }
}
