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
public class CafeteriaFSM {
    private static  EstadosCafeteria estadoActual = new EstSeleccionProductos();
    static  Cafeteria device;

    public CafeteriaFSM(Cafeteria cafeteria) {
        device = cafeteria;
        device.seleccionProductos();
    }

    public static EstadosCafeteria getEstado() {
        return estadoActual;
    }

    public static Cafeteria getDevice() {
        return device;
    }

    public void setEstadoActual(EstadosCafeteria estado) {
        estadoActual = estado;
    }

    public void siguiente() {
        estadoActual.siguiente(this);
    }
    
    public void error() {
        estadoActual.error(this);
    }

}
