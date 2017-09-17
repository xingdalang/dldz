package com.dzm.dldz.dao.extend;

import java.util.Set;

import com.dzm.dldz.bean.module.Module;

public interface ModuleMapperExtend {

	Set<Module> selectModuleByRoleId(Long roleid);
	
}