/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteseis;

import java.io.Serializable;
import paquetedos.Propietario;
import paquetetres.Ubicacion;
import paquetecuatro.Ciudad;
import paquetecinco.Constructora;

/**
 *
 * @author reroes
 */
public class Casa implements Serializable {

    private Propietario propietario;
    private double precioMetroCuadrado;
    private double numMetroCuadrado;
    private double precioFinal;
    private Ubicacion ubicacion;
    private Ciudad ciudad;
    private int numCuartos;
    private Constructora constructora;

    public Casa(Propietario propietario, double precioMetroCuadrado, double numMetroCuadrado, double precioFinal,
            Ubicacion ubicacion, Ciudad ciudad, int numCuartos, Constructora constructora) {
        this.propietario = propietario;
        this.precioMetroCuadrado = precioMetroCuadrado;
        this.numMetroCuadrado = numMetroCuadrado;
        this.precioFinal = precioFinal;
        this.ubicacion = ubicacion;
        this.ciudad = ciudad;
        this.constructora = constructora;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public void setPrecioMetroCuadrado(double precioMetroCuadrado) {
        this.precioMetroCuadrado = precioMetroCuadrado;
    }

    public void setNumMetroCuadrado(double numMetroCuadrado) {
        this.numMetroCuadrado = numMetroCuadrado;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public void setNumCuartos(int numCuartos) {
        this.numCuartos = numCuartos;
    }

    public void setConstructora(Constructora constructora) {
        this.constructora = constructora;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public double getPrecioMetroCuadrado() {
        return precioMetroCuadrado;
    }

    public double getNumMetroCuadrado() {
        return numMetroCuadrado;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public int getNumCuartos() {
        return numCuartos;
    }

    public Constructora getConstructora() {
        return constructora;
    }

    @Override
    public String toString() {
        return "Casa{" + "propietario=" + propietario + ", precioMetroCuadrado=" + precioMetroCuadrado + ", numMetroCuadrado=" + numMetroCuadrado + ", precioFinal=" + precioFinal + ", ubicacion=" + ubicacion + ", ciudad=" + ciudad + ", numCuartos=" + numCuartos + ", constructora=" + constructora + '}';
    }

}
