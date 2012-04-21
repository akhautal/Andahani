/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import java.util.ArrayList;

/**
 *
 * @author hanna
 */
public interface TiedostonkasittelijaRajapinta {
    public void tallenna(Viite viite);
    public ArrayList<Viite> lueViitteet();
    //public Viite haeViite(String label);
    public boolean labelOnOlemassa(String label);
    public void lisaaTagitTiedostoon(String label, ArrayList<String> tagit);
}
