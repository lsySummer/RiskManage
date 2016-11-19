package edu.nju.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<RiskItem,Integer>  identifyMost(Date startTime, Date endTime) {
		String hql = "from PlanItem where createTime >= :startTime and createTime <= :endTime";
		List<PlanItem> planList=baseDao.getNewSession().createQuery(hql).setParameter("startTime", startTime).setParameter("endTime", endTime).getResultList();
		int []ss=new int[planList.size()];
		RiskItem[] itemArr=new RiskItem[planList.size()];
		for(int i=0;i<planList.size();i++){
			PlanItem plan=planList.get(i);
			int rid=plan.getRid();
			ss[i]=rid;
			RiskItem item=baseDao.load(RiskItem.class, rid);
			itemArr[i]=item;
		}
		
		Map<RiskItem,Integer> map = new HashMap<RiskItem,Integer>();

		for (int i = 0; i < ss.length; i++) {
			int count = 0;
			for (int j = 0; j < ss.length; j++) {
				if (ss[i] == (ss[j])) {
					count = count + 1;
				}
			}
			// 为了不打印重复的，放入map中去掉重复的
			map.put(itemArr[i], count);
		}
		
		
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<RiskItem,Integer> happenMost(Date startTime, Date endTime) {
		String hql = "from RiskState where createTime >= :startTime and createTime <= :endTime and ifHappen=0";
		List<RiskState> stateList=baseDao.getNewSession().createQuery(hql).setParameter("startTime", startTime).setParameter("endTime", endTime).getResultList();
		int []ss=new int[stateList.size()];
		RiskItem[] itemArr=new RiskItem[stateList.size()];
		for(int i=0;i<stateList.size();i++){
			RiskState state=stateList.get(i);
			int rid=state.getRid();
			ss[i]=rid;
			RiskItem item=baseDao.load(RiskItem.class, rid);
			itemArr[i]=item;
		}
		
		Map<RiskItem,Integer> map = new HashMap<RiskItem,Integer>();

		for (int i = 0; i < ss.length; i++) {
			int count = 0;
			for (int j = 0; j < ss.length; j++) {
				if (ss[i] == (ss[j])) {
					count = count + 1;
				}
			}
			// 为了不打印重复的，放入map中去掉重复的
			map.put(itemArr[i], count);
		}
		
		
		return map;
	}

}
