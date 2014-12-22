 package com.qiheng.hibernate;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Test1 {
	public static SessionFactory sessionFactory;

	static {
		try {
			Configuration cfg = new Configuration().configure();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(cfg.getProperties()).buildServiceRegistry();
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		StudentPrimaryKey primaryKey = new StudentPrimaryKey();
		primaryKey.setName("qiheng");
		primaryKey.setNumber(123);
		Student student = new Student();
		student.setPrimaryKey(primaryKey);
		student.setAge(21);
		student.setTimestamp(new Timestamp(new Date().getTime()));
		
		StudentPrimaryKey primaryKey1 = new StudentPrimaryKey();
		primaryKey1.setName("zhangsan");
		primaryKey1.setNumber(321);
		Student student1 = new Student();
		student1.setPrimaryKey(primaryKey1);
		student1.setAge(53);
		student1.setTimestamp(new Timestamp(new Date().getTime()));
		
		try{
			tx = session.beginTransaction();
			session.save(student);
			session.save(student1);
			
			
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		
		
		}finally{
			session.close();
		}
		
		
	}
}

