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
import edu.nju.dao.UserDao;
import edu.nju.model.PlanItem;
import edu.nju.model.RiskItem;
import edu.nju.model.RiskPlan;
import edu.nju.model.RiskState;
import edu.nju.vo.RiskItemVO;

@Repository
public class RiskPlanDaoImpl implements RiskPlanDao{
	
	@Autowired
	private BaseDao baseDao;
	@Autowired
	private UserDao userDao;

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
			boolean notExisted = this.baseDao.find(RiskItem.class, new ParamMap("name", risk.getName())).isEmpty();
			if (notExisted) {
				baseDao.save(risk);
				System.out.println("riskId"+risk.getId());
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
		List<RiskState> state=baseDao.find(RiskState.class,map);
		if (!result.isEmpty()) {
			baseDao.delete(result.get(0));
			baseDao.delete(state.get(0));
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
		List<RiskItemVO> resultList=new ArrayList<RiskItemVO>();
		List<PlanItem> planList=baseDao.find(hql0);
		for(PlanItem item:planList){
			int rid=item.getRid();
			RiskItem riskItem=baseDao.load(RiskItem.class, rid);
			if(riskItem.getName().contains(keyword)){
				RiskItemVO vo = new RiskItemVO();
				vo.setContent(riskItem.getContent());
				vo.setLevel(riskItem.getLevel());
				vo.setName(riskItem.getName());
				vo.setPossibility(riskItem.getPossibility());
				vo.setRid(riskItem.getId());
				vo.setRiskTrigger(riskItem.getRiskTrigger());
				vo.setCreateTime(item.getCreateTime());
				vo.setCurrentState(getStateById(item.getStateId()));
				vo.setFollowName(userDao.getById(item.getFollowerId()).getUsername());
				vo.setPid(item.getPid());
				resultList.add(vo);
			}
		}
		
		return resultList;
	}
	
	public String getStateById(int id){
		RiskState state=baseDao.load(RiskState.class,id);
		return state.getState();
	}
	
	@Override
	public List<RiskItemVO> showAll(int pid) {
		String hql="from PlanItem where pid="+pid;
		List<PlanItem> planList=baseDao.find(hql);
		List<RiskItemVO> resultList=new ArrayList<RiskItemVO>();
		for(PlanItem item:planList){
			int rid=item.getRid();
			RiskItem riskItem=baseDao.load(RiskItem.class, rid);
			RiskItemVO vo = new RiskItemVO();
			vo.setContent(riskItem.getContent());
			vo.setLevel(riskItem.getLevel());
			vo.setName(riskItem.getName());
			vo.setPossibility(riskItem.getPossibility());
			vo.setRid(riskItem.getId());
			vo.setRiskTrigger(riskItem.getRiskTrigger());
			vo.setCreateTime(item.getCreateTime());
			vo.setCurrentState(getStateById(item.getStateId()));
			vo.setFollowName(userDao.getById(item.getFollowerId()).getUsername());
			vo.setPid(item.getPid());
			resultList.add(vo);
		}
		return resultList;
	}

	@Override
	public List<RiskPlan> getSubmitPlans(int submitterId) {
		String hql="from RiskPlan where uid="+submitterId;
		List<RiskPlan> list=baseDao.find(hql);
		return list;
	}

	@Override
	public List<RiskPlan> getFollowPlans(int followId) {
		String hql="from PlanItem where followerId="+followId;
		List<PlanItem> list=baseDao.find(hql);
		List<RiskPlan> result=new ArrayList<RiskPlan>();
		for(PlanItem item:list){
			int pid=item.getPid();
			RiskPlan riskPlan=baseDao.load(RiskPlan.class, pid);
			result.add(riskPlan);
		}
		return result;
	}

	@Override
	public List<RiskItemVO> getFollowItem(int followId, int pid) {
		String hql="from PlanItem where followerId="+followId+" and pid="+pid;
		List<PlanItem> list=baseDao.find(hql);
		List<RiskItemVO> result=new ArrayList<RiskItemVO>();
		for(PlanItem item:list){
			int rid=item.getRid();
			RiskItem riskItem=baseDao.load(RiskItem.class, rid);
			RiskItemVO vo = new RiskItemVO();
			vo.setContent(riskItem.getContent());
			vo.setLevel(riskItem.getLevel());
			vo.setName(riskItem.getName());
			vo.setPossibility(riskItem.getPossibility());
			vo.setRid(riskItem.getId());
			vo.setRiskTrigger(riskItem.getRiskTrigger());
			vo.setCreateTime(item.getCreateTime());
			vo.setCurrentState(getStateById(item.getStateId()));
			vo.setFollowName(userDao.getById(item.getFollowerId()).getUsername());
			vo.setPid(item.getPid());
			result.add(vo);
		}
			return result;
		}

	@Override
	public List<RiskState> getState(int pid, int rid) {
		String hql="from RiskState where pid="+pid+" and rid="+rid;
		List<RiskState> list=baseDao.find(hql);
		return list;
	}

	@Override
	public boolean addState(RiskState state) {
		try{
			baseDao.save(state);
			int rid=state.getRid();
			int pid=state.getPid();
			String hql="from PlanItem where rid="+rid+" and pid="+pid;
			List<PlanItem> planList=baseDao.find(hql);
			if(planList.size()>0){
				PlanItem plan=planList.get(0);
				plan.setState(state.getState());
				plan.setStateId(state.getId());
				baseDao.update(plan);
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean importRisk(int rid, int pid, int followId) {
		try{
			RiskState state=new RiskState();
			state.setCreateTime(new Date());
			state.setDetail("建立风险条目");
			state.setState("新建");
			state.setIfHappen(1);
			state.setPid(pid);
			state.setRid(rid);
			baseDao.save(state);
			
			PlanItem item=new PlanItem();
			item.setCreateTime(new Date());
			item.setFollowerId(followId);
			item.setPid(pid);
			item.setRid(rid);
			item.setState("新建");
			item.setStateId(state.getId());
			baseDao.save(item);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public RiskPlan getById(int id) {
		RiskPlan plan=baseDao.load(RiskPlan.class, id);
		return plan;
	}

}
