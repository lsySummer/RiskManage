package edu.nju.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.nju.model.RiskItem;
import edu.nju.model.RiskState;
import edu.nju.model.User;
import edu.nju.service.RiskService;
import edu.nju.service.UserService;

@SuppressWarnings("serial")
@Controller
public class RiskAction extends BaseAction {
	@Autowired
	RiskService riskService;
	@Autowired
	UserService userService;

	public String add() {
		String name = request.getParameter("rname");
		String content = request.getParameter("rcontent");
		String possibility = request.getParameter("rpossible");
		String influence = request.getParameter("rinfluence");
		String trig = request.getParameter("rtrig");
		int follower = Integer.parseInt(request.getParameter("folSelect"));
		User user = (User) session.get("user");
		if (user == null) {
			request.setAttribute("error", "未登录或登录失效，请重新登录");
			return "login";
		}
		RiskItem r = new RiskItem();
		r.setName(name);
		r.setContent(content);
		r.setPossibility(possibility);
		r.setLevel(influence);
		r.setRiskTrigger(trig);
		r.setSubmitterId(user.getId());
		r.setSubName(user.getUsername());
		r.setFollowerId(follower);
		User userf = userService.getById(follower);
		r.setFolName(userf.getUsername());
		boolean result = riskService.add(r);
		if (result) {
			List<RiskItem> rlist = riskService.getSubmitItem(user.getId());
			request.setAttribute("rList", rlist);
			request.setAttribute("type", 0);
			return "success";
		} else {
			return "error";
		}
	}

	public String toRisk() {
		List<User> uList = userService.showAll();
		request.setAttribute("uList", uList);
		return "success";
	}

	public String toState() {
		List<User> uList = userService.showAll();
		request.setAttribute("uList", uList);
		User u = (User) session.get("user");
		if (u == null) {
			request.setAttribute("error", "未登录或登录失效，请重新登录");
			return "login";
		}
		List<RiskItem> rList = riskService.getFollowItem(u.getId());
		request.setAttribute("rList", rList);
		request.setAttribute("type", 1);
		return "success";
	}

	public String showState() {
		int id = Integer.parseInt(request.getParameter("hiddenCourseId"));
		RiskItem item = riskService.getItemById(id);
		request.setAttribute("itemName", item.getName());
		request.setAttribute("itemId", item.getId());
		List<RiskState> slist = riskService.getState(id);
		request.setAttribute("slist", slist);
		return "success";
	}

	public String addState() {
		String rdescription = request.getParameter("rdescription");
		String rdetail = request.getParameter("rdetail");
		int id = Integer.parseInt(request.getParameter("rid"));
		RiskState s = new RiskState();
		s.setCreateTime(new Date());
		s.setDetail(rdetail);
		s.setState(rdescription);
		s.setRid(id);
		riskService.addState(s);
		RiskItem item = riskService.getItemById(id);
		List<RiskState> slist = riskService.getState(id);
		request.setAttribute("slist", slist);
		request.setAttribute("itemName", item.getName());
		request.setAttribute("itemId", id);
		return "success";
	}

	public String riskType() {
		String type = request.getParameter("riskSelect");
		User user = (User) session.get("user");
		if (user == null) {
			request.setAttribute("error", "未登录或登录失效，请重新登录");
			return "login";
		}
		if (type.equals("0")) {
			List<RiskItem> rlist = riskService.getSubmitItem(user.getId());
			request.setAttribute("rList", rlist);
			request.setAttribute("type", 0);
		} else {
			List<RiskItem> rlist = riskService.getFollowItem(user.getId());
			request.setAttribute("rList", rlist);
			request.setAttribute("type", 1);
		}
		return "success";
	}

}
