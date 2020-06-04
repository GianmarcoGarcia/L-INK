package com.LINK.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Table;

import lombok.Data;
@Data
@Entity
@Table(appliesTo = "user")
public class User {
	@Column(name="iduser" ,nullable = false, unique = true)
	private @Id @GeneratedValue Long id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="user_name")
	private String userName;
	@Column(name="info")
	private String info;
	public User() {}
	public User(String firstName,String lastName,String userName) {
		this.firstName=firstName;
		this. lastName=lastName;
		this. userName=userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String name) {
		this.firstName = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

}
