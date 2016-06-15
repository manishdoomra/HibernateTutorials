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
	}
	
	private static Employee getEmployee(int id, String name){
		Employee employee = new Employee(id, name);
		employee.setDateOfJoining(new Date());
		employee.setAddress("Address of "+name);
		employee.setDescription("description of "+name);
		return employee;
	}
	
	private static Employee getEmployee(String name){
		Employee employee = new Employee(name);
		employee.setDateOfJoining(new Date());
		employee.setAddress("Address of "+name);
		employee.setDescription("description of "+name);
		return employee;
	}
	
	private static void closeDB(Session session){
		session.close();
		sessionFactory.close();
	}
	
	private static void fetchAnEmployeeById(Session session, int id){
		Employee employeeFetchedFromDb = session.get(Employee.class, id);
		System.out.println("Employee name fetched from DB : - "+employeeFetchedFromDb.getName());
	}
	
	public static void doHibernateStuff(){
		Session session = initializeDatabase();
		int id=2;
		Employee employee = getEmployee(id, "Manish");
		Employee employee1 = getEmployee("Hari Krishan");
		saveEmployeeInDB(session, employee);
		saveEmployeeInDB(session, employee1);
		fetchAnEmployeeById(session, id);
		closeDB(session);
	}
	
	public static void main( String[] args )
    {
		doHibernateStuff();
    }
}
