package com.dzm.dldz.service.module;

import java.util.Set;

import com.dzm.dldz.bean.module.Module;

public interface IModuleService {

	Set<Module> selectModuleByRoleId(Long roleid);

}
