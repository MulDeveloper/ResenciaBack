/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.UserLogin;

import com.resencia.backoffice.app.AccesoPersonal.Dominio.AccesoPersonalResencia;
import com.resencia.backoffice.app.AccesoPersonal.Infraestructura.ServiceAccesoPersonal;
import com.resencia.backoffice.app.Personal.Dominio.PersonalResencia;
import com.resencia.backoffice.app.Personal.Dominio.RolesResencia;
import com.resencia.backoffice.app.Personal.Infraestructura.ServicePersonal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bunn3
 */
@Service("userLoginService")
public class UserLoginService implements UserDetailsService{
    
    
    @Autowired
    private ServiceAccesoPersonal service;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
 
        AccesoPersonalResencia acceso = service.loadByUsername(string);
        
        if(acceso == null){
            throw new UsernameNotFoundException("Usuario no existe");
        }
        
        List <GrantedAuthority> roles = new ArrayList();
        
        for (RolesResencia r: acceso.getIdpersonal().getRolesResenciaList()){
            //registramos el rol
            roles.add(new SimpleGrantedAuthority(r.getAuthority()));
        }
        
        if(roles.isEmpty()){
            throw new UsernameNotFoundException("No tienes permisos");
        }
        
        return new User(acceso.getUsername(), acceso.getPasswordPersonal(),true, true, true, true, roles);
        
        
    }
    
    
    
    
    
}