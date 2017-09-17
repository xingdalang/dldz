package com.dzm.dldz.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzm.dldz.bean.user.User;
import com.dzm.dldz.bean.user.UserExample;
import com.dzm.dldz.dao.UserMapper;
import com.dzm.dldz.service.user.IUserService;
@Service
public class UserSerivceImpl implements IUserService{
	@Autowired
	UserMapper userMapper;
	@Override 
	public List<User> getAllUser() {
		UserExample example = new UserExample();
		List<User> list = userMapper.selectByExample(example);
		return list;
	}
	@Override
	public List<User> selectByExample(UserExample example) {
		List<User> list = userMapper.selectByExample(example);
		return list;
	}

}
