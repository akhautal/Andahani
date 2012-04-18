/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.toiminnot;

import projekti.Toiminta;
import projekti.IOrajapinta;

/**
 *
 * @author dasha
 */
public class Lopeta implements Toiminta {
    private IOrajapinta io;
 
    public Lopeta(IOrajapinta io) {
        this.io = io;
    }
 
    @Override
    public void suorita() {
        io.tulosta("Suoritus loppuu.");
        System.exit(0);
    }
 
}
