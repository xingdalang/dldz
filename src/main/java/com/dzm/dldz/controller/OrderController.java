package com.dzm.dldz.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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
	
	@RequiresPermissions(value = { "add" })
	@RequestMapping("/list")
	public String hello(Map<String, Object> map,Model model) {
		OrderQO qo = new OrderQO();
		model.addAttribute("qo", qo);
		return "order/order";
	}
	
	@RequestMapping("/listBody")
	public String queryOrder(Model model,OrderQO qo){
		if(qo==null){
			qo = new OrderQO();
		}
		List<Order> list = orderService.queryOrder();
		model.addAttribute("list", list);
		model.addAttribute("PageResult", qo);
		return "order/listBody";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public ReturnDate addOrder(Order order){
		ReturnDate re = orderService.addOrder(order);
		return re;
	}
}
