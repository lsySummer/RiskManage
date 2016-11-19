package edu.nju.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.dao.BaseDao;
import edu.nju.dao.StatisticsDao;
import edu.nju.model.PlanItem;
import edu.nju.model.RiskItem;
import edu.nju.model.RiskState;

@Repository
public class StatisticsDaoImpl implements StatisticsDao{

	@Autowired
	private BaseDao baseDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RiskItem> identifyMost(Date startTime, Date endTime) {
		String hql = "from PlanItem where createTime >= :startTime and createTime <= :endTime order by count(*)";
		List<PlanItem> planList=baseDao.getSession().createQuery(hql).setParameter("startTime", startTime).setParameter("endTime", endTime).getResultList();
		List<RiskItem> result=new ArrayList<RiskItem>();
		for(PlanItem plan:planList){
			int rid=plan.getRid();
			RiskItem item=baseDao.load(RiskItem.class, rid);
			result.add(item);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RiskItem> happenMost(Date startTime, Date endTime) {
		String hql = "from RiskState where createTime >= :startTime and createTime <= :endTime and ifHappen=0 order by count(*)";
		List<RiskState> stateList=baseDao.getSession().createQuery(hql).setParameter("startTime", startTime).setParameter("endTime", endTime).getResultList();
		List<RiskItem> result=new ArrayList<RiskItem>();
		for(RiskState state:stateList){
			int rid=state.getRid();
			RiskItem item=baseDao.load(RiskItem.class, rid);
			result.add(item);
		}
		return result;
	}

}
