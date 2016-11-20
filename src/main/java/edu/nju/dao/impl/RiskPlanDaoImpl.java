package edu.nju.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
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
				state.setIfHappen(true);
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
		List<RiskItemVO> resultList=new ArrayList<RiskItemVO>();
		List<PlanItem> planList=baseDao.find(PlanItem.class, "pid", pid);
		for(PlanItem item:planList){
			int rid=item.getRid();
			RiskItem riskItem=baseDao.load(RiskItem.class, rid);
			if(riskItem.getName().contains(keyword)){
				resultList.add(this.toVO(item, riskItem));
			}
		}

		return resultList;
	}

	@Override
	public List<RiskItemVO> find(String keyword, int pid, int followerId) {
		List<RiskItemVO> resultList=new ArrayList<RiskItemVO>();
		List<PlanItem> planList=baseDao.find(PlanItem.class, new ParamMap("pid", pid).append("followerId", followerId));
		for(PlanItem item:planList){
			int rid=item.getRid();
			RiskItem riskItem=baseDao.load(RiskItem.class, rid);
			if(riskItem.getName().contains(keyword)){
				resultList.add(this.toVO(item, riskItem));
			}
		}

		return resultList;
	}

	@Override
	public RiskItemVO getRiskItem(int pid, int rid) {
		List<PlanItem> plans = this.baseDao.find(PlanItem.class,"pid", pid);

		if (plans.isEmpty()) {
			return null;
		}

		RiskItem risk = this.baseDao.load(RiskItem.class, rid);
		return this.toVO(plans.get(0), risk);
	}

	public String getStateById(int id){
		RiskState state=baseDao.load(RiskState.class,id);
		return state.getState();
	}

	@Override
	public List<RiskItemVO> showAll(int pid) {
		String hql="from PlanItem where pid="+pid;
		List<PlanItem> planList=baseDao.find(hql);
		return this.getVOs(planList);
	}

	@Override
	public List<RiskPlan> getSubmitPlans(int submitterId) {
		return baseDao.find(RiskPlan.class, "uid", submitterId);
	}

	@Override
	public List<RiskPlan> getFollowPlans(int followId) {
		List<PlanItem> list=baseDao.find(PlanItem.class, "followerId", followId);
		List<RiskPlan> result=new ArrayList<RiskPlan>();
        HashSet<Integer> added = new HashSet<>();
        for(PlanItem item:list){
			int pid=item.getPid();
            if (added.add(pid)) {
                RiskPlan riskPlan=baseDao.load(RiskPlan.class, pid);
                result.add(riskPlan);
            }
		}
		return result;
	}

	@Override
	public List<RiskItemVO> getFollowItem(int followId, int pid) {
		List<PlanItem> list=baseDao.find(PlanItem.class, new ParamMap("followerId", followId).append("pid", pid));
		return this.getVOs(list);
		}

	@Override
	public List<RiskState> getState(int pid, int rid) {
		return baseDao.find(RiskState.class,new ParamMap("rid", rid).append("pid", pid));
	}

	@Override
	public boolean addState(RiskState state) {
		try{
			baseDao.save(state);
			int rid=state.getRid();
			int pid=state.getPid();
			List<PlanItem> planList=baseDao.find(PlanItem.class, new ParamMap("rid", rid).append("pid", pid));
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
			state.setIfHappen(true);
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
		return baseDao.load(RiskPlan.class, id);
	}

	private RiskItemVO toVO(PlanItem item, RiskItem riskItem) {
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

		return vo;
	}

	private List<RiskItemVO> getVOs(List<PlanItem> list) {
		ArrayList<RiskItemVO> result = new ArrayList<>();
		for (PlanItem item : list) {
			int rid = item.getRid();
			RiskItem riskItem = this.baseDao.load(RiskItem.class, rid);
			result.add(this.toVO(item, riskItem));
		}
		return result;
	}
}
