package com.qf.meeting.test;

import java.io.IOException;
import java.security.spec.ECFieldF2m;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

import com.qf.meeting.bean.Emp;
import com.qf.meeting.dbutils.JdbcUtils;
import com.qf.meeting.mapper.EmpMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-base.xml")
public class TestEmpMapper extends AbstractDbutilsTestCase{

	public TestEmpMapper() throws DatabaseUnitException, SQLException, IOException {
		super(JdbcUtils.getConnection(), new FlatXmlDataSet(new InputSource(
				TestEmpMapper.class.getClassLoader().getResourceAsStream("Emp.xml"))));
	
	}
	
	@Autowired
	private EmpMapper empMapper = null;
	
	private Emp exEmp = null;
	
	@Before
	public void init() throws Exception{
		backOneTable("emp");
		insertTestData();
		exEmp = new Emp(1, "head.jpg", "jack", "18408250060", 1);
	}
	
	@Test
	public void testGetList() {
		List<Emp> lists= empMapper.getList();
		Emp emp = lists.get(0);
		Assert.assertEquals(exEmp.toString(), emp.toString());
	}
	
	@Test
	public void testGetById() {
		Emp emp = empMapper.getById(1);
		Assert.assertEquals(exEmp.toString(), emp.toString());
	}
	
	@Test
	public void testGetByDeptId() {
		List<Emp> list = empMapper.getByDeptId(1);
		Emp emp = list.get(0);
		Assert.assertEquals(exEmp.toString(), emp.toString());
	}
	
	@Test
	public void testAdd() {
		Emp emp = new Emp(null, "head.jpg", "tom", "18408250060", 1);
		int num = empMapper.add(emp);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testUpdate() {
		Emp emp = new Emp(1, "head.jpg", "tom", "18408250060", 1);
		int num = empMapper.update(emp);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testDeleteById() {
		int num = empMapper.deleteById(1);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testDeleteByIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		int num = empMapper.deleteByIds(ids);
		Assert.assertEquals(2, num);
	}
	
	@After
	public void destory() throws Exception{
		resumeTable();
	}

}
