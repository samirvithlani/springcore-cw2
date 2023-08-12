package com.config;

import java.util.Date;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com")
public class AppConfig {

	@Bean
	public Date date() {
		return new Date();
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);

		return jdbcTemplate;
	}

	@Bean
	public DataSource dataSource() {

		// setter injection..
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/cw2spring");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
}
