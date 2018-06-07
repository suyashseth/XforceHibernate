package com.dev.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dev.beans.UserInfo;

public class UserOperation {

	public static void main(String[] args) {
		
		Configuration config = new Configuration().configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		
		UserInfo user = new UserInfo();
		user.setUser_id(12);
		user.setFirstname("blake");
		user.setLastname("rockford");
		user.setEmail("blake@rock");
		user.setPassword("qwerty");
		
		session.getTransaction().begin();
		
		session.save(user);
		session.getTransaction().commit();
		
		session.close();
		
		factory.close();
		
			
		
	}

}
