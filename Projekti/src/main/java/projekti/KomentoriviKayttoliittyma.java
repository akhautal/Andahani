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
            String millainenViite = kysyViitteenLaatu();
            Viite uusi = kysySyotetta(millainenViite);
            io.tulosta("\nLisätään syöte järjestelmään.");
            naytaOhjeet();
            return uusi;
        }
        
        return null;
    }
    
    
    private Viite kysySyotetta(String millainenViite){
        String[] kentat = {"label", "author", "title", "year", "publisher", "booktitle", "pages", 
            "journal", "volume", "number",  "address"};
        String syote;
        Viite uusi = new Viite();
        int i = 0;
        
        uusi.lisaaTietoa("millainenViite", millainenViite);
        while(i < kentat.length){
            io.tulosta(kentat[i]);
            syote = io.lue();
            if(syote != null && !syote.equals("")){
                uusi.lisaaTietoa(kentat[i], syote);
            }
            i++;
        }
        return uusi;
    }
    
    private String kysyViitteenLaatu(){
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
}
