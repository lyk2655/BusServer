package com.linyk3.service;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linyk3.bean.Bus;
import com.linyk3.bean.GAPI_DISTANCE;
import com.linyk3.bean.GAPI_DISTANCE_PARAMETERS;
import com.linyk3.bean.GAPI_DISTANCE_RESULT;
import com.linyk3.bean.Line;
import com.linyk3.mapper.BusMapper;
import com.linyk3.mapper.LineMapper;
import com.linyk3.util.GapiUtil;

@Service("busService")
public class BusService {
	Logger logger = Logger.getLogger(BusService.class);
	
	@Autowired
    private LineMapper lineMapper;
	
	@Autowired 
	private BusMapper busMapper;
    
	public List<Line> queryLineByLine(String line) {
		List<Line> stationList = lineMapper.queryLineByLine(line);
		return stationList;
	}
	
	public Line queryLineByLineAndStanum(String line, String stanum) {
		Line station = lineMapper.queryLineByLineAndStanum(line,stanum);
		return station;
	}

	public Bus queryBus(String line) {
		// TODO Auto-generated method stub
		Bus bus = busMapper.queryBus(line);
		return bus;
	}

	public Line queryCloestStation(String line, String longitude, String latitude) {
		//获取班车路线站点信息
		List<Line> stationList = lineMapper.queryLineByLine(line);
		if(stationList == null || stationList.isEmpty()) {
			return null;
		}
		StringBuffer origin = new StringBuffer();
		StringBuffer des = new StringBuffer();
		Iterator<Line> iter = stationList.iterator();
		Line station;
		while(iter.hasNext()) {
			station = iter.next();
			origin.append(station.getLine_longitude()).append(",").append(station.getLine_latitude());
			if(iter.hasNext()) {
				origin.append("|");
			}
		}
		des.append(longitude).append(",").append(latitude);
		//查询直线距离
		GAPI_DISTANCE_PARAMETERS pa = new GAPI_DISTANCE_PARAMETERS(origin.toString(), des.toString(),"0");
		GAPI_DISTANCE dis = GapiUtil.getDistance(pa);
		GAPI_DISTANCE_RESULT min = GapiUtil.getMinDistance(dis);
		logger.info(dis);
		int minid = Integer.parseInt(min.getOrigin_id());
		if(minid < 1 || minid > stationList.size()) {
			return null;
		}
		station = stationList.get(minid-1);
		return station;
	}

}
