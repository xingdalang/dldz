package com.dzm.dldz.dao.extend;

import java.util.Set;

import com.dzm.dldz.bean.role.Role;

public interface RoleMapperExtend {

	Set<Role> selectRoleByUserId(Long userid);

}
