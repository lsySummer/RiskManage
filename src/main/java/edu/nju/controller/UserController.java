package edu.nju.controller;

import edu.nju.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.nju.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam(value = "role", required = false) String role,
            HttpSession session) {
        User user = this.userService.login(username, password, role);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/risk/plan/list";
        } else {
            return "index";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam(value = "role", required = false) String role,
            HttpSession session) {
        User user = this.userService.register(username, password, role);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/risk/list";
        } else {
            return "index";
        }
    }
}
