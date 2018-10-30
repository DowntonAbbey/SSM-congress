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

import com.qf.meeting.bean.UserNotice;
import com.qf.meeting.dbutils.JdbcUtils;
import com.qf.meeting.mapper.UserNoticeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-base.xml")
public class TestUserNoticeMapper extends AbstractDbutilsTestCase{

	public TestUserNoticeMapper() throws DatabaseUnitException, SQLException, IOException {
		super(JdbcUtils.getConnection(), new FlatXmlDataSet(new InputSource(
				TestUserMapper.class.getClassLoader().getResourceAsStream("UserNotice.xml"))));
	}
	
	@Autowired
	private UserNoticeMapper userNoticeMapper;
	
	private UserNotice exUserNotice;
	
	private UserNotice paramUserNotice;
	
	@Before
	public void init() throws Exception{
		backOneTable("user_notice");
		insertTestData();
		exUserNotice=new UserNotice(1, 1, 1);
		paramUserNotice=new UserNotice(null, 1, 1);
	}
	
	@Test
	public void testGetByUserId() {
		List<UserNotice> userNotices = userNoticeMapper.getByNoticeId(1);
		Assert.assertEquals(exUserNotice.toString(), userNotices.get(0).toString());
	}
	
	@Test
	public void testGetByNoticeId() {
		List<UserNotice> userNotices = userNoticeMapper.getByUserId(1);
		Assert.assertEquals(exUserNotice.toString(), userNotices.get(0).toString());
	}
	
	@Test
	public void testAdd() {
		int num = userNoticeMapper.add(paramUserNotice);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testUpdateByUserId() {
		int num = userNoticeMapper.updateByUserId(paramUserNotice);
		Assert.assertEquals(1, num);
	}
	
	@Test 
	public void testUpdateByNoticeId() {
		int num = userNoticeMapper.updateByNoticeId(paramUserNotice);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testDeleteByUserId() {
		int num = userNoticeMapper.deleteByUserId(1);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testDeleteByNoticeId() {
		int num = userNoticeMapper.deleteByNoticeId(1);
		Assert.assertEquals(1, num);
	}
	
	@Test 
	public void testDeleteByUserIds() {
		List<Integer> userIds = new ArrayList<>();
		userIds.add(1);
		int num = userNoticeMapper.deleteByNoticeIds(userIds);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testDeleteByNoticeIds() {
		List<Integer> noticeIds = new ArrayList<>();
		noticeIds.add(1);
		int num = userNoticeMapper.deleteByNoticeIds(noticeIds);
		Assert.assertEquals(1, num);
	}
	
	@After
	public void destory() throws Exception{
		resumeTable();
	}

}
