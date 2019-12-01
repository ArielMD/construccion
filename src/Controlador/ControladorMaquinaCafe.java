/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cafeteria;
import Modelo.CafeteriaFSM;
import Modelo.ClienteCafe;
import Modelo.FReader;
import Modelo.Monedero;
import Vista.MaquinaCafe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ariel May
 */
public class ControladorMaquinaCafe implements ActionListener{
    
    private MaquinaCafe maquina;
    private Monedero monedero;
    private CafeteriaFSM fsm;
    private ClienteCafe cliente;
    private FReader fReader;
    
    public ControladorMaquinaCafe(MaquinaCafe maquina) throws IOException {
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
        this.maquina.getLeche().addActionListener(this);
        this.maquina.getAzucar().addActionListener(this);
        this.maquina.getJbtNuevaCompra().addActionListener(this);
        this.maquina.getjbtRellenarIng().addActionListener(this);
        
        Cafeteria cafe = new Cafeteria(maquina);
        this.fsm = new CafeteriaFSM(cafe);
        this.monedero = new Monedero();
        this.cliente = new ClienteCafe();
        this.fReader = new FReader();
        this.llenarIngredientes();
        fReader.crearArchivo("Bitacora");
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.maquina.getJbtUno() == e.getSource()){
            monedero.ingresarUno();
            this.maquina.getDineroIngresado().setText(monedero.getIngresado().toString());
            activarProductos();
        }
        if(this.maquina.getJbtCinco() == e.getSource()){
            monedero.ingresarCinco();
            this.maquina.getDineroIngresado().setText(monedero.getIngresado().toString());
            activarProductos();
        }
        if(this.maquina.getJbtDiez() == e.getSource()){
            monedero.ingresarDiez();
            this.maquina.getDineroIngresado().setText(monedero.getIngresado().toString());
            activarProductos();
        }
        if(this.maquina.getJbtVeinte() == e.getSource()){
            monedero.ingresarVeinte();
            this.maquina.getDineroIngresado().setText(monedero.getIngresado().toString());
            activarProductos();
        }
        if(this.maquina.getJbtCincuenta() == e.getSource()){
            monedero.ingresarCincuenta();
            this.maquina.getDineroIngresado().setText(monedero.getIngresado().toString());
            activarProductos();
        }
        if (this.maquina.getLeche() == e.getSource()) {
            this.cliente.cucharadaLeche();
            this.maquina.getPbarLeche().setValue(this.cliente.getNivelLeche());
        }
        if (this.maquina.getAzucar() == e.getSource()) {
            this.cliente.cucharadaAzucar();
            this.maquina.getPbarAzucar().setValue(this.cliente.getNivelAzucar());
        }
        if (this.maquina.getTgbNegro() == e.getSource()) {
            this.maquina.getPedido().setText("Café Negro");
            this.maquina.getPrecio().setText(String.valueOf(cliente.precioCafeNegro()));
            this.cliente.cucharadaCafe();
            this.maquina.getPbarCafe().setValue(this.cliente.getNivelCafe());
            this.fsm.siguiente();
        }
        if(this.maquina.getTgbDescafeinado() == e.getSource()){
            this.maquina.getPedido().setText("Café Descafeinado");
            this.maquina.getPrecio().setText(String.valueOf(cliente.precioCafeDescafeinado()));
            this.cliente.cucharadaCafe();
            this.maquina.getPbarCafe().setValue(this.cliente.getNivelCafe());
            this.fsm.siguiente();
        }
        if(this.maquina.getTgbCapuccino() == e.getSource()){
            this.maquina.getPedido().setText("Café Capuccino");
            this.maquina.getPrecio().setText(String.valueOf(cliente.precioCafeCapuccino()));
            this.cliente.cucharadaCafe();
            this.maquina.getPbarCafe().setValue(this.cliente.getNivelCafe());
            this.fsm.siguiente();
        } 
        if (this.maquina.getJbtNuevaCompra() == e.getSource()) {
            boolean conIngredientes = this.cliente.getNivelAzucar() > 0
                    && this.cliente.getNivelCafe() > 0
                    && this.cliente.getNivelLeche() > 0;
            if (conIngredientes) {
                this.fsm.siguiente();
            } else {
                this.fsm.error();
            }
        }
        if (this.maquina.getjbtRellenarIng() == e.getSource()) {
            this.cliente.rellenarIngredientes();
            this.llenarIngredientes();
            this.fsm.siguiente();
        }

        if (this.maquina.getJbtAceptar() == e.getSource()) {

            try {

                this.fsm.siguiente();
                TimeUnit.SECONDS.sleep(3);

                this.fsm.siguiente();
                String bitacora = new Date().toString()+" "+
                                  this.maquina.getPedido().getText()+" $"+
                                  this.maquina.getPrecio().getText()+"\n";
                this.fReader.escribirArchivo(bitacora, "Bitacora");

                JOptionPane.showMessageDialog(null, "Gracias por su compra");
                 //Aqui va los metodos para dar cambio y agregar el dinero al monedero.
                this.monedero.iniciarDineroIngresado();
                this.maquina.getDineroIngresado().setText(monedero.getIngresado().toString());
                this.maquina.getPrecio().setText("0");
            } catch (IOException ex) {
                Logger.getLogger(ControladorMaquinaCafe.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControladorMaquinaCafe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void activarProductos(){
        
        if(cliente.precioCafeNegro()<= monedero.getIngresado()){
            this.maquina.getTgbNegro().setEnabled(true);
        }
        if(cliente.precioCafeCapuccino()<= monedero.getIngresado()){
            this.maquina.getTgbCapuccino().setEnabled(true);
        }
        if(cliente.precioCafeDescafeinado()<= monedero.getIngresado()){
            this.maquina.getTgbDescafeinado().setEnabled(true);
        }

    }
    
    public void llenarIngredientes(){
        this.maquina.getPbarCafe().setValue(100);
        this.maquina.getPbarAzucar().setValue(100);
        this.maquina.getPbarLeche().setValue(100);
    }
    
}
