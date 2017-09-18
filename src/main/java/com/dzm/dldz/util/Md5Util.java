package com.dzm.dldz.util;

import java.security.MessageDigest;
import org.apache.tomcat.util.codec.binary.Base64;

public class Md5Util {
	public static String getMd5(String msg){
		 String md5str = "";  
		    try {  
	        // 1 创建一个提供信息摘要算法的对象，初始化为md5算法对象  
	        MessageDigest md = MessageDigest.getInstance("MD5");  
	  
	        // 2 将消息变成byte数组  
	        byte[] input = msg.getBytes();  
	  
	        // 3 计算后获得字节数组,这就是那128位了  
	        byte[] buff = md.digest(input);  
	  
	        // 4 base64
	        md5str = Base64.encodeBase64String(buff);
		  
		    } catch (Exception e) {  
		        e.printStackTrace();  
		    }  
		    return md5str;  
	}
}
