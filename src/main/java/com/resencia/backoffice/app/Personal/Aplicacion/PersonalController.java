/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Personal.Aplicacion;

import com.resencia.backoffice.app.AccesoPersonal.Dominio.AccesoPersonalResencia;
import com.resencia.backoffice.app.AccesoPersonal.Infraestructura.ServiceAccesoPersonal;
import com.resencia.backoffice.app.Personal.Dominio.PersonalResencia;
import com.resencia.backoffice.app.Personal.Dominio.RolesResencia;
import com.resencia.backoffice.app.Personal.Infraestructura.ServicePersonal;
import com.resencia.backoffice.app.Personal.Infraestructura.ServiceRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        
        PersonalResencia p = servicePersonal.save(personal);
        
        // se ecnripta la password y se da de alta el acceso
        acceso.setPasswordPersonal(bcrypt.encode(acceso.getPasswordPersonal()));
        acceso.setIdpersonal(p);
        serviceAcceso.save(acceso);
        
        //rol
        rol.setUserid(p);
        serviceRoles.saveRol(rol);
        
        return "index";
        
    }
    
    @DeleteMapping("/del/{id}")
    public String delPersonal(@PathVariable Integer id){
        //logica de baja
        /*
            Observar que tenemos el cascade delete en la entidad de dominio PersonalResencia
        */
        
        servicePersonal.delById(id);

        //retornamos lista de personal
 
        return "index";
    }
}
