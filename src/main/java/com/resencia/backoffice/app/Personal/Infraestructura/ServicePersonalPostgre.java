
package com.resencia.backoffice.app.Personal.Infraestructura;

import com.resencia.backoffice.app.AccesoPersonal.Dominio.AccesoPersonalResencia;
import com.resencia.backoffice.app.Personal.Dominio.PersonalResencia;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePersonalPostgre implements ServicePersonal{
    
    @Autowired
    private DAOPersonalResencia dao;
    
    @Override
    public PersonalResencia getById(int id) {
        return dao.getOne(id);
    }

    @Override
    public PersonalResencia save(PersonalResencia p) {
        return dao.save(p);
    }

   
}
