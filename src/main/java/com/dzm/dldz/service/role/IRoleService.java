package com.dzm.dldz.service.role;

import java.util.Set;

import com.dzm.dldz.bean.role.Role;

public interface IRoleService {

	/**
	 * 
	 * @return
	 */
	Set<Role> selectRoleByUserId(Long id);

}
