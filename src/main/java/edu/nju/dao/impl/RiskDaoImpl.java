package edu.nju.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.Log;
import edu.nju.ParamMap;
import edu.nju.dao.BaseDao;
import edu.nju.dao.RiskDao;
import edu.nju.model.RiskItem;
import edu.nju.model.RiskState;

@Repository
public class RiskDaoImpl implements RiskDao {
	@Autowired
	private BaseDao baseDao;

	@Override
	public boolean add(RiskItem risk) {
		try {
			baseDao.save(risk);
			int id = risk.getId();
			RiskState state = new RiskState();
			state.setRid(id);
			state.setCreateTime(new Date());
			state.setDetail("建立风险条目");
			state.setState("新建");
			addState(state);
			return true;
		} catch (Exception e) {
			Log.log(e);
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			baseDao.delete(RiskItem.class, id);
			return true;
		} catch (Exception e) {
			Log.log(e);
			return false;
		}
	}

	@Override
	public boolean modify(RiskItem risk) {
		try {
			baseDao.update(risk);
			return true;
		} catch (Exception e) {
			Log.log(e);
			return false;
		}
	}

	@Override
	public List<RiskItem> show() {
		return baseDao.getAllList(RiskItem.class);
	}

	@Override
	public List<RiskItem> find(String keyword) {
		String str = "from RiskItem s where s.content like \'%" + keyword
				+ "%\'";
		return baseDao.find(str);
	}

	@Override
	public boolean addState(RiskState state) {
		try {
			baseDao.save(state);
			return true;
		} catch (Exception e) {
			Log.log(e);
			return false;
		}
	}

	@Override
	public List<RiskState> getAllState() {
		return baseDao.getAllList(RiskState.class);
	}

	@Override
	public RiskState getStateById(int id) {
		RiskState state = baseDao.load(RiskState.class, id);
		return state;
	}

	@Override
	public List<RiskItem> getSubmitItem(int userId) {
		return this.baseDao.find(
				RiskItem.class,
				new ParamMap("submitterId", userId));
	}

	@Override
	public List<RiskState> getSubmitState(int riskId) {
		return this.baseDao.find(RiskState.class, new ParamMap("rid", riskId));
	}

	@Override
	public List<RiskItem> getFollowItem(int userId) {
		return this.baseDao.find(
				RiskItem.class,
				new ParamMap("followerId", userId));
	}

	@Override
	public RiskItem getItemById(int id) {
		return this.baseDao.load(RiskItem.class, id);
	};

}
