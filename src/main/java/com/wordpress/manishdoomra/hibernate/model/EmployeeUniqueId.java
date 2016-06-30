package com.wordpress.manishdoomra.hibernate.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EmployeeUniqueId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String mobile;
	
	
	public EmployeeUniqueId(){
		
	}
	
	public EmployeeUniqueId(String email, String mobile){
		this.email = email;
		this.mobile = mobile;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result	+ ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((mobile ==  null) ? 0 : mobile.hashCode());
		return result;
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeUniqueId other = (EmployeeUniqueId) obj;
		if (email == null && mobile == null) {
			if (other.email != null && other.mobile !=null)
				return false;
		} else if (!email.equals(other.email) && !mobile.equals(other.mobile))
			return false;		
		return true;
	}

}
