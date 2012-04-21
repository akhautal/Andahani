/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import java.util.ArrayList;

/**
 *
 * @author dasha
 */
public class StubIO implements IOrajapinta {

    private String[] lines;
    private int i;
    private ArrayList<String> output;

    public StubIO(String... values) {
        this.lines = values;
        output = new ArrayList<String>();
        //i = 0;
    }

    public void tulosta(String tuloste) {
        output.add(tuloste);
    }

    public ArrayList<String> getOutput() {
        return output;
    }

    public String lue() {
        if (i < lines.length) {
            return lines[i++];
        }
        return "";
    }
    
}
