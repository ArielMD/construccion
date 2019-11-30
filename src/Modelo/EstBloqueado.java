/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.CafeteriaFSM;
import Modelo.EstadosCafeteria;

/**
 *
 * @author Ariel May
 */
public class EstBloqueado implements EstadosCafeteria{

    @Override
    public void siguiente(CafeteriaFSM fsm) { 
        fsm.setEstadoActual(new EstBloqueado());
    }

    @Override
    public void error(CafeteriaFSM fsm) {
        fsm.setEstadoActual(new EstBloqueado());
    }
    
}
