package edu.nju.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nju.dao.TestDao;
import edu.nju.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	TestDao testDao;
	
	@Override
	public String test(String text) {
		System.out.println(text);
		return testDao.addName(text);
	}

}
