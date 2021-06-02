/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecinco;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Constructora implements Serializable {

    private String nombreConstructora;
    private String idEmpresarial;

    public Constructora(String nombreConstructora, String idEmpresarial) {
        this.nombreConstructora = nombreConstructora;
        this.idEmpresarial = idEmpresarial;
    }

    public void setNombreConstructora(String nombreConstructora) {
        this.nombreConstructora = nombreConstructora;
    }

    public void setIdEmpresarial(String idEmpresarial) {
        this.idEmpresarial = idEmpresarial;
    }

    public String getNombreConstructora() {
        return nombreConstructora;
    }

    public String getIdEmpresarial() {
        return idEmpresarial;
    }
}
