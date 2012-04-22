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
    private ArrayList<String> tagit;
    
    public void tallenna(Viite viite) {
        viitteet.add(viite);
    }

    public ArrayList<Viite> lueViitteet() {
        return viitteet;
    }

    public boolean labelOnOlemassa(String label) {
        for(Viite viite: viitteet) {
            if(viite.getLabel().equals(label)) return true;
        }
        return false;
    }

    public void poistaTiedosto() {
        viitteet = null;
    }
    
    public void lisaaTagitTiedostoon(String label, ArrayList<String> tagit) {
        this.tagit = tagit;
    }
    
    public ArrayList<String> annaTagit() {
        return tagit;
    }
}
