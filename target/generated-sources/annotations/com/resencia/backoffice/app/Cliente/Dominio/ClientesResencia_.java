package com.resencia.backoffice.app.Cliente.Dominio;

import com.resencia.backoffice.app.Servicios.Dominio.ServiciosResencia;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ClientesResencia.class)
public abstract class ClientesResencia_ {

	public static volatile SingularAttribute<ClientesResencia, String> emailCliente;
	public static volatile SingularAttribute<ClientesResencia, String> nifCliente;
	public static volatile SingularAttribute<ClientesResencia, String> nombreCliente;
	public static volatile ListAttribute<ClientesResencia, ServiciosResencia> serviciosResenciaList;
	public static volatile SingularAttribute<ClientesResencia, String> apellidoCliente;
	public static volatile SingularAttribute<ClientesResencia, String> telefonoCliente;
	public static volatile SingularAttribute<ClientesResencia, String> direccionCliente;
	public static volatile SingularAttribute<ClientesResencia, Integer> idcliente;
	public static volatile SingularAttribute<ClientesResencia, String> poblacionCliente;

}

