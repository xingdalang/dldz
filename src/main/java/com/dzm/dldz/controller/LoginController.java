package com.dzm.dldz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.dzm.dldz.bean.user.User;
import com.dzm.dldz.util.ReturnDate;

@Controller
@RequestMapping("")
public class LoginController {
	@RequestMapping("/")
	public String index() {
		return "login/login";
	}
	
	
	
	@RequestMapping("/login")
	@ResponseBody
	public ReturnDate login(User user) {
		System.out.println(JSON.toJSONString(user));
		ReturnDate re = new ReturnDate();
		if((user.getUsername().equals("jiandan"))&&(user.getPass().equals("123456"))){
			re.setResult(true);
			re.setMsg("");
		}else {
			re.setMsg("密码错误!");
			re.setResult(false);
		}
		return re;
	}
}
