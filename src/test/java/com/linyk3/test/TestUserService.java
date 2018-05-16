package com.linyk3.test;


import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.linyk3.bean.UploadLocationRes;
import com.linyk3.service.BusService;
import com.linyk3.util.DateUtil;
import com.linyk3.util.MyHttpRequest;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml","/spring-mybatis.xml"})
public class TestUserService {

	Logger logger = Logger.getLogger(TestUserService.class);
    private String ip = "localhost:8080/BocbusServer/";
   // private String ip = "111.230.148.118:8080/BocbusServer/";
    
    @Autowired
    private BusService busService;
    
    public void printUpdate(String longitude,String latitude) {
    	String url = "http://"+ip+"UploadLocation.do";
	    String par= "param={'head':{'TRACDE':'BC00002','TRADAT':'11111','TRATIM':'11111','USRNAM':'1'},'body':{'line':'4','longitude':"
				+longitude+",'latitude':"+latitude+ "}}";
    }
    
    
    @Test
    public void QueryLocation(){
    	String url = "http://"+ip+"QueryLocation.do";
	    String par= "param={'heaBusServiced':{'TRACDE':'BC00002','TRADAT':'11111','TRATIM':'11111','USRNAM':'1'},'body':{'line':'4','stanum':'3'}}";
	    System.out.println(url+"?"+par);
	    String t1 = new DateUtil().getTm();
	    String res = MyHttpRequest.sendGet(url, par,"utf-8");
	    String t2 = new DateUtil().getTm();
	    logger.info(res.toString());
	    logger.info("["+ t1+"]-[" + t2 +"]");
	    logger.info("["+String.valueOf((Integer.parseInt(t2.substring(4))-Integer.parseInt(t1.substring(4)))/100)+"ms]");
    }
    @Test
    public void BusLine(){
    	String url = "http://"+ip+"BusLine.do";
	    String par= "param={'head':{'TRACDE':'BC00002','TRADAT':'11111','TRATIM':'11111','USRNAM':'1'},'body':{'line':'4'}}";
	    System.out.println("BusLine"+MyHttpRequest.sendGet(url, par,"utf-8"));
    }
    
    @Test
    public void QueryClosestStation(){
    	String url = "http://"+ip+"QueryClosestStation.do";
	    String par= "param={'head':{'TRACDE':'BC00002','TRADAT':'11111','TRATIM':'11111','USRNAM':'1'},'body':{'line':'4','longitude':'114.121028','latitude':'36.284643'}}";
	    System.out.println("BusLine"+MyHttpRequest.sendGet(url, par,"utf-8"));
    }
    
    @Test
    public void UpdateLocation() {
    	ArrayList<String> lons = new ArrayList<String>();;
    	ArrayList<String> lats = new ArrayList<String>();
    	lons.add("113.945382");
    	lons.add("113.935126");
    	lons.add("113.921908");
    	lons.add("113.91796" );
    	lons.add("113.906287");
    	lons.add("113.903068");
    	lons.add("113.901995");
    	lons.add("113.90072" );
    	lons.add("113.899947");
    	lons.add("113.899228");
    	lons.add("113.898424");
    	lons.add("113.89808" );
    	lons.add("113.894711");
    	lons.add("113.894036");
    	lons.add("113.893145");
    	lons.add("113.892094");
    	lons.add("113.891654");
    	lons.add("113.890184");
    	lons.add("113.889004");
    	lons.add("113.887263");
    	lons.add("113.886571");

    	lats.add("22.542117");
    	lats.add("22.539996");
    	lats.add("22.540472");
    	lats.add("22.541404");
    	lats.add("22.544753");
    	lats.add("22.547943");
    	lats.add("22.548915");
    	lats.add("22.550077");
    	lats.add("22.550815");
    	lats.add("22.551464");
    	lats.add("22.55245" );
    	lats.add("22.552802");
    	lats.add("22.555868");
    	lats.add("22.556567");
    	lats.add("22.557345");
    	lats.add("22.558321");
    	lats.add("22.558841");
    	lats.add("22.560164");
    	lats.add("22.561308");
    	lats.add("22.562997");
    	lats.add("22.563659");
    	for(int i=0; i < lons.size(); i++) {
    		String url = "http://"+ip+"UploadLocation.do";
    	    String par= "param={'head':{'TRACDE':'BC00002','TRADAT':'11111','TRATIM':'11111','USRNAM':'1'},'body':{'line':'4','longitude':"
    				+lons.get(i)+",'latitude':"+lats.get(i)+ "}}";
    	    //System.out.println(url+"?"+par);
    	    String t1 = new DateUtil().getTm();
    	    UploadLocationRes res = JSONObject.parseObject(MyHttpRequest.sendGet(url, par,"utf-8"),UploadLocationRes.class);
    	    String t2 = new DateUtil().getTm();
    	    //logger.info("["+ t1+"]-[" + t2 +"]");
    	    //logger.info("["+String.valueOf((Integer.parseInt(t2.substring(4))-Integer.parseInt(t1.substring(4)))/100)+"ms]");
    	    if(res == null || res.getBody() == null) continue;
    	    logger.info("["+i+"]"+"["+res.getBody().getBus_laststa()+"]["+res.getBody().getBus_nextsta()+"]["+res.getBody().getBus_nextdis()+"]"+"["+String.valueOf((Integer.parseInt(t2.substring(4))-Integer.parseInt(t1.substring(4)))/100)+"ms]"+res.getHead().getERRMSG());
    	}
    }
    
    @Test
    public void UpdateLocationService_baoan2_xiaban() throws Exception {
    	ArrayList<String> lons = new ArrayList<String>();;
    	ArrayList<String> lats = new ArrayList<String>();
    	lons.add("113.945382");
    	lons.add("113.935126");
    	lons.add("113.921908");
    	lons.add("113.91796" );
    	lons.add("113.906287");
    	lons.add("113.903068");
    	lons.add("113.901995");
    	lons.add("113.90072" );
    	lons.add("113.899947");
    	lons.add("113.899228");
    	lons.add("113.898424");
    	lons.add("113.89808" );
    	lons.add("113.894711");
    	lons.add("113.894036");
    	lons.add("113.893145");
    	lons.add("113.892094");
    	lons.add("113.891654");
    	lons.add("113.890184");
    	lons.add("113.889004");
    	lons.add("113.887263");
    	lons.add("113.886571");

    	lats.add("22.542117");
    	lats.add("22.539996");
    	lats.add("22.540472");
    	lats.add("22.541404");
    	lats.add("22.544753");
    	lats.add("22.547943");
    	lats.add("22.548915");
    	lats.add("22.550077");
    	lats.add("22.550815");
    	lats.add("22.551464");
    	lats.add("22.55245" );
    	lats.add("22.552802");
    	lats.add("22.555868");
    	lats.add("22.556567");
    	lats.add("22.557345");
    	lats.add("22.558321");
    	lats.add("22.558841");
    	lats.add("22.560164");
    	lats.add("22.561308");
    	lats.add("22.562997");
    	lats.add("22.563659");
    	for(int i=0; i < lons.size(); i++) {
    		//String url = "http://"+ip+":8080/BusServer/UploadLocation.do";
    	   // String par= "param={'head':{'TRACDE':'BC00002','TRADAT':'11111','TRATIM':'11111','USRNAM':'1'},'body':{'line':'4','longitude':"
    		//		+lons.get(i)+",'latitude':"+lats.get(i)+ "}}";
    	    //System.out.println(url+"?"+par);
    	    String t1 = new DateUtil().getTm();
    	    //UploadLocationRes res = JSONObject.parseObject(MyHttpRequest.sendGet(url, par,"utf-8"),UploadLocationRes.class);
    	    UploadLocationRes res = busService.UploadLocation("4",lons.get(i),lats.get(i));
    	    String t2 = new DateUtil().getTm();
    	    //logger.info("["+ t1+"]-[" + t2 +"]");
    	    //logger.info("["+String.valueOf((Integer.parseInt(t2.substring(4))-Integer.parseInt(t1.substring(4)))/100)+"ms]");
    	    if(res == null || res.getBody() == null) continue;
    	    logger.info("["+(i+1)+"]"+"["+res.getBody().getBus_laststa()+"]["+res.getBody().getBus_nextsta()+"]["+res.getBody().getBus_nextdis()+"]"+"["+String.valueOf((Integer.parseInt(t2.substring(4))-Integer.parseInt(t1.substring(4)))/100)+"ms]"+res.getHead().getERRMSG());
    	}
    }
    
    @Test
    public void UpdateLocationService_xili_shangban() throws Exception {
    	ArrayList<String> lons = new ArrayList<String>();;
    	ArrayList<String> lats = new ArrayList<String>();
    	lons.add("114.033714"); lats.add("22.610874");
    	lons.add("114.025150"); lats.add("22.611061");
    	lons.add("114.020515"); lats.add("22.608486");
    	lons.add("114.011975"); lats.add("22.599373");
    	lons.add("114.006095"); lats.add("22.596481");
    	lons.add("114.002233"); lats.add("22.594223");
    	lons.add("113.999229"); lats.add("22.592242");
    	lons.add("113.998827"); lats.add("22.592074");
    	lons.add("113.998558"); lats.add("22.592018");
    	lons.add("113.995533"); lats.add("22.592133");
    	lons.add("113.993886"); lats.add("22.592188");
    	lons.add("113.992626"); lats.add("22.592168");
    	lons.add("113.991902"); lats.add("22.592282");
    	lons.add("113.991769"); lats.add("22.592347");
    	lons.add("113.989434"); lats.add("22.592371");
    	lons.add("113.988415"); lats.add("22.591747");
    	lons.add("113.987326"); lats.add("22.590925");
    	lons.add("113.987326"); lats.add("22.590925");
    	lons.add("113.981795"); lats.add("22.590350");
    	lons.add("113.982224"); lats.add("22.587735");
    	lons.add("113.982224"); lats.add("22.587735");
    	lons.add("113.982224"); lats.add("22.587735");
    	lons.add("113.980593"); lats.add("22.584764");
    	lons.add("113.972884"); lats.add("22.582742");
    	lons.add("113.970326"); lats.add("22.582827");
    	lons.add("113.969671"); lats.add("22.582872");
    	lons.add("113.969515"); lats.add("22.582900");
    	lons.add("113.968920"); lats.add("22.582912");
    	lons.add("113.967268"); lats.add("22.582951");
    	lons.add("113.965948"); lats.add("22.582773");
    	lons.add("113.964934"); lats.add("22.582506");
    	lons.add("113.964218"); lats.add("22.582293");
    	lons.add("113.963491"); lats.add("22.582089");
    	lons.add("113.961115"); lats.add("22.581480");
    	lons.add("113.959103"); lats.add("22.580876");
    	lons.add("113.957794"); lats.add("22.580856");
    	lons.add("113.957626"); lats.add("22.580965");
    	lons.add("113.956620"); lats.add("22.580841");
    	lons.add("113.954645"); lats.add("22.580762");
    	lons.add("113.954167"); lats.add("22.578649");
    	lons.add("113.954236"); lats.add("22.579951");
    	lons.add("113.954220"); lats.add("22.579129");
    	lons.add("113.954182"); lats.add("22.579069");
    	lons.add("113.954198"); lats.add("22.578133");
    	lons.add("113.954236"); lats.add("22.577286");
    	lons.add("113.954236"); lats.add("22.576018");
    	lons.add("113.954161"); lats.add("22.574671");
    	lons.add("113.954354"); lats.add("22.572947");
    	lons.add("113.954375"); lats.add("22.572392");
    	lons.add("113.954455"); lats.add("22.570973");
    	lons.add("113.955212"); lats.add("22.569321");
    	lons.add("113.956285"); lats.add("22.565675");
    	lons.add("113.957294"); lats.add("22.562465");
    	lons.add("113.957380"); lats.add("22.559929");
    	lons.add("113.957594"); lats.add("22.558383");
    	lons.add("113.957562"); lats.add("22.557977");
    	lons.add("113.957592"); lats.add("22.557415");
    	lons.add("113.957479"); lats.add("22.557306");
    	lons.add("113.957533"); lats.add("22.556845");
    	lons.add("113.957500"); lats.add("22.555731");
    	lons.add("113.957592"); lats.add("22.554452");
    	lons.add("113.945323"); lats.add("22.552620");
    	lons.add("113.945237"); lats.add("22.549865");
    	lons.add("113.945216"); lats.add("22.548300");
    	lons.add("113.945194"); lats.add("22.547448");
    	lons.add("113.945280"); lats.add("22.546828");
    	lons.add("113.945318"); lats.add("22.545892");
    	lons.add("113.945301"); lats.add("22.545510");
    	lons.add("113.945260"); lats.add("22.545159");

    	for(int i=0; i < lons.size(); i++) {
    		//String url = "http://"+ip+":8080/BusServer/UploadLocation.do";
    	   // String par= "param={'head':{'TRACDE':'BC00002','TRADAT':'11111','TRATIM':'11111','USRNAM':'1'},'body':{'line':'4','longitude':"
    		//		+lons.get(i)+",'latitude':"+lats.get(i)+ "}}";
    	    //System.out.println(url+"?"+par);
    	    String t1 = new DateUtil().getTm();
    	    //UploadLocationRes res = JSONObject.parseObject(MyHttpRequest.sendGet(url, par,"utf-8"),UploadLocationRes.class);
    	    UploadLocationRes res = busService.UploadLocation("11",lons.get(i),lats.get(i));
    	    String t2 = new DateUtil().getTm();
    	    logger.info("bigin time["+ t1+"]-end time [" + t2 +"] time cost:["+String.valueOf((Integer.parseInt(t2.substring(4))-Integer.parseInt(t1.substring(4)))/100)+"ms]");
    	    if(res == null || res.getBody() == null) continue;
    	    logger.info("["+i+"]"+"["+res.getBody().getBus_laststa()+"]["+res.getBody().getBus_nextsta()+"]["+res.getBody().getBus_nextdis()+"]"+"["+String.valueOf((Integer.parseInt(t2.substring(4))-Integer.parseInt(t1.substring(4)))/100)+"ms]"+res.getHead().getERRMSG());
    	}
    }
    
    @Test
    public void UpdateLocationController_xili_shangban() throws Exception {
    	ArrayList<String> lons = new ArrayList<String>();;
    	ArrayList<String> lats = new ArrayList<String>();
    	lons.add("114.033714"); lats.add("22.610874");
    	lons.add("114.025150"); lats.add("22.611061");
    	lons.add("114.020515"); lats.add("22.608486");
    	lons.add("114.011975"); lats.add("22.599373");
    	lons.add("114.006095"); lats.add("22.596481");
    	lons.add("114.002233"); lats.add("22.594223");
    	lons.add("113.999229"); lats.add("22.592242");
    	lons.add("113.998827"); lats.add("22.592074");
    	lons.add("113.998558"); lats.add("22.592018");
    	lons.add("113.995533"); lats.add("22.592133");
    	lons.add("113.993886"); lats.add("22.592188");
    	lons.add("113.992626"); lats.add("22.592168");
    	lons.add("113.991902"); lats.add("22.592282");
    	lons.add("113.991769"); lats.add("22.592347");
    	lons.add("113.989434"); lats.add("22.592371");
    	lons.add("113.988415"); lats.add("22.591747");
    	lons.add("113.987326"); lats.add("22.590925");
    	lons.add("113.981795"); lats.add("22.590350");
    	lons.add("113.981795"); lats.add("22.590350");
    	lons.add("113.981795"); lats.add("22.590350");
    	lons.add("113.981795"); lats.add("22.590350");
    	lons.add("113.982224"); lats.add("22.587735");
    	lons.add("113.980593"); lats.add("22.584764");
    	lons.add("113.972884"); lats.add("22.582742");
    	lons.add("113.970326"); lats.add("22.582827");
    	lons.add("113.969671"); lats.add("22.582872");
    	lons.add("113.969515"); lats.add("22.582900");
    	lons.add("113.968920"); lats.add("22.582912");
    	lons.add("113.967268"); lats.add("22.582951");
    	lons.add("113.965948"); lats.add("22.582773");
    	lons.add("113.964934"); lats.add("22.582506");
    	lons.add("113.964218"); lats.add("22.582293");
    	lons.add("113.963491"); lats.add("22.582089");
    	lons.add("113.961115"); lats.add("22.581480");
    	lons.add("113.959103"); lats.add("22.580876");
    	lons.add("113.957794"); lats.add("22.580856");
    	lons.add("113.957626"); lats.add("22.580965");
    	lons.add("113.956620"); lats.add("22.580841");
    	lons.add("113.954645"); lats.add("22.580762");
    	lons.add("113.954167"); lats.add("22.578649");
    	lons.add("113.954236"); lats.add("22.579951");
    	lons.add("113.954220"); lats.add("22.579129");
    	lons.add("113.954182"); lats.add("22.579069");
    	lons.add("113.954198"); lats.add("22.578133");
    	lons.add("113.954236"); lats.add("22.577286");
    	lons.add("113.954236"); lats.add("22.576018");
    	lons.add("113.954161"); lats.add("22.574671");
    	lons.add("113.954354"); lats.add("22.572947");
    	lons.add("113.954375"); lats.add("22.572392");
    	lons.add("113.954455"); lats.add("22.570973");
    	lons.add("113.955212"); lats.add("22.569321");
    	lons.add("113.956285"); lats.add("22.565675");
    	lons.add("113.957294"); lats.add("22.562465");
    	lons.add("113.957380"); lats.add("22.559929");
    	lons.add("113.957594"); lats.add("22.558383");
    	lons.add("113.957562"); lats.add("22.557977");
    	lons.add("113.957592"); lats.add("22.557415");
    	lons.add("113.957479"); lats.add("22.557306");
    	lons.add("113.957533"); lats.add("22.556845");
    	lons.add("113.957500"); lats.add("22.555731");
    	lons.add("113.957592"); lats.add("22.554452");
    	lons.add("113.945323"); lats.add("22.552620");
    	lons.add("113.945237"); lats.add("22.549865");
    	lons.add("113.945216"); lats.add("22.548300");
    	lons.add("113.945194"); lats.add("22.547448");
    	lons.add("113.945280"); lats.add("22.546828");
    	lons.add("113.945318"); lats.add("22.545892");
    	lons.add("113.945301"); lats.add("22.545510");
    	lons.add("113.945260"); lats.add("22.545159");

    	for(int i=0; i < lons.size(); i++) {
    		//String url = "http://"+ip+":8080/BusServer/UploadLocation.do";
    	   // String par= "param={'head':{'TRACDE':'BC00002','TRADAT':'11111','TRATIM':'11111','USRNAM':'1'},'body':{'line':'4','longitude':"
    		//		+lons.get(i)+",'latitude':"+lats.get(i)+ "}}";
    	    //System.out.println(url+"?"+par);
    	    //String t1 = new DateUtil().getTm();
    	    //UploadLocationRes res = JSONObject.parseObject(MyHttpRequest.sendGet(url, par,"utf-8"),UploadLocationRes.class);
    	   // UploadLocationRes res = busService.UploadLocation("11",lons.get(i),lats.get(i));
    	   // String t2 = new DateUtil().getTm();
    	   // logger.info("bigin time["+ t1+"]-end time [" + t2 +"] time cost:["+String.valueOf((Integer.parseInt(t2.substring(4))-Integer.parseInt(t1.substring(4)))/100)+"ms]");
    	   // if(res == null || res.getBody() == null) continue;
    	   // logger.info("["+i+"]"+"["+res.getBody().getBus_laststa()+"]["+res.getBody().getBus_nextsta()+"]["+res.getBody().getBus_nextdis()+"]"+"["+String.valueOf((Integer.parseInt(t2.substring(4))-Integer.parseInt(t1.substring(4)))/100)+"ms]"+res.getHead().getERRMSG());
    	
    	    String url = "http://"+ip+"UploadLocation.do";
    	    String par= "param={'head':{'TRACDE':'BC00002','TRADAT':'11111','TRATIM':'11111','USRNAM':'1'},'body':{'line':'11','longitude':"
    				+lons.get(i)+",'latitude':"+lats.get(i)+ "}}";
    	    String t1 = new DateUtil().getTm();
    	    UploadLocationRes res = JSONObject.parseObject(MyHttpRequest.sendGet(url, par,"utf-8"),UploadLocationRes.class);
    	    String t2 = new DateUtil().getTm();
    	    if(res == null || res.getBody() == null) continue;
    	    logger.info("["+i+"]"+"["+res.getBody().getBus_laststa()+"]["+res.getBody().getBus_nextsta()+"]["+res.getBody().getBus_nextdis()+"]"+"["+String.valueOf((Integer.parseInt(t2.substring(4))-Integer.parseInt(t1.substring(4)))/100)+"ms]"+res.getHead().getERRMSG());

    	    
    	}
    }
}