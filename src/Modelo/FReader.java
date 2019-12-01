package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author Ita
 */
public class FReader {
    
    
    public void crearArchivo(String nombre) throws IOException {
        File archivo = new File(this.getAbsolutPath() + "\\src\\" + nombre + ".txt");
        if (!archivo.exists()) {
            archivo.createNewFile();
        }
    }
    
    public String getAbsolutPath(){
        return System.getProperty("user.dir");
    }
    
    public void escribirArchivo(String cadena ,String nombre) throws IOException{
        FileWriter file = new FileWriter(this.getAbsolutPath() + "\\src\\" + nombre + ".txt",true);
        PrintWriter pw = new PrintWriter(file);
        pw.write(cadena);
        pw.close();
    }
}