package com.dzm.dldz.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController {
	@RequestMapping("/get")
	@ResponseBody
	public String get() {
		return "get";
	}

	@RequestMapping("/hello")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "hello";
	}

	@RequestMapping("/ftl")
	public String hello(Map<String, Object> map) {
		map.put("name", "[Angel -- 守护天使]");
		return "order";
	}
}
