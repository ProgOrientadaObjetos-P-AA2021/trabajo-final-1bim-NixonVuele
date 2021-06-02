/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteseis;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.util.ArrayList;

/**
 *
 * @author nixon
 */
public class LecturaArchivoDepartamento {

    private ObjectInputStream entrada;
    private ArrayList<Departamento> departamentos;
    private String nombreArchivoDepartamentos;

    public LecturaArchivoDepartamento(String n) {
        nombreArchivoDepartamentos = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try // abre el archivo
            {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } // fin de try
            catch (IOException ioException) {
                System.err.println("Error al abrir el archivo." + ioException);
            } // fin de catch
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivoDepartamentos = n;
    }

    public void establecerDepartamentos() {
        departamentos = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            while (true) {
                try {
                    Departamento registro = (Departamento) entrada.readObject();
                    departamentos.add(registro);
                } catch (EOFException endOfFileException) {
                    return;
                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("No hay datos en el archivo: " + ex);

                }
            }
        }
    }

    public ArrayList<Departamento> obtenerDepartamentos() {
        return departamentos;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivoDepartamentos;
    }

    @Override
    public String toString() {
        String cadena = "Lista de Departamentos:\n";
        for (int i = 0; i < obtenerDepartamentos().size(); i++) {
            Departamento d = obtenerDepartamentos().get(i);
            cadena = String.format("%sDepartamento numero (%d):\n"
                    + "Informacion del Propietario:\n"
                    + "\t> Nombres: %s\n"
                    + "\t> Apellidos: %s\n"
                    + "\t> Identificación: %s\n"
                    + "Informacion de la ubicacion:\n"
                    + "\t> Barrio: %s\n"
                    + "\t> Referencia: %s\n"
                    + "\t> Numero de Departamento: %s\n"
                    + "Informacion de la Ciudad:\n"
                    + "\t> Ciudad: %s\n"
                    + "\t> Provincia: %s\n"
                    + "Información de la constructora:\n"
                    + "\t> Constructora: %s\n"
                    + "\t> Id de la empresa: %s\n"
                    + "Informacion de Edificio y costo:\n"
                    + "\t> Nombre de edificio: %s\n"
                    + "\t> Precio por metro cuadrado: %.2f$\n "
                    + "\t> Número de metros cuadrados: %.2fm\n"
                    + "\t> Valor cuota mensual: %.2f$\n  "
                    + "\t> Precio: %.2f$\n  "
                    + "\t> Costo Final: %.2f$\n\n",
                    cadena,
                    i + 1,
                    d.getPropietario().getNombres(),
                    d.getPropietario().getApellidos(),
                    d.getPropietario().getIdentificacion(),//
                    d.getUbicacion().getNombreBarrio(),
                    d.getUbicacion().getReferencia(),
                    d.getUbicacion().getNumCasa(),//
                    d.getCiudad().getNombreCity(),
                    d.getCiudad().getNombreProvincia(),
                    d.getConstructora().getNombreConstructora(),
                    d.getConstructora().getIdEmpresarial(),
                    d.getNombreEdificio(),
                    d.getPrecioMetroCuadrado(),
                    d.getNumMetroCuadrado(),
                    d.getCuotaMensual(),
                    d.getCostoFinal(),
                    d.getPrecio());
        }
        return cadena;
    }

    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        }
    }
}
