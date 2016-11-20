package edu.nju.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Tuple;

public interface StatisticsDao {

	List<Tuple> identifyMost(Date startTime, Date endTime);

	List<Tuple> happenMost(Date startTime, Date endTime);

}
