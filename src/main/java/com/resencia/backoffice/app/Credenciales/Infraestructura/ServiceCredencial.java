/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Credenciales.Infraestructura;

import com.resencia.backoffice.app.Credenciales.Dominio.CredencialesServicio;

/**
 *
 * @author bunn3
 */
public interface ServiceCredencial {
    public void save(CredencialesServicio credencial);
}
