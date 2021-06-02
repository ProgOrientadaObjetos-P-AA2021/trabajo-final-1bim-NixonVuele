/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecinco;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author nixon
 */
public class EscrituraArchivoConstructora {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Constructora registro;
    private ArrayList<Constructora> listaConstructora;

    public EscrituraArchivoConstructora(String n) {
        nombreArchivo = n;
        establecerListaConstructora();
        // sacar la información del archivo, previo a volver 
        // a trabajar con el mimso.
        try // abre el archivo
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            // proceso para ingresar nuevamente los valores del archivo
            if (obtenerListaConstructora().size() > 0) {
                for (int i = 0; i < obtenerListaConstructora().size(); i++) {
                    establecerRegistro(obtenerListaConstructora().get(i));
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

    public void establecerRegistro(Constructora n) {
        registro = n;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registro); // envía el registro como salida
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerListaConstructora() {
        LecturaArchivoConstructora l = new LecturaArchivoConstructora(
                obtenerNombreArchivo());
        l.establecerListaConstructora();
        listaConstructora = l.obtenerListaConstructora();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Constructora> obtenerListaConstructora() {
        return listaConstructora;
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
