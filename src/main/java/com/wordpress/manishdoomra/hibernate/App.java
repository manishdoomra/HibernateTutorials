package com.wordpress.manishdoomra.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wordpress.manishdoomra.hibernate.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
	private static SessionFactory sessionFactory;
	
	public static Session initializeDatabase(){
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		return session;
	}
	
	public static void saveEmployeeInDB(Session session, Employee employee){
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}
	
	private static Employee getEmployee(int id, String name){
		return new Employee(id, name);
	}
	
	private static void closeDB(){
		sessionFactory.close();
	}
	
	public static void main( String[] args )
    {
		Session session = initializeDatabase();
		Employee employee = getEmployee(1, "Manish");
		saveEmployeeInDB(session, employee);
		closeDB();
    }
}
