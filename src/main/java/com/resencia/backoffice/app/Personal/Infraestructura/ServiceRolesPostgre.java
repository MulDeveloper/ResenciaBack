/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Personal.Infraestructura;

import com.resencia.backoffice.app.Personal.Dominio.RolesResencia;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRolesPostgre implements ServiceRoles{
    
    @Autowired
    private DAORoles dao;
    

    @Override
    public void saveRol(RolesResencia r) {
        dao.save(r);
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
