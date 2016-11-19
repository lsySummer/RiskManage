package edu.nju.service;

import java.util.List;

import edu.nju.model.User;

public interface UserService {
	public User register(String username,String password,String role);
	
	public User login(String username,String password,String role);		
	
	public List<User> showAll();
	
	public User getById(int id);

}
