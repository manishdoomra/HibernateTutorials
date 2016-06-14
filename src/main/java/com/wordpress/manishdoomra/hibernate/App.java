package com.wordpress.manishdoomra.hibernate;

import java.util.Date;

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
	
	private static Session initializeDatabase(){
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		return session;
	}
	
	private static void saveEmployeeInDB(Session session, Employee employee){
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}
	
	private static Employee getEmployee(int id, String name){
		Employee employee = new Employee(id, name);
		employee.setDateOfJoining(new Date());
		employee.setAddress("Address of "+name);
		employee.setDescription("description of "+name);
		return employee;
	}
	
	private static void closeDB(){
		sessionFactory.close();
	}
	
	private static void fetchAnEmployeeById(int id){
		Session fetchSession = sessionFactory.openSession();
		Employee employeeFetchedFromDb = fetchSession.get(Employee.class, id);
		fetchSession.close();
		System.out.println("Employee name fetched from DB : - "+employeeFetchedFromDb.getName());
	}
	
	public static void doHibernateStuff(){
		Session session = initializeDatabase();
		int id=1;
		Employee employee = getEmployee(id, "Manish");
		saveEmployeeInDB(session, employee);
		fetchAnEmployeeById(id);
		closeDB();
	}
	
	public static void main( String[] args )
    {
		doHibernateStuff();
    }
}
