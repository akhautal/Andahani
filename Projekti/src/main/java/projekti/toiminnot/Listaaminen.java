/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.toiminnot;

import java.util.ArrayList;
import projekti.IOrajapinta;
import projekti.TiedostonkasittelijaRajapinta;
import projekti.Toiminta;
import projekti.Viite;

/**
 *
 * @author dasha
 */
public class Listaaminen implements Toiminta{
    private IOrajapinta io;
    private TiedostonkasittelijaRajapinta tiedostonKasittelija;
    
    public Listaaminen(IOrajapinta io, TiedostonkasittelijaRajapinta tiedostonKasittelija) {
        this.io = io;
        this.tiedostonKasittelija = tiedostonKasittelija;
    }
 
    @Override
    public void suorita() {
        ArrayList<Viite> viitteet = tiedostonKasittelija.lueViitteet();
        
        if(viitteet != null) {
            tulostaViitteet(viitteet);
        }
        else {
            io.tulosta("Viitteita ei ole tai tiedosto ei ole olemassa.\n");
        } 
    }
    
    private void tulostaViitteet(ArrayList<Viite> viitteet){
        int i = 0;
        int j = 0;
        String[][] tiedot;
        
        while(i < viitteet.size()){
            tiedot = viitteet.get(i).annaTiedot();
            while(j < tiedot.length){
                if(!tiedot[j][1].equals("")){
                    io.tulosta(tiedot[j][0] + " = " + tiedot[j][1]);
                }
                j++;
            }
            io.tulosta("");
            j = 0;
            i++;
        }
    }
}
