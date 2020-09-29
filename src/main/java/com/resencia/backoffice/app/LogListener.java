/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
public class LogListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    private String userName;
    
    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        userName = ""+event.getAuthentication().getPrincipal();
    }
    
    public String retornaNomUsu(){
        return userName;
    }
}