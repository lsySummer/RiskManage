package edu.nju.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.nju.service.RiskPlanService;
import edu.nju.service.RiskService;
import edu.nju.service.StatisticsService;

@Controller
public class TestController {
	
	 @Autowired
	 private RiskPlanService service;
	
	 @Autowired
	 private RiskService riskService;
	 
	 @Autowired
	 private StatisticsService staService;
	 
	 @RequestMapping(value = "/test")
	 public void test(){
		 
		/* RiskPlan plan=new RiskPlan();
		 plan.setPlanName("需求管理计划");
		 plan.setProjectName("需求管理系统");
		 plan.setUid(1);
		 service.addRiskPlan(plan);
		 
		 RiskPlan plan1=new RiskPlan();
		 plan1.setPlanName("设计计划");
		 plan1.setProjectName("教学系统");
		 plan1.setUid(1);
		 service.addRiskPlan(plan1);*/
		 
		 
	/*	 RiskItem item=new RiskItem();
		 item.setContent("测试id");
		 item.setName("测试id需求");
		 item.setLevel("1级");
		 item.setPossibility("123");
		 item.setRiskTrigger("沟通不当");
		 service.itemAdd(item, 31, 2);*/
		 
		/* RiskItem item=riskService.getById(34);
		 item.setContent("修改了测试id");
		 item.setName("修改id需求");
		 item.setLevel("1级");
		 item.setPossibility("123");
		 item.setRiskTrigger("沟通不当");
		 service.itemModify(item, 31, 2);
		 
		System.out.println("size1??"+service.showAll(31).size());
		 System.out.println("查找！！！"+service.find("测试", 31).size());
		 service.itemDelete(37, 31);
		 System.out.println("size2??"+service.showAll(31).size());
		 System.out.println("查找！！！"+service.find("测试", 31).size());*/
		 
	/*	System.out.println(service.getSubmitPlans(1).size());
		System.out.println(service.getFollowItem(2, 31));
		System.out.println(service.getFollowPlans(2));*/
		 
	/*	 RiskState state=new RiskState();
		 state.setCreateTime(new Date());
		 state.setDetail("这里有一些状态");
		 state.setIfHappen(0);
		 state.setPid(31);
		 state.setRid(34);
		 state.setState("风险发生");
		 service.addState(state);
		 
		 RiskState state1=new RiskState();
		 state1.setCreateTime(new Date());
		 state1.setDetail("那里有一些状态");
		 state1.setIfHappen(0);
		 state1.setPid(31);
		 state1.setRid(34);
		 state1.setState("再一次发生");
		 service.addState(state1);
		 
		System.out.println(service.getState(31, 34));*/
		 
//		 service.importRisk(37, 31, 1);
		 
		 //@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss.S")
		 staService.happenMost(startTime, endTime);
		 staService.identifyMost(startTime, endTime);
	 }

}
