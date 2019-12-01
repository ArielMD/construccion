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
public class EstSinIngredientes implements EstadosCafeteria{

    @Override
    public void siguiente(CafeteriaFSM fsm) {
        System.out.println("Return inicio");
        fsm.device.seleccionProductos();
        fsm.setEstadoActual(new EstSeleccionProductos());
    }

    @Override
    public void error(CafeteriaFSM fsm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
