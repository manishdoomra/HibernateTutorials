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
	
	@Id
	@Column(name="employee_id")
	private int id;
	@Column(name="employee_name")
	private String name;
	
	public Employee(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
