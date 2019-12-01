/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cafeteria;
import Modelo.CafeteriaFSM;
import Modelo.Cliente;
import Vista.MaquinaCafe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ariel May
 */
public class ControladorMaquinaCafe implements ActionListener{
    
    private MaquinaCafe maquina;
    private Cliente cliente;
    private CafeteriaFSM fsm;
    
    public ControladorMaquinaCafe(MaquinaCafe maquina) {
        this.maquina = maquina;
        this.maquina.getJbtUno().addActionListener(this);
        this.maquina.getJbtCinco().addActionListener(this);
        this.maquina.getJbtDiez().addActionListener(this);
        this.maquina.getJbtVeinte().addActionListener(this);
        this.maquina.getJbtCincuenta().addActionListener(this);
        this.maquina.getJbtAceptar().addActionListener(this);
        this.maquina.getTgbCapuccino().addActionListener(this);
        this.maquina.getTgbNegro().addActionListener(this);
        this.maquina.getTgbDescafeinado().addActionListener(this);
        
        
        Cafeteria cafe = new Cafeteria(maquina);
        this.fsm = new CafeteriaFSM(cafe);
        this.cliente = new Cliente();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.maquina.getJbtUno() == e.getSource()){
            cliente.ingresarUno();
            this.maquina.getDineroIngresado().setText(cliente.getIngresado().toString());
            activarProductos();
        }
        if(this.maquina.getJbtCinco() == e.getSource()){
            cliente.ingresarCinco();
            this.maquina.getDineroIngresado().setText(cliente.getIngresado().toString());
            activarProductos();
        }
        if(this.maquina.getJbtDiez() == e.getSource()){
            cliente.ingresarDiez();
            this.maquina.getDineroIngresado().setText(cliente.getIngresado().toString());
            activarProductos();
        }
        if(this.maquina.getJbtVeinte() == e.getSource()){
            cliente.ingresarVeinte();
            this.maquina.getDineroIngresado().setText(cliente.getIngresado().toString());
            activarProductos();
        }
        if(this.maquina.getJbtCincuenta() == e.getSource()){
            cliente.ingresarCincuenta();
            this.maquina.getDineroIngresado().setText(cliente.getIngresado().toString());
            activarProductos();
        }
        
        if(this.maquina.getTgbNegro() == e.getSource()){
            System.out.println("n");
            this.maquina.getPedido().setText("Café Negro");
            this.fsm.siguiente();
        }
        if(this.maquina.getTgbDescafeinado() == e.getSource()){
            System.out.println("d");
            this.maquina.getPedido().setText("Café Descafeinado");
            this.fsm.siguiente();
        }
        if(this.maquina.getTgbCapuccino() == e.getSource()){
            System.out.println("c");
            this.maquina.getPedido().setText("Café Capuccino");
            this.fsm.siguiente();
        }
        if(this.maquina.getJbtAceptar() == e.getSource()){
            this.fsm.siguiente();
        }
    }
    
    public void activarProductos(){
        
        if(cliente.precioCafeNegro()<= cliente.getIngresado()){
            this.maquina.getTgbNegro().setEnabled(true);
        }
        if(cliente.precioCafeCapuccino()<= cliente.getIngresado()){
            this.maquina.getTgbCapuccino().setEnabled(true);
        }
        if(cliente.precioCafeDescafeinado()<= cliente.getIngresado()){
            this.maquina.getTgbDescafeinado().setEnabled(true);
        }

    }
    
}
