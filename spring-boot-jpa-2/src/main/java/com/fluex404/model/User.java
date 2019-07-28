package com.fluex404.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "first_name")
	private String firstname;
	@Column(name = "last_name")
	private String lastname;
	@Column(name = "created_date")
	private Date createddate;
	private Integer age;
	private Integer active;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String firstname, String lastname, Integer age, Integer active) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.createddate = new Date();
		this.age = age;
		this.active = active;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstname + ", lastName=" + lastname + ", created_date="
				+ createddate + ", age=" + age + ", active=" + active + "]";
	}
	
}
