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
        CompletableFuture<Void> preparacion = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Preparando cafe...");
                Thread.sleep(2000);
                System.out.println("Café terminado!");
            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }, executor);

        CompletableFuture<Void> orden = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Comenzando orden...");
                Thread.sleep(4000);
                System.out.println("Orden terminada!");
            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }, executor);
    }

}
