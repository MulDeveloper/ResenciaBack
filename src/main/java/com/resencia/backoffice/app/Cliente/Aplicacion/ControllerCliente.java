/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Cliente.Aplicacion;

import com.resencia.backoffice.app.Cliente.Dominio.ClientesResencia;
import com.resencia.backoffice.app.Cliente.Infraestructure.ServiceCliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/v0/clients")
public class ControllerCliente {
    
    private final ServiceCliente service;

    public ControllerCliente(ServiceCliente service) {
        this.service = service;
    }
    
    @GetMapping("/")
    public String listClients(Model m){
        m.addAttribute("listaClientes", this.service.list());
        m.addAttribute("title", "Lista clientes");
        return "listaClientes";
    }

    
    @GetMapping("/add")
    public String addClient(Model m){
        
        //we create a new client and pass it to the model
        
        ClientesResencia cliente = new ClientesResencia();
        m.addAttribute("title", "Alta cliente");
        m.addAttribute("cliente", cliente);
        
        return "altaCliente";
    }
    
    
    @GetMapping("/edit/{id}")
    public String editClient(@PathVariable("id") Integer id, Model m){
        //we get the client and populate de form
        
        ClientesResencia cliente = this.service.getOne(id);
        m.addAttribute("title", "Editar " + cliente.getNombreCliente() + " " + cliente.getApellidoCliente());
        m.addAttribute("cliente", cliente);
        
        return "editCliente";
    }
    
    
    @PostMapping("/add")
    public String persistClient(@ModelAttribute("cliente") ClientesResencia cliente){
        this.service.add(cliente);
        return "redirect:/v0/clients/";
    }
    
}
