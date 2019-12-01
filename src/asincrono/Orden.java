/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asincrono;

import java.util.concurrent.Callable;

/**
 *
 * @author USUARIO
 */
public class Orden implements Callable<String>{

    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        return "Orden Lista";
    }
    
}
