/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Servicios.Infraestructura;

import com.resencia.backoffice.app.Servicios.Dominio.ServiciosResencia;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiciosPostgre implements ServiceServicios{
    
    private final DAOServicio dao;

    public ServiceServiciosPostgre(DAOServicio dao) {
        this.dao = dao;
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

 
    
}
