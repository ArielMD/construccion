/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Ariel May
 */
public class EstEntrega implements EstadosCafeteria{

    @Override
    public void siguiente(CafeteriaFSM fsm) {
        System.out.println("Estado seleccion:");
        fsm.device.seleccionProductos();
        fsm.setEstadoActual(new EstSeleccionProductos());
    }

    @Override
    public void error(CafeteriaFSM fsm) {
        System.out.println("Estado sin ingredientes");
        fsm.device.SinIngredientes();
        fsm.setEstadoActual(new EstSinIngredientes());
    }
    
}