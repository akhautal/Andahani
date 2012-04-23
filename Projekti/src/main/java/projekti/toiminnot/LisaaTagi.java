/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.toiminnot;

import java.util.ArrayList;
import projekti.io.IOrajapinta;
import projekti.tiedostonkasittely.TiedostonkasittelijaRajapinta;
import projekti.Viite;

/**
 *
 * @author dasha
 */
public class LisaaTagi implements Toiminta {
    private IOrajapinta io;
    private TiedostonkasittelijaRajapinta tiedostonKasittelija;
    
    public LisaaTagi(IOrajapinta io, TiedostonkasittelijaRajapinta tiedostonKasittelija) {
        this.io = io;
        this.tiedostonKasittelija = tiedostonKasittelija;
    }
 
    @Override
    public void suorita() {
        ArrayList<String> tagit = new ArrayList<String>();
        
        io.tulosta("Kirjoita viitteen label:");

        String label = io.lue();
        //Viite haettuViite = tiedostonKasittelija.haeViite(label);
        while(!tiedostonKasittelija.labelOnOlemassa(label)) {
            io.tulosta("Viite ei ole olemassa! Anna toinen label:");
            label = io.lue();
        }
        io.tulosta("Viite on löydetty. Nyt anna tägejä (tyhja rivi lopeta).");
        
        String uusTagi = io.lue();
        while(!uusTagi.equals("")) {
            tagit.add(uusTagi);
            uusTagi = io.lue();
        }        
        tiedostonKasittelija.lisaaTagitTiedostoon(label, tagit);
        
        io.tulosta("Tagit lisatty.\n");
    } 
}
