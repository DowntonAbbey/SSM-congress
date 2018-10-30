package com.qf.meeting.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qf.meeting.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-base.xml")
public class EnviromentTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactoryBean session;
	
	@Autowired
	private UserMapper UserMapper;
	
	@Test
	public void testDataSource() {
		System.out.println(dataSource);
	}
	
	@Test
	public void testSession() {
		System.out.println(session);
	}
	
	@Test
	public void testUserMapper() {
		System.out.println(UserMapper);
	}
}
