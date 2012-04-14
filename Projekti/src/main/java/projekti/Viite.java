/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import java.util.HashMap;
import java.util.Set;
/**
 *
 * @author hanna
 */
public class Viite {
    private HashMap<String, String> tiedot;
    
    public Viite(){
        tiedot = new HashMap<String, String>();
    }
    
    public void lisaaTietoa(String kentta, String syote){
        tiedot.put(kentta, syote);
    }
    
    public boolean onkoKenttaa(String kentta){
        return tiedot.containsKey(kentta);
    }
    
    public String getTieto(String kentta){
        return tiedot.get(kentta);
    }
    public String[] getKentat(){
        Object[] apukentat = tiedot.keySet().toArray();
        String[] kentat = new String[apukentat.length];
        
        int i = 0;
        while(i < kentat.length){
            kentat[i] = (String)apukentat[i];
            i++;
        }
        return kentat;
    }
}
