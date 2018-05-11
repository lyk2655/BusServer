package com.linyk3.service;

import java.text.ParseException;
import java.util.Date;
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
import com.linyk3.bean.ResHeader;
import com.linyk3.bean.UploadLocationRes;
import com.linyk3.mapper.BusMapper;
import com.linyk3.mapper.LineMapper;
import com.linyk3.util.DateUtil;
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
	
	public Line queryCloestStation(List<Line> stationList, String longitude, String latitude, String type) {
		//获取班车路线站点信息
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
		GAPI_DISTANCE_PARAMETERS pa = new GAPI_DISTANCE_PARAMETERS(origin.toString(), des.toString(),type);
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

	
	/**
	 * 更新班车位置
	 * @param line
	 * @param longitude
	 * @param latitude
	 * @return
	 * @throws Exception
	 */
	public UploadLocationRes UploadLocation(String line, String longitude, String latitude) throws Exception {
		UploadLocationRes res = new UploadLocationRes();
		Bus bus = busMapper.queryBus(line);
		if(bus == null) {
			res.setHead(new ResHeader("R0001","bus do exist"));
			return res;
		}
		Bus tmpbus = new Bus(bus);
		DateUtil date = new DateUtil();
		if(bus.getBus_longitude3().equals(longitude) && bus.getBus_latitude3().equals(latitude)) {
			tmpbus.setBus_chgdt(date.getDt());
			tmpbus.setBus_chgtm(date.getTm());
			busMapper.updateBus(tmpbus);
			res.setHead(new ResHeader("R0002","position do not change"));
			return res;
		}
		if (date.isTimeOut(bus.getBus_chgdt(), bus.getBus_chgtm()) || bus.getBus_latitude3().equals("0")
				|| bus.getBus_longitude3().equals("0") || latitude.equals("0") || longitude.equals("0")) {
			tmpbus.setBus_latitude1("0");
			tmpbus.setBus_longitude1("0");
			tmpbus.setBus_latitude2("0");
			tmpbus.setBus_longitude2("0");
			tmpbus.setBus_latitude3(latitude);
			tmpbus.setBus_longitude3(longitude);
			tmpbus.setBus_laststa("1");
			tmpbus.setBus_lasttm("0");
			tmpbus.setBus_nextsta("2");
			tmpbus.setBus_nexttm("0");
			tmpbus.setBus_nextdis("0");
			tmpbus.setBus_chgdt(date.getDt());
			tmpbus.setBus_chgtm(date.getTm());
			busMapper.updateBus(tmpbus);
			res.setHead(new ResHeader("R0002","time out to refresh!"));
			res.setBody(tmpbus);
			return res;
		}
		
		List<Line> stationList = lineMapper.queryLineByLine(line);
		if(stationList == null || stationList.isEmpty()) {
			res.setHead(new ResHeader("R0002","station list is empty!"));
			return res;
		}
		if(bus.getBus_latitude2().equals("0") || bus.getBus_longitude2().equals("0")) {
			//获取pownew最近站点
			Line staMinNew = queryCloestStation(stationList,longitude,latitude,"0");
			if(staMinNew == null) {
				return null;
			}
			//获取disNew
			StringBuffer ori = new StringBuffer();
			StringBuffer des = new StringBuffer();
			ori.append(longitude).append(",").append(latitude);
			des.append(staMinNew.getLine_longitude()).append(",").append(staMinNew.getLine_latitude());
			GAPI_DISTANCE_RESULT disNew = GapiUtil.getStationDistance(ori.toString(), des.toString(),"1");
			if(disNew == null) {
				return null;
			}
			int dis = Integer.parseInt(disNew.getDistance());
			//到达最近站点
			if(dis < 50) {
				tmpbus.setBus_latitude2(bus.getBus_latitude3());
				tmpbus.setBus_longitude2(bus.getBus_longitude3());
				tmpbus.setBus_latitude3(latitude);
				tmpbus.setBus_longitude3(longitude);
				tmpbus.setBus_laststa(staMinNew.getLine_stanum());
				tmpbus.setBus_nextsta(staMinNew.getLine_stanum());
				tmpbus.setBus_nexttm(disNew.getDuration());
				tmpbus.setBus_nextdis(disNew.getDistance());
				tmpbus.setBus_chgdt(date.getDt());
				tmpbus.setBus_chgtm(date.getTm());
				busMapper.updateBus(tmpbus);
				res.setHead(new ResHeader("R0003","refresh: the bus is arriving!"));
				res.setBody(tmpbus);
				return res;
			}
			//获取pos3最近站点	
			Line staMin3 = queryCloestStation(stationList,bus.getBus_longitude3(),bus.getBus_latitude3(),"0");
			if(staMin3 == null) {
				return null;
			}
			int stanumNew = Integer.parseInt(staMinNew.getLine_stanum());
			int stanum3 = Integer.parseInt(staMin3.getLine_stanum());
			if(stanumNew == stanum3) {
				//posnew和pos3最近站点相同
				
				
			}else if(stanumNew - stanum3 == 1) {
				//pownew 是pos3 下一站
			} else {
				//
			}
			
		}
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return res;
	}

}
