package com.LINK.ServiceGateway;



public class ImageReponse {
	private String description;
	private String userName;
	private Long id;
	private String url;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return this.url;
	}
}
