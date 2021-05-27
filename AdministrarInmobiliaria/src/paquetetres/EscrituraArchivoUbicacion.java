/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetetres;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author nixon
 */
public class EscrituraArchivoUbicacion {
    
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Ubicacion registro;
    private ArrayList<Ubicacion> listaUbicacion;

    public EscrituraArchivoUbicacion(String n) {
        nombreArchivo = n;
        establecerListaUbicacion();
        // sacar la información del archivo, previo a volver 
        // a trabajar con el mimso.
        try // abre el archivo
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            // proceso para ingresar nuevamente los valores del archivo
            if (obtenerListaUbicacion().size() > 0) {
                for (int i = 0; i < obtenerListaUbicacion().size(); i++) {
                    establecerRegistro(obtenerListaUbicacion().get(i));
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

    public void establecerRegistro(Ubicacion n) {
        registro = n;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registro); // envía el registro como salida
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerListaUbicacion() {
        LecturaArchivoUbicacion l = new LecturaArchivoUbicacion(
                obtenerNombreArchivo());
        l.establecerListaUbicacion();
        listaUbicacion = l.obtenerListaUbicacion();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Ubicacion> obtenerListaUbicacion() {
        return listaUbicacion;
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
