package edu.nju.service;

import java.util.List;

import edu.nju.model.RiskItem;
import edu.nju.model.RiskPlan;
import edu.nju.model.RiskState;

public interface RiskPlanService {
	public boolean addRiskPlan(RiskPlan plan);//新建风险管理计划

	//某个风险管理计划中的风险条目的增删改查(pid:风险管理计划的id,rid:风险条目id)
	public boolean planAdd(RiskItem risk, int pid);
	public boolean planDelete(int rid, int pid);
	public boolean planModify(RiskItem risk);
	public List<RiskItem> find(String keyword, int pid);
	public List<RiskItem> showAll(int pid);
	
	//获得某个人提交的风险计划
	public List<RiskPlan> getSubmitPlans(int submitterId);
	//获得某个人跟踪的风险计划
	public List<RiskPlan> getFollowPlans(int followId);
	
	//风险管理计划中风险状态的管理
	public List<RiskState> getState(int pid, int rid);
	public boolean addState(RiskState state, int pid);

	public boolean importRisk(int rid, int pid);
}
