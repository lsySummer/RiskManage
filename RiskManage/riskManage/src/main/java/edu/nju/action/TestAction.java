package edu.nju.action;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.nju.service.TestService;

@Controller
public class TestAction extends BaseAction {

	@Autowired
	private TestService testService;

	public String execute() throws ServletException, IOException {
		System.out.println("hello");
		String text = request.getParameter("txt");
		return testService.test(text);
	}
}
