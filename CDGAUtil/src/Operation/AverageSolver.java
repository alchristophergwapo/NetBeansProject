/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation;

import IO.Input;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alonzoch_sd2081
 */
public class AverageSolver {
    Input i = new Input();
    private double[] list;
    private int size;

    public AverageSolver() {
        this.list = new double[size];
    }
    public void getInputs() {
        size = (int)(i.getInput());
        int count = 0;
        while (count != size){
            try {
                System.out.print("Enter a number: ");
                Scanner s = new Scanner(System.in);
                if (!s.hasNextInt()) {
                    double num = s.nextDouble();
                    list[count] = (num);
                    count++;
                }
                else {
                    continue;
                }
            } catch (Exception e) {
                continue;
            }
        }
    }
    public double getAverage() {
        double output = 0;
        for (double value : list){
            output += value;
        }
        System.out.println("Total = "+ output);
        return output/size;
    }
    
    
    public void sort() {
        
    double temp1;
    boolean sorted = false;
    while(!sorted) {
        sorted = true;
        for (int i = 0; i < size; i++) {
            if (list[i] > list[i+1]) {
                temp1 = list[i];
                list[i] = list[i+1];
                list[i+1] = temp1;
                sorted = false;
            }
        }
    }
    }
    public void displaySorted() {
        for (Double val : list) {
            System.out.println(val);
        }
    }
}
