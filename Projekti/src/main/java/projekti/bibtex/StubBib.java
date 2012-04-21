/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.bibtex;

import java.util.ArrayList;
import projekti.Viite;

/**
 *
 * @author dasha
 */
public class StubBib implements BibtallentajaRajapinta {
    
    ArrayList<Viite> viitteet = new ArrayList<Viite>();
    ArrayList<String> tiedostot = new ArrayList<String>();
    
    public void tallenna(Viite viite, String tiedostonimi) {
        viitteet.add(viite);
        tiedostot.add(tiedostonimi);
    }
    
    public ArrayList<Viite> annaViitteet() {
        return viitteet;
    }
    
    public ArrayList<String> annaTiedostonimet() {
        return tiedostot;
    }
}
