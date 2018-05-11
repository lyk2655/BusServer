package com.linyk3.test;


import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.linyk3.service.UserServiceImpl;
import com.linyk3.util.MyHttpRequest;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml","/spring-mybatis.xml"})
public class TestUserService {
    @Autowired
    private UserServiceImpl userService;
    private String ip = "localhost";

    @Test
    public void QueryLocation(){
    	String url = "http://"+ip+":8080/BusServer/QueryLocation.do";
	    String par= "param={'head':{'TRACDE':'BC00002','TRADAT':'11111','TRATIM':'11111','USRNAM':'1'},'body':{'line':'4','stanum':'3'}}";
	    System.out.println(url+"?"+par);
	    System.out.println("QueryLocation"+MyHttpRequest.sendGet(url, par,"utf-8"));
    }
    @Test
    public void BusLine(){
    	String url = "http://"+ip+":8080/BusServer/BusLine.do";
	    String par= "param={'head':{'TRACDE':'BC00002','TRADAT':'11111','TRATIM':'11111','USRNAM':'1'},'body':{'line':'4'}}";
	    System.out.println("BusLine"+MyHttpRequest.sendGet(url, par,"utf-8"));
    }
    
    @Test
    public void QueryClosestStation(){
    	String url = "http://"+ip+":8080/BusServer/QueryClosestStation.do";
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
    		System.out.println(i+":"+lons.get(i)+"   "+ lats.get(i));
    		//String url = "http://111.230.148.118:8080/BusServer/UploadLocation.do";
    		String url = "http://"+ip+":8080/BusServer/UploadLocation.do";
    	    String par= "param={'head':{'TRACDE':'BC00002','TRADAT':'11111','TRATIM':'11111','USRNAM':'1'},'body':{'line':'4','longitude':"
    				+lons.get(i)+",'latitude':"+lats.get(i)+ "}}";
    		//System.out.println(url+"?"+par);
    		//System.out.println("上传位置:【"+(i+1)+"】"+MyHttpRequest.sendGet(url, par,"utf-8"));
    		
    		
    	}
    }
}