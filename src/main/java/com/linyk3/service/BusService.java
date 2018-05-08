package com.linyk3.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linyk3.bean.Line;
import com.linyk3.bean.QueryLineResBody;
import com.linyk3.mapper.LineMapper;

@Service("busService")
public class BusService {
	Logger logger = Logger.getLogger(BusService.class);
	
	@Autowired
    private LineMapper lineMapper;
    
	public QueryLineResBody queryLine(String line) {
		List<Line> lineList = lineMapper.queryLine(line);
		QueryLineResBody body = new QueryLineResBody();
		logger.info(lineList);
		body.setLineList(lineList);
		return body;
	}

}
