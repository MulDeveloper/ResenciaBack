/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Login;

import com.resencia.backoffice.app.AccesoPersonal.Dominio.AccesoPersonalResencia;
import com.resencia.backoffice.app.LogListener;
import com.resencia.backoffice.app.Personal.Dominio.PersonalResencia;
import com.resencia.backoffice.app.Personal.Dominio.RolesResencia;
import com.resencia.backoffice.app.Personal.Infraestructura.ServicePersonal;
import com.resencia.backoffice.app.Personal.Infraestructura.ServiceRoles;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    
    @Autowired
    private LogListener listener;
    
    
    @GetMapping("/login")
    public String login(@RequestParam(value="error", required = false) String error,
            Model m, Principal principal, RedirectAttributes flash){     
        if (principal != null){
            //ya habia iniciado sesion anteriormente
            flash.addFlashAttribute("info", "Ya has iniciado sesion");
            return "redirect:/";
        }
        if (error != null){
            m.addAttribute("error", "Login Incorrecto :(");
            //System.out.println(principal.getName());
            m.addAttribute("username", listener.retornaNomUsu());

        }
        return "login";
    }
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

}
