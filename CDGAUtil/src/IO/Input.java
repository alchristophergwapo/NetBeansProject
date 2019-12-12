/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.util.Scanner;

/**
 *
 * @author alonzoch_sd2081
 */
public class Input {
    private long input;
    public long getInput() {
        try{
            System.out.print("Input a number: ");
            Scanner s = new Scanner(System.in);
            
            input = s.nextLong();
        } catch (Exception e) {
            System.out.println("An error occur!");
        }
        return input;
    }
    
//    public double getValue() {
//        return input;
//    }
}
