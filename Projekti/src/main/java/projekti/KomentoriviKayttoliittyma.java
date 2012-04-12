/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;
import java.util.Scanner;
/**
 *
 * @author hanna
 */
public class KomentoriviKayttoliittyma implements KayttoliittymaRajapinta{
    private Scanner lukija;
    
    public KomentoriviKayttoliittyma(){
        lukija = new Scanner(System.in);
    }

    public void naytaOhjeet() {
        System.out.println("\"lisaa\" aloittaa uuden viitteen lisäyksen.");
        System.out.println("\"lopeta\" lopettaa.");
    }


    public Viite annaViite() {
        String syote;
        
        while(true){
            syote = lukija.nextLine();
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
            System.out.println("Kirjoita ensin, minkä tiedon viitteestä aiot antaa (esim \"author\"),"
                + " ja sen jälkeen enter. seuraavalle riville kirjailijan nimi.");
            System.out.println("\"lopeta\" lopettaa.");
        }
        
        Viite uusi = new Viite();
        
        syote = lukija.nextLine();
        while(!syote.equalsIgnoreCase("lopeta")){
            tarkistaAakkoset(syote);
            uusi.lisaaTietoa(syote);
            syote = lukija.nextLine();
        }
        
        System.out.println("lisätään syöte järjestelmään.");
        naytaOhjeet();
        return uusi;
    }
    
    // tekee jotain jos syötteessä on ääkkösiä
    private void tarkistaAakkoset(String syote){
        
    }
}
