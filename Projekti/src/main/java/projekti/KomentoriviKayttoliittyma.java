/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

/**
 *
 * @author hanna
 */
public class KomentoriviKayttoliittyma implements KayttoliittymaRajapinta{
    private IOrajapinta io;
    private Komentotehdas toiminnot;
    
    public KomentoriviKayttoliittyma(IOrajapinta io, TiedostonkasittelijaRajapinta tallentaja, Bibtallentaja bibTallentaja) { 
        this.io = io;
        toiminnot = new Komentotehdas(io, tallentaja, bibTallentaja);            
    }
    
    public KomentoriviKayttoliittyma(IOrajapinta io) { 
        this.io = io;
    }
 
    public void kaynnista(){
        naytaOhjeet();
        while(true){
            String syote = io.lue();
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

    public Viite annaViite() {
//        String syote;
//        
//        while(true){
//            syote = io.lue();
//            if(syote == null){
//                naytaOhjeet();
//                continue;
//            }
//            if(syote.equalsIgnoreCase("lopeta") || syote.equalsIgnoreCase("lisaa")){
//                break;
//            }
//            if(syote.equalsIgnoreCase("lista")){
//                tallentaja.tulosta();
//            }
//            naytaOhjeet();
//        }
//       
//        if(syote.equalsIgnoreCase("lopeta")){
//            return null;
//        }
//        
//        if(syote.equalsIgnoreCase("lisaa")){
//        }
//        
//        Viite uusi = kysySyotetta();
//        
//        io.tulosta("lisätään syöte järjestelmään.");
//        naytaOhjeet();
//        return uusi;
        return null;
    }
   
}
