/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Tickets.Aplicacion;

import com.resencia.backoffice.app.Tickets.Dominio.FormTicket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v0/tickets")
public class TicketsController {
    
    @GetMapping("/check")
    public String preTicketCheck(Model m){
        return "check";
    }
    
    @PostMapping("/check")
    public String preTicketCheck(@ModelAttribute("personal") FormTicket form){
        return "check";
    }
    
    @GetMapping("/add")
    public String addTicketNoSecurity(Model m){
        //check if we have the correct parameters to create a ticket
        return "altaTicket";
    }
    
    @GetMapping("/list")
    public String getList(Model m){
        return "listaTickets";
    }
}
