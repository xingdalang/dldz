package com.dzm.dldz.service.role.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzm.dldz.bean.role.Role;
import com.dzm.dldz.dao.extend.RoleMapperExtend;
import com.dzm.dldz.service.role.IRoleService;
@Service
public class RoleServiceImpl implements IRoleService{
	@Autowired
	RoleMapperExtend roleMapperExtend;
	@Override
	public Set<Role> selectRoleByUserId(Long id) {
		Set<Role> roles = roleMapperExtend.selectRoleByUserId(id);
		return roles;
	}

}
