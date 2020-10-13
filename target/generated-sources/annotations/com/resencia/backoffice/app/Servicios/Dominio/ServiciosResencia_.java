package com.resencia.backoffice.app.Servicios.Dominio;

import com.resencia.backoffice.app.Cliente.Dominio.ClientesResencia;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ServiciosResencia.class)
public abstract class ServiciosResencia_ {

	public static volatile SingularAttribute<ServiciosResencia, String> descripcion;
	public static volatile SingularAttribute<ServiciosResencia, BigInteger> precio;
	public static volatile SingularAttribute<ServiciosResencia, Date> fechaAlta;
	public static volatile SingularAttribute<ServiciosResencia, Date> fechaEntrega;
	public static volatile SingularAttribute<ServiciosResencia, Boolean> estadoPago;
	public static volatile SingularAttribute<ServiciosResencia, ClientesResencia> idcliente;
	public static volatile SingularAttribute<ServiciosResencia, Integer> idservicio;
	public static volatile SingularAttribute<ServiciosResencia, Date> fechaPago;

}

