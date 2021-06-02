/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetetres;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Ubicacion implements Serializable {

    private int numCasa;
    private String nombreBarrio;
    private String referencia;

    public Ubicacion(int numCasa, String nombreBarrio, String referencia) {
        this.numCasa = numCasa;
        this.nombreBarrio = nombreBarrio;
        this.referencia = referencia;
    }

    public void setNombreBarrio(String nombreBarrio) {
        this.nombreBarrio = nombreBarrio;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setNumCasa(int numCasa) {
        this.numCasa = numCasa;
    }

    public String getNombreBarrio() {
        return nombreBarrio;
    }

    public String getReferencia() {
        return referencia;
    }

    public int getNumCasa() {
        return numCasa;
    }

}
