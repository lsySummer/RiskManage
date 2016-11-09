package edu.nju.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.nju.model.User;
import edu.nju.service.UserService;

@SuppressWarnings("serial")
@Controller
public class UserAction extends BaseAction{
	
	@Autowired
	UserService userService;
	
	public String login(){
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String role=request.getParameter("role");
		User user=userService.register(username, password, role);
		if(user==null){
			return "error";
		}else{
			return "success";
			
		}
	}
}
