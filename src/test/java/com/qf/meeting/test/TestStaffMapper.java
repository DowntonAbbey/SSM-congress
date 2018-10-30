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

import com.qf.meeting.bean.Staff;
import com.qf.meeting.dbutils.JdbcUtils;
import com.qf.meeting.mapper.StaffMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-base.xml")
public class TestStaffMapper extends AbstractDbutilsTestCase{
	public TestStaffMapper() throws DatabaseUnitException, SQLException, IOException {
		super(JdbcUtils.getConnection(), new FlatXmlDataSet(new InputSource(
				TestStaffMapper.class.getClassLoader().getResourceAsStream("Staff.xml"))));
	}
	
	@Autowired
	private StaffMapper staffMapper;
	
	private Staff exStaff,paramStaff;
	
	@Before
	public void init() throws Exception {
		backOneTable("staff");
		insertTestData();
		exStaff = new Staff(1, "职位名");
		paramStaff = new Staff(1, "职位名");
	}
	
	@Test
	public void testGetList() {
		List<Staff> list = staffMapper.getList();
		Staff news = list.get(0);
		Assert.assertEquals(exStaff.toString(), news.toString());
	}
	
	
	
	@Test
	public void testGetById() {
		Staff news = staffMapper.getById(1);
		Assert.assertEquals(exStaff.toString(), news.toString());
	}
	
	@Test
	public void testAdd() {
		int num = staffMapper.add(paramStaff);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testUpdate() {
		int num = staffMapper.update(exStaff);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testDeleteById() {
		int num = staffMapper.deleteById(1);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testDeleteByIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		int num = staffMapper.deleteByIds(ids);
		Assert.assertEquals(2, num);
	}

	@After
	public void destory() throws Exception {
		resumeTable();
	}
}
