package com.linyk3.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.linyk3.bean.Bus;
import com.linyk3.bean.BusReq;
import com.linyk3.bean.Line;
import com.linyk3.bean.QueryBusRes;
import com.linyk3.bean.QueryBusResBody;
import com.linyk3.bean.QueryLineRes;
import com.linyk3.bean.QueryLineResBody;
import com.linyk3.bean.ResHeader;
import com.linyk3.bean.User;
import com.linyk3.service.BusService;
import com.linyk3.service.UserServiceImpl;


@Controller
public class LoginController {
	Logger logger = Logger.getLogger(LoginController.class);
    @Autowired
    private UserServiceImpl userService;
    
    @Autowired 
    private BusService busService;
    
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
    	QueryLineRes res = new QueryLineRes();
    	ResHeader head = new ResHeader();
    	QueryLineResBody body = new QueryLineResBody();
    	if(req == null || req.getBody() == null || req.getBody().getLine() == null) {
    		head.setRTNSTS("EEEE");
    		head.setERRMSG("参数错误");
    		res.setHead(head);
    		request.getSession().setAttribute("data",JSON.toJSONString(res));
            return "json";
    	}
    	String line = req.getBody().getLine();
    	List<Line> stationList = busService.queryLineByLine(line);
		logger.info(stationList);
    	if(stationList == null || stationList.isEmpty())
    	{
    		head.setRTNSTS("EEEE");
    		head.setERRMSG("参数line错误");
    		res.setHead(head);
    		request.getSession().setAttribute("data",JSON.toJSONString(res));
            return "json";
    	}
    	body.setStationList(stationList);
    	
    	head.setRTNSTS("0000");
		head.setERRMSG("查询线路成功");
		res.setHead(head);	
		res.setBody(body);
		request.getSession().setAttribute("data",JSON.toJSONString(res));
        return "json";
    }
    
    @RequestMapping(value = "/QueryLocation.do")
    public String queryBus(HttpServletRequest request) {
    	String param = request.getParameter("param");
    	logger.info(param);
    	BusReq req = JSONObject.parseObject(param, BusReq.class);
    	logger.info(req.getBody());
    	QueryBusRes res = new QueryBusRes();
    	ResHeader head = new ResHeader();
    	QueryBusResBody body = new QueryBusResBody();
    	if(req == null || req.getBody() == null || req.getBody().getLine() == null
    			|| req.getBody().getStanum() == null) {
    		head.setRTNSTS("EEEE");
    		head.setERRMSG("参数错误");
    		res.setHead(head);
    		request.getSession().setAttribute("data",JSON.toJSONString(res));
            return "json";
    	}
    	String line = req.getBody().getLine();
    	String stanum = req.getBody().getStanum();

    	Bus bus = busService.queryBus(line);
    	logger.info(bus);
    	if(bus == null) {
    		head.setRTNSTS("EEEE");
    		head.setERRMSG("参数line错误");
    		res.setHead(head);
    		request.getSession().setAttribute("data",JSON.toJSONString(res));
            return "json";
    	}
    	
    	//班车位置到站点stanum的距离时间
    	Line station = busService.queryLineByLineAndStanum(line, stanum);
    	logger.info(station);
    	if(station == null) {
    		head.setRTNSTS("EEEE");
    		head.setERRMSG("参数stanum错误");
    		res.setHead(head);
    		request.getSession().setAttribute("data",JSON.toJSONString(res));
            return "json";
    	}
    	
    	
    
    	head.setRTNSTS("0000");
		head.setERRMSG("查询位置成功");
		res.setHead(head);	
		res.setBody(body);
		request.getSession().setAttribute("data",JSON.toJSONString(res));
        return "json";
    }
    
}