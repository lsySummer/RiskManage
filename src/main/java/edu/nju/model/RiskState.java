package edu.nju.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="risk_state")
public class RiskState {
	private int id;
	private int pid;	//风险管理计划id
	private int rid;	//风险条目id
	private String state;		//状态(概括描述)
	private boolean ifHappen;	//标志位，代表风险是否发生。0代表发生，1代表不发生
	private String detail;			//详细描述
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createTime;			//建立状态时间
	

	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public boolean isIfHappen() {
		return ifHappen;
	}
	public void setIfHappen(boolean ifHappen) {
		this.ifHappen = ifHappen;
	}
	@Override
	public String toString() {
		return "RiskState [id=" + id + ", rid=" + rid + ", state=" + state
				+ ", detail=" + detail+ ", createTime=" + createTime + "]";
	}
	
}
