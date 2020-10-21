
package com.resencia.backoffice.app.Index;

import com.resencia.backoffice.app.Servicios.Infraestructura.ServiceServicios;
import com.resencia.backoffice.app.Tickets.Infraestructura.ServiceTicket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    private final ServiceServicios serviceServicios;
    private final ServiceTicket serviceTicket;

    public IndexController(ServiceServicios serviceServicios, ServiceTicket serviceTicket) {
        this.serviceServicios = serviceServicios;
        this.serviceTicket = serviceTicket;
    }

    
    
    
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/index")
    public String getIndex(Model m){
        m.addAttribute("title", "Resencia CRM Backoffice");
        m.addAttribute("ultimosServicios", serviceServicios.lastTen());
        
        m.addAttribute("data", getVentas());
        m.addAttribute("pieData",getPieChartMap());
        m.addAttribute("serviciosActivos", serviceServicios.count());
        m.addAttribute("ticketsActivos", serviceTicket.getTicketsNotClosed());
        
        return "index";
        
    }
    
    private Map<String, Double> getPieChartMap(){
        Long total = serviceServicios.count();
        Map indexByService = serviceServicios.getByService(total);
        return indexByService;
    }
    
    private Map<Date, Double> getVentas(){
        try {
            Map indexVentas = new HashMap<Date, Double>();
            TreeMap res = new TreeMap<Date, Double>();
            
            for(int i=11;i>=0;i--){
                //we iterate through the months
                LocalDate date = LocalDate.now().minusMonths(i);
                int mes = date.getMonthValue();
                Double total = serviceServicios.getTotalByMonth(mes);
                if( total == null){
                    total = 0.0;
                }
                
                //we create the value of date and add it the map
                
                String dateString = date.toString();
                Date d = new SimpleDateFormat("yyyy-MM").parse(dateString);
                
                
                indexVentas.put(d, total);  
                
            }
            
            //we order the map
            res = new TreeMap<Date, Double>(indexVentas);
            
            return res;
            
            
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
        
    }
    
    
    
}
