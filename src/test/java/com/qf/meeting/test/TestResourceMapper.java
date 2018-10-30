package com.qf.meeting.test;

import java.io.IOException;
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

import com.qf.meeting.bean.Resource;
import com.qf.meeting.dbutils.JdbcUtils;
import com.qf.meeting.mapper.ResourceMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-base.xml")
public class TestResourceMapper extends AbstractDbutilsTestCase{

	public TestResourceMapper() throws DatabaseUnitException, SQLException, IOException {
		super(JdbcUtils.getConnection(), new FlatXmlDataSet(new InputSource(
				TestResourceMapper.class.getClassLoader().getResourceAsStream("Base.xml"))));
	}
	
	@Autowired
	private ResourceMapper resourceMapper;
	
	private Resource exResource;
	
	private Resource parmResource;
	
	@Before
	public void init() throws Exception {
		backOneTable("resource");
		insertTestData();
		exResource = new Resource(1, "通知名","通知地址", "资料详情", 1);
		parmResource = new Resource(1, "通知名","通知地址", "资料详情", 1);
	}
	
	@Test
	public void testGetList() {
		List<Resource> list = resourceMapper.getList();
		Resource news = list.get(0);
		Assert.assertEquals(exResource.toString(), news.toString());
	}
	
	@Test
	public void testGetByIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		List<Resource> list = resourceMapper.getByIds(ids);
		Resource news = list.get(0);
		Assert.assertEquals(exResource.toString(), news.toString());
	}
	
	@Test
	public void testGetById() {
		Resource news = resourceMapper.getById(1);
		Assert.assertEquals(exResource.toString(), news.toString());
	}
	
	@Test
	public void testAdd() {
		int num = resourceMapper.add(parmResource);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testUpdate() {
		int num = resourceMapper.update(exResource);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testDeleteById() {
		int num = resourceMapper.deleteById(1);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testDeleteByIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		int num = resourceMapper.deleteByIds(ids);
		Assert.assertEquals(2, num);
	}
	
	@Test
	public void testgetByNoticeIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		List<Resource> resources = resourceMapper.getByNoticeIds(ids);
		Assert.assertEquals(2, resources.size());
	}
	
	@Test
	public void testDeleteByNoticeIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		int num = resourceMapper.deleteByNoticeIds(ids);
		Assert.assertEquals(2, num);
		
	}

	@After
	public void destory() throws Exception {
		resumeTable();
	}
}
