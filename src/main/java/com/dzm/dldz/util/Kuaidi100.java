package com.dzm.dldz.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Kuaidi100 {
	/**
	 *  返回类型： 
		0：返回json字符串， 
		1：返回xml对象， 
		2：返回html对象， 
		3：返回text文本。 
		如果不填，默认返回json字符串。
	 */
	private final static String key = "ca8593c08927589b";
	
	public static Map<String, Object> tran(String tno){
		String com = getCom(tno);
		String url = "http://api.kuaidi100.com/api?id="+key+"&com="+com+"&nu="+tno+"&show=0&muti=1&order=desc";
		String re = loadJSON(url);
		Map<String, Object> map = null;
		map = (Map<String, Object>) JSON.parse(re);
		return map;
	}
	@Test
	public void testName() throws Exception {
		Map<String, Object> tran = tran("667892293768");
		System.out.println(tran.get("data"));
		List<JSONObject> a = (List<JSONObject>) tran.get("data");
		JSONObject o = a.get(0);
		Object object = o.get("context");
		System.out.println(object);
	}
	@Test
	public void dfs() throws Exception {
		String d = "{\"context\":\"快件已签收,签收人是乡镇代理点，签收网点是平江县长寿分部\",\"location\":\"dsa\",\"time\":\"dfs2017-09-11 15:21:03\"}";
		JSONObject dd = JSON.parseObject(d);
		System.out.println(dd.get("context"));
	}
	
	
	 public static String loadJSON(String url) {
		          StringBuilder json = new StringBuilder();
		          try {
		              URL oracle = new URL(url);
		              URLConnection yc = oracle.openConnection();
		              BufferedReader in = new BufferedReader(new InputStreamReader(
		                      yc.getInputStream(),"utf-8"));//防止乱码
		              String inputLine = null;
		              while ((inputLine = in.readLine()) != null) {
		                  json.append(inputLine);
		              }
		              in.close();
		          } catch (MalformedURLException e) {
		          } catch (IOException e) {
		          }
		          return json.toString();
		     }
	 
	 /**
	 * @param no
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getCom(String no){
		 no = "667892293768";
		 String url = "https://m.kuaidi100.com/autonumber/auto?num=";
		 String com = loadJSON(url+no);
		 List<Map<String, Object>> list;
		 Object parse = JSON.parse(com);
		 list = (List<Map<String, Object>>) parse;
		 Map<String, Object> map = list.get(0);
		 String comCode = (String) map.get("comCode");
		 return comCode;
	 }
	 
	 /**
	  * state	快递单当前的状态 ：　 
		0：在途，即货物处于运输过程中；
		1：揽件，货物已由快递公司揽收并且产生了第一条跟踪信息；
		2：疑难，货物寄送过程出了问题；
		3：签收，收件人已签收；
		4：退签，即货物由于用户拒签、超区等原因退回，而且发件人已经签收；
		5：派件，即快递正在进行同城派件；
		6：退回，货物正处于退回发件人的途中；
		该状态还在不断完善中，若您有更多的参数需求，欢迎发邮件至 kuaidi@kingdee.com 提出。
		status	查询结果状态： 
		0：物流单暂无结果， 
		1：查询成功， 
		2：接口出现异常，
	  */
	 
}
