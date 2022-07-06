package com.cg.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
	
	public User getByUserId(String id);
	public User findByUserIdAndPassword(String id ,String password);
	public User findByUserIdAndPasswordAndRole(String id,String password,String Role);
    public List<User> deleteByUserId(String id);

}
