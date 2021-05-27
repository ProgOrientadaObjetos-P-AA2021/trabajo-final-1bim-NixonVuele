/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaquetePrueba;

import paqueteseis.Casa;
import paqueteseis.Departamento;
import paquetedos.Propietario;
import paquetetres.Ubicacion;
import paquetecuatro.Ciudad;
import paquetecinco.Constructora;
import paqueteuno.EscrituraArchivoSecuencial;
import paqueteuno.LecturaArchivoSecuencial;
/**
 *
 * @author nixon
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String nombreArchivo = "propietario.txt";
        
        nombreArchivo = "casas.txt";
        Propietario p1 = new Propietario("Nixon Javier", "Vuele Irene", "324234234");
        Ubicacion u1 = new Ubicacion("La florida", "Frente al banco de Loja");
        Ciudad ciud1 = new Ciudad("Loja", "Loja");
        Constructora construccion = new Constructora("Constructora1", "Ide empresarial");
        Casa c1 = new Casa(p1, 10.00, 20, 30, u1, ciud1, 40, construccion);
        Casa c2 = new Casa(p1, 10.00, 20, 30, u1, ciud1, 40, construccion);
        Casa[] lista = {c1, c2};

        EscrituraArchivoSecuencial archivo = new EscrituraArchivoSecuencial(
                nombreArchivo);

        for (int i = 0; i < lista.length; i++) {
            // establecer el valor del atributo registro
            archivo.establecerRegistro(lista[i]);
            // establecer en el archivo el atributo del registro
            archivo.establecerSalida();
        }
        archivo.cerrarArchivo();
        LecturaArchivoSecuencial lectura = new LecturaArchivoSecuencial(
                nombreArchivo);
        lectura.establecerListaCasas();
        System.out.println(lectura);
    }
}
