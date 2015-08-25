/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author noncowi
 */
public class Exercise1 {

    private static volatile boolean stop = false;

    /**
     * @param args the command line arguments
     */
    private static class Task1 extends Thread {

        @Override
        public void run() {
            long sum = 0;
            for (long i = 0; i < 1000000001; i++) {
                sum = sum + i;
            }
            System.out.println(sum);
        }
    }

    private static class Task2 extends Thread {

        @Override
        public void run() {
            for (int i = 1; i < 6; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Exercise1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private static class Task3 extends Thread {

        @Override
        public void run() {
            int i = 10;
            while (stop==false) {
                System.out.println(i);
                i++;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Exercise1.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

    }

    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        new Task1().start();
        new Task2().start();
        new Task3().start();

        Thread.sleep(10000);
        stop = true;
    }
}
