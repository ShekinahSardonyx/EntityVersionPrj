package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Admin;
import com.cg.entity.User;
import com.cg.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	
	
	public String addAdmin(Admin admin) {
		User user = new User();
		if(user.getRole().equals("Admin")) {
			admin.setAdminUsername(user.getUserId());
			admin.setAdminPassword(user.getPassword());
			adminRepository.save(admin);
			return "Admin Added Successfully";
		}
		return "Not an Admin";
	}
	
	public Admin updateAdminPassword(int id, String pwd) {
		Admin admin = adminRepository.findById(id).get();
		admin.setAdminPassword(pwd);
		adminRepository.flush();
		return admin;
	}
	
	public Admin updateAdminName(int id, String username) {
		Admin admin = adminRepository.findById(id).get();
		admin.setAdminUsername(username);;
		adminRepository.flush();
		return admin;
	}
	public List<Admin> deleteAdmin(int id) {
		adminRepository.deleteById(id);
		return adminRepository.findAll();
	}
	
	/*public List<Customer> waitingList(){
		
	}*/
}
