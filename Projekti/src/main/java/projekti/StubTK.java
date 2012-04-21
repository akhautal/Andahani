/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import java.util.ArrayList;

/**
 *
 * @author dasha
 */
public class StubTK implements TiedostonkasittelijaRajapinta {

    private ArrayList<Viite> viitteet = new ArrayList<Viite>();
    
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

    public void lisaaTagitTiedostoon(String label, ArrayList<String> tagit) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
