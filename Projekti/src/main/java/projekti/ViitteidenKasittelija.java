/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

/**
 *
 * @author hanna
 */
public class ViitteidenKasittelija {
    KayttoliittymaRajapinta kayttoliittyma;
    TallentajaRajapinta tallentaja;
    
    public ViitteidenKasittelija(KayttoliittymaRajapinta kl, TallentajaRajapinta tallentaja){
        this.kayttoliittyma = kl;
        this.tallentaja = tallentaja;
    }
    
    public void kaynnista(){
        kayttoliittyma.naytaOhjeet();
        
        Viite lisattava = kayttoliittyma.annaViite();
        
        while(lisattava != null){
            tallentaja.tallenna(lisattava);
            lisattava = kayttoliittyma.annaViite();
        }
           
    }
    
}
