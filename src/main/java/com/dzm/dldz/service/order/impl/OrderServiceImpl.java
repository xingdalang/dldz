package com.dzm.dldz.service.order.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.dzm.dldz.bean.order.Order;
import com.dzm.dldz.bean.order.OrderExample;
import com.dzm.dldz.dao.OrderMapper;
import com.dzm.dldz.service.order.IOrderService;
import com.dzm.dldz.util.Kuaidi100;
import com.dzm.dldz.util.ReturnDate;
@Service
public class OrderServiceImpl implements IOrderService{
	@Autowired
	OrderMapper orderMapper;
	@Override
	public List<Order> queryOrder() {
		OrderExample example = new OrderExample();
		List<Order> list = orderMapper.selectByExample(example);
		for (Order order : list) {
			String trans = order.getTrans();
			if(order.getState()==0){
				String add = getAdd(trans);
				if(add==null){
					order.setAddress("点击查看");
				}else{
					// 快递结果前7位
					String sub = add.substring(0,6);
					System.out.println(sub);
					if(sub.equals("快件已签收,")){
						System.out.println("dfsdmfoadjs");
						order.setAddress(add.substring(6,add.length()));
					}
				}
				orderMapper.updateByPrimaryKey(order);
			}
		}
		return list;
	}
	
	@Override
	public ReturnDate addOrder(Order order) {
		ReturnDate re = new ReturnDate();
		Map<String, Object> tranMap = null;
		try {
			String add = getAdd(order.getTrans());
			order.setAddress(add);
			order.setCreateby(1L);
			order.setCreatetime(new Date());
			order.setState(0);//0:已发货
			int insert = orderMapper.insert(order);
			re.setCode("0000");
			re.setResult(true);
			re.setMsg("添加成功!");
		} catch (Exception e) {
			re.setCode("9999");
			re.setMsg("添加失败!");
			re.setResult(false);
			e.printStackTrace();
		}
		return re;
	}
	
	private String getAdd(String trans){
		Map<String, Object> tranMap = null;
		String add = null;
		try {
			tranMap = Kuaidi100.tran(trans);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String state = (String) tranMap.get("state");
		String status = (String) tranMap.get("status");
		if(status.equals("1")){
			List<JSONObject> datas = (List<JSONObject>)tranMap.get("data");
			JSONObject data = datas.get(0);
			add = data.getString("context");
		}
		return add;
	}
}
