/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation;

/**
 *
 * @author alonzoch_sd2081
 */
public class Quadratic {
    
    public double getQuadraticX1(double a, double b, double c) {
        double x;
        x = (-b + (Math.sqrt(b * b  - 4 * (a * c))))/2 * a;
        return x;
    }
    
    public double getQuadraticX2(double a, double b, double c) {
        double x;
        x = (-b - (Math.sqrt(b * b  - 4 * (a * c))))/2 * a;
        return x;
    }
}
