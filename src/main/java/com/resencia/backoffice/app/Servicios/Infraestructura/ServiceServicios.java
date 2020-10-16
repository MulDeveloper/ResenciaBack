/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Servicios.Infraestructura;

import com.resencia.backoffice.app.Servicios.Dominio.ServiciosResencia;
import java.util.List;

/**
 *
 * @author bunn3
 */
public interface ServiceServicios {
    public List<ServiciosResencia> listar();
    
    public ServiciosResencia save(ServiciosResencia servicio);
    
    public ServiciosResencia getOne(int id);
    
    
}
