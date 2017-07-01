package com.wowwebapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wow_products")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	private String category;
	private String brand;
	private String size;
	private float price;
	private int quantity;
	private int discount;
	
	public ProductEntity(){
		
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setCategory(String category){
		this.category = category;
	}
	
	public String getCategory(){
		return this.category;
	}
	
	public void setBrand(String brand){
		this.brand = brand;
	}
	
	public String getBrand(){
		return this.brand;
	}
	
	public void setSize(String size){
		this.size = size;
	}
	
	public String getSize(){
		return this.size;
	}
	
	public void setPrice(float price){
		this.price = price;
	}
	
	public float getPrice(){
		return this.price;
	}
	
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	public int getQuantity(){
		return this.quantity;
	}
	
	public void setDiscount(int discount){
		this.discount = discount;
	}
	
	public int getDiscount(){
		return this.discount;
	}
		
}
