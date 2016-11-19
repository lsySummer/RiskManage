package edu.nju.service;

import java.util.List;

import edu.nju.model.RiskItem;
import edu.nju.model.RiskPlan;
import edu.nju.model.RiskState;

public interface RiskPlanService {
	public boolean addRiskPlan(RiskPlan plan);

	public boolean planAdd(RiskItem risk, int pid);

	public boolean planDelete(int rid, int pid);

	public boolean planModify(RiskItem risk);
	
	public List<RiskPlan> getAllPlans();

	public List<RiskItem> find(String keyword, int pid);

	public List<RiskItem> showAll(int pid);

	public RiskItem getById(int rid);

	public List<RiskState> getState(int pid, int rid);

	public boolean addState(RiskState state, int pid);

	public boolean importRisk(int rid, int pid);
}
