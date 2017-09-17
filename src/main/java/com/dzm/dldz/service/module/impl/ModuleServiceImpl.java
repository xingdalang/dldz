package com.dzm.dldz.service.module.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzm.dldz.bean.module.Module;
import com.dzm.dldz.dao.extend.ModuleMapperExtend;
import com.dzm.dldz.service.module.IModuleService;
@Service
public class ModuleServiceImpl implements IModuleService{
	@Autowired
	ModuleMapperExtend moduleMapperExtend;
	@Override
	public Set<Module> selectModuleByRoleId(Long roleid) {
		Set<Module> modules = moduleMapperExtend.selectModuleByRoleId(roleid);
		return modules;
	}

}
