package com.bean;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//sterotype annotaion
//@component --> genric annotation
//@repository --> database layer class,, spring Dao
//@service   -->business logic
//@controller -->servelet ->

@Component("stu")
@Scope("prototype")
public class StudentBean {

	private int sId;
	private String sName;

	@Autowired
	private Date date;

	@Autowired
	private StudentDetail detail;

	public StudentDetail getDetail() {
		return detail;
	}

	public void setDetail(StudentDetail detail) {
		this.detail = detail;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	@PostConstruct
	public void myInit() {

		System.out.println("init method calle.d....");
	}

	@PreDestroy
	public void myDestroy() {
		System.out.println("my detroy...");

	}

}
