package com.demo.second.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class ProductInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String productname;
	private String price;

	public ProductInfo() {
		super();
		
	}

	public ProductInfo(int id, String productname, String price) {
		super();
		this.id = id;
		this.productname = productname;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductInfo [id=" + id + ", productname=" + productname + ", price=" + price + "]";
	}

}
