package edu.nju.model;

import edu.nju.vo.RiskItemVO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="risk_item")
public class RiskItem {

	private int id;
	private String name;
	private String content;//内容
	private String possibility;//可能性
	private String level;//影响程度(高？低)
	private String riskTrigger;//触发器
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "RiskItem [id=" + id + ", content=" + content + ", possibility=" + possibility
				+ ", level=" + level+ ", riskTrigger=" + riskTrigger +  "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RiskItemVO) {
			return this.id == ((RiskItemVO)obj).getRid();
		} else if (obj instanceof RiskItem){
			return this.id == ((RiskItem)obj).id;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (content != null ? content.hashCode() : 0);
		result = 31 * result + (possibility != null ? possibility.hashCode() : 0);
		result = 31 * result + (level != null ? level.hashCode() : 0);
		result = 31 * result + (riskTrigger != null ? riskTrigger.hashCode() : 0);
		return result;
	}
}
