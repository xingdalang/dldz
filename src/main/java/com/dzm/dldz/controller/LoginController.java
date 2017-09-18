package com.dzm.dldz.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.dzm.dldz.bean.user.User;
import com.dzm.dldz.util.Md5Util;
import com.dzm.dldz.util.ReturnDate;

@Controller
@RequestMapping("")
public class LoginController {
	@RequestMapping("/")
	public String index() {
		return "login/login";
	}
	
	
	
//	@RequestMapping("/login")
	@ResponseBody
	public ReturnDate login(User user) {
		System.out.println(JSON.toJSONString(user));
		ReturnDate re = new ReturnDate();
		if((user.getUsername().equals("jiandan"))&&(user.getPassword().equals("123456"))){
			re.setResult(true);
			re.setMsg("");
		}else {
			re.setMsg("密码错误!");
			re.setResult(false);
		}
		return re;
	}
	
	@RequestMapping("/login")
	@ResponseBody
    public ReturnDate loginUser(String username,String password,HttpSession session) {
		System.out.println(""+username +"--"+password);
		password = Md5Util.getMd5(password);
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        ReturnDate re = new ReturnDate();
        try {
            subject.login(usernamePasswordToken);   //完成登录
            User user=(User) subject.getPrincipal();
            session.setAttribute("user", user);
            re.setResult(true);
			re.setMsg("");
        }catch(Exception e) {
        	e.printStackTrace();
//            return "login";//返回登录页面
            re.setMsg("密码错误!");
			re.setResult(false);
        }
        return re;
    }
    @RequestMapping("/logOut")
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}
