/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Tickets.Infraestructura;

import com.resencia.backoffice.app.Tickets.Dominio.TicketSoporte;
import java.util.List;

/**
 *
 * @author bunn3
 */
public interface ServiceTicket {
    public List<TicketSoporte> listAll();
    public boolean save(TicketSoporte t);
}
