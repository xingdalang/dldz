package com.dzm.dldz.service.order.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzm.dldz.bean.order.Order;
import com.dzm.dldz.bean.order.OrderExample;
import com.dzm.dldz.dao.OrderMapper;
import com.dzm.dldz.service.order.IOrderService;
import com.dzm.dldz.util.ReturnDate;
@Service
public class OrderServiceImpl implements IOrderService{
	@Autowired
	OrderMapper orderMapper;
	@Override
	public List<Order> queryOrder() {
		OrderExample example = new OrderExample();
		List<Order> list = orderMapper.selectByExample(example);
		return list;
	}
	
	@Override
	public ReturnDate addOrder(Order order) {
		ReturnDate re = new ReturnDate();
		try {
			order.setCreateby(1L);
			order.setCreatetime(new Date());
			order.setState(0);//0:已发货
			int insert = orderMapper.insert(order);
			re.setCode("0000");
			re.setMsg("添加成功!");
		} catch (Exception e) {
			re.setCode("9999");
			re.setMsg("添加失败!");
			e.printStackTrace();
		}
		return re;
	}
}
