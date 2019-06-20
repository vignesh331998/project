package com.cts.dto;

public class User {
	int cid,id,age;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	String cname,name,gender,password;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	long contactNumber;
	int roleId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contact) {
		this.contactNumber = contact;
	}
	

	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public User(int id, int age, String name, String gender, String password, int contactNumber,int roleId) {
		super();
		//this.id = id;
		this.age = age;
		this.name = name;
		this.gender = gender;
		this.password = password;
		this.contactNumber = contactNumber;
		
		this.roleId = roleId;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserTable [id=" + id + ", age=" + age + ", name=" + name + ", gender=" + gender + ", password="
				+ password + ", contactNumber=" + contactNumber + ", roleId=" + roleId + "]";
	}
}
