package edu.nju.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.dao.BaseDao;
import edu.nju.dao.RiskDao;
import edu.nju.model.RiskItem;
import edu.nju.model.RiskState;

@Repository
public class RiskDaoImpl implements RiskDao{
	@Autowired
	private BaseDao baseDao;

	@Override
	public boolean add(RiskItem risk) {
		try{
			baseDao.save(risk);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		try{
			baseDao.delete(RiskItem.class,id);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean modify(RiskItem risk) {
		try{
			baseDao.update(risk);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RiskItem> show() {
		return baseDao.getAllList(RiskItem.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RiskItem> find(String keyword) {
		String str = "from RiskItem s where s.content like \'%" + keyword + "%\'";
		List<RiskItem> list = baseDao.find(str);
		return list;
	}

	@Override
	public boolean addState(RiskState state) {
		try{
			baseDao.save(state);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RiskState> getAllState() {
		return baseDao.getAllList(RiskState.class);
	}

	@Override
	public RiskState getStateById(int id) {
		RiskState state=(RiskState) baseDao.load(RiskState.class, id);
		return state;
	}
	
	
}
