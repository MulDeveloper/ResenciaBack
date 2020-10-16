package com.resencia.backoffice.app.Credenciales.Dominio;

import com.resencia.backoffice.app.Servicios.Dominio.ServiciosResencia;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CredencialesServicio.class)
public abstract class CredencialesServicio_ {

	public static volatile SingularAttribute<CredencialesServicio, String> passwordCms;
	public static volatile SingularAttribute<CredencialesServicio, String> ip;
	public static volatile SingularAttribute<CredencialesServicio, String> usernameCms;
	public static volatile SingularAttribute<CredencialesServicio, String> passFtp;
	public static volatile SingularAttribute<CredencialesServicio, Integer> idcredencial;
	public static volatile SingularAttribute<CredencialesServicio, String> userFtp;
	public static volatile SingularAttribute<CredencialesServicio, String> passSsh;
	public static volatile SingularAttribute<CredencialesServicio, ServiciosResencia> idservicio;

}

