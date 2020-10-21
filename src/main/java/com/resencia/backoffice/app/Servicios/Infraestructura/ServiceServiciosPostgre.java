/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Servicios.Infraestructura;

import com.resencia.backoffice.app.Servicios.Dominio.ServicioStats;
import com.resencia.backoffice.app.Servicios.Dominio.ServiciosResencia;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Override
    public Double getTotalByMonth(int month) {
        try{
            Query q = em.createNamedQuery("ServiciosResencia.byMonth").setParameter("mes", month);
            Double res = Double.parseDouble(""+q.getSingleResult());
            return res;
        }
        catch(Exception e){
            return null;
        }
    }

    @Override
    public Map<String, Double> getByService(Long total) {
        Map indexByService = new HashMap<String, Double>();
        try{
            Query q = em.createNamedQuery("ServiciosResencia.byService");
            List <Object[]> lista = q.getResultList();
            for(Object[] s: lista){
                String desc = (String) s[0];
                int count = ((Number) s[1]).intValue();
                Double res = new Double((count*100)/total);
                indexByService.put(desc, res);
            }
            
            //we check if there are no services in that category
            String[] services = {"APP", "WEB", "A MEDIDA", "MANTENIMIENTO", "TIENDA", "CRM"};
            
            for (int i=0;i<services.length;i++){
                if(!indexByService.containsKey(services[i])){
                    //we dont have any services of that category so we add it with 0 value
                    indexByService.put(services[i], 0.0);
                            
                }
            }
            
            
            
            return indexByService;
        }
        catch(Exception e){
            return null;
        }
    }

    @Override
    public Long count() {
        return dao.count();
    }


 
}
