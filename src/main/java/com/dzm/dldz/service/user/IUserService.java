package com.dzm.dldz.service.user;

import java.util.List;

import com.dzm.dldz.bean.user.User;
import com.dzm.dldz.bean.user.UserExample;

public interface IUserService {
	/**
	 * 
	 * @return
	 * @author xingguanghui
	 */
	public List<User> getAllUser();
	

	List<User> selectByExample(UserExample example);
}
