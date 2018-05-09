package com.linyk3.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linyk3.bean.Bus;
import com.linyk3.bean.Line;
import com.linyk3.bean.QueryLineResBody;
import com.linyk3.mapper.BusMapper;
import com.linyk3.mapper.LineMapper;

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

}
