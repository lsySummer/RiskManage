package edu.nju.service;

import java.util.List;

import edu.nju.model.RiskItem;
import edu.nju.model.RiskPlan;
import edu.nju.model.RiskState;
import edu.nju.vo.RiskItemVO;

public interface RiskPlanService {
	
	public boolean addRiskPlan(RiskPlan plan);
	public RiskPlan getById(int id);

	//某个风险管理计划中的风险条目的增删改查(pid:风险管理计划的id,rid:风险条目id,followId:跟踪者id)
	public boolean itemAdd(RiskItem risk, int pid,int followId);
	public boolean itemDelete(int rid, int pid);
	public boolean itemModify(RiskItem risk,int pid,int followId);
	public List<RiskItemVO> find(String keyword, int pid);
	
	//获得某个风险计划里的全部风险条目
	public List<RiskItemVO> showAll(int pid);
	
	//获得某个人提交的风险计划(默认风险计划下所有的风险条目都是他提交的)
	public List<RiskPlan> getSubmitPlans(int submitterId);
	
	//获得某个人跟踪的风险计划
	public List<RiskPlan> getFollowPlans(int followId);
	
	//获得某个人跟踪的计划中，自己负责跟踪的风险条目
	public List<RiskItemVO> getFollowItem(int followId,int pid);
	
	//风险管理计划中风险状态的管理
	public List<RiskState> getState(int pid, int rid);
	public boolean addState(RiskState state);
	
	//导入风险条目(需要额外指定跟踪着)
	public boolean importRisk(int rid, int pid,int followId);
}
