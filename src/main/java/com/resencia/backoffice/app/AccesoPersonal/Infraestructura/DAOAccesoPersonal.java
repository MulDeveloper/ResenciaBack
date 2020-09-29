/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.AccesoPersonal.Infraestructura;

import com.resencia.backoffice.app.AccesoPersonal.Dominio.AccesoPersonalResencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DAOAccesoPersonal extends JpaRepository <AccesoPersonalResencia, Integer>{
    
}
