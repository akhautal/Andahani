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
    private  String[] kentat = {"author", "title", "year", "publisher", "booktitle", "pages", 
            "journal", "volume", "number",  "address"};
    
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
        String syote;
        Viite uusi = new Viite();
        
        String viite = annaViite();
        String label = annaLabel();
        uusi.lisaaTietoa("millainenViite", viite);
        uusi.lisaaTietoa("label", label);
        uusi = lisaaKentat(uusi);
        uusi = lisaaTagit(uusi);
        
        return uusi;
    }
    
    private String korvaaAakkoset(String str) {
        str = str.replaceAll("ö", "\\\"{o}");
        str = str.replaceAll("Ö", "\\\"{O}");
        str = str.replaceAll("ä", "\\\"{a}");
        str = str.replaceAll("Ä", "\\\"{A}");
        
        //System.out.println(str);
        return str;
    }
        
    private Viite lisaaKentat(Viite viite) {
        int i = 0;
        String syote;
        
        while(i < kentat.length){
            io.tulosta(kentat[i] + ":");
            syote = io.lue();
            syote = korvaaAakkoset(syote);
            if(!syote.equals("")){
                viite.lisaaTietoa(kentat[i], syote);
            }
            i++;
        }
        
        return viite;
    }
    
    private Viite lisaaTagit(Viite viite) {
        io.tulosta("Nyt voit lisätä viitteeseen tägejä. Tyhjä rivi lopeta.");
        
        String tagi = io.lue();
        while(!tagi.equals("")) {
            viite.lisaaTagi(tagi);
            tagi = io.lue();
        }
        return viite;
    }
    
    private String annaViite(){
        io.tulosta("Millaisen viitteen haluat lisätä?");
        
        String vastaus;
        do {
            io.tulosta("(anna numero)");
            io.tulosta("1. @inproceedings \n2. @book \n3. @article");
            vastaus = io.lue();
        }
        while(!vastaus.equals("1") && !vastaus.equals("2") && !vastaus.equals("3"));
         
        
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

        while(labelOnJoKaytossa(syote)){
            io.tulosta("Tämä label on jo käytössä!");
            io.tulosta("Valitse toinen label.");
            io.tulosta("Label:");
            syote = io.lue();
        }
        return syote;
    }
    
    private boolean labelOnJoKaytossa(String ehdotettuLabel){
        ArrayList<Viite> viitteet = tiedostonKasittelija.lueViitteet();
        
        if(viitteet == null) return false;
        
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
