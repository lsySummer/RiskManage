package edu.nju.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nju.dao.StatisticsDao;
import edu.nju.model.RiskItem;
import edu.nju.service.StatisticsService;

@Service
public class StatisticsServiceImpl implements StatisticsService{

	@Autowired
	private StatisticsDao dao;
	
	@Override
	public List<RiskItem> identifyMost(Date startTime, Date endTime) {
		return dao.identifyMost(startTime,endTime);
	}

	@Override
	public Map<RiskItem,Integer> happenMost(Date startTime, Date endTime) {
		return dao.happenMost(startTime,endTime);
	}

}
