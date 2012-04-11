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
    private ArrayList<String> tiedot;
    
    public Viite(){
        tiedot = new ArrayList<String>();
    }
    
    public void lisaaTietoa(String syote){
        tiedot.add(syote);
    }
    
    public ArrayList<String> annaTiedot(){
        return tiedot;
    }
}
