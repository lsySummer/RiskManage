package edu.nju.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import edu.nju.model.RiskItem;
import edu.nju.vo.StatVO;

public interface StatisticsService {
	
	//获得特定时间内被识别最多的风险
	public List<StatVO> identifyMost(Date startTime, Date endTime);

	//获得特定时间内出现问题最多的风险
	public List<StatVO> happenMost(Date startTime, Date endTime);
}
