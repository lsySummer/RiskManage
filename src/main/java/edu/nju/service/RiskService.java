package edu.nju.service;

import java.util.List;

import edu.nju.model.RiskItem;

/**
 * @author lsy
 */
public interface RiskService {
	//获得全部风险条目
	public List<RiskItem> show();
	public RiskItem getById(int rid);	
}
