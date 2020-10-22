/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Credenciales.Aplicacion;

import org.springframework.stereotype.Controller;
import com.resencia.backoffice.app.Credenciales.Dominio.CredencialesServicio;
import com.resencia.backoffice.app.Credenciales.Infraestructura.ServiceCredencial;
import com.resencia.backoffice.app.Email.Infraestructura.ServiceEmail;
import com.resencia.backoffice.app.Security.Crypto;
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
    private final Crypto crypto;
    private final ServiceEmail serviceEmail;

    public CredencialesController(ServiceServicios serviceServicios, ServiceCredencial serviceCredencial, Crypto crypto, ServiceEmail serviceEmail) {
        this.serviceServicios = serviceServicios;
        this.serviceCredencial = serviceCredencial;
        this.crypto = crypto;
        this.serviceEmail = serviceEmail;
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
        
        credencial.setPasswordCms(this.crypto.encrypt(credencial.getPasswordCms()));
        credencial.setPassFtp(this.crypto.encrypt(credencial.getPassFtp()));
        credencial.setPassSsh(this.crypto.encrypt(credencial.getPassSsh()));
        
        
        this.serviceCredencial.save(credencial);
        
        return "redirect:/v0/servicios/lista";
    }
    
    @GetMapping("/get/{id}")
    public String getCredentials(@PathVariable("id") Integer id,Model m){
        //we get the credential to that service
        
        CredencialesServicio c = this.serviceCredencial.getOne(id);

        if(c == null){
            return "redirect:/v0/servicios/lista";
        }
        
        //we decrypt the password
        
        c.setPasswordCms(this.crypto.decrypt(c.getPasswordCms()));
        c.setPassFtp(this.crypto.decrypt(c.getPassFtp()));
        c.setPassSsh(this.crypto.decrypt(c.getPassSsh()));
        
        m.addAttribute("title", "Credencial");
        m.addAttribute("credencial", c);
        return "showCredential";
    }
    
    @GetMapping("/send/{id}")
    public String sendCred(@PathVariable("id") Integer id){
        //we get the credential to that service
        CredencialesServicio c = this.serviceCredencial.getOne(id);

        if(c == null){
            return "redirect:/v0/servicios/lista";
        }
        
        //we decrypt the password
        
        c.setPasswordCms(this.crypto.decrypt(c.getPasswordCms()));
        c.setPassFtp(this.crypto.decrypt(c.getPassFtp()));
        c.setPassSsh(this.crypto.decrypt(c.getPassSsh()));
        
        serviceEmail.sendEmailCredentials(c, c.getIdservicio().getIdcliente().getEmailCliente());
        
        
        
        return "redirect:/v0/servicios/lista";
    }
    
    @GetMapping("/edit/{id}")
    public String getEditCredential(@PathVariable("id") Integer id,Model m){
         //we get the credential to that service
        
        CredencialesServicio c = this.serviceCredencial.getOne(id);
        
        if(c == null){
            return "redirect:/v0/servicios/lista";
        }
        
        //we decrypt the password
        
        c.setPasswordCms(this.crypto.decrypt(c.getPasswordCms()));
        c.setPassFtp(this.crypto.decrypt(c.getPassFtp()));
        c.setPassSsh(this.crypto.decrypt(c.getPassSsh()));
        
        m.addAttribute("title", "Credencial");
        m.addAttribute("credencial", c);
        return "editCredential";
    }
    
    @PostMapping("/edit")
    public String editCredential(@ModelAttribute("credencial") CredencialesServicio credencial){
        
        //we have to encrypt the passwords and store it
        
        credencial.setPasswordCms(this.crypto.encrypt(credencial.getPasswordCms()));
        credencial.setPassFtp(this.crypto.encrypt(credencial.getPassFtp()));
        credencial.setPassSsh(this.crypto.encrypt(credencial.getPassSsh()));
        
        this.serviceCredencial.save(credencial);
        
        return "redirect:/v0/servicios/lista";
    }
    
    
}
