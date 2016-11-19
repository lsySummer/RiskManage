package edu.nju.dao;

import java.util.Date;
import java.util.List;

import edu.nju.model.RiskItem;

public interface StatisticsDao {

	List<RiskItem> identifyMost(Date startTime, Date endTime);

	List<RiskItem> happenMost(Date startTime, Date endTime);

}
