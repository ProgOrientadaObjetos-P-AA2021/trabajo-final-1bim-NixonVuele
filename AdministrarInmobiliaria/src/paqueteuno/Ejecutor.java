/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;

import java.util.Scanner;
import paqueteseis.*;
import paquetedos.*;
import paquetetres.*;
import paquetecuatro.*;
import paquetecinco.*;
import java.util.ArrayList;

/**
 *
 * @author reroes
 */
public class Ejecutor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salida = true;
        int opcionIngreso;
        int ingresarMostrar;
        do {
            System.out.println("==============Administración Inmobiliaria====="
                    + "======");
            System.out.printf("Eliga la opcion que desea:"
                    + "\n1.Ingresar registros\n2.Mostrar registros\n3.Salir"
                    + "\n> ");
            ingresarMostrar = sc.nextInt();
            if (ingresarMostrar == 1) {
                System.out.println("Seleccione la opcion que desea:");
                System.out.printf("1.Si desea ingresar un propietario\n"
                        + "2.Si desea ingresar una ubicacion\n"
                        + "3.Si desea ingresar una ciudad\n"
                        + "4.Si desea ingresar una constructora\n"
                        + "5.Si desea ingresar una casa\n"
                        + "6.Si desea ingresar un departamento\n> ");
                sc.nextLine();
                opcionIngreso = sc.nextInt();
                switch (opcionIngreso) {
                    case 1:
                        ingresoPropietarios();

                        break;
                    case 2:
                        ingresoUbicaciones();
                        break;
                    case 3:
                        ingresoCiudades();
                        break;
                    case 4:
                        ingresoConstructoras();
                        break;
                    case 5:
                        System.out.println("Antes de ingresar una casa es "
                                + "necesario que verifique si constan sus\n"
                                + "datos en el sistema, caso contrario su "
                                + "solicitud sera invalidada");
                        sc.nextLine();
                        System.out.println("Ingrese la identificacion del "
                                + "Propietario:");
                        String idPropi = sc.nextLine();
                        System.out.println("Ingrese el numero de casa:");
                        int numCasa = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Ingrese el nombre de la ciudad:");
                        String nombreCiudad = sc.nextLine();
                        System.out.println("Ingres ID de la empresa de la "
                                + "constructora:");
                        String constructoraID = sc.nextLine();
                        //Verificacion principal es para que verifique si sus 
                        //datos estan ingresados en el sistema, caso contrario 
                        //el programa hara que ingrese la informacion faltante
                        verificacionPrincipal(idPropi, numCasa, nombreCiudad,
                                constructoraID);
                        ingresoCasas(idPropi, numCasa, nombreCiudad,
                                constructoraID);
                        break;
                    case 6:
                        System.out.println("Antes de ingresar un departamento "
                                + "es necesario que verifique si constan sus\n"
                                + "datos en el sistema, caso contrario su "
                                + "solicitud sera invalidada");
                        sc.nextLine();
                        System.out.println("Ingrese la identificacion del "
                                + "Propietario:");
                        String idPropiDepa = sc.nextLine();
                        System.out.println("Ingrese el numero del "
                                + "Departamento:");
                        int numDepa = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Ingrese el nombre de la ciudad:");
                        String nombreCiudadDepa = sc.nextLine();
                        System.out.println("Ingres el ID de la empresa "
                                + "constructora:");
                        String idCostructoraDepa = sc.nextLine();
                        //Verificacion principal es para que verifique si sus 
                        //datos estan ingresados en el sistema, caso contrario 
                        //el programa hara que ingrese la informacion faltante
                        verificacionPrincipal(idPropiDepa, numDepa,
                                nombreCiudadDepa, idCostructoraDepa);
                        ingresoDepartamento(idPropiDepa, numDepa,
                                nombreCiudadDepa, idCostructoraDepa);
                        break;
                    default:
                        System.err.println("Eligio una opcion fuera del "
                                + "rango(1-6)");
                }
            } else {
                if (ingresarMostrar == 2) {
                    System.out.println("Que lista desea mostrar:");
                    System.out.printf("1.Mostrar lista de propietarios\n"
                            + "2.Mostrar lista de ubicaciones\n"
                            + "3.Mostrar lista de una ciudades\n"
                            + "4.Mostrar lista de una constructoras\n"
                            + "5.Mostrar lista de una casas\n"
                            + "6.Mostrar lista de un departamentos\n> ");
                    opcionIngreso = sc.nextInt();
                    switch (opcionIngreso) {
                        case 1:
                            mostrarPropietarios();
                            break;
                        case 2:
                            mostrarUbicaciones();
                            break;
                        case 3:
                            mostrarCiudades();
                            break;
                        case 4:
                            mostrarConstructoras();
                            break;
                        case 5:
                            mostrarCasas();
                            break;
                        case 6:
                            mostrarDepartamentos();
                            break;
                        default:
                            System.err.println("Eligio una opcion fuera del "
                                    + "rango(1-6)");
                    }
                }
                if (ingresarMostrar == 3) {
                    salida = false;
                    System.out.println("\u001B[34mGracias por registrarce en "
                            + "nuestra inmobiliaria");
                }
                if (ingresarMostrar != 1 && ingresarMostrar != 2
                        && ingresarMostrar != 3) {
                    System.err.println("Eligio una opcion fuera del "
                            + "rango(1-3)");

                }
            }
        } while (salida);
    }

    //Ingreso los datos del propietario
    public static void ingresoPropietarios() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese sus nombres:");
        String nombres = sc.nextLine();
        System.out.println("Ingrese sus apellidos: ");
        String apellidos = sc.nextLine();
        System.out.println("Ingrese su identificacion");
        String id = sc.nextLine();
        Propietario propi = new Propietario(nombres, apellidos, id);
        //Se escribe el archivo en un archivo propietario.txt
        EscrituraArchivoPropietario archivoPropi
                = new EscrituraArchivoPropietario("propietario.txt");
        //Le envio un objeto propietario para el registro
        archivoPropi.establecerRegistro(propi);
        archivoPropi.establecerSalida();
        //Cierro el archivo
        archivoPropi.cerrarArchivo();
    }

    //Ingreso Ubicaciones:
    public static void ingresoUbicaciones() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre de su barrio:");
        String nombreBarrio = sc.nextLine();
        System.out.println("Ingrese una referencia de su ubicacion ");
        String refencia = sc.nextLine();
        System.out.println("Ingrese el numero de la casa");
        int numCasa = sc.nextInt();
        Ubicacion ubi = new Ubicacion(numCasa, nombreBarrio, refencia);
        //Se escribe el archivo en un archivo ubicacion.txt
        EscrituraArchivoUbicacion archivoUbi
                = new EscrituraArchivoUbicacion("ubicacion.txt");
        archivoUbi.establecerRegistro(ubi);
        archivoUbi.establecerSalida();
        //Cierro el archivo
        archivoUbi.cerrarArchivo();
    }

    //Ingreso ciudades:
    public static void ingresoCiudades() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre de su ciudad:");
        String ciudad = sc.nextLine();
        System.out.println("Ingrese el nombre de su provincia");
        String provincia = sc.nextLine();
        Ciudad city = new Ciudad(ciudad, provincia);
        //Se escribe el archivo en un archivo ciudad.txt
        EscrituraArchivoCiudad archivoCiu
                = new EscrituraArchivoCiudad("ciudad.txt");
        archivoCiu.establecerRegistro(city);
        archivoCiu.establecerSalida();
        //Cierro el archivo
        archivoCiu.cerrarArchivo();
    }

    public static void ingresoConstructoras() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la contructora:");
        String nombreConstructora = sc.nextLine();
        System.out.println("Ingrese el id Empresarial ");
        String idEmpresa = sc.nextLine();
        Constructora constructora
                = new Constructora(nombreConstructora, idEmpresa);
        //Se escribe el archivo en un archivo constructora.txt
        EscrituraArchivoConstructora archivoCons
                = new EscrituraArchivoConstructora("constructora.txt");
        archivoCons.establecerRegistro(constructora);
        archivoCons.establecerSalida();
        //Cierro el archivo
        archivoCons.cerrarArchivo();
    }

    public static void ingresoCasas(String idPropi, int numCasa,
            String nameCiudad, String constructoraID) {
        Scanner sc = new Scanner(System.in);
        //Declaro Araylists de objetos para guardar los objetos
        //que se recuperaran del archivo txt
        ArrayList<Propietario> propietarios;
        ArrayList<Ubicacion> ubicaciones;
        ArrayList<Ciudad> citys;
        ArrayList<Constructora> constructoras;
        //Ingresa los datos de algunos atributos que contiene casa
        System.out.println("Ingrese el precio por metro Cuadrado");
        double precioMetroCuadrado = sc.nextDouble();
        System.out.println("Ingrese el numero de metros cuadrados de la casa:");
        int numMetroCuadrado = sc.nextInt();
        System.out.println("Ingrese el numero de cuartos de la casa:");
        int numeroCuartos = sc.nextInt();
        //Lee el archivo de propietario.txt
        LecturaArchivoPropietario lecturPropietarios
                = new LecturaArchivoPropietario("propietario.txt");
        lecturPropietarios.establecerListaPropietarios();
        //recupera los objetos de propietarios.txt y los guarda en un arraylist
        //llamado propietarios:
        propietarios = lecturPropietarios.obtenerListaPropietarios();
        String nombrePropi = "";
        String apellidoPropi = "";
        //Se recorre el arraylist de objetos buscando si un atributo de
        //propietario Identificacion es igual al id que ingreso el usuario:
        for (int i = 0; i < propietarios.size(); i++) {
            if (propietarios.get(i).getIdentificacion().equals(idPropi)) {
                nombrePropi = propietarios.get(i).getNombres();
                apellidoPropi = propietarios.get(i).getApellidos();
            }
        }
        Propietario objPropi = new Propietario(nombrePropi, apellidoPropi,
                idPropi);
        //Ubicacion
        //Lee el archivo de ubicacion.txt
        LecturaArchivoUbicacion lecturaUbicacion
                = new LecturaArchivoUbicacion("ubicacion.txt");
        lecturaUbicacion.establecerListaUbicacion();
        //recupera los objetos de ubicacion.txt y los guarda en un arraylist
        //llamado ubicaciones:
        ubicaciones = lecturaUbicacion.obtenerListaUbicacion();
        String nombreBarri = "";
        String referens = "";
        for (int i = 0; i < ubicaciones.size(); i++) {
            int numC = ubicaciones.get(i).getNumCasa();
            if (numC == numCasa) {
                nombreBarri = ubicaciones.get(i).getNombreBarrio();
                referens = ubicaciones.get(i).getReferencia();
            }
        }
        Ubicacion objUbicacion = new Ubicacion(numCasa, nombreBarri, referens);
        //Ciudad
        //Lee el archivo de ciudad.txt
        LecturaArchivoCiudad lecturaCity
                = new LecturaArchivoCiudad("ciudad.txt");
        lecturaCity.establecerListaCiudad();
        //recupera los objetos de ciudad.txt y los guarda en un arraylist
        //llamado citys:
        citys = lecturaCity.obtenerListaCiudad();
        String nombreProvincia = "";
        for (int i = 0; i < lecturaCity.obtenerListaCiudad().size(); i++) {
            if ((citys.get(i).getNombreCity().toLowerCase()).equals(nameCiudad.toLowerCase())) {
                nombreProvincia = citys.get(i).getNombreCity();
            }
        }
        Ciudad objCity = new Ciudad(nameCiudad, nombreProvincia);
        //Constructoras
        //Lee el archivo de constructora.txt
        LecturaArchivoConstructora lectruaConstructora
                = new LecturaArchivoConstructora("constructora.txt");
        lectruaConstructora.establecerListaConstructora();
        //recupera los objetos de constructora.txt y los guarda en un arraylist
        //llamado constructoras:
        constructoras = lectruaConstructora.obtenerListaConstructora();
        String nombreConstructora = "";
        for (int i = 0; i < lectruaConstructora.obtenerListaConstructora().
                size(); i++) {
            if (constructoras.get(i).getIdEmpresarial().equals(constructoraID)) {
                nombreConstructora = constructoras.get(i).
                        getNombreConstructora();
            }
        }
        Constructora objContructora
                = new Constructora(nombreConstructora, constructoraID);
        //creo un objeto casa y le envio los parametros correspondientes
        Casa casa = new Casa(objPropi, precioMetroCuadrado, numMetroCuadrado,
                objUbicacion, objCity, numeroCuartos, objContructora);
        casa.setPrecioFinal();
        //Se escribe el archivo en un archivo casa.txt
        EscrituraArchivoCasa archivoCasa = new EscrituraArchivoCasa("casa.txt");
        archivoCasa.establecerRegistro(casa);
        archivoCasa.establecerSalida();
        archivoCasa.cerrarArchivo();
    }

    //Ingreso Departamentos
    public static void ingresoDepartamento(String idPropi, int numCasa,
            String nameCiudad, String constructoraID) {
        Scanner sc = new Scanner(System.in);
        //Declaro Araylists de objetos para guardar los objetos
        //que se recuperaran del archivo txt
        ArrayList<Propietario> propietarios;
        ArrayList<Ubicacion> ubicaciones;
        ArrayList<Ciudad> citys;
        ArrayList<Constructora> constructoras;
        //Ingresa los datos de algunos atributos que contiene casa
        System.out.println("Ingrese el precio por metro Cuadrado:");
        double precioMetroCuadrado = sc.nextDouble();
        System.out.println("Ingrese el numero de metros cuadrados del "
                + "departamento:");
        int numMetroCuadrado = sc.nextInt();
        System.out.println("Ingrese el valor de la cuota mensual:");
        double cuotaMensual = sc.nextDouble();
        sc.nextLine();
        System.out.println("Ingrese el nombre del edificio:");
        String nameEdificio = sc.nextLine();
        System.out.println("Ingrese la dirección del edificio:");
        String ubicacionEdi = sc.nextLine();
        //Propietarios
        //Lee el archivo de propietario.txt
        LecturaArchivoPropietario lecturPropietarios
                = new LecturaArchivoPropietario("propietario.txt");
        lecturPropietarios.establecerListaPropietarios();
        propietarios = lecturPropietarios.obtenerListaPropietarios();
        String nombrePropi = "";
        String apellidoPropi = "";
        for (int i = 0; i < propietarios.size(); i++) {
            if (propietarios.get(i).getIdentificacion().equals(idPropi)) {
                nombrePropi = propietarios.get(i).getNombres();
                apellidoPropi = propietarios.get(i).getApellidos();
            }
        }
        Propietario objPropi = new Propietario(nombrePropi, apellidoPropi,
                idPropi);
        //Ubicacion
        //Lee el archivo de ubicacion.txt
        LecturaArchivoUbicacion lecturaUbicacion
                = new LecturaArchivoUbicacion("ubicacion.txt");
        lecturaUbicacion.establecerListaUbicacion();
        ubicaciones = lecturaUbicacion.obtenerListaUbicacion();
        String nombreBarri = "";
        String referens = "";
        for (int i = 0; i < ubicaciones.size(); i++) {
            int numC = ubicaciones.get(i).getNumCasa();
            if (numC == numCasa) {
                nombreBarri = ubicaciones.get(i).getNombreBarrio();
                referens = ubicaciones.get(i).getReferencia();
            }
        }
        Ubicacion objUbicacion = new Ubicacion(numCasa, nombreBarri, referens);
        //Ciudad
        //Lee el archivo de ciudad.txt
        LecturaArchivoCiudad lecturaCity
                = new LecturaArchivoCiudad("ciudad.txt");
        lecturaCity.establecerListaCiudad();
        citys = lecturaCity.obtenerListaCiudad();
        String nombreProvincia = "";
        for (int i = 0; i < lecturaCity.obtenerListaCiudad().size(); i++) {
            if (citys.get(i).getNombreCity().equals(nameCiudad)) {
                nombreProvincia = citys.get(i).getNombreCity();
            }
        }
        Ciudad objCity = new Ciudad(nameCiudad, nombreProvincia);
        //Constructoras
        //Lee el archivo de constructora.txt
        LecturaArchivoConstructora lectruaConstructora
                = new LecturaArchivoConstructora("constructora.txt");
        lectruaConstructora.establecerListaConstructora();
        constructoras = lectruaConstructora.obtenerListaConstructora();
        String nombreConstructora = "";
        for (int i = 0; i < lectruaConstructora.obtenerListaConstructora().
                size(); i++) {
            if (constructoras.get(i).getIdEmpresarial().equals(constructoraID)) {
                nombreConstructora = constructoras.get(i).
                        getNombreConstructora();
            }
        }
        Constructora objContructora = new Constructora(nombreConstructora,
                constructoraID);
        //Departamento
        Departamento depa = new Departamento(objPropi, precioMetroCuadrado,
                numMetroCuadrado, cuotaMensual, objUbicacion, objCity,
                nameEdificio, ubicacionEdi, objContructora);
        depa.setPrecio();
        depa.setCostoFinal();
        EscrituraArchivoDepartamento archivoDepa
                = new EscrituraArchivoDepartamento("departamento.txt");
        archivoDepa.establecerRegistroDepartamento(depa);
        archivoDepa.establecerSalida();
        archivoDepa.cerrarArchivo();
    }

    public static void mostrarPropietarios() {
        LecturaArchivoPropietario lecturaCasas
                = new LecturaArchivoPropietario("propietario.txt");
        lecturaCasas.establecerListaPropietarios();
        System.out.println(lecturaCasas);
    }

    public static void mostrarUbicaciones() {
        LecturaArchivoUbicacion lecturaUbicacion
                = new LecturaArchivoUbicacion("ubicacion.txt");
        lecturaUbicacion.establecerListaUbicacion();
        System.out.println(lecturaUbicacion);
    }

    public static void mostrarCiudades() {
        LecturaArchivoCiudad lecturaCity
                = new LecturaArchivoCiudad("ciudad.txt");
        lecturaCity.establecerListaCiudad();
        System.out.println(lecturaCity);
    }

    public static void mostrarConstructoras() {
        LecturaArchivoConstructora lecturaConstructora
                = new LecturaArchivoConstructora("constructora.txt");
        lecturaConstructora.establecerListaConstructora();
        System.out.println(lecturaConstructora);
    }

    public static void mostrarCasas() {
        LecturaArchivoCasa lecturaCasa
                = new LecturaArchivoCasa("casa.txt");
        lecturaCasa.establecerListaCasas();
        System.out.println(lecturaCasa);
    }

    public static void mostrarDepartamentos() {
        LecturaArchivoDepartamento lecturaDepartamento
                = new LecturaArchivoDepartamento("departamento.txt");
        lecturaDepartamento.establecerDepartamentos();
        System.out.println(lecturaDepartamento);
    }

    //En verificacion Principal se reciben los valores que son necesarios para 
    //comprar si constan en el sistema, caso contrario se tendrian que registrar
    public static void verificacionPrincipal(String idPropi, int numCas,
            String nameCiu, String constructoraID) {

        Scanner sc = new Scanner(System.in);
        //En caso de que cualquier verificacion retorne un valor de 0, significa
        //que no esta registrado en el sisteme, por ende el programa llama al 
        //metodo ingreso, con el objetivo que se registren en el sistema
        System.out.println("===========Verificacion de Propietario===========");
        if (verificacionPropietarios(idPropi) == 0) {
            ingresoPropietarios();
        }
        System.out.println("===========Verificacion de Ubicacion===========");
        if (verificacionUbicacion(numCas) == 0) {
            ingresoUbicaciones();
        }//level in the paper
        sc.nextLine();
        System.out.println("===========Verificacion de Ciudad===========");
        if (verificacionCiudad(nameCiu) == 0) {
            ingresoCiudades();
        }
        System.out.println("===========Verificacion de Constructota==========");
        if (verificacionConstructora(constructoraID) == 0) {
            ingresoConstructoras();
        }
    }

    public static int verificacionPropietarios(String idPropi) {
        String mensaje = "El propietario no consta en nuestro sistema";
        int ingreso = 0;
        ArrayList<Propietario> propietarios;
        LecturaArchivoPropietario lecturPropietarios
                = new LecturaArchivoPropietario("propietario.txt");
        lecturPropietarios.establecerListaPropietarios();
        propietarios = lecturPropietarios.obtenerListaPropietarios();
        for (int i = 0; i < propietarios.size(); i++) {
            if (propietarios.get(i).getIdentificacion().equals(idPropi)) {
                mensaje = "El propietario si consta en nuestro sistema";
                ingreso = 1;
            }
        }
        System.out.println(mensaje);
        return ingreso;
    }

    public static int verificacionUbicacion(int numCasa) {
        String mensaje = "Su ubicacion no consta en nuestro sistema";
        ArrayList<Ubicacion> ubicaciones;
        int ingreso = 0;
        LecturaArchivoUbicacion lecturaUbicacion
                = new LecturaArchivoUbicacion("ubicacion.txt");
        lecturaUbicacion.establecerListaUbicacion();
        ubicaciones = lecturaUbicacion.obtenerListaUbicacion();
        for (int i = 0; i < ubicaciones.size(); i++) {
            int numC = ubicaciones.get(i).getNumCasa();
            if (numC == numCasa) {
                mensaje = "Su ubicacion si consta en nuestro sistema";
                ingreso = 1;
            }
        }
        System.out.println(mensaje);
        return ingreso;
    }

    public static int verificacionCiudad(String nombreCiudad) {
        String mensaje = "Su ciudad no consta en nuestro sistema";
        ArrayList<Ciudad> citys;
        int ingreso = 0;
        LecturaArchivoCiudad lecturaCity
                = new LecturaArchivoCiudad("ciudad.txt");
        lecturaCity.establecerListaCiudad();
        citys = lecturaCity.obtenerListaCiudad();
        for (int i = 0; i < lecturaCity.obtenerListaCiudad().size(); i++) {
            if ((citys.get(i).getNombreCity().toLowerCase()).equals(nombreCiudad.toLowerCase())) {
                mensaje = "Su ciudad si consta en nuestro sistema";
                ingreso = 1;
            }
        }
        System.out.println(mensaje);
        return ingreso;
    }

    public static int verificacionConstructora(String constructoraID) {
        String mensaje = "Su constructora no consta en nuestro sistema";
        ArrayList<Constructora> constructoras;
        int ingreso = 0;
        LecturaArchivoConstructora lectruaConstructora
                = new LecturaArchivoConstructora("constructora.txt");
        lectruaConstructora.establecerListaConstructora();
        constructoras = lectruaConstructora.obtenerListaConstructora();
        for (int i = 0; i < lectruaConstructora.obtenerListaConstructora().
                size(); i++) {
            if (constructoras.get(i).getIdEmpresarial().equals(constructoraID)) {
                mensaje = "Su constructora si consta en nuestro sistema";
                ingreso = 1;
            }
        }
        System.out.println(mensaje);
        return ingreso;
    }
}
