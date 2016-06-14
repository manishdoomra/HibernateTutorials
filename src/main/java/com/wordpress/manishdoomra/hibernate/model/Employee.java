/**
 * 
 */
package com.wordpress.manishdoomra.hibernate.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @author manish
 *
 */
@Entity
@Table(name="Employee_details")
public class Employee {
	
	
	private int id;
	
	private String name;
	
	private Date dateOfJoining;
	
	private String address;
	
	private String description;
	
	@Basic
	@Temporal(TemporalType.DATE)
	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
	@Transient
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Lob
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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
