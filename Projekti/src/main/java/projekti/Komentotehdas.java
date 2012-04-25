/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import java.util.HashMap;
import projekti.bibtex.BibtallentajaRajapinta;
import projekti.io.IOrajapinta;
import projekti.tiedostonkasittely.TiedostonkasittelijaRajapinta;
import projekti.toiminnot.*;

/**
 *
 * @author dasha
 */
public class Komentotehdas {
    private HashMap<String, Toiminta> toiminnot;
 
    public Komentotehdas(IOrajapinta io, TiedostonkasittelijaRajapinta tallentaja, BibtallentajaRajapinta bib) {
        toiminnot = new HashMap<String, Toiminta>();
        toiminnot.put("lisaa", new Lisaaminen(io, tallentaja));
        toiminnot.put("tagi", new LisaaTagi(io, tallentaja));
        toiminnot.put("lista", new Listaaminen(io, tallentaja));
        toiminnot.put("bib", new Bib(io, tallentaja, bib));
        toiminnot.put("haku", new TagiHaku(io, tallentaja));
        toiminnot.put("lopeta", new Lopeta(io));
        toiminnot.put("tuntematon", new Tuntematon(io));
        toiminnot.put("poista", new PoistaViite(io, tallentaja));
    }
 
    public Toiminta hae(String operaatio) {
        Toiminta toiminta = toiminnot.get(operaatio);
        if (toiminta == null) {
            toiminta = toiminnot.get("tuntematon");
        }
        return toiminta;
    }
}

