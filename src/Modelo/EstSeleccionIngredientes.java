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
public class EstSeleccionIngredientes implements EstadosCafeteria{

    @Override
    public void siguiente(CafeteriaFSM fsm) {
        System.out.println("Estado preparacion:");
        fsm.setEstadoActual(new EstPreparacion());
        fsm.device.preparacion();
    }

    @Override
    public void error(CafeteriaFSM fsm) {
        System.out.println("Sin Ingredients");
        fsm.setEstadoActual(new EstSinIngredientes());
    }
    
}
