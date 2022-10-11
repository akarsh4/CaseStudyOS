package com.sonata.model;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.boot.context.properties.bind.Name;
@Entity
public class user {
	@Id
	private String user_name;
	private long user_phone;
	private String user_email;
	private String user_address;
	public String getUser_name() {
		return user_name;
	}
	
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public double getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(long user_phone) {
		this.user_phone =  user_phone;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public user(String user_name, long user_phone, String user_email, String user_address) {
		super();
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.user_email = user_email;
		this.user_address = user_address;
	}
	
	public  user() {
		
	}
}
