/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paqueteseis.Casa;
/**
 *
 * @author nixon
 */
public class LecturaArchivoSecuencial {

    private ObjectInputStream entrada;
    private ArrayList<Casa> listaCasas;
    private String nombreArchivo;

    public LecturaArchivoSecuencial(String n) {
        nombreArchivo = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try // abre el archivo
            {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } // fin de try
            catch (IOException ioException) {
                System.err.println("Error al abrir el archivo.");

            } // fin de catch
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaCasas() {
        // 
        listaCasas = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Casa registro = (Casa) entrada.readObject();
                    listaCasas.add(registro);
                } catch (EOFException endOfFileException) {
                    return; // se llegó al fin del archivo

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    // System.err.println("No hay datos en el archivo: " + ex);
                    break;
                }
            }
        }

    }

    public ArrayList<Casa> obtenerListaCasas() {

        return listaCasas;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "Lista de Hospitales:\n";

        for (int i = 0; i < obtenerListaCasas().size(); i++) {
            cadena = String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n", cadena,
                    i + 1,
                    obtenerListaCasas().get(i).getPropietario(),
                    obtenerListaCasas().get(i).getPrecioMetroCuadrado(),
                    obtenerListaCasas().get(i).getNumMetroCuadrado(),
                    obtenerListaCasas().get(i).getNumMetroCuadrado(),
                    obtenerListaCasas().get(i).getPrecioFinal(),
                    obtenerListaCasas().get(i).getUbicacion().getNombreBarrio(),
                    obtenerListaCasas().get(i).getUbicacion().getReferencia(),
                    obtenerListaCasas().get(i).getCiudad().getNombreCity(),
                    obtenerListaCasas().get(i).getCiudad().getNombreProvincia(),
                    obtenerListaCasas().get(i).getNumCuartos(),
                    obtenerListaCasas().get(i).getConstructora().getNombreConstructora(),
                    obtenerListaCasas().get(i).getConstructora().getIdEmpresarial());
                    
        }

        return cadena;
    }
    public void cerrarArchivo() {
        try // cierra el archivo y sale
        {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        } // fin de catch
    }

}
