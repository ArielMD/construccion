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
public class ClienteCafe {
    private int cucharada = 5;
    
    private int cafeNegro = 35;
    private int cafeCapuccino = 45;
    private int cafeDescafeinado = 30;
    
    private int nivelCafe;
    private int nivelLeche;
    private int nivelAzucar;

    public ClienteCafe() {
        this.nivelCafe = 100;
        this.nivelLeche = 100;
        this.nivelAzucar = 100;
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

    public int getNivelCafe() {
        return nivelCafe;
    }

    public int getNivelLeche() {
        return nivelLeche;
    }

    public int getNivelAzucar() {
        return nivelAzucar;
    }

    public void cucharadaCafe() {
        nivelCafe -= cucharada*2;
    }

    public void cucharadaLeche() {
        nivelLeche -= cucharada;
    }

    public void cucharadaAzucar() {
        nivelAzucar -= cucharada;
    }

    public void rellenarIngredientes() {
        this.nivelCafe = 100;
        this.nivelLeche = 100;
        this.nivelAzucar = 100;
    }
}
