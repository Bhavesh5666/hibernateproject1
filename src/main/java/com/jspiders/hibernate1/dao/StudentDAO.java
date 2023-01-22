package com.jspiders.hibernate1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate1.dto.StudentDTO;

public class StudentDAO {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		
		StudentDTO student = new StudentDTO();
		
		student.setId(1);
		student.setName("Bhavesh");
		student.setEmail("bhavesh@gmail.com");
		student.setContact(8768775765l);
		student.setCity("Pune");
		
		entityManager.persist(student);
		entityTransaction.commit();
		
		entityManagerFactory.close();
		entityManager.clear();
	}

}
