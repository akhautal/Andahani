/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

/**
 *
 * @author hanna
 */
public class Viite {
   
    private String[][] tiedot = {
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
    
    public void lisaaTietoa(String command, String syote){
       for(int i = 0; i < 10; i++) {
           if(tiedot[i][0].equals(command)) tiedot[i][1] = syote; 
       }
    }
    
    public String[][] annaTiedot(){
        return tiedot;
    }
}
