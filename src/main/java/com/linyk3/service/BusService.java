package com.linyk3.service;

import java.util.Collections;
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

	private int len = 100;

	@Autowired
	private LineMapper lineMapper;

	@Autowired
	private BusMapper busMapper;

	public List<Line> queryLineByLine(String line) {
		List<Line> stationList = lineMapper.queryLineByLine(line);
		Collections.sort(stationList);
		return stationList;
	}

	public Line queryLineByLineAndStanum(String line, String stanum) {
		Line station = lineMapper.queryLineByLineAndStanum(line, stanum);
		return station;
	}

	public Bus queryBus(String line) {
		// TODO Auto-generated method stub
		Bus bus = busMapper.queryBus(line);
		return bus;
	}

	public Line queryCloestStation(String line, String longitude, String latitude) {
		// 获取班车路线站点信息
		List<Line> stationList = lineMapper.queryLineByLine(line);
		if (stationList == null || stationList.isEmpty()) {
			return null;
		}
		Collections.sort(stationList);
		StringBuffer origin = new StringBuffer();
		StringBuffer des = new StringBuffer();
		Iterator<Line> iter = stationList.iterator();
		Line station;
		while (iter.hasNext()) {
			station = iter.next();
			origin.append(station.getLine_longitude()).append(",").append(station.getLine_latitude());
			if (iter.hasNext()) {
				origin.append("|");
			}
		}
		des.append(longitude).append(",").append(latitude);
		// 查询直线距离
		GAPI_DISTANCE_PARAMETERS pa = new GAPI_DISTANCE_PARAMETERS(origin.toString(), des.toString(), "0");
		GAPI_DISTANCE dis = GapiUtil.getDistance(pa);
		GAPI_DISTANCE_RESULT min = GapiUtil.getMinDistance(dis);
		logger.info(dis);
		int minid = Integer.parseInt(min.getOrigin_id());
		if (minid < 1 || minid > stationList.size()) {
			return null;
		}
		station = stationList.get(minid - 1);
		return station;
	}

	public Line queryCloestStation(List<Line> stationList, String longitude, String latitude, String type) {
		// 获取班车路线站点信息
		if (stationList == null || stationList.isEmpty()) {
			return null;
		}
		Collections.sort(stationList);
		StringBuffer origin = new StringBuffer();
		StringBuffer des = new StringBuffer();
		Iterator<Line> iter = stationList.iterator();
		Line station;
		while (iter.hasNext()) {
			station = iter.next();
			origin.append(station.getLine_longitude()).append(",").append(station.getLine_latitude());
			if (iter.hasNext()) {
				origin.append("|");
			}
		}
		des.append(longitude).append(",").append(latitude);
		GAPI_DISTANCE_PARAMETERS pa = new GAPI_DISTANCE_PARAMETERS(origin.toString(), des.toString(), type);
		GAPI_DISTANCE dis = GapiUtil.getDistance(pa);
		GAPI_DISTANCE_RESULT min = GapiUtil.getMinDistance(dis);
		// logger.info(dis);
		int minid = Integer.parseInt(min.getOrigin_id());
		if (minid < 1 || minid > stationList.size()) {
			return null;
		}
		station = stationList.get(minid - 1);
		return station;
	}

	/**
	 * 更新班车位置
	 * 
	 * @param line
	 * @param longitude
	 * @param latitude
	 * @return
	 * @throws Exception
	 */
	public UploadLocationRes UploadLocation(String line, String longitude, String latitude) throws Exception {
		UploadLocationRes res = new UploadLocationRes();
		Bus bus = busMapper.queryBus(line);
		if (bus == null) {
			res.setHead(new ResHeader("R0001", "bus do exist"));
			return res;
		}
		Bus tmpbus = new Bus(bus);
		DateUtil date = new DateUtil();
		if (bus.getBus_longitude3().equals(longitude) && bus.getBus_latitude3().equals(latitude)) {
			tmpbus.setBus_chgdt(date.getDt());
			tmpbus.setBus_chgtm(date.getTm());
			// busMapper.updateBus(tmpbus);位置不变，不再更新数据库，担心影响并发处理顺序
			res.setHead(new ResHeader("R0002", "position do not change"));
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
			// tmpbus.setBus_laststa("1");
			// tmpbus.setBus_lasttm("0");
			// tmpbus.setBus_nextsta("2");
			tmpbus.setBus_nexttm("0");
			tmpbus.setBus_nextdis("0");
			tmpbus.setBus_chgdt(date.getDt());
			tmpbus.setBus_chgtm(date.getTm());
			if (busMapper.updateBus(tmpbus) == 0) {
				res.setHead(new ResHeader("R0002", "update fail!"));
				logger.info(bus);
				logger.info(tmpbus);
			} else {
				res.setHead(new ResHeader("R0002", "time out to refresh!"));
			}
			res.setBody(tmpbus);
			return res;
		}

		List<Line> stationList = lineMapper.queryLineByLine(line);
		Collections.sort(stationList);
		// logger.info(stationList);
		if (stationList == null || stationList.isEmpty()) {
			res.setHead(new ResHeader("R0002", "station list is empty!"));
			return res;
		}
		if ((bus.getBus_longitude1().equals("0") || bus.getBus_latitude1().equals("0"))
				&& (bus.getBus_longitude2().equals("0") || bus.getBus_latitude2().equals("0"))) {
			// 获取pownew最近站点
			Line staMinNew = queryCloestStation(stationList, longitude, latitude, "0");
			if (staMinNew == null) {
				return null;
			}
			// 获取disNew
			StringBuffer ori = new StringBuffer();
			StringBuffer des = new StringBuffer();
			ori.append(longitude).append(",").append(latitude);
			des.append(staMinNew.getLine_longitude()).append(",").append(staMinNew.getLine_latitude());
			GAPI_DISTANCE_RESULT resultNew = GapiUtil.getStationDistance(ori.toString(), des.toString(), "1");
			if (resultNew == null) {
				return null;
			}
			int disNew = Integer.parseInt(resultNew.getDistance());

			// 获取pos3最近站点
			Line staMin3 = queryCloestStation(stationList, bus.getBus_longitude3(), bus.getBus_latitude3(), "0");
			if (staMin3 == null) {
				return null;
			}
			int stanumNew = Integer.parseInt(staMinNew.getLine_stanum());
			int stanum3 = Integer.parseInt(staMin3.getLine_stanum());
			// 获取dis3
			ori = new StringBuffer();
			des = new StringBuffer();
			ori.append(bus.getBus_longitude3()).append(",").append(bus.getBus_latitude3());
			des.append(staMin3.getLine_longitude()).append(",").append(staMin3.getLine_latitude());
			GAPI_DISTANCE_RESULT result3 = GapiUtil.getStationDistance(ori.toString(), des.toString(), "1");
			if (result3 == null) {
				return null;
			}
			int dis3 = Integer.parseInt(result3.getDistance());

			if (Math.abs(disNew - dis3) > len) {
				// 距离变化过大，舍去
				tmpbus.setBus_latitude3(latitude);
				tmpbus.setBus_longitude3(longitude);
				tmpbus.setBus_chgdt(date.getDt());
				tmpbus.setBus_chgtm(date.getTm());
				if (busMapper.updateBus(tmpbus) == 0) {
					res.setHead(new ResHeader("R0004", "update fail!"));
					logger.info(bus);
					logger.info(tmpbus);
				} else {
					res.setHead(new ResHeader("R0004", "refresh: distance change too mush[" + disNew + " - " + dis3
							+ "= " + Math.abs(disNew - dis3) + "]!"));
				}
				res.setBody(tmpbus);
				return res;
			}

			// 到达最近站点
			if (disNew <= len) {
				tmpbus.setBus_latitude2(bus.getBus_latitude3());
				tmpbus.setBus_longitude2(bus.getBus_longitude3());
				tmpbus.setBus_latitude3(latitude);
				tmpbus.setBus_longitude3(longitude);
				tmpbus.setBus_laststa(staMinNew.getLine_stanum());
				tmpbus.setBus_nextsta(staMinNew.getLine_stanum());
				tmpbus.setBus_nexttm(resultNew.getDuration());
				tmpbus.setBus_nextdis(resultNew.getDistance());
				tmpbus.setBus_chgdt(date.getDt());
				tmpbus.setBus_chgtm(date.getTm());
				if (busMapper.updateBus(tmpbus) == 0) {
					res.setHead(new ResHeader("R0003", "update fail!"));
					logger.info(bus);
					logger.info(tmpbus);
				} else {
					res.setHead(new ResHeader("R0003", "refresh: the bus is arriving!"));
				}
				res.setBody(tmpbus);
				return res;
			}
			// posnew和pos3最近站点相同
			if (stanumNew == stanum3) {
				// disNew < dis3 距离缩小： 下一站：stanumNew=stanum3
				if (disNew < dis3) {
					tmpbus.setBus_latitude2(bus.getBus_latitude3());
					tmpbus.setBus_longitude2(bus.getBus_longitude3());
					tmpbus.setBus_latitude3(latitude);
					tmpbus.setBus_longitude3(longitude);
					if (stanumNew > 1) {
						tmpbus.setBus_laststa(String.valueOf(stanumNew - 1));
					} else {
						tmpbus.setBus_laststa("1");
					}
					tmpbus.setBus_nextsta(staMinNew.getLine_stanum());
					tmpbus.setBus_nexttm(resultNew.getDuration());
					tmpbus.setBus_nextdis(resultNew.getDistance());
					tmpbus.setBus_chgdt(date.getDt());
					tmpbus.setBus_chgtm(date.getTm());
					if (busMapper.updateBus(tmpbus) == 0) {
						res.setHead(new ResHeader("R0004", "update fail!"));
						logger.info(bus);
						logger.info(tmpbus);
					} else {
						res.setHead(new ResHeader("R0004", "refresh: both staMin3 and staMinNew is the next station!"));
					}
					res.setBody(tmpbus);
					return res;
				} else {
					// disNew >= dis3 距离变大 上一站：stanumNew=stanum3
					tmpbus.setBus_latitude2(bus.getBus_latitude3());
					tmpbus.setBus_longitude2(bus.getBus_longitude3());
					tmpbus.setBus_latitude3(latitude);
					tmpbus.setBus_longitude3(longitude);
					if (stanumNew < stationList.size()) {
						tmpbus.setBus_laststa(staMinNew.getLine_stanum());
						tmpbus.setBus_nextsta(String.valueOf(stanumNew + 1));
					} else {
						tmpbus.setBus_laststa(String.valueOf(stanumNew - 1));
						tmpbus.setBus_nextsta(staMinNew.getLine_stanum());
					}
					tmpbus.setBus_nexttm(resultNew.getDuration());
					tmpbus.setBus_nextdis(resultNew.getDistance());
					tmpbus.setBus_chgdt(date.getDt());
					tmpbus.setBus_chgtm(date.getTm());
					if (busMapper.updateBus(tmpbus) == 0) {
						res.setHead(new ResHeader("R0005", "update fail!"));
						logger.info(bus);
						logger.info(tmpbus);
					} else {
						res.setHead(new ResHeader("R0005", "refresh:both staMin3 and staMinNew is the last station!"));
					}
					res.setBody(tmpbus);
					return res;
				}
			} else if (stanumNew - stanum3 == 1) {
				// pownew 是pos3 下一站
				tmpbus.setBus_latitude2(bus.getBus_latitude3());
				tmpbus.setBus_longitude2(bus.getBus_longitude3());
				tmpbus.setBus_latitude3(latitude);
				tmpbus.setBus_longitude3(longitude);
				tmpbus.setBus_laststa(staMin3.getLine_stanum());
				tmpbus.setBus_nextsta(staMinNew.getLine_stanum());
				tmpbus.setBus_nexttm(resultNew.getDuration());
				tmpbus.setBus_nextdis(resultNew.getDistance());
				tmpbus.setBus_chgdt(date.getDt());
				tmpbus.setBus_chgtm(date.getTm());
				if (busMapper.updateBus(tmpbus) == 0) {
					res.setHead(new ResHeader("R0006", "update fail!"));
					logger.info(bus);
					logger.info(tmpbus);
				} else {
					res.setHead(new ResHeader("R0006",
							"refresh: staMin3 is the last station, and the staMinNew is the next station!"));
				}
				res.setBody(tmpbus);
				return res;
			} else {
				// 重新计算
				tmpbus.setBus_latitude1("0");
				tmpbus.setBus_longitude1("0");
				tmpbus.setBus_latitude2("0");
				tmpbus.setBus_longitude2("0");
				tmpbus.setBus_latitude3(latitude);
				tmpbus.setBus_longitude3(longitude);
				tmpbus.setBus_chgdt(date.getDt());
				tmpbus.setBus_chgtm(date.getTm());
				if (busMapper.updateBus(tmpbus) == 0) {
					res.setHead(new ResHeader("R0007", "update fail!"));
					logger.info(bus);
					logger.info(tmpbus);
				} else {
					res.setHead(new ResHeader("R0007", "refresh: Continue to refresh !"));
				}
				res.setBody(tmpbus);
				return res;
			}
		} // end of longitude1="0" || latitude1="0" && longitude2="0" || latitude2="0"

		if (bus.getBus_latitude2().equals("0") || bus.getBus_longitude2().equals("0")) {
			// 获取pownew最近站点
			Line staMinNew = queryCloestStation(stationList, longitude, latitude, "0");
			if (staMinNew == null) {
				return null;
			}
			// 获取disNew
			StringBuffer ori = new StringBuffer();
			StringBuffer des = new StringBuffer();
			ori.append(longitude).append(",").append(latitude);
			des.append(staMinNew.getLine_longitude()).append(",").append(staMinNew.getLine_latitude());
			GAPI_DISTANCE_RESULT resultNew = GapiUtil.getStationDistance(ori.toString(), des.toString(), "1");
			if (resultNew == null) {
				return null;
			}
			int disNew = Integer.parseInt(resultNew.getDistance());

			// 获取pos3最近站点
			Line staMin3 = queryCloestStation(stationList, bus.getBus_longitude3(), bus.getBus_latitude3(), "0");
			if (staMin3 == null) {
				return null;
			}
			int stanumNew = Integer.parseInt(staMinNew.getLine_stanum());
			int stanum3 = Integer.parseInt(staMin3.getLine_stanum());
			// 获取dis3
			ori = new StringBuffer();
			des = new StringBuffer();
			ori.append(bus.getBus_longitude3()).append(",").append(bus.getBus_latitude3());
			des.append(staMin3.getLine_longitude()).append(",").append(staMin3.getLine_latitude());
			GAPI_DISTANCE_RESULT result3 = GapiUtil.getStationDistance(ori.toString(), des.toString(), "1");
			if (result3 == null) {
				return null;
			}
			int dis3 = Integer.parseInt(result3.getDistance());

			if (Math.abs(disNew - dis3) > len) {
				// 距离变化过大，舍去
				tmpbus.setBus_latitude2("0");
				tmpbus.setBus_longitude2("0");
				tmpbus.setBus_latitude3(latitude);
				tmpbus.setBus_longitude3(longitude);
				tmpbus.setBus_chgdt(date.getDt());
				tmpbus.setBus_chgtm(date.getTm());
				if (busMapper.updateBus(tmpbus) == 0) {
					res.setHead(new ResHeader("R0004", "update fail!"));
					logger.info(bus);
					logger.info(tmpbus);
				} else {
					res.setHead(new ResHeader("R0004", "refresh: distance change too mush[" + disNew + " - " + dis3
							+ "= " + Math.abs(disNew - dis3) + "]!"));
				}
				res.setBody(tmpbus);
				return res;
			}

			// 到达最近站点
			if (disNew <= len) {
				tmpbus.setBus_latitude2(bus.getBus_latitude3());
				tmpbus.setBus_longitude2(bus.getBus_longitude3());
				tmpbus.setBus_latitude3(latitude);
				tmpbus.setBus_longitude3(longitude);
				tmpbus.setBus_laststa(staMinNew.getLine_stanum());
				tmpbus.setBus_nextsta(staMinNew.getLine_stanum());
				tmpbus.setBus_nexttm(resultNew.getDuration());
				tmpbus.setBus_nextdis(resultNew.getDistance());
				tmpbus.setBus_chgdt(date.getDt());
				tmpbus.setBus_chgtm(date.getTm());
				if (busMapper.updateBus(tmpbus) == 0) {
					res.setHead(new ResHeader("R0003", "update fail!"));
					logger.info(bus);
					logger.info(tmpbus);
				} else {
					res.setHead(new ResHeader("R0003", "refresh: the bus is arriving!"));
				}
				res.setBody(tmpbus);
				return res;
			}
			// 数据库中的上一站，下一站
			int busNextStaNum = Integer.parseInt(bus.getBus_nextsta());
			int busLastStaNum = Integer.parseInt(bus.getBus_laststa());
			/*if (busNextStaNum == busLastStaNum) {
				// 重新初始化
			} else if (busNextStaNum == busLastStaNum + 1) {
				if (stanumNew == stanum3) {
					if (stanumNew == busLastStaNum) {
						if (disNew > dis3) {
							// 距离变大，从busLastStaNum出发继续往下，只需更新距离，时间
						} else {
							// 重新初始化
						}
					} else if (stanumNew == busNextStaNum) {
						if (disNew < dis3) {
							// 距离变大，继续往下靠近busNextStaNum，只需更新距离，时间
						} else {
							// 重新初始化
						}
					}
				} else if (stanumNew - stanum3 == 1) {
					if (stanumNew == busNextStaNum) {
						// 下一站正是busNextStaNum，继续往下靠近busNextStaNum，只需更新距离，时间
					} else {
						// 初始化
					}
				} else {
					// 重新初始话
				}
			} else {
				// 重新初始化
			}*/
			if ((busNextStaNum == busLastStaNum + 1) && (((stanumNew == stanum3)
					&& ((stanumNew == busLastStaNum && disNew > dis3) || (stanumNew == busNextStaNum && disNew < dis3)))
					|| (stanumNew - stanum3 == 1 && stanumNew == busNextStaNum))) {
				// 上下站点不变，只需更新距离，时间
				int stanumNext = Integer.parseInt(bus.getBus_nextsta());
				Line staNext = stationList.get(stanumNext - 1);
				if (staNext == null) {
					return null;
				}
				ori = new StringBuffer();
				des = new StringBuffer();
				ori.append(longitude).append(",").append(latitude);
				des.append(staNext.getLine_longitude()).append(",").append(staNext.getLine_latitude());
				GAPI_DISTANCE_RESULT resultNext = GapiUtil.getStationDistance(ori.toString(), des.toString(), "1");
				if (resultNext == null) {
					return null;
				}
				tmpbus.setBus_latitude2(bus.getBus_latitude3());
				tmpbus.setBus_longitude2(bus.getBus_longitude3());
				tmpbus.setBus_latitude3(latitude);
				tmpbus.setBus_longitude3(longitude);
				tmpbus.setBus_nexttm(resultNext.getDuration());
				tmpbus.setBus_nextdis(resultNext.getDistance());
				tmpbus.setBus_chgdt(date.getDt());
				tmpbus.setBus_chgtm(date.getTm());
				if (busMapper.updateBus(tmpbus) == 0) {
					res.setHead(new ResHeader("R0009", "update fail!"));
					logger.info(bus);
					logger.info(tmpbus);
				} else {
					res.setHead(new ResHeader("R0009", "normal: bus is arriving to stanumNext, update distance and time!"));
				}
				res.setBody(tmpbus);
				return res;

			} else {
				// 初始化
				tmpbus.setBus_latitude2("0");
				tmpbus.setBus_longitude2("0");
				tmpbus.setBus_latitude3(latitude);
				tmpbus.setBus_longitude3(longitude);
				tmpbus.setBus_chgdt(date.getDt());
				tmpbus.setBus_chgtm(date.getTm());
				if (busMapper.updateBus(tmpbus) == 0) {
					res.setHead(new ResHeader("R0004", "update fail!"));
					logger.info(bus);
					logger.info(tmpbus);
				} else {
					res.setHead(new ResHeader("R0004", "refresh: distance change too mush[" + disNew + " - " + dis3
							+ "= " + Math.abs(disNew - dis3) + "]!"));
				}
				res.setBody(tmpbus);
				return res;
			}
		}

		// 正常情况计算
		// pos2 pos3 posnew 正常， 上下站点正常
		// 只需计算posnew到下一站的距离，判断是否到站
		int stanumNext = Integer.parseInt(bus.getBus_nextsta());
		Line staNext = stationList.get(stanumNext - 1);
		if (staNext == null) {
			return null;
		}
		StringBuffer ori = new StringBuffer();
		StringBuffer des = new StringBuffer();
		ori.append(longitude).append(",").append(latitude);
		des.append(staNext.getLine_longitude()).append(",").append(staNext.getLine_latitude());
		GAPI_DISTANCE_RESULT resultNext = GapiUtil.getStationDistance(ori.toString(), des.toString(), "1");
		if (resultNext == null) {
			return null;
		}
		int disNext = Integer.parseInt(resultNext.getDistance());
		int dis3 = Integer.parseInt(bus.getBus_nextdis());

		if (Math.abs(disNext - dis3) > len) {
			// 距离变化过大，舍去
			tmpbus.setBus_latitude2("0");
			tmpbus.setBus_longitude2("0");
			// 正常情况的，新坐标应该是错误的，舍去
			// tmpbus.setBus_latitude3(latitude);
			// tmpbus.setBus_longitude3(longitude);
			tmpbus.setBus_chgdt(date.getDt());
			tmpbus.setBus_chgtm(date.getTm());
			if (busMapper.updateBus(tmpbus) == 0) {
				res.setHead(new ResHeader("R0004", "update fail!"));
				logger.info(bus);
				logger.info(tmpbus);
			} else {
				res.setHead(new ResHeader("R0004", "normal: distance change too mush[" + disNext + " - " + dis3 + "= "
						+ Math.abs(disNext - dis3) + "]!"));
			}
			res.setBody(tmpbus);
			return res;
		}

		if (disNext <= len) {
			tmpbus.setBus_latitude1(bus.getBus_latitude2());
			tmpbus.setBus_longitude1(bus.getBus_longitude2());
			tmpbus.setBus_latitude2(bus.getBus_latitude3());
			tmpbus.setBus_longitude2(bus.getBus_longitude3());
			tmpbus.setBus_latitude3(latitude);
			tmpbus.setBus_longitude3(longitude);
			tmpbus.setBus_laststa(staNext.getLine_stanum());
			tmpbus.setBus_nextsta(staNext.getLine_stanum());
			tmpbus.setBus_nexttm(resultNext.getDuration());
			tmpbus.setBus_nextdis(resultNext.getDistance());
			tmpbus.setBus_chgdt(date.getDt());
			tmpbus.setBus_chgtm(date.getTm());
			if (busMapper.updateBus(tmpbus) == 0) {
				res.setHead(new ResHeader("R0008", "update fail!"));
				logger.info(bus);
				logger.info(tmpbus);
			} else {
				res.setHead(new ResHeader("R0008", "normal: bus is arriving at stanumNext!"));
			}
			res.setBody(tmpbus);
			return res;
		}

		// 距离变小： 更新距离&时间
		if (disNext <= dis3) {
			tmpbus.setBus_latitude1(bus.getBus_latitude2());
			tmpbus.setBus_longitude1(bus.getBus_longitude2());
			tmpbus.setBus_latitude2(bus.getBus_latitude3());
			tmpbus.setBus_longitude2(bus.getBus_longitude3());
			tmpbus.setBus_latitude3(latitude);
			tmpbus.setBus_longitude3(longitude);
			tmpbus.setBus_nexttm(resultNext.getDuration());
			tmpbus.setBus_nextdis(resultNext.getDistance());
			tmpbus.setBus_chgdt(date.getDt());
			tmpbus.setBus_chgtm(date.getTm());
			if (busMapper.updateBus(tmpbus) == 0) {
				res.setHead(new ResHeader("R0009", "update fail!"));
				logger.info(bus);
				logger.info(tmpbus);
			} else {
				res.setHead(new ResHeader("R0009", "normal: bus is arriving to stanumNext, update distance and time!"));
			}
			res.setBody(tmpbus);
			return res;
		} else {
			// 距离变大，且非到站情况： 矫正重算
			tmpbus.setBus_latitude2("0");
			tmpbus.setBus_longitude2("0");
			tmpbus.setBus_latitude3(latitude);
			tmpbus.setBus_longitude3(longitude);
			tmpbus.setBus_chgdt(date.getDt());
			tmpbus.setBus_chgtm(date.getTm());
			if (busMapper.updateBus(tmpbus) == 0) {
				res.setHead(new ResHeader("R0012", "update fail!"));
				logger.info(bus);
				logger.info(tmpbus);
			} else {
				res.setHead(new ResHeader("R0012", "lastStaion[" + tmpbus.getBus_laststa() + "]nextStation["
						+ tmpbus.getBus_nextsta() + "]" + "error:Continue to refresh !"));
			}
			res.setBody(tmpbus);
			return res;
		}
	}

	public void insertBusH(Bus bus) {
		busMapper.insertBusH(bus);
	}

}
