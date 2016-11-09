package edu.nju.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.nju.model.RiskItem;
import edu.nju.service.RiskService;

@SuppressWarnings("serial")
@Controller
public class RiskAction extends BaseAction{
	@Autowired
	RiskService riskService;
	
	public String add(){
		String content=request.getParameter("content");
		String possibility=request.getParameter("possibility");
		String influence=request.getParameter("influence");
		String trig=request.getParameter("trig");
		String submiter=request.getParameter("submiter");
		String follower=request.getParameter("follower");
		RiskItem r=new RiskItem();
		r.setContent(content);
		r.setPossibility(possibility);
		r.setLevel(influence);
		r.setRiskTrigger(trig);
		r.setSubmitterId(Integer.parseInt(submiter));
		r.setFollowerId(Integer.parseInt(follower));
		boolean result=riskService.add(r);
		if(result==true){
			return "success";
		}else{
			return "error";
		}
	}
	
}
