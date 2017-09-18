package com.dzm.dldz.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.security.auth.login.AccountException;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
//http://www.cnblogs.com/hlhdidi/p/6376457.html
public class AuthRealm extends AuthorizingRealm{
	 @Autowired
	 private IUserService userService;
	 @Autowired
	 private IRoleService roleService;
	 @Autowired
	 private IModuleService moduleService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		User user=(User) principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
        List<String> permissions=new ArrayList<String>();
//        Set<Role> roles = user.getRoles();
        Set<Role> roles = roleService.selectRoleByUserId(user.getUserid());
        if(roles.size()>0) {
            for(Role role : roles) {
            	Set<Module> modules = moduleService.selectModuleByRoleId(role.getRoleid());
//                Set<Module> modules = role.getModules();
                if(modules.size()>0) {
                    for(Module module : modules) {
                        permissions.add(module.getModulename());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);//将权限放入shiro中.
        return info;
	}
	
	//认证.登录
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		 UsernamePasswordToken utoken=(UsernamePasswordToken) token;//获取用户输入的token
	        String username = utoken.getUsername();
	        char[] password = utoken.getPassword();
	        UserExample example = new UserExample();
	        Criteria criteria = example.createCriteria();
	        criteria.andUsernameEqualTo(username);
	        criteria.andPasswordEqualTo(new String(password));
	        List<User> list = userService.selectByExample(example);
	        User user = null;
	        if(list.size()!=0){
	            user = list.get(0);
	        }
	        System.out.println("user:"+JSON.toJSONString(user));
	        if (null == user) {
	        	try {
					throw new AccountException("密码错误！");
				} catch (AccountException e) {
					e.printStackTrace();
					throw new RuntimeException("密码错误！");
				}
	        }
	    /*    else if(0==0){
	            *//**
	             * 如果用户的status为禁用。那么就抛出<code>DisabledAccountException</code>
	             *//*
	            throw new DisabledAccountException("帐号已经禁止登录！");
	        }*/
	        return new SimpleAuthenticationInfo(user, user.getPassword(),this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
	}

}
