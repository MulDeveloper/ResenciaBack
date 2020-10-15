/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Cliente.Infraestructure;

import com.resencia.backoffice.app.Cliente.Dominio.ClientesResencia;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ServiceClientePostgre implements ServiceCliente{
    
    private final ClienteRepository repo;

    public ServiceClientePostgre(ClienteRepository repo) {
        this.repo = repo;
    }
    
    @Override
    public ClientesResencia add(ClientesResencia cliente) {
        return this.repo.save(cliente);
    }

    @Override
    public List<ClientesResencia> list() {
        return this.repo.findAll();
    }

    @Override
    public boolean delete(int id) {
        try{
            this.repo.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public ClientesResencia getOne(int id) {
        return this.repo.getOne(id);
    }
    
}
