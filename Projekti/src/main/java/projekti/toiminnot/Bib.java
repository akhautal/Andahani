/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.toiminnot;

import java.util.ArrayList;
import java.util.HashSet;
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
            bibtallentaja.tallenna(viitteet.get(i), tiedostonimi);
            //bibtallentaja.tallenna(viitteet.get(i), tiedostonimi);
            i++;
        }
    }
     
    private String bibTiedostonNimi(){
        io.tulosta("Millä nimellä haluat tallentaa bibtex-tiedoston?");
        io.tulosta("Anna muodossa tiedostonimi.bib");
        String tiedostonimi = io.lue();
        while(!onKelvollinenBibtexnimi(tiedostonimi)){
            io.tulosta("Epäkelpo nimi!");
            io.tulosta("Anna toinen nimi.");
            tiedostonimi = io.lue();
        }
        
        return tiedostonimi;
    }
    
    private boolean onKelvollinenBibtexnimi(String ehdotus){
        if(ehdotus == null || ehdotus.charAt(0) == '.') {
            return false;
        }
        
        HashSet<Character> kielletytMerkit = new HashSet<Character>();
        kielletytMerkit.add('*');
        kielletytMerkit.add('\\');
        kielletytMerkit.add('?');
        kielletytMerkit.add('*');
        kielletytMerkit.add('|');
        kielletytMerkit.add('<');
        kielletytMerkit.add('>');
        kielletytMerkit.add('\"');
        kielletytMerkit.add(':');
        
        if(!ehdotus.endsWith(".bib")) return false;
        
        for(char i: kielletytMerkit) {
            if(ehdotus.contains(Character.toString(i))) return false; 
        }
        
        return true;
    }
}
