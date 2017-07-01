package com.wowwebapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wow_user")
public class UserEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
    public int id;
	
	@Column(name = "username")
	public String username;
	
	@Column(name = "password")
	public String password;
	
	public UserEntity(){
		
	}
	
	public UserEntity(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return this.password;
	}
}
