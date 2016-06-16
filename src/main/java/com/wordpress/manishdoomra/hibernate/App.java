package com.wordpress.manishdoomra.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wordpress.manishdoomra.hibernate.model.Address;
import com.wordpress.manishdoomra.hibernate.model.Employee;
import com.wordpress.manishdoomra.hibernate.model.EmployeeUniqueId;

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
	
	private static Employee getEmployee(String name){
		Employee employee = new Employee(name);
		employee.setDateOfJoining(new Date());
		Address address = getHomeAddress(name);
		Address offcAddress = getOfficeAddress(name);
		employee.setHomeAddress(address);
		employee.setOfficeAddress(offcAddress);
		employee.setDescription("description of "+name);
		return employee;
	}
	
	private static Employee getEmployee(String name, String email, String mobile){
		Employee employee = new Employee(name, new EmployeeUniqueId(email, mobile));
		employee.setDateOfJoining(new Date());
		Address address = getHomeAddress(name);
		Address offcAddress = getOfficeAddress(name);
		employee.setHomeAddress(address);
		employee.setOfficeAddress(offcAddress);
		employee.setDescription("description of "+name);
		return employee;
	}
	
	private static Address getHomeAddress(String name){
		Address address = new Address();
		address.setCity("Home city of "+name);
		address.setState("Home state of "+name);
		address.setPinCode("Home pinCode of "+name);
		return address;
	}
	
	private static Address getOfficeAddress(String name){
		Address address = new Address();
		address.setCity("Office city of "+name);
		address.setState("Office state of "+name);
		address.setPinCode("Office pinCode of "+name);
		return address;
	}
	
	private static void closeDB(Session session){
		session.close();
		sessionFactory.close();
	}
	
	private static void fetchAnEmployeeById(Session session, int id){
		Employee employeeFetchedFromDb = session.get(Employee.class, new EmployeeUniqueId("hari.krishan.doomra@wordpress.com", "+91-9XXXXYYXXX"));
		System.out.println("Employee name fetched from DB : - "+employeeFetchedFromDb.getName());
	}
	
	public static void doHibernateStuff(){
		Session session = initializeDatabase();
		int id=2;
		Employee employee = getEmployee("Manish", "manish.doomra@wordpress.com", "+91-9XXXXXXXXX");
		Employee employee1 = getEmployee("Hari Krishan", "hari.krishan.doomra@wordpress.com", "+91-9XXXXYYXXX");
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
