package com.linyk3.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MyHttpRequest {



    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @param charset         
     *             发送和接收的格式
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param,String charset) {
        String result = "";
        String line;
        StringBuffer sb=new StringBuffer();
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            //System.out.println(realUrl.toString());
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性 设置请求格式
            conn.setRequestProperty("contentType", charset); 
            conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            //设置超时时间
            conn.setConnectTimeout(600);
            conn.setReadTimeout(600);
            // 建立实际的连接
            conn.connect();
            // 定义 BufferedReader输入流来读取URL的响应,设置接收格式
            in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(),charset));
            //System.out.println(in);
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            result=sb.toString();
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            if(e.getMessage().equals("connect timed out")) {
            	return sendGet( url,  param, charset);
            }
            if(e.getMessage().equals("Read timed out")) {
            	return sendGet( url,  param, charset);
            }
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * @param url        发送请求的 URL
     * @param param   请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @param charset            发送和接收的格式       
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param,String charset) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        String line;
        StringBuffer sb=new StringBuffer();
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接 
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性 设置请求格式
            conn.setRequestProperty("contentType", charset);  
            conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            //设置超时时间
            conn.setConnectTimeout(60);
            conn.setReadTimeout(60);
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应    设置接收格式
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(),charset));
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            result=sb.toString();
        } catch (Exception e) {
            System.out.println("发送 POST请求出现异常!"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    
    public static void main(String[] args) {
    	//http://111.230.148.118:8080/BocbusServer/Mode.do?
    	//param={'head':{'TRACDE':'BC00001','TRADAT':'11111','TRATIM':'11111','USRNAM':'ling123'},'body':{'line':'2','mode':'P'}}
    	//String ip = "localhost"; 

    	String ip = "http://restapi.amap.com/v3/distance";
        String param="key=8ad12a9140feb5b3ebdcd83abf021d45&origins=116.481028,39.989643|114.481028,39.989643|115.481028,39.989643&destination=114.465302,40.004717&type=1";
       //String param="key=8ad12a9140feb5b3ebdcd83abf021d45&origins=116.481028,39.989643|114.481028,39.989643|115.481028,39.989643&destination=114.465302,40.004717&type=1";
        
       System.out.println("Get请求:"+MyHttpRequest.sendGet(ip, param,"utf-8"));
        /*String ip = "111.230.148.118";
    	String port = "8080";
        String getUrl="/BocbusServer/Mode.do";
        String getUrl2="/BocbusServer/BusLine.do";
        String param="param={'head':{'TRACDE':'BC00001','TRADAT':'11111','TRATIM':'11111','USRNAM':'ling123'},'body':{'line':'2','mode':'P'}}";
        String param2="param={'head':{'TRACDE':'BC00004','TRADAT':'11111','TRATIM':'11111','USRNAM':'ling123'},'body':{'line':'2'}}";
        for(int i =0; i < 1; i++)
    	{
        	System.out.println("Get请求1["+i+"]:"+MyHttpRequest.sendGet("http://"+ip+":"+port+getUrl, param,"utf-8"));
            System.out.println("Get请求2["+i+"]:"+MyHttpRequest.sendGet(("http://"+ip+":"+port+getUrl2), param2,"utf-8"));
    	} */
        
    }
}