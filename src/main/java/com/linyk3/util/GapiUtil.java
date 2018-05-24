package com.linyk3.util;

import java.util.Iterator;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.linyk3.action.LoginController;
import com.linyk3.bean.GAPI_DISTANCE;
import com.linyk3.bean.GAPI_DISTANCE_PARAMETERS;
import com.linyk3.bean.GAPI_DISTANCE_RESULT;



public class GapiUtil {

	static Logger Glogger = Logger.getLogger(GapiUtil.class);
	
	// 距离测量 1-1
	public static GAPI_DISTANCE getDistance(GAPI_DISTANCE_PARAMETERS pa) {
		String ip = "http://restapi.amap.com/v3/distance";
		String param = "key=" + pa.getKey() + "&origins=" + pa.getOrigins() + "&destination=" + pa.getDestination()
				+ "&type=" + pa.getType();
		// String ip = "http://restapi.amap.com/v3/distance";
		// String param="key=8ad12a9140feb5b3ebdcd83abf021d45&origins=116.481028,39.989643|114.481028,39.989643|115.481028,39.989643&destination=114.465302,40.004717&type=1";
		String dis = MyHttpRequest.sendGet(ip, param, "utf-8",true);
		//Glogger.info(dis);
		GAPI_DISTANCE distance = JSONObject.parseObject(dis, GAPI_DISTANCE.class);
		//Glogger.info(distance);
		return distance;
	}
	
	public static GAPI_DISTANCE_RESULT getMinDistance(GAPI_DISTANCE distances) {
		// 查询不成功，返回-1
		if (distances.getResults() == null || distances.getResults().isEmpty() || distances.getStatus().equals("0")) {
			return null;
		}
		Iterator<GAPI_DISTANCE_RESULT> i = distances.getResults().iterator();
		GAPI_DISTANCE_RESULT candidate = i.next();

        while (i.hasNext()) {
        	GAPI_DISTANCE_RESULT next = i.next();
            if (next.compareTo(candidate) < 0)
                candidate = next;
        }
        
        //第二种实现取最小值
        //GAPI_DISTANCE_RESULT min = Collections.min(distances.getResults());
        //System.out.println("min\n"+min.toString());
        return candidate;
	}
	
	//获取到两点的距离
	public static GAPI_DISTANCE_RESULT getStationDistance(String ori, String des, String type) {
		GAPI_DISTANCE_PARAMETERS pa1 = new GAPI_DISTANCE_PARAMETERS(ori,des,type);
		GAPI_DISTANCE_PARAMETERS pa2 = new GAPI_DISTANCE_PARAMETERS(des,ori,type);
		GAPI_DISTANCE dis1  = GapiUtil.getDistance(pa1);
		if(dis1 == null || dis1.getResults() == null || dis1.getResults().isEmpty()) {
			return null;
		}

		GAPI_DISTANCE dis2  = GapiUtil.getDistance(pa2);
		if(dis2 == null || dis2.getResults() == null || dis2.getResults().isEmpty()) {
			return null;
		}
		int ln1 = Integer.parseInt(dis1.getResults().get(0).getDistance());
		int ln2 = Integer.parseInt(dis2.getResults().get(0).getDistance());
		if(ln1 < ln2) {
			return dis1.getResults().get(0);
		}else {
			return dis2.getResults().get(0);
		}
	}

	public static void main(String[] args) {
		GAPI_DISTANCE_PARAMETERS pa = new GAPI_DISTANCE_PARAMETERS(
				"113.865479,22.573118|116.481028,39.989643|114.481028,39.989643|115.481028,39.989643",
				"113.882852,22.56638");
		GAPI_DISTANCE dis = getDistance(pa);
		//System.out.println(pa);
		//System.out.println("[dis]"+dis);
		//System.out.println("[min]" + getMinDistance(dis).toString());
	}
}
