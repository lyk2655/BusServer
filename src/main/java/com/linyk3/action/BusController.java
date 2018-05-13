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
import com.linyk3.bean.QueryClosestStationRes;
import com.linyk3.bean.QueryLineRes;
import com.linyk3.bean.QueryLineResBody;
import com.linyk3.bean.ResHeader;
import com.linyk3.bean.UploadLocationRes;
import com.linyk3.service.BusService;
import com.linyk3.util.DateUtil;
import com.linyk3.util.GapiUtil;

@Controller
public class BusController {
	Logger logger = Logger.getLogger(BusController.class); 
    @Autowired 
    private BusService busService;
    /**
     * 查询路线站点信息
     * @param line
     * @return List<Line>
     */
    @RequestMapping(value = "/BusLine.do")
    public String queryLine(HttpServletRequest request) {
    	 String t1 = new DateUtil().getTm();
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
		String t2 = new DateUtil().getTm();
	    logger.info("queryLine:["+line+"]:"+"bigin time["+ t1+"]-end time [" + t2 +"] time cost:["+String.valueOf((Integer.parseInt(t2.substring(4))-Integer.parseInt(t1.substring(4)))/100)+"ms]");
        return "json";
    }
    
    /**
     * 查询班车位置，以及到站点的预计时间距离
     * @param line， station number
     * @return bus，station number，distance，time
     */
    @RequestMapping(value = "/QueryLocation.do")
    public String queryBus(HttpServletRequest request) {
    	String t1 = new DateUtil().getTm();
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
		String t2 = new DateUtil().getTm();
	    logger.info("queryBus:["+line+"]:"+"bigin time["+ t1+"]-end time [" + t2 +"] time cost:["+String.valueOf((Integer.parseInt(t2.substring(4))-Integer.parseInt(t1.substring(4)))/100)+"ms]");
        return "json";
    }
    /**
     * 查询最近站点信息
     * @param line，longitude，latitude
     * @return Line
     */
    @RequestMapping(value = "/QueryClosestStation.do")
    public String queryClosestStation(HttpServletRequest request) {
    	String t1 = new DateUtil().getTm();
    	String param = request.getParameter("param");
    	logger.info(param);
    	BusReq req = JSONObject.parseObject(param, BusReq.class);
    	logger.info(req.getBody());
    	QueryClosestStationRes res = new QueryClosestStationRes();
    	ResHeader head = new ResHeader();
    	if(req == null || req.getBody() == null  || req.getBody().getLine() == null 
    			|| req.getBody().getLongitude() == null || req.getBody().getLatitude() == null) {
    		head.setRTNSTS("EEEE");
    		head.setERRMSG("参数错误");
    		res.setHead(head);
    		request.getSession().setAttribute("data",JSON.toJSONString(res));
            return "json";
    	}
    	String line = req.getBody().getLine();
    	String longitude = req.getBody().getLongitude();
    	String latitude = req.getBody().getLatitude();
    	
    	Line station = busService.queryCloestStation(line,longitude,latitude);
		logger.info(station);
    	if(station == null)
    	{
    		head.setRTNSTS("EEEE");
    		head.setERRMSG("查询错误");
    		res.setHead(head);
    		request.getSession().setAttribute("data",JSON.toJSONString(res));
            return "json";
    	}
    	head.setRTNSTS("0000");
		head.setERRMSG("查询线路成功");
		res.setHead(head);
		res.setBody(station);
		request.getSession().setAttribute("data",JSON.toJSONString(res));
		String t2 = new DateUtil().getTm();
	    logger.info("queryClosestStation:bigin time["+ t1+"]-end time [" + t2 +"] time cost:["+String.valueOf((Integer.parseInt(t2.substring(4))-Integer.parseInt(t1.substring(4)))/100)+"ms]");
        return "json";
    }
    /**
     * 更新班车位置
     * @param line，longitude，latitude
     * @return Line
     * @throws Exception 
     */
    @RequestMapping(value = "/UploadLocation.do")
    public String UploadLocation(HttpServletRequest request) throws Exception {
    	String t1 = new DateUtil().getTm();
    	String param = request.getParameter("param");
    	logger.info(param);
    	BusReq req = JSONObject.parseObject(param, BusReq.class);
    	logger.info(req.getBody());
    	UploadLocationRes res = new UploadLocationRes();
    	ResHeader head = new ResHeader();
    	if(req == null || req.getBody() == null  || req.getBody().getLine() == null 
    			|| req.getBody().getLongitude() == null || req.getBody().getLatitude() == null) {
    		head.setRTNSTS("EEEE");
    		head.setERRMSG("参数错误");
    		res.setHead(head);
    		request.getSession().setAttribute("data",JSON.toJSONString(res));
            return "json";
    	}
    	String line = req.getBody().getLine();
    	String longitude = req.getBody().getLongitude();
    	String latitude = req.getBody().getLatitude();
    	
    	res = busService.UploadLocation(line,longitude,latitude);
		logger.info(res);
    	if(res == null)
    	{
    		res = new UploadLocationRes();
    		head.setRTNSTS("EEEE");
    		head.setERRMSG("查询错误");
    		res.setHead(head);
    		request.getSession().setAttribute("data",JSON.toJSONString(res));
            return "json";
    	}
		request.getSession().setAttribute("data",JSON.toJSONString(res));
		String t2 = new DateUtil().getTm();
	    logger.info("UploadLocation:bigin time["+ t1+"]-end time [" + t2 +"] time cost:["+String.valueOf((Integer.parseInt(t2.substring(4))-Integer.parseInt(t1.substring(4)))/100)+"ms]");
        return "json";
    }
}
