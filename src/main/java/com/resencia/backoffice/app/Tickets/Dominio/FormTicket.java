/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Tickets.Dominio;

/**
 *
 * @author bunn3
 */
public class FormTicket {
    private String nif;
    private String telefono;
    private String poblacion;

    public FormTicket() {
    }

    public FormTicket(String nif, String telefono, String poblacion) {
        this.nif = nif;
        this.telefono = telefono;
        this.poblacion = poblacion;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }
    
    
}
