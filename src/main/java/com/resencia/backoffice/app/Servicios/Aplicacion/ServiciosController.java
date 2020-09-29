/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Servicios.Aplicacion;

import com.resencia.backoffice.app.Servicios.Dominio.ServiciosResencia;
import com.resencia.backoffice.app.Servicios.Infraestructura.ServiceServicios;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v0/servicios")
public class ServiciosController {
    
    @Autowired
    private ServiceServicios service;
    
    @GetMapping("/lista")
    public String listServices(Model m){
        List <ServiciosResencia> lista = service.listar();
        m.addAttribute("servicios", lista);
        return "";
    }
    
    
}
