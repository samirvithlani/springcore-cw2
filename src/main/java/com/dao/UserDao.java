package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

//spring bean
@Repository("userdao")
public class UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addUser() {

		return jdbcTemplate.update("insert into user(uname,uemail,upassword)values(?,?,?)", "amit", "amit@gmail.com",
				"amit123");
	}

	public int addUser1(UserBean userBean) {

		return jdbcTemplate.update("insert into user(uname,uemail,upassword)values(?,?,?)", userBean.getuName(),
				userBean.getuEmail(), userBean.getuPassword());
	}

}
