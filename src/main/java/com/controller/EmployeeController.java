package com.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.bean.EmployeeBean;

public class EmployeeController {

	public static void main(String[] args) {
		
		//depedency injection runtime properties-->
		// constructor injection
		// setter inject --- setters
		
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src//main//java//com//ApplicationContext.xml");
		///ctx is spring coontainer
		
//		EmployeeBean employeeBean1 = new EmployeeBean();
//		EmployeeBean employeeBean2 = new EmployeeBean();
//		System.out.println(employeeBean1);
//		System.out.println(employeeBean2);
		
		EmployeeBean employeeBean1 = (EmployeeBean) ctx.getBean("emp");
		EmployeeBean employeeBean2 = (EmployeeBean) ctx.getBean("emp");
		
		System.out.println(employeeBean1);
		System.out.println(employeeBean2);
		System.out.println(employeeBean1.getId());
		System.out.println(employeeBean1.getName());
		System.out.println(employeeBean1.getDate());
		 
		
	}
}
