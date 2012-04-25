/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.toiminnot;

import java.util.ArrayList;
import projekti.io.IOrajapinta;
import projekti.tiedostonkasittely.TiedostonkasittelijaRajapinta;
import projekti.Viite;



import java.io.*;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import projekti.Viite;

/**
 *
 * @author akhautal
 */

public class PoistaViite implements Toiminta {
    
      
    private IOrajapinta io;
    private TiedostonkasittelijaRajapinta tiedostonKasittelija;
    
    public PoistaViite(IOrajapinta io, TiedostonkasittelijaRajapinta tiedostonKasittelija) {
        this.io = io;
        this.tiedostonKasittelija = tiedostonKasittelija;
    }    

    
    @Override
    public void suorita() {
        ArrayList<Viite> viitteet = tiedostonKasittelija.lueViitteet();
        if(viitteet == null || viitteet.isEmpty()) {
            io.tulosta("Viitteita ei ole tai tiedostoa ei ole olemassa.\n");
            return;
        }
       
        io.tulosta("Kirjoita poistettavan viitteen label:"); 
        String syote = io.lue();
        
        while(!tiedostonKasittelija.labelOnOlemassa(syote)) {
            io.tulosta("Viite ei ole olemassa! Anna toinen label:");
            syote = io.lue();
        }
        
        tiedostonKasittelija.poistaViiteTiedostosta(syote);
        io.tulosta("Viite poistettiin");
    }
    
}
