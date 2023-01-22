package com.jspiders.hibernate1.codestandraitaion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate1.dto.StudentDTO;

public class StudentDAO {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		
		factory = Persistence.createEntityManagerFactory("student");
		
		manager = factory.createEntityManager();
		
		transaction = manager.getTransaction();
	}
	
	private static void closeConnection() {
		
		if (factory != null) {
			factory.close();
		}
		
		if (manager != null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}
	
	public static void main(String[] args) {
		
		openConnection();
		
		transaction.begin();
		StudentDTO student = new StudentDTO();
		
		student.setId(2);
		student.setName("LOKESH");
		student.setEmail("lokesh@gmail.com");
		student.setContact(9876543210L);
		student.setCity("PUNE");
		
		manager.persist(student);
		
		transaction.commit();
		closeConnection();
	}
}
