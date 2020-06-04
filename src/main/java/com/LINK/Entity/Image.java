package com.LINK.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Table;
import org.springframework.stereotype.Component;
@Entity
@Component
@Table(appliesTo = "image")
public class Image {
	@Column(name="idimage" ,nullable = false, unique = true)
	private @Id @GeneratedValue Long idimage;
	@Column(name="descripcion")
	private String description;
	@Column(name="user_name")
	private String userName;
	@Column(name="url")
	private String url;
	
	public Image() {}
	public Image(String description, String userName, String url) {
	 this.description=description;
	 this.userName=userName;
	 this.url = url;
	}
	
	public String getUrl() {
		return this.url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getId() {
		return idimage;
	}
	public void setId(Long id) {
		this.idimage = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String nombre) {
		this.description = nombre;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
