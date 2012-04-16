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
    public static void main(String[] args) {
//        ViitteidenKasittelija kasittelija = new ViitteidenKasittelija
//                (new KomentoriviKayttoliittyma(new KonsoliIO()), new CSVtallentaja());
//        kasittelija.kaynnista();
        KomentoriviKayttoliittyma kl = new KomentoriviKayttoliittyma(new KonsoliIO(), 
                new CSVtallentaja());
        kl.kaynnista();
    }
}
