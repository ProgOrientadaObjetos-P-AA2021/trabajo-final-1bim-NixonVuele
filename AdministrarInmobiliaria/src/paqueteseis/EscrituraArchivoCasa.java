/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteseis;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author nixon
 */
public class EscrituraArchivoCasa {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Casa registro;
    private ArrayList<Casa> listaCasas;

    public EscrituraArchivoCasa(String n) {
        nombreArchivo = n;
        establecerListaCasa();
        // sacar la información del archivo, previo a volver 
        // a trabajar con el mimso.
        try // abre el archivo
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            // proceso para ingresar nuevamente los valores del archivo
            if (obtenerListaCasa().size() > 0) {
                for (int i = 0; i < obtenerListaCasa().size(); i++) {
                    establecerRegistro(obtenerListaCasa().get(i));
                    establecerSalida();
                }
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        } // fin de catch
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerRegistro(Casa n) {
        registro = n;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registro); // envía el registro como salida
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerListaCasa() {
        LecturaArchivoCasa l = new LecturaArchivoCasa(
                obtenerNombreArchivo());
        l.establecerListaCasas();
        listaCasas = l.obtenerListaCasas();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Casa> obtenerListaCasa() {
        return listaCasas;
    }

    // agrega registros al archivo
    public ObjectOutputStream obtenerSalida() {
        return salida;
    }

    public void cerrarArchivo() {
        try // cierra el archivo
        {
            if (salida != null) {
                salida.close();
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");

        } // fin de catch
    }

}
