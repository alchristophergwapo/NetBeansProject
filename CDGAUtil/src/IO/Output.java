/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

/**
 *
 * @author alonzoch_sd2081
 */
public class Output {
    public boolean printThis(String val) {
        System.out.println(val);
        return true;
    }
    
    public String display(String val) {
        return val;
    }
    
    public void displayReverse(String val) {
        for(int i = val.length()-1; i >= 0; i--) {
            System.out.println(val.charAt(i));
        }
    }
}
