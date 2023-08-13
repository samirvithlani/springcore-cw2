package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
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

	public List<UserBean> getAllUSers() {

		List<UserBean> userList = jdbcTemplate.query("select * from user", new ResultSetExtractor<List<UserBean>>() {

			@Override
			public List<UserBean> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<UserBean> users = new ArrayList<UserBean>();
				while (rs.next()) {
					UserBean userBean = new UserBean();
					// userBean.setuId(rs.getInt("id"));
					userBean.setuName(rs.getString("uname"));
					userBean.setuEmail(rs.getString("uemail"));
					userBean.setuPassword(rs.getString("upassword"));
					users.add(userBean);
				}
				return users;
			}

		});
		return userList;

	}

	public List<UserBean> getAllusers1() {

		return jdbcTemplate.query("select * from user", new UserMapper());
	}
	
	public UserBean getUserbyId(int uId) {
		
		return jdbcTemplate.queryForObject("select * from user where uid =?", new UserMapper(),uId);
	}

	class UserMapper implements RowMapper<UserBean> {

		@Override
		public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserBean userBean = new UserBean();
			userBean.setuId(rs.getInt("uid"));
			userBean.setuName(rs.getString("uname"));
			userBean.setuEmail(rs.getString("uemail"));
			userBean.setuPassword(rs.getString("upassword"));

			return userBean;
		}

	}

}
