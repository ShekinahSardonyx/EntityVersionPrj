package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Admin extends User{

	private int adminId;
	@Column
	private String adminUsername;
	@Column
	private String adminPassword;
	@Column
	private String adminEmailId;
	public Admin() {

	}
	public Admin(int adminId, String adminUsername, String adminPassword, String adminEmailId) {
		super();
		this.adminId = adminId;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
		this.adminEmailId = adminEmailId;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	public String getAdminEmailId() {
		return adminEmailId;
	}
	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminUsername=" + adminUsername + ", adminPassword=" + adminPassword
				+ ", adminEmailId=" + adminEmailId + "]";
	}
	
	
	
	
	
	
}
