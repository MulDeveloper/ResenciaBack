/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Email.Infraestructura;

import com.resencia.backoffice.app.Credenciales.Dominio.CredencialesServicio;

/**
 *
 * @author bunn3
 */
public interface ServiceEmail {
    public void sendEmailOnTicketClosed(String emailCliente);
    public void sendEmailCredentials(CredencialesServicio cred, String clientEmail);
}
