/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Tickets.Infraestructura;

import com.resencia.backoffice.app.Tickets.Dominio.TicketSoporte;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ServiceTicketPostgre implements ServiceTicket{
    
    private final TicketRepo repo;

    public ServiceTicketPostgre(TicketRepo repo) {
        this.repo = repo;
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
    
}
