package com.dzm.dldz.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authz.AuthorizationFilter;
//http://blog.csdn.net/splf32/article/details/54922753
public class LoginFilter extends AuthorizationFilter{

	@Override
	protected boolean isAccessAllowed(ServletRequest arg0, ServletResponse arg1, Object arg2) throws Exception {
		
		return false;
	}

}
