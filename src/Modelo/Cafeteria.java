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
public class Cafeteria {
    
    private MaquinaCafe maquina;
    public Cafeteria(MaquinaCafe maquina) {
        this.maquina = maquina;
    }
    
    public void seleccionProductos(){
        maquina.getAzucar().setEnabled(false);
        maquina.getLeche().setEnabled(false);
        maquina.getTgbNegro().setEnabled(false);
        maquina.getTgbCapuccino().setEnabled(false);
        maquina.getTgbDescafeinado().setEnabled(false);
        //maquina.getPedido().setEnable(false);
        
    }
    
    public void seleccionIngredientes(){
        //maquina.getPedido().setEnable("true");
        maquina.getAzucar().setEnabled(true);
        maquina.getLeche().setEnabled(true);
        //maquina.getAceptar().setEnable(true);
    }
    
    public void Preparacion(){
        
    }
    
    public void Entrega(){
        
    }
    
    public void SinIngredientes(){
        
    }
    
    public void SinCambio(){
        
    }
}
