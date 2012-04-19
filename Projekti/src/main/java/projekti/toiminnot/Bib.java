/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.toiminnot;

import java.util.ArrayList;
import projekti.*;

/**
 *
 * @author dasha
 */
public class Bib implements Toiminta{

    private IOrajapinta io;
    private Bibtallentaja bibtallentaja;
    private TiedostonkasittelijaRajapinta tiedostonKasittelija;
    
    public Bib(IOrajapinta io, TiedostonkasittelijaRajapinta tiedostonKasittelija) {
        this.io = io;
        this.tiedostonKasittelija = tiedostonKasittelija;
        bibtallentaja = new Bibtallentaja();    
    } 
    
  
    
    public void suorita() {
        String tiedostonimi = bibTiedostonNimi();
        
        ArrayList<Viite> viitteet = tiedostonKasittelija.lueViitteet();
        int i = 0;
        while(i < viitteet.size()){
            bibtallentaja.tallenna(viitteet.get(i));
            //bibtallentaja.tallenna(viitteet.get(i), tiedostonimi);
            i++;
        }
    }
     
    private String bibTiedostonNimi(){
        io.tulosta("Millä nimellä haluat tallentaa bibtex-tiedoston?");
        String tiedostonimi = io.lue();
        while(!onkoKelvollinenBibtexnimi(tiedostonimi)){
            io.tulosta("Epäkelpo nimi!");
            io.tulosta("Anna toinen nimi.");
            tiedostonimi = io.lue();
        }
        
        return tiedostonimi;
    }
    
    private boolean onkoKelvollinenBibtexnimi(String ehdotus){
        if(ehdotus == null || ehdotus.charAt(0) == '.') {
            return false;
        }
        
        int i = 0;
        
        while (i < ehdotus.length() && ehdotus.charAt(i) != '.'){
            i++;
        }
        
        if(i == ehdotus.length()){
            return false;
        }
        if(!ehdotus.substring(i+1).equals("bib")){
            return false;
        }
        
        return true;
    }

   
}
