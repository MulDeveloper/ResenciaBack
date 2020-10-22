/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Tickets.Infraestructura;

import com.resencia.backoffice.app.Tickets.Dominio.TicketSoporte;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.stereotype.Service;

@Service
public class ServiceTicketPostgre implements ServiceTicket{
    
    private final TicketRepo repo;
    private final EntityManager em;

    public ServiceTicketPostgre(TicketRepo repo, EntityManager em) {
        this.repo = repo;
        this.em = em;
    }

    
    
    

    @Override
    public List<TicketSoporte> listAll() {
        return this.repo.findAll();
    }

    @Override
    public boolean save(TicketSoporte t) {
        try{
            this.repo.save(t);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public Long getTicketsNotClosed() {
        try{
            Query q = em.createNamedQuery("TicketSoporte.count").setParameter("param", "CERRADO");
            Long res = Long.parseLong(""+q.getSingleResult());
            return res;
        }
        catch(Exception e){
            return null;
        }
    }

    @Override
    public TicketSoporte getOne(int id) {
        return this.repo.getOne(id);
    }
    
}
