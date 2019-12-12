/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Thread;


/**
 *
 * @author alonzoch_sd2081
 */
public class StopWatch implements Runnable{
    private static int ms = 0;

    public StopWatch() {
    }
    
    public static int getMs() {
        return ms;
    }
    
    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            try {
                ms = i;
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    
    
}
