/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Servicios.Dominio;

import org.springframework.stereotype.Component;

public class ServicioStats {
    private String descripcion;
    private Long count;

    public ServicioStats(String descripcion, Long count) {
        this.descripcion = descripcion;
        this.count = count;
    }

    public ServicioStats() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
    
    
}
