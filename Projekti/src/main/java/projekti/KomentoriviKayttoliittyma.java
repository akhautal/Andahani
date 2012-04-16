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
    private TallentajaRajapinta tallentaja;public KomentoriviKayttoliittyma(IOrajapinta io, TallentajaRajapinta tallentaja) { 
        this.io = io;
        this.tallentaja = tallentaja;
    }
    
    public KomentoriviKayttoliittyma(IOrajapinta io) { 
        this.io = io;
    }

    public void naytaOhjeet() {
        io.tulosta("\"lisaa\" aloittaa uuden viitteen lisäyksen.");
        io.tulosta("\"lopeta\" lopettaa.");
        io.tulosta("\"lista\" listaa kaikki viitteet.");
        io.tulosta("\n");
    }
    
    public void kaynnista(){
        naytaOhjeet();
        while(true){
            String syote = io.lue();
            if(syote == null){
                naytaOhjeet();
                continue;
            }
            if(syote.equalsIgnoreCase("lopeta")){
                break;
            }
            else if(syote.equalsIgnoreCase("lista")){
                listaa();
            }
            else if(syote.equalsIgnoreCase("lisaa")){
                lisaa();
            }
            naytaOhjeet();
            
        }
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
        }
        
        Viite uusi = kysySyotetta();
        
        io.tulosta("lisätään syöte järjestelmään.");
        naytaOhjeet();
        return uusi;
    }
    private void lisaa(){
        Viite uusi = kysySyotetta();
        if(onkoLabelJoKaytossa(uusi)){
            io.tulosta("Tämä label on jo käytössä! Uutta viitettä ei lisätä.");
        }
        else{
            io.tulosta("lisätään viite järjestelmään.");
            tallentaja.tallenna(uusi);
        }
        
    }
    
    private void listaa(){
        //CSVtallentaja tallentaja = new CSVtallentaja();
        tallentaja.tulosta();
    }
    
    
    private Viite kysySyotetta(){
        String[] kentat = {"label", "author", "title", "year", "publisher", "booktitle", "pages", 
            "journal", "volume", "number",  "address"};
        String syote;
        Viite uusi = new Viite();
        int i = 0;
        
        uusi.lisaaTietoa("millainenViite", viitteenLaatu());
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
    
    private boolean onkoLabelJoKaytossa(Viite viite){
        //??? vaatii CSV-tiedoston lukua
        return false;
    }
    
  
}
