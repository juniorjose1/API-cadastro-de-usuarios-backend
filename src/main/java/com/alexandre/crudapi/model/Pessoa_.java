package com.alexandre.crudapi.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pessoa.class)
public abstract class Pessoa_ {

	public static volatile SingularAttribute<Pessoa, String> idade;
	public static volatile SingularAttribute<Pessoa, String> grupo;
	public static volatile SingularAttribute<Pessoa, String> nome;
	public static volatile SingularAttribute<Pessoa, Long> id;
	public static volatile SingularAttribute<Pessoa, String> sexo;
	public static volatile SingularAttribute<Pessoa, String> status;

	public static final String IDADE = "idade";
	public static final String GRUPO = "grupo";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String SEXO = "sexo";
	public static final String STATUS = "status";

}

