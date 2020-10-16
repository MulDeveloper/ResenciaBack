package com.resencia.backoffice.app.AccesoPersonal.Dominio;

import com.resencia.backoffice.app.Personal.Dominio.PersonalResencia;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AccesoPersonalResencia.class)
public abstract class AccesoPersonalResencia_ {

	public static volatile SingularAttribute<AccesoPersonalResencia, String> passwordPersonal;
	public static volatile SingularAttribute<AccesoPersonalResencia, Integer> idacceso;
	public static volatile SingularAttribute<AccesoPersonalResencia, String> username;
	public static volatile SingularAttribute<AccesoPersonalResencia, PersonalResencia> idpersonal;

}

