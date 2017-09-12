package com.dzm.dldz.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzm.dldz.bean.order.Order;
import com.dzm.dldz.qo.OrderQO;
import com.dzm.dldz.qo.QueryObject;
import com.dzm.dldz.service.order.IOrderService;
import com.dzm.dldz.util.ReturnDate;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	IOrderService orderService;
	

	@RequestMapping("/hello")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "hello";
	}

	@RequestMapping("/list")
	public String hello(Map<String, Object> map,Model model) {
		OrderQO qo = new OrderQO();
		model.addAttribute("qo", qo);
		return "order";
	}
	
	@RequestMapping("/listBody")
	public String queryOrder(Model model,OrderQO qo){
		if(qo==null){
			qo = new OrderQO();
		}
		List<Order> list = orderService.queryOrder();
		model.addAttribute("list", list);
		model.addAttribute("PageResult", qo);
		return "listBody";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public ReturnDate addOrder(Order order){
		ReturnDate re = orderService.addOrder(order);
		return re;
	}
}
