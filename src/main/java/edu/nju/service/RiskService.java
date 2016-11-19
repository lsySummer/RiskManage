package edu.nju.service;

import java.util.List;

import edu.nju.model.RiskItem;
import edu.nju.model.RiskPlan;
import edu.nju.model.RiskState;

/**
 * @author lsy
 */
public interface RiskService {
	//风险条目增删改查
	public boolean add(RiskItem risk);	//风险条目输入
	public List<RiskItem> show();
	
	public List<RiskItem>  getSubmitItem(int userId);//提交者查看自己提交的全部风险条目
	public List<RiskItem>  getFollowItem(int userId);//跟踪者查看自己跟踪的全部风险条目
	
	public RiskItem getById(int rid);	
}
