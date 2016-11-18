package edu.nju.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.nju.LOGGER;
import edu.nju.model.User;
import edu.nju.service.RiskService;
import edu.nju.service.UserService;

@SuppressWarnings("serial")
@Controller
public class UserAction extends BaseAction {

	@Autowired
	UserService userService;
	@Autowired
	RiskService riskService;

	public String login() {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		User user = userService.login(username, password, role);
		if (user == null) {
			request.setAttribute("error", "用户名或密码错误");
			return ERROR;
		} else {
			List<User> uList = userService.showAll();
			request.setAttribute("uList", uList);
			session.put("user", user);
			return SUCCESS;
		}
	}

	public String register() {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		try {

			User user = userService.register(username, password, role);
			if (user == null) {
				request.setAttribute("error", "用户名已存在");
				return "repeat";
			} else {
				List<User> uList = userService.showAll();
				request.setAttribute("uList", uList);
				session.put("user", user);
				return SUCCESS;
			}
		} catch (Exception e) {
			LOGGER.log(e);
			return ERROR;
		}
	}
}
