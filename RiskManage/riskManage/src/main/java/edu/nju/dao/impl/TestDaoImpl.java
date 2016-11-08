package edu.nju.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.dao.BaseDao;
import edu.nju.dao.TestDao;
import edu.nju.model.First;

@Repository
public class TestDaoImpl implements TestDao{

	@Autowired
	private BaseDao baseDao;
	
	@Override
	public String addName(String name) {
		First f = new First();
		f.setName(name);
		baseDao.save(f);
		return "success";
	}

}
