/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Email.Infraestructura;

import com.resencia.backoffice.app.Credenciales.Dominio.CredencialesServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ServiceEmailImpl implements ServiceEmail{
    
    public final JavaMailSender emailSender;

    public ServiceEmailImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }
    

    @Async
    @Override
    public void sendEmailOnTicketClosed(String clientEmail) {
        
        try {
            MimeMessage mimeMessage = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
            String htmlMsg = new EmailValues().getTicket();
            mimeMessage.setContent(htmlMsg, "text/html");
            
            helper.setTo(clientEmail);
            helper.setSubject("Resencia - Ticket Resuelto");
            helper.setFrom("soporte@resencia.com");
            emailSender.send(mimeMessage);
        } catch (MessagingException ex) {
            Logger.getLogger(ServiceEmailImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Async
    @Override
    public void sendEmailCredentials(CredencialesServicio cred, String clientEmail) {
        try {
            MimeMessage mimeMessage = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
            String htmlMsg = new EmailValues(cred).getCred();
            mimeMessage.setContent(htmlMsg, "text/html");
            
            helper.setTo(clientEmail);
            helper.setSubject("Resencia - Servicio Operativo");
            helper.setFrom("soporte@resencia.com");
            emailSender.send(mimeMessage);
        } catch (MessagingException ex) {
            Logger.getLogger(ServiceEmailImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
