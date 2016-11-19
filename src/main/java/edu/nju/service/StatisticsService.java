package edu.nju.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import edu.nju.model.RiskItem;

public interface StatisticsService {
	
	//获得特定时间内被识别最多的风险
	public List<RiskItem> identifyMost(Date startTime, Date endTime);

	//获得特定时间内出现问题最多的风险
	public Map<RiskItem,Integer> happenMost(Date startTime, Date endTime);
}
