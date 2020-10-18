package com.resencia.backoffice.app.Tickets.Dominio;

import com.resencia.backoffice.app.Cliente.Dominio.ClientesResencia;
import com.resencia.backoffice.app.Servicios.Dominio.ServiciosResencia;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TicketSoporte.class)
public abstract class TicketSoporte_ {

	public static volatile SingularAttribute<TicketSoporte, String> descripcion;
	public static volatile SingularAttribute<TicketSoporte, String> estado;
	public static volatile SingularAttribute<TicketSoporte, Date> fechaAlta;
	public static volatile SingularAttribute<TicketSoporte, Integer> idticket;
	public static volatile SingularAttribute<TicketSoporte, ClientesResencia> idcliente;
	public static volatile SingularAttribute<TicketSoporte, ServiciosResencia> idservicio;

}

