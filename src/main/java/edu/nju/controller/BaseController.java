package edu.nju.controller;

import edu.nju.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

abstract class BaseController {

    @Autowired
    protected HttpSession session;

    @Autowired
    protected HttpServletRequest request;

    @ModelAttribute
    protected User getUser() {
        return (User) session.getAttribute("user");
    }
}
