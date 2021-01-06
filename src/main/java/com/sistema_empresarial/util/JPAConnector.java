package com.sistema_empresarial.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sistema_empresarial.model.Funcionario;

public class JPAConnector {
	private static JPAConnector instance;
	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;
	
	public static JPAConnector getInstance() {
		if(instance == null) {return new JPAConnector();}
		return  instance;
	}
	private JPAConnector() {
		entityManager = getEntityManager();
	}
	public EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("sistema-empresarial");
		if(entityManager == null) {
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}
	public void closeConnection() {
		entityManager.close();
		entityManagerFactory.close();	
	}
}
