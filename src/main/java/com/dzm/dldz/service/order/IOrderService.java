package com.dzm.dldz.service.order;

import java.util.List;

import com.dzm.dldz.bean.order.Order;
import com.dzm.dldz.util.ReturnDate;

public interface IOrderService {

	/**
	 * 获取所有订单
	 * @return
	 * @author xingguanghui
	 */
	List<Order> queryOrder();

	/**
	 * 添加订单
	 * @param order
	 * @return
	 * @author xingguanghui
	 */
	ReturnDate addOrder(Order order);

}
