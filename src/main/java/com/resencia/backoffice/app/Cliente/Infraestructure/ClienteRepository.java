
package com.resencia.backoffice.app.Cliente.Infraestructure;

import com.resencia.backoffice.app.Cliente.Dominio.ClientesResencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClientesResencia, Integer>{
    
}
