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
    
    //tarvitsee tallentajan? rivi 40
    public KomentoriviKayttoliittyma(IOrajapinta io) { 
        this.io = io;
    }

    public void naytaOhjeet() {
        io.tulosta("\"lisaa\" aloittaa uuden viitteen lisäyksen.");
        io.tulosta("\"lopeta\" lopettaa.");
        io.tulosta("\"lista\" listaa kaikki viitteet.");
    }


    public Viite annaViite() {
        String syote;
        String command;
        
        while(true){
            syote = io.lue();
            if(syote == null){
                naytaOhjeet();
                continue;
            }
            if(syote.equalsIgnoreCase("lopeta") || syote.equalsIgnoreCase("lisaa")){
                break;
            }
            if(syote.equalsIgnoreCase("lista")){
                CSVtallentaja tallentaja = new CSVtallentaja();
                tallentaja.tulosta();
            }
            naytaOhjeet();
        }
       
        if(syote.equalsIgnoreCase("lopeta")){
            return null;
        }
        
        if(syote.equalsIgnoreCase("lisaa")){
            io.tulosta("Kirjoita ensin, minkä tiedon viitteestä aiot antaa (esim \"author\"),"
                + " ja sen jälkeen enter. seuraavalle riville kirjailijan nimi.");
            io.tulosta("tyhjä lopettaa.");
        }
        
        Viite uusi = new Viite();
        

        command = io.lue();
        while(!command.equalsIgnoreCase("")){
            syote = io.lue();
            uusi.lisaaTietoa(command, syote);
            command = io.lue();
        //   tarkistaAakkoset(syote);
        //    uusi.lisaaTietoa(syote);          
        }
        
        io.tulosta("lisätään syöte järjestelmään.");
        naytaOhjeet();
        return uusi;
    }
    
    // tekee jotain jos syötteessä on ääkkösiä
    private void tarkistaAakkoset(String syote){
        
    }
}
