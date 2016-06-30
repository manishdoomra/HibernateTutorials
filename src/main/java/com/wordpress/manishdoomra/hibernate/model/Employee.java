/**
 * 
 */
package com.wordpress.manishdoomra.hibernate.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author manish
 *
 */
@Entity
@Table(name="Employee_details")
public class Employee {
	
	
	private EmployeeUniqueId uniqueId;
	
	private String name;
	
	private Date dateOfJoining;
	
	private Address homeAddress;
	
	private Address officeAddress; 
	
	private String description;
	
	private Set<String> alternateContactNumbers = new HashSet<String>();
	
	@Basic
	@Temporal(TemporalType.DATE)
	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
	
	@Lob
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@ElementCollection	
	public Set<String> getAlternateContactNumbers() {
		return alternateContactNumbers;
	}

	public void setAlternateContactNumbers(Set<String> alternateContactNumbers) {
		this.alternateContactNumbers = alternateContactNumbers;
	}

	public Employee(){
		//Required by JPA, while fetching the data from DB
	}

		
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="city", column=@Column(name="HOME_CITY")),
		@AttributeOverride(name="state", column=@Column(name="HOME_STATE")),
		@AttributeOverride(name="pinCode", column=@Column(name="HOME_PINCODE"))
	})
	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="city", column=@Column(name="OFFICE_CITY")),
		@AttributeOverride(name="state", column=@Column(name="OFFICE_STATE")),
		@AttributeOverride(name="pinCode", column=@Column(name="OFFICE_PINCODE"))
	})
	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Employee(String name){
		this.name = name;
	}
	
	public Employee(String name, EmployeeUniqueId uniqueId){
		this.name = name;
		this.uniqueId = uniqueId;
	}
	
	
	@Column(name="employee_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@EmbeddedId
	public EmployeeUniqueId getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(EmployeeUniqueId uniqueId) {
		this.uniqueId = uniqueId;
	}

}
