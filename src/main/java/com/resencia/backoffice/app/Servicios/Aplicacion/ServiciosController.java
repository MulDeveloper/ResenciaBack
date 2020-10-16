/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Servicios.Aplicacion;

import com.resencia.backoffice.app.Cliente.Dominio.ClientesResencia;
import com.resencia.backoffice.app.Cliente.Infraestructure.ServiceCliente;
import com.resencia.backoffice.app.Servicios.Dominio.ServiciosResencia;
import com.resencia.backoffice.app.Servicios.Infraestructura.ServiceServicios;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/v0/servicios")
public class ServiciosController {


    private final ServiceServicios service;
    private final ServiceCliente serviceCliente;

    public ServiciosController(ServiceServicios service, ServiceCliente serviceCliente) {
        this.service = service;
        this.serviceCliente = serviceCliente;
    }
    
    

    @GetMapping("/lista")
    public ModelAndView listServices(){
        ModelAndView mav = new ModelAndView("servicesTables");
        List <ServiciosResencia> lista = this.service.listar();
        mav.addObject("servicios", lista);
        return mav;
    }

    @GetMapping("/alta")
    public String loadViewAlta(Model m){
        ServiciosResencia servicio = new ServiciosResencia();

        m.addAttribute("title", "Alta servicio");
        m.addAttribute("servicio", servicio);
       
        
        //list all the clients to populate the select
        
        List <ClientesResencia> listaClientes = this.serviceCliente.list();
        m.addAttribute("clientes", listaClientes);
        
        
        
        

        return "altaServicio";
    }


    @PostMapping("/add")
    public String addServicio(@ModelAttribute("servicio") ServiciosResencia servicio){
        
        
        

        System.out.println(servicio.getIdcliente().getNombreCliente());
        
        //ServiciosResencia p = service.save(servicio);

        return "servicesTables";

    }


}
