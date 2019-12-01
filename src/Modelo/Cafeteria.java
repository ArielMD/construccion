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
        maquina.getJbtAceptar().setVisible(false);
        //maquina.getPedido().setEnable(false);
        
    }
    
    public void seleccionIngredientes(){
        maquina.getTgbNegro().setEnabled(false);
        maquina.getTgbCapuccino().setEnabled(false);
        maquina.getTgbDescafeinado().setEnabled(false);
        maquina.getPedido().setEnabled(true);
        maquina.getAzucar().setEnabled(true);
        maquina.getLeche().setEnabled(true);
        maquina.getJbtAceptar().setVisible(true);
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
