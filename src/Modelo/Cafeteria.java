/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.MaquinaCafe;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        maquina.getSelectProducto().setEnabled(true);
        maquina.getSelectIngredientes().setEnabled(false);
        maquina.getPreparando().setEnabled(false);
        maquina.getEntrega().setEnabled(false);
        maquina.getJbtNuevaCompra().setVisible(false);
    }
    
    public void seleccionIngredientes(){
        maquina.getSelectIngredientes().setEnabled(true);
        maquina.getTgbNegro().setEnabled(false);
        maquina.getTgbCapuccino().setEnabled(false);
        maquina.getTgbDescafeinado().setEnabled(false);
        maquina.getPedido().setEnabled(true);
        maquina.getAzucar().setEnabled(true);
        maquina.getLeche().setEnabled(true);
        maquina.getJbtAceptar().setVisible(true);
    }
    
    public void preparacion() {
        maquina.getPreparando().setEnabled(true);
        maquina.getJbtAceptar().setVisible(false);
        maquina.getAzucar().setEnabled(false);
        maquina.getLeche().setEnabled(false);

    }
    
    public void entrega(){
        maquina.getEntrega().setEnabled(true);
        maquina.getJbtNuevaCompra().setVisible(true);
    }
    
    public void SinIngredientes(){
        
    }
    
    public void SinCambio(){
        
    }
}
