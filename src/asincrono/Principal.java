/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asincrono;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
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

        try {
            ExecutorService executor = Executors.newFixedThreadPool(2);
            ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(executor);
            completionService.submit(new Preparar());
            completionService.submit(new Orden());

            for (int i = 0; i < 2; i++) {
                System.out.println(completionService.take().get());
            }
            executor.shutdown();

        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
