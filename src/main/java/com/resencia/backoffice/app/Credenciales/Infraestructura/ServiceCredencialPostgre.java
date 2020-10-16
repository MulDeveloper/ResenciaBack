/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Credenciales.Infraestructura;

import com.resencia.backoffice.app.Credenciales.Dominio.CredencialesServicio;
import org.springframework.stereotype.Service;

@Service
public class ServiceCredencialPostgre implements ServiceCredencial{
    
    private final CredencialRepo repo;

    public ServiceCredencialPostgre(CredencialRepo repo) {
        this.repo = repo;
    }
    
    

    @Override
    public void save(CredencialesServicio credencial) {
        this.repo.save(credencial);
    }
    
}
