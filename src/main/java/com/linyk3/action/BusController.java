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
import com.linyk3.bean.GAPI_DISTANCE;
import com.linyk3.bean.GAPI_DISTANCE_PARAMETERS;
import com.linyk3.bean.Line;
import com.linyk3.bean.QueryBusRes;
import com.linyk3.bean.QueryBusResBody;
import com.linyk3.bean.QueryLineRes;
import com.linyk3.bean.QueryLineResBody;
import com.linyk3.bean.ResHeader;
import com.linyk3.service.BusService;
import com.linyk3.service.UserServiceImpl;
import com.linyk3.util.GapiUtil;

@Controller
public class BusController {
	Logger logger = Logger.getLogger(BusController.class); 
    @Autowired 
    private BusService busService;
    
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
    	body.setBus(bus);
    	
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
    	
    	StringBuffer ori = new StringBuffer();
		StringBuffer des = new StringBuffer();
		ori.append(bus.getBus_longitude3()).append(",").append(bus.getBus_latitude3());
		des.append(station.getLine_longitude()).append(",").append(station.getLine_latitude());
		GAPI_DISTANCE_PARAMETERS pa = new GAPI_DISTANCE_PARAMETERS(ori.toString(),des.toString(),"1");
		GAPI_DISTANCE dis = GapiUtil.getDistance(pa);
		logger.info(dis);
		if(dis == null || dis.getResults() == null || dis.getResults().isEmpty() 
				|| dis.getResults().get(0).getDistance() == null || dis.getResults().get(0).getDuration() == null)
		{
			body.setStanum(stanum);
			body.setStadis("0");
			body.setStatime("0");
		}else {
			body.setStanum(stanum);
			body.setStadis(dis.getResults().get(0).getDistance());
			body.setStatime(dis.getResults().get(0).getDuration());
		}
    	head.setRTNSTS("0000");
		head.setERRMSG("查询位置成功");
		res.setHead(head);	
		res.setBody(body);
		logger.info(res);
		request.getSession().setAttribute("data",JSON.toJSONString(res));
        return "json";
    }
}
