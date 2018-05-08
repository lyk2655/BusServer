package com.linyk3.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.linyk3.bean.BusReq;
import com.linyk3.bean.User;
import com.linyk3.service.UserServiceImpl;


@Controller
public class LoginController {
	Logger logger = Logger.getLogger(LoginController.class);
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/")
    public String loginPage() {
        return "index";
    }
    
    @RequestMapping(value = "/test")
    public String testMybatis(HttpServletRequest request) {
    	User user = userService.getUserByUsername("linyk3");
    	logger.info(user);
    	request.getSession().setAttribute("data", user);
        return "json";
    }
    
    @RequestMapping(value = "/BusLine.do")
    public String queryLine(HttpServletRequest request) {
    	String param = request.getParameter("param");
    	logger.info(param);
    	BusReq req = JSONObject.parseObject(param, BusReq.class);
    	logger.info(req.getBody());
    
    	request.getSession().setAttribute("data", req.getBody());
        return "json";
    }
    
}