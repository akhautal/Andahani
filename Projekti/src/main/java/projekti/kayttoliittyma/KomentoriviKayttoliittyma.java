/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.kayttoliittyma;

import projekti.Komentotehdas;
import projekti.bibtex.BibtallentajaRajapinta;
import projekti.io.IOrajapinta;
import projekti.tiedostonkasittely.TiedostonkasittelijaRajapinta;

/**
 *
 * @author hanna
 */
public class KomentoriviKayttoliittyma implements KayttoliittymaRajapinta{
    private IOrajapinta io;
    private Komentotehdas toiminnot;
    
    public KomentoriviKayttoliittyma(IOrajapinta io, TiedostonkasittelijaRajapinta tallentaja, BibtallentajaRajapinta bibTallentaja) { 
        this.io = io;
        toiminnot = new Komentotehdas(io, tallentaja, bibTallentaja);            
    }
 
    public void kaynnista(){
        naytaOhjeet();
        while(true){
            String syote = io.lue();
            
            if (syote.isEmpty()) {
                break;
            }
            
            toiminnot.hae(syote).suorita();
            naytaOhjeet();
        }
    }

    public void naytaOhjeet() {
        io.tulosta("\"lisaa\" aloittaa uuden viitteen lisäyksen.");
        io.tulosta("\"tagi\" aloittaa uuden tagin lisäyksen olemassaolevaan viitteeseen.");
        io.tulosta("\"lopeta\" lopettaa.");
        io.tulosta("\"lista\" listaa kaikki viitteet.");
        io.tulosta("\"bib\" tulostaa kaikki viitteet bibtex-muodossa.");
        io.tulosta("\n");
    }
}
