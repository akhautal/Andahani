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
    
    public KomentoriviKayttoliittyma(IOrajapinta io){
        this.io = io;
    }

    public void naytaOhjeet() {
        io.tulosta("\"lisaa\" aloittaa uuden viitteen lisäyksen.");
        io.tulosta("\"lopeta\" lopettaa.");
    }


    public Viite annaViite() {
        String syote;
        
        while(true){
            syote = io.lue();
            if(syote == null){
                naytaOhjeet();
                continue;
            }
            if(syote.equalsIgnoreCase("lopeta") || syote.equalsIgnoreCase("lisaa")){
                break;
            }
            naytaOhjeet();
        }
        
        if(syote.equalsIgnoreCase("lopeta")){
            return null;
        }
        
        if(syote.equalsIgnoreCase("lisaa")){
            io.tulosta("Kirjoita ensin, minkä tiedon viitteestä aiot antaa (esim \"author\"),"
                + " ja sen jälkeen enter. seuraavalle riville kirjailijan nimi.");
            io.tulosta("\"lopeta\" lopettaa.");
        }
        
        Viite uusi = new Viite();
        
        syote = io.lue();
        while(!syote.equalsIgnoreCase("lopeta")){
            tarkistaAakkoset(syote);
            uusi.lisaaTietoa(syote);
            syote = io.lue();
        }
        
        io.tulosta("lisätään syöte järjestelmään.");
        naytaOhjeet();
        return uusi;
    }
    
    // tekee jotain jos syötteessä on ääkkösiä
    private void tarkistaAakkoset(String syote){
        
    }
}
