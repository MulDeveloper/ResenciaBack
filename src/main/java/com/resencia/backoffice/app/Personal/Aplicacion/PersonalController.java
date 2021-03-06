/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Personal.Aplicacion;

import com.resencia.backoffice.app.AccesoPersonal.Dominio.AccesoPersonalResencia;
import com.resencia.backoffice.app.AccesoPersonal.Infraestructura.ServiceAccesoPersonal;
import com.resencia.backoffice.app.Auth.Auth;
import com.resencia.backoffice.app.Personal.Dominio.PersonalResencia;
import com.resencia.backoffice.app.Personal.Dominio.RolesResencia;
import com.resencia.backoffice.app.Personal.Infraestructura.ServicePersonal;
import com.resencia.backoffice.app.Personal.Infraestructura.ServiceRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v0/personal")
public class PersonalController {
    
    @Autowired
    private ServicePersonal servicePersonal;
    
    @Autowired
    private ServiceRoles serviceRoles;
    
    @Autowired
    private ServiceAccesoPersonal serviceAcceso;
    
    @Autowired
    private BCryptPasswordEncoder bcrypt;
    
    @Autowired
    private Auth auth;
    
    @GetMapping("/alta")
    public String loadViewAlta(Model m){
        PersonalResencia personal = new PersonalResencia();
        AccesoPersonalResencia acceso = new AccesoPersonalResencia();
        RolesResencia rol = new RolesResencia();
        
        m.addAttribute("title", "Alta personal");
        m.addAttribute("personal", personal);
        m.addAttribute("acceso", acceso);
        m.addAttribute("rol", rol);
        
        return "altaPersonal";
    }
    
    
    @PostMapping("/add")
    public String addPersonal(@ModelAttribute("personal") PersonalResencia personal,
            @ModelAttribute(name="password") AccesoPersonalResencia acceso,
            @ModelAttribute(name="rol") RolesResencia rol){
        
        //check if the username exist
        
        if(serviceAcceso.existUsername(acceso.getUsername())){
            return "redirect:/v0/personal/adminlist";
        }
        
        PersonalResencia p = servicePersonal.save(personal);
        
        // se ecnripta la password y se da de alta el acceso
        acceso.setPasswordPersonal(bcrypt.encode(acceso.getPasswordPersonal()));
        acceso.setIdpersonal(p);
        serviceAcceso.save(acceso);
        
        //rol
        rol.setUserid(p);
        serviceRoles.saveRol(rol);
        
        return "redirect:/v0/personal/adminlist";
        
    }
    
    @GetMapping("/del/{id}")
    public String delPersonal(@PathVariable Integer id){
        //logica de baja
        /*
            Observar que tenemos el cascade delete en la entidad de dominio PersonalResencia
        */
        
        servicePersonal.delById(id);

        //retornamos lista de personal
 
        return "redirect:/v0/personal/adminlist";
    }
    
    @GetMapping("/adminlist")
    public String loadViewAdminList(Model m){

        m.addAttribute("title", "Lista Administradores");
        m.addAttribute("listaadmin", servicePersonal.listAll());
        return "list_admin";
    }
    
    //personal cambio dprueba
    
    
    @GetMapping("/ownerEdit/{username}")
    public String editData(Model m, @PathVariable String username){
        // check if the user is the same user that we are trying to change
        
        if(auth.getAuthentication().getName().equals(username)){
            //we get the objects and we pass it to te view
            AccesoPersonalResencia acceso = serviceAcceso.loadByUsername(username);
            PersonalResencia p = servicePersonal.findByUsername(username);
            
            
            m.addAttribute("personal", p);
            m.addAttribute("acceso", acceso);
            return "editAdmin"; 
        }
        else{
            return "redirect:/";
        }
    }
    
    @PostMapping("/update")
    public String updatePersonal(@ModelAttribute("personal") PersonalResencia personal,
            @ModelAttribute(name="password") AccesoPersonalResencia acceso){
        
        
        PersonalResencia p = servicePersonal.save(personal);
        
        // se ecnripta la password y se modifica el acceso
        acceso.setPasswordPersonal(bcrypt.encode(acceso.getPasswordPersonal()));
        acceso.setIdpersonal(p);
        serviceAcceso.save(acceso);
        
        
        return "index";
        
    }
    
    
}
