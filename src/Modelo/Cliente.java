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
public class Cliente {
    private int cafeNegro = 35;
    private int cafeCapuccino = 45;
    private int cafeDescafeinado = 30;
    
    //Dinero dentro de la maquina
    private int monedaUno = 0;
    private int monedaCinco = 0;
    private int monedaDiez = 0;
    private int monedaVeinte = 0;
    private int monedaCincuenta = 0;
    
    //Dinero que ingreso el cliente
    private int uno = 0;
    private int cinco = 0;
    private int diez = 0;
    private int veinte = 0;
    private int cincuenta = 0;

    public Cliente() {
    }

    public void ingresarUno() {
       uno++;
    }

    public void ingresarCinco() {
       cinco++;
    }

    public void ingresarDiez() {
        diez++;
    }

    public void ingresarVeinte() {
        veinte++;
    }

    public void ingresarCincuenta() {
        cincuenta++;
    }
    
    public Integer getIngresado(){
        return uno + cinco*5 + diez*10 + veinte*20 + cincuenta*50;
    }

    public int precioCafeNegro() {
        return cafeNegro;
    }

    public int precioCafeCapuccino() {
        return cafeCapuccino;
    }

    public int precioCafeDescafeinado() {
        return cafeDescafeinado;
    }
    
    
}
