/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.MaquinaCafe;

/**
 *
 * @author Ariel May
 */
public class cafe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Cafeteria cafe = new Cafeteria(new MaquinaCafe());
        CafeteriaFSM fsm = new CafeteriaFSM(cafe);
        System.out.println(fsm.getEstado());
        Thread.sleep(5000);
        fsm.siguiente();
        System.out.println(fsm.getEstado());
        fsm.siguiente();
        System.out.println(fsm.getEstado());
        fsm.siguiente();
        System.out.println(fsm.getEstado());
        fsm.error();
        System.out.println(fsm.getEstado());
        fsm.siguiente();
        System.out.println(fsm.getEstado());
    }
    
}
