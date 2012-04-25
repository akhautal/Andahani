/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.toiminnot;

import java.util.ArrayList;
import projekti.toiminnot.Toiminta;
import projekti.Viite;
import projekti.io.IOrajapinta;
import projekti.io.ViitteenTulostaja;
import projekti.tiedostonkasittely.TiedostonkasittelijaRajapinta;

/**
 *
 * @author hanna
 */
public class TagiHaku  implements Toiminta{
    private IOrajapinta io;
    private TiedostonkasittelijaRajapinta tiedostonKasittelija;
    
    public TagiHaku (IOrajapinta io, TiedostonkasittelijaRajapinta tiedostonKasittelija) {
        this.io = io;
        this.tiedostonKasittelija = tiedostonKasittelija;
    }
    
    @Override
    public void suorita() {
        System.out.println("123");
        ArrayList<Viite> viitteet = tiedostonKasittelija.lueViitteet();
        System.out.println("456");
        if(viitteet == null || viitteet.isEmpty()) {
            io.tulosta("Viitteita ei ole tai tiedosto ei ole olemassa.\n");
            return;
        }
        
        io.tulosta("Millä tagilla haluat hakea?");
        String haettava = io.lue();
        haeTagilla(viitteet, haettava);
        
    }
    
    private void haeTagilla(ArrayList<Viite> viitteet, String haettavaTagi){
        ArrayList<Viite> tagiOn = new ArrayList<Viite>();
        for(Viite viite: viitteet) {
            if(viite.hasTag(haettavaTagi))
                tagiOn.add(viite);
        }
        if(tagiOn.isEmpty()){
            io.tulosta("Millään viitteellä ei ole tagia " + haettavaTagi + ".");
        }
        else{
            ViitteenTulostaja tulostaja = new ViitteenTulostaja(io);
            tulostaja.annaTuloste(tagiOn);
            //tulostaViitteet(tagiOn);
        }
    }
    
//    private void tulostaViitteet(ArrayList<Viite> viitteet){
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
//    }
//    
//    private void tulostaTagit(ArrayList<String> tagit) {
//        String output = "";
//        for(String tagi: tagit) {
//            output += tagi + ",";
//        }
//        io.tulosta("tagit: " + output.substring(0, output.length() - 1) + ".");
//    }   
    
}
