
package com.resencia.backoffice.app.Personal.Infraestructura;

import com.resencia.backoffice.app.AccesoPersonal.Dominio.AccesoPersonalResencia;
import com.resencia.backoffice.app.AccesoPersonal.Infraestructura.ServiceAccesoPersonal;
import com.resencia.backoffice.app.Personal.Dominio.PersonalResencia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePersonalPostgre implements ServicePersonal{
    
    @Autowired
    private DAOPersonalResencia dao;
    
    @Autowired
    private ServiceAccesoPersonal serviceAcceso;
    
    
    @Override
    public PersonalResencia getById(int id) {
        return dao.getOne(id);
    }

    @Override
    public PersonalResencia save(PersonalResencia p) {
        return dao.save(p);
    }

    @Override
    public boolean delById(int id) {
        try{
            dao.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public PersonalResencia findByUsername(String username) {
        AccesoPersonalResencia acceso = serviceAcceso.loadByUsername(username);
        return acceso.getIdpersonal();
        
    }
    
    @Override
    public List<PersonalResencia> listAll() {
        return dao.findAll();
    }

   
}
