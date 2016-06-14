/**
 * 
 */
package com.wordpress.manishdoomra.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author manish
 *
 */
@Entity(name="Employee_details")
public class Employee {
	
	
	private int id;
	
	private String name;
	
	public Employee(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	@Id
	@Column(name="employee_id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="employee_name")
	public String getName() {
		return name + " from getter";
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
