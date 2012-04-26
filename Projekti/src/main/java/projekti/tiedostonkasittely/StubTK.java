/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.tiedostonkasittely;

import projekti.tiedostonkasittely.TiedostonkasittelijaRajapinta;
import java.util.ArrayList;
import projekti.Viite;

/**
 *
 * @author dasha
 */
public class StubTK implements TiedostonkasittelijaRajapinta {

    private ArrayList<Viite> viitteet = new ArrayList<Viite>();
    private ArrayList<String> tagit = new ArrayList<String>();
    
    @Override
    public void tallenna(Viite viite) {
        viitteet.add(viite);
    }

    @Override
    public ArrayList<Viite> lueViitteet() {
        return viitteet;
    }

    @Override
    public boolean labelOnOlemassa(String label) {
        for(Viite viite: viitteet) {
            if(viite.getLabel().equals(label)) return true;
        }
        return false;
    }

    public void poistaTiedosto() {
        viitteet = null;
    }
    
    @Override
    public void lisaaTagitTiedostoon(String label, ArrayList<String> tagit) {
        this.tagit = tagit;
    }
    
    public ArrayList<String> annaTagit() {
        return tagit;
    }
       
    @Override
    public void poistaViiteTiedostosta(String label){
        Viite poistettavaViite = null;
        
        for(Viite viite: viitteet) {
            if(viite.getLabel().equals(label)) poistettavaViite = viite;
        }
        
        if(poistettavaViite != null) viitteet.remove(poistettavaViite); 
    }
}
