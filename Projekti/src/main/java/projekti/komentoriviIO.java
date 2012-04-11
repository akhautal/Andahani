/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import java.util.Scanner;
/**
 *
 * @author hanna
 */
public class komentoriviIO implements IOrajapinta{
    Scanner lukija;
    
    public komentoriviIO(){
        lukija = new Scanner(System.in);
    }
    
    public void tulosta(String tuloste){
        System.out.println(tuloste);
    }
    
    public String lue(){
        return lukija.nextLine();
    }
}
