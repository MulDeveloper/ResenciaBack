/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Tickets.Aplicacion;

import com.resencia.backoffice.app.Cliente.Dominio.ClientesResencia;
import com.resencia.backoffice.app.Cliente.Infraestructure.ServiceCliente;
import com.resencia.backoffice.app.Email.Infraestructura.ServiceEmail;
import com.resencia.backoffice.app.Tickets.Dominio.FormTicket;
import com.resencia.backoffice.app.Tickets.Dominio.TicketSoporte;
import com.resencia.backoffice.app.Tickets.Infraestructura.ServiceTicket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v0/tickets")
public class TicketsController {
    
    private final ServiceCliente serviceCliente;
    private final ServiceTicket serviceTicket;
    private final ServiceEmail serviceEmail;

    public TicketsController(ServiceCliente serviceCliente, ServiceTicket serviceTicket, ServiceEmail serviceEmail) {
        this.serviceCliente = serviceCliente;
        this.serviceTicket = serviceTicket;
        this.serviceEmail = serviceEmail;
    }

    

    
    
    @GetMapping("/check")
    public String preTicketCheck(Model m){
        m.addAttribute("checkForm", new FormTicket());
        m.addAttribute("title", "Comprobacion previa");
        return "check";
    }
    
    @GetMapping("/lista")
    public String listTickets(Model m){
        m.addAttribute("title", "Lista tickets");
        m.addAttribute("tickets", serviceTicket.listAll());
        return "tickets";
    }
    
    @GetMapping("/setStatus/{id}/{status}")
    public String setStatus(@PathVariable("id") Integer id, @PathVariable("status") String status){
        TicketSoporte t = serviceTicket.getOne(id);
        t.setEstado(status);
        serviceTicket.save(t);
        if (status.equals("CERRADO")){
            serviceEmail.sendEmailOnTicketClosed(t.getIdcliente().getEmailCliente());
        }
        return "redirect:/v0/tickets/lista";
    }
    
    @PostMapping("/check")
    public String checkForm(@ModelAttribute("checkForm") FormTicket form, Model m){
        //check if the data exist and populate de form with the services of that users
        
        //servicecliente get by nif
        ClientesResencia cliente = serviceCliente.getByNif(form.getNif());
        
        if(cliente.getTelefonoCliente().equals(form.getTelefono())){
            //"login" correct
            m.addAttribute("title", "Alta de ticket");
            
            TicketSoporte ticket = new TicketSoporte();
            ticket.setIdcliente(cliente);
            
            ticket.setFechaAlta(java.util.Calendar.getInstance().getTime());
            
            ticket.setEstado("ABIERTO");
            
            m.addAttribute("ticket", ticket);
            //we get the services related to that client
            
            m.addAttribute("servicios", cliente.getServiciosResenciaList());
            
            
            return "altaTicket";
        }
        
        return "check";
    }
    
    @PostMapping("/save")
    public String success(@ModelAttribute("ticket") TicketSoporte ticket){
        this.serviceTicket.save(ticket);
        return "redirect:" + "https://resencia.com";
    }
    
    
    @GetMapping("/list")
    public String getList(Model m){
        return "listaTickets";
    }
}
