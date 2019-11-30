/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.MaquinaCafe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ariel May
 */
public class ControladorMaquinaCafe implements ActionListener{
    
    private MaquinaCafe maquina;
    public ControladorMaquinaCafe(MaquinaCafe maquina) {
        this.maquina = maquina;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
