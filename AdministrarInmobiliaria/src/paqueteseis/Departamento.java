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
public class Departamento implements Serializable {

    private Propietario propietario;
    private double precioMetroCuadrado;
    private double numMetroCuadrado;
    private double cuotaMensual;
    private double costoFinal;
    private double precio;
    private Ubicacion ubicacion;
    private Ciudad ciudad;
    private String nombreEdificio;
    private String ubicacionDepartamento;
    private Constructora constructora;

    public Departamento(Propietario propietario, double precioMetroCuadrado,
            double numMetroCuadrado, double cuotaMensual, Ubicacion ubicacion,
            Ciudad ciudad, String nombreEdificio,
            String ubicacionDepartamento,
            Constructora constructora) {
        this.propietario = propietario;
        this.precioMetroCuadrado = precioMetroCuadrado;
        this.numMetroCuadrado = numMetroCuadrado;
        this.cuotaMensual = cuotaMensual;
        this.ubicacion = ubicacion;
        this.ciudad = ciudad;
        this.nombreEdificio = nombreEdificio;
        this.ubicacionDepartamento = ubicacionDepartamento;
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

    public void setCuotaMensual(double cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    public void setCostoFinal() {
        this.costoFinal = precio + (cuotaMensual * 12);
    }

    public void setPrecio() {
        this.precio = (numMetroCuadrado * precioMetroCuadrado);
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public void setNombreEdificio(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }

    public void setUbicacionDepartamento(String ubicacionDepartamento) {
        this.ubicacionDepartamento = ubicacionDepartamento;
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

    public double getCuotaMensual() {
        return cuotaMensual;
    }

    public double getCostoFinal() {
        return costoFinal;
    }

    public double getPrecio() {
        return precio;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public String getUbicacionDepartamento() {
        return ubicacionDepartamento;
    }

    public Constructora getConstructora() {
        return constructora;
    }
}
