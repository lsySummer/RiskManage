package edu.nju.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.LOGGER;
import edu.nju.ParamMap;
import edu.nju.dao.BaseDao;
import edu.nju.dao.RiskPlanDao;
import edu.nju.model.PlanItem;
import edu.nju.model.RiskItem;
import edu.nju.model.RiskPlan;
import edu.nju.model.RiskState;
import edu.nju.vo.RiskItemVO;

@Repository
public class RiskPlanDaoImpl implements RiskPlanDao{
	
	@Autowired
	private BaseDao baseDao;

	@Override
	public boolean addRiskPlan(RiskPlan plan) {
		try {
			baseDao.save(plan);
			return true;
		}catch(Exception e){
			LOGGER.log(e);
			return false;
		}
	}

	@Override
	public boolean itemAdd(RiskItem risk, int pid, int followId) {
		try {
			boolean notExisted = this.baseDao.find(RiskItem.class, new ParamMap("username", risk.getName())).isEmpty();
			if (notExisted) {
				baseDao.save(risk);
				RiskState state=new RiskState();
				state.setCreateTime(new Date());
				state.setDetail("建立风险条目");
				state.setState("新建");
				state.setIfHappen(1);
				state.setPid(pid);
				state.setRid(risk.getId());
				baseDao.save(state);
				PlanItem planItem=new PlanItem();
				planItem.setCreateTime(new Date());
				planItem.setFollowerId(followId);
				planItem.setPid(pid);
				planItem.setRid(risk.getId());
				planItem.setState("新建");
				planItem.setStateId(state.getId());
				baseDao.save(planItem);
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			LOGGER.log(e);
			return false;
		}
	}

	@Override
	public boolean itemDelete(int rid, int pid) {
		ParamMap map = new ParamMap("rid", rid)
				.append("pid", pid);
		List<PlanItem> result = this.baseDao.find(PlanItem.class, map);
		if (!result.isEmpty()) {
			baseDao.delete(result.get(0));
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean itemModify(RiskItem risk, int pid, int followId) {
		try{
			baseDao.update(risk);
			ParamMap map = new ParamMap("rid", risk.getId())
					.append("pid", pid);
			List<PlanItem> result = this.baseDao.find(PlanItem.class, map);
			if (!result.isEmpty()) {
				result.get(0).setFollowerId(followId);
				baseDao.update(result.get(0));
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			LOGGER.log(e);
			return false;
		}
	}

	@Override
	public List<RiskItemVO> find(String keyword, int pid) {
		String hql0="from PlanItem where pid="+pid;
		List<PlanItem> planList=baseDao.find(hql0);
		for(PlanItem item:planList){
			int rid=item.getRid();
			RiskItem riskItem=baseDao.load(RiskItem.class, rid);
			if(riskItem.getName().contains(keyword)){
				
			}
		}
		
		List<RiskItem> list=baseDao.find(hql);
		List<RiskItemVO> resultList=new ArrayList<RiskItemVO>();
		for(RiskItem item:list){
			RiskItemVO vo=new RiskItemVO();
			
			resultList.add(vo);
		}
		return null;
	}

	@Override
	public List<RiskItemVO> showAll(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RiskPlan> getSubmitPlans(int submitterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RiskPlan> getFollowPlans(int followId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RiskItemVO> getFollowItem(int followId, int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RiskState> getState(int pid, int rid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addState(RiskState state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean importRisk(int rid, int pid, int followId) {
		// TODO Auto-generated method stub
		return false;
	}

}
