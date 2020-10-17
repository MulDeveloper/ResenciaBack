/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Credenciales.Aplicacion;

import org.springframework.stereotype.Controller;
import com.resencia.backoffice.app.Credenciales.Dominio.CredencialesServicio;
import com.resencia.backoffice.app.Credenciales.Infraestructura.ServiceCredencial;
import com.resencia.backoffice.app.Servicios.Dominio.ServiciosResencia;
import com.resencia.backoffice.app.Servicios.Infraestructura.ServiceServicios;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v0/credenciales/")
public class CredencialesController {
    
    private final ServiceServicios serviceServicios;
    private final ServiceCredencial serviceCredencial;

    public CredencialesController(ServiceServicios serviceServicios, ServiceCredencial serviceCredencial) {
        this.serviceServicios = serviceServicios;
        this.serviceCredencial = serviceCredencial;
    }
    

    

    
    @GetMapping("/alta/{idservicio}")
    public String add(Model m,@PathVariable("idservicio") Integer idservicio){
        
        //we check if that services has credentials related
        
        ServiciosResencia servicio = serviceServicios.getOne(idservicio);
        
        //if that services has credentials we go back
        if(serviceCredencial.hasCredential(servicio)){
            //the services has credentials we go back
            return "redirect:/v0/servicios/lista";
        }
        
        
        m.addAttribute("title", "Alta nueva credencial");
        
        //we get the service in the db and add it to the credential object
        
        CredencialesServicio credencial = new CredencialesServicio();
        credencial.setIdservicio(servicio);
        
        //we add it to the model
        m.addAttribute("credencial", credencial);
        
        
        
        return "altaCredencial";
    }
    
    @PostMapping("/add")
    public String save(@ModelAttribute("credencial") CredencialesServicio credencial){
        
        //we have to encrypt the passwords and store it
        
        
        this.serviceCredencial.save(credencial);
        
        return "redirect:/v0/servicios/lista";
    }
    
    @GetMapping("/get/{id}")
    public String getCredentials(@PathVariable("id") Integer id,Model m){
        //we get the credential to that service
        
        CredencialesServicio c = this.serviceCredencial.getOne(id);
        
        //we decrypt the password
       
        
        if(c == null){
            return "redirect:/v0/servicios/lista";
        }
        
        m.addAttribute("title", "Credencial");
        m.addAttribute("credencial", c);
        return "showCredential";
    }
    
    @GetMapping("/edit/{id}")
    public String getEditCredential(@PathVariable("id") Integer id,Model m){
         //we get the credential to that service
        
        CredencialesServicio c = this.serviceCredencial.getOne(id);
        
        
        if(c == null){
            return "redirect:/v0/servicios/lista";
        }
        
        m.addAttribute("title", "Credencial");
        m.addAttribute("credencial", c);
        return "editCredential";
    }
    
    @PostMapping("/edit")
    public String editCredential(@ModelAttribute("credencial") CredencialesServicio credencial){
        
        this.serviceCredencial.save(credencial);
        
        return "redirect:/v0/servicios/lista";
    }
    
}
