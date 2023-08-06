package com.controller;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.bean.StudentBean;
import com.config.AppConfig;

public class StudentController {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		StudentBean studentBean = (StudentBean) ctx.getBean("stu");
		StudentBean studentBean1 = (StudentBean) ctx.getBean("stu");
		System.out.println(ctx);
		studentBean.setsId(101);
		System.out.println(studentBean.getsId());
		System.out.println(studentBean.getDate());

		studentBean.getDetail().setCity("ahmedabad");
		System.out.println(studentBean.getDetail().getCity());

		System.out.println(studentBean);
		System.out.println(studentBean1);
		//((ConfigurableApplicationContext)ctx).close();
		((AbstractApplicationContext)ctx).close();
		

	}
}
