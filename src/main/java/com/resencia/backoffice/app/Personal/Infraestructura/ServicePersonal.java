/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Personal.Infraestructura;

import com.resencia.backoffice.app.Personal.Dominio.PersonalResencia;
import java.util.List;

/**
 *
 * @author bunn3
 */
public interface ServicePersonal {
   
    public PersonalResencia getById(int id);
    public PersonalResencia save(PersonalResencia p);
    public boolean delById(int id);
    public PersonalResencia findByUsername(String username);
    public List<PersonalResencia> listAll();
}
