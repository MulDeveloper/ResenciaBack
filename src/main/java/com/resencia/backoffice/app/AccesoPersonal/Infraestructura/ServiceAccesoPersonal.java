/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.AccesoPersonal.Infraestructura;

import com.resencia.backoffice.app.AccesoPersonal.Dominio.AccesoPersonalResencia;

/**
 *
 * @author bunn3
 */
public interface ServiceAccesoPersonal {
    public AccesoPersonalResencia loadByUsername(String username);
    public boolean save(AccesoPersonalResencia a);
    public boolean delete(int id);
    public boolean existUsername(String username);
}
