/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Personal.Infraestructura;

import com.resencia.backoffice.app.Personal.Dominio.RolesResencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DAORoles extends JpaRepository <RolesResencia, Integer>{
    
}
