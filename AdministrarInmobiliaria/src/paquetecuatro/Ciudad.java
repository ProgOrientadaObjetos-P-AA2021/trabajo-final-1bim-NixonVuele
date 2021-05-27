/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecuatro;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Ciudad implements Serializable{

    private String nombreCity;
    private String nombreProvincia;

    public Ciudad(String nombreCity,String nombreProvincia) {
        this.nombreCity=nombreCity;
        this.nombreProvincia=nombreProvincia;
    }

    public void setNombreCity(String nombreCity) {
        this.nombreCity = nombreCity;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public String getNombreCity() {
        return nombreCity;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

}
