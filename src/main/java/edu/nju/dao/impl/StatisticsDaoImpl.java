package edu.nju.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.dao.BaseDao;
import edu.nju.dao.StatisticsDao;
import edu.nju.model.PlanItem;
import edu.nju.model.RiskItem;

@Repository
public class StatisticsDaoImpl implements StatisticsDao{

	@Autowired
	private BaseDao baseDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RiskItem> identifyMost(Date startTime, Date endTime) {
//		String hql = "from PlanItem where createTime >= :startTime and createTime <= :endTime";
//		List<PlanItem> result=baseDao.getSession().createQuery(hql).setParameter("startTime", startTime).setParameter("endTime", endTime).getResultList();
//		
		return null;
	}

	@Override
	public List<RiskItem> happenMost(Date startTime, Date endTime) {
		// TODO Auto-generated method stub
		return null;
	}

}
