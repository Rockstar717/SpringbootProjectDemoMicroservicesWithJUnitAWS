package com.demo.first.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	// @NotEmpty=@NotNull or NotEmpty
	// @Pattern(regexp = "^((?!).)*$", message = "hdfhd")
	@NotEmpty(message = "Cannot invoke null or Empty")
	private String name;
	@Email(message = "Email address is not valid !!")
	private String email;
	@NotEmpty
	private String city;
	@NotEmpty
	private String password;

	public UserInfo() {
		super();
	}

	public UserInfo(int id, String name, String email, String city, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.city = city;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", email=" + email + ", city=" + city + ", password="
				+ password + "]";
	}

}
