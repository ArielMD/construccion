/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class Principal {
    
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        CompletableFuture<Void> futureRunAsync = CompletableFuture.runAsync(() -> {
            System.out.println("Preparando Café...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Café terminado");
        }, executor);

        CompletableFuture<Void> futureSupplyAsync = CompletableFuture.runAsync(() -> {
            System.out.println("Preparando Orden...");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Orden Lista!");
        }, executor);
                
        executor.shutdown();
    }
    
}
