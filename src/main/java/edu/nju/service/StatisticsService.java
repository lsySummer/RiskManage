package edu.nju.service;

import java.util.Date;
import java.util.List;

import edu.nju.model.RiskItem;

public interface StatisticsService {
	public List<RiskItem> identifyMost(Date startTime, Date endTime);

	public List<RiskItem> happenMost(Date startTime, Date endTime);
}
