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
public class EstSinCambio implements EstadosCafeteria{

    @Override
    public void siguiente(CafeteriaFSM fsm) {
        System.out.println("Seleccion ingredientes");
        fsm.setEstadoActual(new EstSeleccionIngredientes());
    }

    @Override
    public void error(CafeteriaFSM fsm) {
        System.out.println("bloqueado");
        fsm.setEstadoActual(new EstBloqueado());
    }
    
}
