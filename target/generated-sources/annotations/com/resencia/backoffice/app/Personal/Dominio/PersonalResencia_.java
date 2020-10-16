package com.resencia.backoffice.app.Personal.Dominio;

import com.resencia.backoffice.app.AccesoPersonal.Dominio.AccesoPersonalResencia;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PersonalResencia.class)
public abstract class PersonalResencia_ {

	public static volatile ListAttribute<PersonalResencia, AccesoPersonalResencia> accesoPersonalResenciaList;
	public static volatile SingularAttribute<PersonalResencia, String> emailPersonal;
	public static volatile SingularAttribute<PersonalResencia, String> apellidoPersonal;
	public static volatile SingularAttribute<PersonalResencia, String> nombrePersonal;
	public static volatile SingularAttribute<PersonalResencia, String> telefono;
	public static volatile SingularAttribute<PersonalResencia, Integer> idpersonal;
	public static volatile ListAttribute<PersonalResencia, RolesResencia> rolesResenciaList;

}

