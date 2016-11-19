package edu.nju.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nju.dao.UserDao;
import edu.nju.model.User;
import edu.nju.service.UserService;

@Service 
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public User register(String username, String password, String role) {
		return userDao.register(username,password,role);
	}

	@Override
	public User login(String username, String password, String role) {
		return userDao.login(username,password,role);
	}

	@Override
	public List<User> showAll() {
		return userDao.showAll();
	}

	@Override
	public User getById(int id) {
		return userDao.getById(id);
	}

}
