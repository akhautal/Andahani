/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.toiminnot;

import java.util.ArrayList;
import projekti.io.IOrajapinta;
import projekti.tiedostonkasittely.TiedostonkasittelijaRajapinta;
import projekti.Viite;
import projekti.io.ViitteenTulostaja;

    
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
        if(viitteet == null || viitteet.isEmpty()) {
            io.tulosta("Viitteita ei ole tai tiedosto ei ole olemassa.\n");
        }
        else {
            tulostaViitteet(viitteet);
        }
    }
    
    private void tulostaViitteet(ArrayList<Viite> viitteet){
        ViitteenTulostaja tulostaja = new ViitteenTulostaja(io);
        tulostaja.tulostaViitteet(viitteet);
//        int i = 0, j = 0;
//        String[][] tiedot;
//        
//        while(i < viitteet.size()){
//            tiedot = viitteet.get(i).annaTiedot();
//            while(j < tiedot.length){
//                if(!tiedot[j][1].equals("")){
//                    io.tulosta(tiedot[j][0] + " = " + tiedot[j][1]);
//                }
//                j++;
//            }
//            
//            ArrayList<String> tagit = viitteet.get(i).getTags();
//            if(!tagit.isEmpty()) tulostaTagit(tagit);
//            
//            io.tulosta("");
//            
//            j = 0;
//            i++;
//        }
    }
    
//    private void tulostaTagit(ArrayList<String> tagit) {
//        String output = "";
//        for(String tagi: tagit) {
//            output += tagi + ",";
//        }
//        io.tulosta("tagit: " + output.substring(0, output.length() - 1) + ".");
//    }   
}
