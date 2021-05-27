/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;

import java.util.Scanner;
import paqueteseis.Casa;
import paqueteseis.Departamento;
import paquetedos.*;
import paquetetres.*;
import paquetecuatro.*;
import paquetecinco.Constructora;

/**
 *
 * @author reroes
 */
public class Ejecutor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salida = true;
        int ingresarMostrar;
        do {
            System.out.println("==============Administración Inmobiliaria===========");
            System.out.println("Eliga la opcion que desea:"
                    + "\n1.Ingresar registros\n2.Mostrar registros");
            ingresarMostrar = sc.nextInt();
            if (ingresarMostrar == 1) {
                sc.nextLine();
                System.out.println("1.Ingrese propietario:");
                ingresoPropietarios();
                System.out.println("2.Ingrese ubicaciones");
                ingresoUbicaciones();
                System.out.println("3.Ingrese ciudades");
                ingresoCiudades();
                System.out.println("4.Ingrese constructoras");
                System.out.println("5.Ingrese casas");
                System.out.println("6.Ingrese departamentos");
            }
            if (ingresarMostrar == 2) {
                System.out.println("Que lista desea ver:");

            } else {
                System.out.println("Ingreso que lista desea mostrar:");
                LecturaArchivoCiudad lecturaCity = new LecturaArchivoCiudad("ciudad.txt");
                lecturaCity.establecerListaCiudad();
                System.out.println(lecturaCity);
            }
        } while (salida);

    }

    public static void ingresoPropietarios() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese sus nombres:");
        String nombres = sc.nextLine();
        System.out.println("Ingrese sus apellidos: ");
        String apellidos = sc.nextLine();
        System.out.println("Inagrese su identificacion");
        String id = sc.nextLine();
        Propietario propi = new Propietario(nombres, apellidos, id);
        EscrituraArchivoPropietario archivoPropi = new EscrituraArchivoPropietario("propietraio.txt");
        archivoPropi.establecerRegistro(propi);
        archivoPropi.establecerSalida();

        LecturaArchivoPropietario lecturaCasas = new LecturaArchivoPropietario("propietraio.txt");
        lecturaCasas.establecerListaPropietarios();
        System.out.println(lecturaCasas);
    }

    public static void ingresoUbicaciones() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre de su barrio:");
        String nombreBarrio = sc.nextLine();
        System.out.println("Ingrese una referencia de su ubicacion ");
        String refencia = sc.nextLine();
        Ubicacion ubi = new Ubicacion(nombreBarrio, refencia);
        EscrituraArchivoUbicacion archivoUbi = new EscrituraArchivoUbicacion("ubicacion.txt");
        archivoUbi.establecerRegistro(ubi);
        archivoUbi.establecerSalida();
        LecturaArchivoUbicacion lecturaUbicacion = new LecturaArchivoUbicacion("ubicacion.txt");
        lecturaUbicacion.establecerListaUbicacion();
        System.out.println(lecturaUbicacion);
    }

    public static void ingresoCiudades() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre de su ciudad:");
        String ciudad = sc.nextLine();
        System.out.println("Ingrese el nombre de su provincia");
        String provincia = sc.nextLine();
        Ciudad city = new Ciudad(ciudad, provincia);
        EscrituraArchivoCiudad archivoCiu = new EscrituraArchivoCiudad("ciudad.txt");
        archivoCiu.establecerRegistro(city);
        archivoCiu.establecerSalida();

    }
}
