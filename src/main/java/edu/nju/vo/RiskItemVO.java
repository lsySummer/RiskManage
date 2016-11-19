package edu.nju.vo;

import java.util.Date;

public class RiskItemVO {
	
	private int pid;//风险计划id
	private int rid;//风险条目id
	private String name;
	private String content;//内容
	private String possibility;//可能性
	private String level;//影响程度(高？低)
	private String riskTrigger;//触发器
	private String currentState;	//当前状态
	private Date createTime;	//创建时间
	private String followName;//跟踪者
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPossibility() {
		return possibility;
	}
	public void setPossibility(String possibility) {
		this.possibility = possibility;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getRiskTrigger() {
		return riskTrigger;
	}
	public void setRiskTrigger(String riskTrigger) {
		this.riskTrigger = riskTrigger;
	}
	public String getCurrentState() {
		return currentState;
	}
	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getFollowName() {
		return followName;
	}
	public void setFollowName(String followName) {
		this.followName = followName;
	}
	
	
	
	

}
