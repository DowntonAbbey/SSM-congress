package com.qf.meeting.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dbunit.DatabaseUnitException;
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

import com.qf.meeting.bean.UserStaff;
import com.qf.meeting.dbutils.JdbcUtils;
import com.qf.meeting.mapper.UserStaffMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-base.xml")
public class TestUserStaffMapper extends AbstractDbutilsTestCase{

	public TestUserStaffMapper() throws DatabaseUnitException, SQLException, IOException {
		super(JdbcUtils.getConnection(), new FlatXmlDataSet(new InputSource(
				TestUserMapper.class.getClassLoader().getResourceAsStream("UserStaff.xml"))));
	}
	
	@Autowired
	private UserStaffMapper userStaffMapper;
	
	private UserStaff exUserStaff;
	
	private UserStaff paramUserStaff;
	
	@Before
	public void init() throws Exception{
		backOneTable("user_staff");
		insertTestData();
		exUserStaff=new UserStaff(1, 1, 1);
		paramUserStaff=new UserStaff(null, 1, 1);
	}
	
	@Test
	public void testGetByUserId() {
		List<UserStaff> userStaffs = userStaffMapper.getByStaffId(1);
		Assert.assertEquals(exUserStaff.toString(), userStaffs.get(0).toString());
	}
	
	@Test
	public void testGetByStaffId() {
		List<UserStaff> userStaffs = userStaffMapper.getByUserId(1);
		Assert.assertEquals(exUserStaff.toString(), userStaffs.get(0).toString());
	}
	
	@Test
	public void testAdd() {
		int num = userStaffMapper.add(paramUserStaff);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testUpdateByUserId() {
		int num = userStaffMapper.updateByUserId(paramUserStaff);
		Assert.assertEquals(2, num);
	}
	
	@Test 
	public void testUpdateByStaffId() {
		int num = userStaffMapper.updateByStaffId(paramUserStaff);
		Assert.assertEquals(2, num);
	}
	
	@Test
	public void testDeleteByUserId() {
		int num = userStaffMapper.deleteByUserId(1);
		Assert.assertEquals(2, num);
	}
	
	@Test
	public void testDeleteByStaffId() {
		int num = userStaffMapper.deleteByStaffId(1);
		Assert.assertEquals(2, num);
	}
	
	@Test 
	public void testDeleteByUserIds() {
		List<Integer> userIds = new ArrayList<>();
		userIds.add(1);
		userIds.add(2);
		int num = userStaffMapper.deleteByStaffIds(userIds);
		Assert.assertEquals(4, num);
	}
	
	@Test
	public void testDeleteByStaffIds() {
		List<Integer> staffIds = new ArrayList<>();
		staffIds.add(1);
		staffIds.add(2);
		int num = userStaffMapper.deleteByStaffIds(staffIds);
		Assert.assertEquals(4, num);
	}
	
	@After
	public void destory() throws Exception{
		resumeTable();
	}

}
