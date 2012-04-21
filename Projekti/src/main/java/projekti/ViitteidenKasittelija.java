/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import projekti.kayttoliittyma.KayttoliittymaRajapinta;
import projekti.bibtex.Bibtallentaja;
import projekti.tiedostonkasittely.TiedostonkasittelijaRajapinta;
import java.util.ArrayList;

/**
 *
 * @author hanna
 */
public class ViitteidenKasittelija {
    KayttoliittymaRajapinta kayttoliittyma;
    TiedostonkasittelijaRajapinta tiedostonKasittelija;
    Bibtallentaja bibtallentaja;
    
    public ViitteidenKasittelija(KayttoliittymaRajapinta kl, TiedostonkasittelijaRajapinta tiedostonKasittelija){
        this.kayttoliittyma = kl;
        this.tiedostonKasittelija = tiedostonKasittelija;
    }
    
    public ViitteidenKasittelija(KayttoliittymaRajapinta kl, TiedostonkasittelijaRajapinta tallentaja,
            Bibtallentaja bibtallentaja){
        this.kayttoliittyma = kl;
        this.tiedostonKasittelija = tallentaja;
        this.bibtallentaja = bibtallentaja;
    }
    
    public void kaynnista(){
//        kayttoliittyma.naytaOhjeet();
//        
//        Viite lisattava = kayttoliittyma.annaViite();
//        
//        while(lisattava != null){
//            tiedostonKasittelija.tallenna(lisattava);
//            lisattava = kayttoliittyma.annaViite();
//        }
           
    }
    
    
    
    
    
//    private void bibTulostus() {
//        ArrayList<Viite> viitteet = tiedostonKasittelija.lueViitteet();
//        int i = 0;
//        while(i < viitteet.size()){
//            bibtallentaja.tallenna(viitteet.get(i));
//            i++;
//        }
//    }
    
}
