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
public class Lisaaminen implements Toiminta{
    private IOrajapinta io;
    private TiedostonkasittelijaRajapinta tiedostonKasittelija;
    
    public Lisaaminen(IOrajapinta io, TiedostonkasittelijaRajapinta tiedostonKasittelija) {
        this.io = io;
        this.tiedostonKasittelija = tiedostonKasittelija;
    }
 
    @Override
    public void suorita() {
        Viite uusi = kysySyotetta();
        
        io.tulosta("lisätään viite järjestelmään.");
        tiedostonKasittelija.tallenna(uusi);
    } 
    
    private Viite kysySyotetta(){
        String[] kentat = {"author", "title", "year", "publisher", "booktitle", "pages", 
            "journal", "volume", "number",  "address"};
        String syote;
        Viite uusi = new Viite();
        int i = 0;
        
        uusi.lisaaTietoa("millainenViite", viitteenLaatu());
        uusi.lisaaTietoa("label", annaLabel());
        while(i < kentat.length){
            io.tulosta(kentat[i] + ":");
            syote = io.lue();
            if(syote != null && !syote.equals("")){
                uusi.lisaaTietoa(kentat[i], syote);
            }
            i++;
        }
        return uusi;
    }
    
     private String viitteenLaatu(){
        io.tulosta("Millaisen viitteen haluat lisätä?");
        io.tulosta("(anna numero)");
        io.tulosta("1. @inproceedings \n2. @book \n3. @article");
        String vastaus = io.lue();
        while(!vastaus.equals("1") && !vastaus.equals("2") && !vastaus.equals("3")){
            io.tulosta("(anna numero)");
            io.tulosta("1. @inproceedings \n2. @book \n3. @article");
            vastaus = io.lue();
        }
        if(vastaus.equals("1")){
            return "@inproceedings";
        }
        else if (vastaus.equals("2")){
            return "@book";
        }
        return "@article";
    }
     
    private String annaLabel() {
        io.tulosta("Label:");
        String syote = io.lue();
        while(onkoLabelJoKaytossa(syote)){
            io.tulosta("Tämä label on jo käytössä!");
            io.tulosta("Valitse toinen label.");
            io.tulosta("Label:");
            syote = io.lue();
        }
        return syote;
    }
    
    private boolean onkoLabelJoKaytossa(String ehdotettuLabel){
        ArrayList<Viite> viitteet = tiedostonKasittelija.lueViitteet();
        
        if(viitteet == null){
            return false;
        }
        
        int i = 0;
        while(i < viitteet.size()){
            if(viitteet.get(i).getLabel().equalsIgnoreCase(ehdotettuLabel)){
                return true;
            }
            i++;
        }
        
        return false;
        
    }
}
