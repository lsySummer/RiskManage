package edu.nju.service.impl;

import java.util.List;

import edu.nju.model.RiskItem;
import edu.nju.model.RiskPlan;
import edu.nju.model.RiskState;
import edu.nju.service.RiskPlanService;
import edu.nju.vo.RiskItemVO;

public class RiskPlanServiceImpl implements RiskPlanService{

	@Override
	public boolean addRiskPlan(RiskPlan plan) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean itemAdd(RiskItem risk, int pid, int followId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean itemDelete(int rid, int pid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean itemModify(RiskItem risk, int pid, int followId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<RiskItemVO> find(String keyword, int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RiskItemVO> showAll(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RiskPlan> getSubmitPlans(int submitterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RiskPlan> getFollowPlans(int followId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RiskItemVO> getFollowItem(int followId, int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RiskState> getState(int pid, int rid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addState(RiskState state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean importRisk(int rid, int pid, int followId) {
		// TODO Auto-generated method stub
		return false;
	}

}
