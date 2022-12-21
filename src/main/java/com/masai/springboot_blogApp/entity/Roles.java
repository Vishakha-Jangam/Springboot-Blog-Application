package com.masai.springboot_blogApp.entity;

import jakarta.persistence.*;

@Entity
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long RoleId;
	
	@Column(length = 60)
    private String name;

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(long roleId, String name) {
		super();
		RoleId = roleId;
		this.name = name;
	}

	public long getRoleId() {
		return RoleId;
	}

	public void setRoleId(long roleId) {
		RoleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Roles [RoleId=" + RoleId + ", name=" + name + "]";
	}
	
	
}