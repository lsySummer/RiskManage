package edu.nju.dao;

import java.util.List;

import edu.nju.model.RiskItem;
import edu.nju.model.RiskPlan;
import edu.nju.model.RiskState;
import edu.nju.vo.RiskItemVO;

public interface RiskPlanDao {

	boolean addRiskPlan(RiskPlan plan);

	boolean itemAdd(RiskItem risk, int pid, int followId);

	boolean itemDelete(int rid, int pid);

	boolean itemModify(RiskItem risk, int pid, int followId);

	List<RiskItemVO> find(String keyword, int pid);

	List<RiskItemVO> find(String keyword, int pid, int followerId);

	RiskItemVO getRiskItem(int pid, int rid);

	List<RiskItemVO> showAll(int pid);

	List<RiskPlan> getSubmitPlans(int submitterId);

	List<RiskPlan> getFollowPlans(int followId);

	List<RiskItemVO> getFollowItem(int followId, int pid);

	List<RiskState> getState(int pid, int rid);

	boolean addState(RiskState state);

	boolean importRisk(int rid, int pid, int followId);

	RiskPlan getById(int id);

}
