/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Credenciales.Infraestructura;

import com.resencia.backoffice.app.Credenciales.Dominio.CredencialesServicio;
import com.resencia.backoffice.app.Servicios.Dominio.ServiciosResencia;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.stereotype.Service;

@Service
public class ServiceCredencialPostgre implements ServiceCredencial{
    
    private final CredencialRepo repo;
    private final EntityManager em;

    public ServiceCredencialPostgre(CredencialRepo repo, EntityManager em) {
        this.repo = repo;
        this.em = em;
    }

    
    

    @Override
    public void save(CredencialesServicio credencial) {
        this.repo.save(credencial);
    }

    @Override
    public boolean hasCredential(ServiciosResencia servicio) {
        try{
            Query q = em.createNamedQuery("CredencialesServicio.findByService")
                    .setParameter("id", servicio.getIdservicio());
            CredencialesServicio c = (CredencialesServicio) q.getSingleResult();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
}
