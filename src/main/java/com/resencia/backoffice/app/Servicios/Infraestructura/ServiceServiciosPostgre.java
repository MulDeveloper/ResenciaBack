/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Servicios.Infraestructura;

import com.resencia.backoffice.app.Servicios.Dominio.ServiciosResencia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiciosPostgre implements ServiceServicios{
    
    private final DAOServicio dao;
    private final EntityManager em;

    public ServiceServiciosPostgre(DAOServicio dao, EntityManager em) {
        this.dao = dao;
        this.em = em;
    }


    @Override
    public List<ServiciosResencia> listar() {
        return dao.findAll();
    }
    
    @Override
    public ServiciosResencia save(ServiciosResencia servicio) {
        return dao.save(servicio);
    }

    @Override
    public ServiciosResencia getOne(int id) {
        return dao.getOne(id);
    }

    @Override
    public List<ServiciosResencia> lastTen() {
        try{
            Query q = em.createNamedQuery("ServiciosResencia.lastTen");
            List<ServiciosResencia> lista = q.setMaxResults(10).getResultList();
            return lista;
        }
        catch(Exception e){
            return null;
        }
    }

 
    
}
