package com.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bean.UserBean;
import com.config.AppConfig;
import com.dao.UserDao;

public class UserController {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		UserDao userDao = (UserDao) ctx.getBean("userdao");
		//userDao.addUser();

		UserBean userBean = new UserBean();
		userBean.setuName("raj");
		userBean.setuEmail("raj@gmail.com");
		userBean.setuPassword("raj123");

		int x = userDao.addUser1(userBean);
		if(x>0) {
			System.out.println("user inserted..");
		}
		else {
			
			System.out.println("user not inserted...");
		}

	}
}
