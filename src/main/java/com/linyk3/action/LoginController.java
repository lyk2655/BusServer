package com.linyk3.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.linyk3.bean.User;
import com.linyk3.service.UserServiceImpl;


@Controller
public class LoginController {
	
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/")
    public String loginPage() {
        return "index";
    }
    
    
    @RequestMapping(value = "/test")
    public String testMybatis(HttpServletRequest request) {
    	User user = userService.getUserByUsername("linyk3");
    	System.out.println(user);
    	request.getSession().setAttribute("data", user);
        return "json";
    }
}