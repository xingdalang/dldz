package com.dzm.dldz.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.dzm.dldz.bean.user.User;

public class SessionUtil {
	// 创建session
	public static Session getSession() {
		Subject currentUser = SecurityUtils.getSubject();
		return currentUser.getSession();
	}
	
	// 获取用户session的值
	public static User getUserSession() {
		User u = (User) getSession().getAttribute("user");
		return u;
	}
}
