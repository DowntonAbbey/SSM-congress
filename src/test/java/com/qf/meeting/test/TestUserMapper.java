package com.qf.meeting.test;



import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove;
import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xml.sax.InputSource;

import com.qf.meeting.bean.Delegation;
import com.qf.meeting.bean.Staff;
import com.qf.meeting.bean.User;
import com.qf.meeting.dbutils.JdbcUtils;
import com.qf.meeting.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-base.xml")
public class TestUserMapper extends AbstractDbutilsTestCase{
	
	
	
	public TestUserMapper() throws DatabaseUnitException, SQLException, IOException {
		super(JdbcUtils.getConnection(), new FlatXmlDataSet(new InputSource(
				TestUserMapper.class.getClassLoader().getResourceAsStream("User.xml"))));
	}

	@Autowired
	private UserMapper userMapper;
	
	private User exUser;
	
	
	@Test
	public void testGetList() {
		List<User> lists = userMapper.getList();
		for(User user:lists) {
			System.out.println(user);
			Delegation delegation = user.getDelegation();
			System.out.println(delegation);
			List<Staff> staffs = user.getStaffs();
			for(Staff staff:staffs) {
				System.out.println("staff:"+staff);
			}
		}
	}
	
	@Test
	public void testGetByName() {
		User user = userMapper.getByUserName("lisi1");
		Assert.assertEquals(user.getUserLoginName(), exUser.getUserLoginName());
	}
	
	@Test
	public void testGetById() {
		User user = userMapper.getById(1);
		Assert.assertEquals(exUser.toString(), user.toString());
	}
	
	
	
	@Test
	public void testDeleteById() {
		int num = userMapper.deleteById(1);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testDeleteByIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);	
		int num = userMapper.deleteByIds(ids);
		Assert.assertEquals(2, num);
	}
	
	
	
}
