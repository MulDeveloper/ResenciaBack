/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Cliente.Infraestructure;

import com.resencia.backoffice.app.Cliente.Dominio.ClientesResencia;
import java.util.List;


public interface ServiceCliente {
    public ClientesResencia add(ClientesResencia cliente);
    public List<ClientesResencia> list();
    public boolean delete(int id);
    public ClientesResencia getOne(int id);
    public ClientesResencia getByNif(String nif);
}
