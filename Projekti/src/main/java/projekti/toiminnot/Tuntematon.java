/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.toiminnot;

import projekti.IOrajapinta;
import projekti.Toiminta;

/**
 *
 * @author dasha
 */
public class Tuntematon implements Toiminta {
    private IOrajapinta io;
 
    public Tuntematon(IOrajapinta io) {
        this.io = io;
    }
 
    @Override
    public void suorita() {
        io.tulosta("Sallitut komennot: lisaa, listaa, bib ja lopeta.");
    }
}
