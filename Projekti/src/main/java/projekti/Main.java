/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

/**
 *
 * @author hanna
 */
public class Main {
    
    private static String tiedosto = "viiitteet.csv";
    
    public static void main(String[] args) {
        KonsoliIO io = new KonsoliIO();
        //kaksi io:ta?
        KomentoriviKayttoliittyma kl = new KomentoriviKayttoliittyma(io, 
                new CSVtiedostonKasittelija(io, tiedosto), new Bibtallentaja());
        kl.kaynnista();
    }
}
