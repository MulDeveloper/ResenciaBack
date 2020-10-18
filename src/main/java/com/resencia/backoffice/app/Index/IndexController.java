
package com.resencia.backoffice.app.Index;

import com.resencia.backoffice.app.Servicios.Infraestructura.ServiceServicios;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    private final ServiceServicios serviceServicios;

    public IndexController(ServiceServicios serviceServicios) {
        this.serviceServicios = serviceServicios;
    }
    
    
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/index")
    public String getIndex(Model m){
        m.addAttribute("title", "Resencia CRM Backoffice");
        m.addAttribute("ultimosServicios", serviceServicios.lastTen());
        return "index";
    }
    
    
}
