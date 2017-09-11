package com.dzm.dldz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.dzm.dldz.bean.user.User;
import com.dzm.dldz.service.user.IUserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	IUserService userService;
	
	@RequestMapping("/getAll")
	@ResponseBody
	public List<User> getAllUser(){
		List<User> list = userService.getAllUser();
		System.out.println(JSON.toJSONString(list));
		return list;
	}
	
	
}
