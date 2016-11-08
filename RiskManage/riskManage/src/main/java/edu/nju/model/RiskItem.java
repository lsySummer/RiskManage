package edu.nju.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="risk_item")
public class RiskItem {

	private int id;
	private String content;//内容
	private String possibility;//可能性
	private String level;//影响程度(高？低)
	private String riskTrigger;//触发器
	private String submitter;		//提交者
	private String follower;	//跟踪者
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getSubmitter() {
		return submitter;
	}
	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}
	public String getFollower() {
		return follower;
	}
	public void setFollower(String follower) {
		this.follower = follower;
	}
	
	@Override
	public String toString() {
		return "RiskItem [id=" + id + ", content=" + content + ", possibility=" + possibility
				+ ", level=" + level+ ", riskTrigger=" + riskTrigger + ", submitter=" + submitter + ", follower=" + follower  + "]";
	}
}
