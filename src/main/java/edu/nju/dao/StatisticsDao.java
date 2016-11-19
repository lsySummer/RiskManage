package edu.nju.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import edu.nju.model.RiskItem;

public interface StatisticsDao {

	List<RiskItem> identifyMost(Date startTime, Date endTime);

	Map<RiskItem,Integer> happenMost(Date startTime, Date endTime);

}
