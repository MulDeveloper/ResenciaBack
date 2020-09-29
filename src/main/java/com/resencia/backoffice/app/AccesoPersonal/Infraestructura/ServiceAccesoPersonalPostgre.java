/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.AccesoPersonal.Infraestructura;

import com.resencia.backoffice.app.AccesoPersonal.Dominio.AccesoPersonalResencia;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAccesoPersonalPostgre implements ServiceAccesoPersonal{
    
    @Autowired
    private DAOAccesoPersonal dao;
    
    @Autowired
    private EntityManager em;

    @Override
    public AccesoPersonalResencia loadByUsername(String username) {
         try{
            Query q = em.createNamedQuery("AccesoPersonalResencia.findByUsername")
                    .setParameter("username", username);
            AccesoPersonalResencia accesoPersonal = (AccesoPersonalResencia) q.getSingleResult();
            return accesoPersonal;
        }
        catch(NoResultException e){
            return null;
        }

    }

    @Override
    public boolean save(AccesoPersonalResencia a) {
        try{
            dao.save(a);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try{
            dao.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
}
