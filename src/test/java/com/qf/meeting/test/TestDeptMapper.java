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

import com.qf.meeting.bean.Dept;
import com.qf.meeting.dbutils.JdbcUtils;
import com.qf.meeting.mapper.DeptMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-base.xml")
public class TestDeptMapper extends AbstractDbutilsTestCase {
	public TestDeptMapper() throws DatabaseUnitException, SQLException, IOException {
		super(JdbcUtils.getConnection(), new FlatXmlDataSet(new InputSource(
				TestDeptMapper.class.getClassLoader().getResourceAsStream("Dept.xml"))));
	}

	@Autowired
	private DeptMapper deptMapper;

	private Dept exDept, paramDept;

	@Before
	public void init() throws Exception {
		backOneTable("dept");
		insertTestData();
		exDept = new Dept(1, "部门名", "部门描述");
		paramDept = new Dept(1, "部门名", "部门描述");
	}

	@Test
	public void testGetList() {
		List<Dept> list = deptMapper.getList();
		Dept news = list.get(0);
		Assert.assertEquals(exDept.toString(), news.toString());
	}

	@Test
	public void testGetById() {
		Dept news = deptMapper.getById(1);
		Assert.assertEquals(exDept.toString(), news.toString());
	}

	@Test
	public void testAdd() {
		int num = deptMapper.add(paramDept);
		Assert.assertEquals(1, num);
	}

	@Test
	public void testUpdate() {
		int num = deptMapper.update(exDept);
		Assert.assertEquals(1, num);
	}

	@Test
	public void testDeleteById() {
		int num = deptMapper.deleteById(1);
		Assert.assertEquals(1, num);
	}

	@Test
	public void testDeleteByIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		int num = deptMapper.deleteByIds(ids);
		Assert.assertEquals(2, num);
	}

	@After
	public void destory() throws Exception {
		resumeTable();
	}
}
