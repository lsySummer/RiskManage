package edu.nju.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
		String hql = "from PlanItem where createTime >= :startTime and createTime <= :endTime";
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
	public Map<RiskItem,Integer> happenMost(Date startTime, Date endTime) {
		String hql = "from RiskState where createTime >= :startTime and createTime <= :endTime and ifHappen=0";
		List<RiskState> stateList=baseDao.getSession().createQuery(hql).setParameter("startTime", startTime).setParameter("endTime", endTime).getResultList();
		List<RiskItem> result=new ArrayList<RiskItem>();
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
		
		Comparator<Map.Entry<RiskItem,Integer>> valueComparator = new Comparator<Map.Entry<RiskItem,Integer>>() {
			@Override
			public int compare(Entry<RiskItem,Integer> o1,
					Entry<RiskItem,Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue()-o1.getValue();
			}
		};
		// map转换成list进行排序
		List<Map.Entry<RiskItem,Integer>> list = new ArrayList<Map.Entry<RiskItem,Integer>>(map.entrySet());
		// 排序
		Collections.sort(list,valueComparator);
		
		return map;
	}

}
