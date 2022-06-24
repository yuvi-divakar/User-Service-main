package com.twad.UserService.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;

import com.twad.UserService.service.ResponseEntity;

public class UserDetailsDAO implements ResponseEntity, Serializable {
	
	@Id
	private Integer id;
	private String username;
	private String email;
	private String mobile1;
	private String mobile2;
	private List<String> roles;
	private List<String> departments;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile1() {
		return mobile1;
	}
	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}
	public String getMobile2() {
		return mobile2;
	}
	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public List<String> getDepartments() {
		return departments;
	}
	public void setDepartments(List<String> departments) {
		this.departments = departments;
	}
	public UserDetailsDAO(Integer id, String username, String email, String mobile1, String mobile2, List<String> roles,
			List<String> departments) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.mobile1 = mobile1;
		this.mobile2 = mobile2;
		this.roles = roles;
		this.departments = departments;
	}

	public UserDetailsDAO() {
		
	}
	
}
