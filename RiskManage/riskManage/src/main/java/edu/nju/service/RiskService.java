package edu.nju.service;

import java.util.List;

import edu.nju.model.RiskItem;
import edu.nju.model.RiskState;

/**
 * @author lsy
 */
public interface RiskService {
	//风险条目增删改查
	public boolean add(RiskItem risk);	
	public boolean delete(int id);
	public boolean modify(RiskItem risk);
	public List<RiskItem> show();
	public List<RiskItem> find(String keyword);
	
	//风险状态增、查
	public boolean addState(RiskState state);
	public List<RiskState> getAllState();
	public RiskState getStateById(int id);
}
