package edu.nju.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nju.dao.RiskPlanDao;
import edu.nju.model.RiskItem;
import edu.nju.model.RiskPlan;
import edu.nju.model.RiskState;
import edu.nju.service.RiskPlanService;
import edu.nju.vo.RiskItemVO;

@Service
public class RiskPlanServiceImpl implements RiskPlanService{

	@Autowired
	private RiskPlanDao riskplanDao;
	
	@Override
	public boolean addRiskPlan(RiskPlan plan) {
		return riskplanDao.addRiskPlan(plan);
	}

	@Override
	public boolean itemAdd(RiskItem risk, int pid, int followId) {
		return riskplanDao.itemAdd(risk,pid,followId);
	}

	@Override
	public boolean itemDelete(int rid, int pid) {
		return riskplanDao.itemDelete(rid,pid);
	}

	@Override
	public boolean itemModify(RiskItem risk, int pid, int followId) {
		return riskplanDao.itemModify(risk,pid,followId);
	}

	@Override
	public List<RiskItemVO> find(String keyword, int pid) {
		return riskplanDao.find(keyword,pid);
	}

	@Override
	public RiskItemVO getRiskItem(int pid, int rid) {
		return riskplanDao.getRiskItem(pid, rid);
	}

	@Override
	public List<RiskItemVO> showAll(int pid) {
		return riskplanDao.showAll(pid);
	}

	@Override
	public List<RiskPlan> getSubmitPlans(int submitterId) {
		return riskplanDao.getSubmitPlans(submitterId);
	}

	@Override
	public List<RiskPlan> getFollowPlans(int followId) {
		return riskplanDao.getFollowPlans(followId);
	}

	@Override
	public List<RiskItemVO> getFollowItem(int followId, int pid) {
		return riskplanDao.getFollowItem(followId,pid);
	}

	@Override
	public List<RiskItemVO> find(String keyword, int pid, int followerId) {
		return this.riskplanDao.find(keyword, pid, followerId);
	}

	@Override
	public List<RiskState> getState(int pid, int rid) {
		return riskplanDao.getState(pid,rid);
	}

	@Override
	public boolean addState(RiskState state) {
		return riskplanDao.addState(state);
	}

	@Override
	public boolean importRisk(int rid, int pid, int followId) {
		return riskplanDao.importRisk(rid,pid,followId);
	}

	@Override
	public RiskPlan getById(int id) {
		return riskplanDao.getById(id);
	}

}
