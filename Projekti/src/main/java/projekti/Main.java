/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import projekti.kayttoliittyma.KomentoriviKayttoliittyma;
import projekti.bibtex.Bibtallentaja;
import projekti.tiedostonkasittely.CSVtiedostonKasittelija;
import projekti.io.KonsoliIO;

/**
 *
 * @author hanna
 */
public class Main {
    public static void main(String[] args) {
//        ViitteidenKasittelija kasittelija = new ViitteidenKasittelija
//                (new KomentoriviKayttoliittyma(new KonsoliIO()), new CSVtallentaja());
//        kasittelija.kaynnista();
        KomentoriviKayttoliittyma kl = new KomentoriviKayttoliittyma(new KonsoliIO(), 
                new CSVtiedostonKasittelija("viitteet.csv"), new Bibtallentaja());
        kl.kaynnista();
    }
}
