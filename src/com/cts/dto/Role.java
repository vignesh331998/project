package com.cts.dto;

public class Role {
	int id;
	String name;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int id,String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}

	
}

	