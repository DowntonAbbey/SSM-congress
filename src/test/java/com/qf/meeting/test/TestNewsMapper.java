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

import com.qf.meeting.bean.News;
import com.qf.meeting.dbutils.JdbcUtils;
import com.qf.meeting.mapper.NewsMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-base.xml")
public class TestNewsMapper extends AbstractDbutilsTestCase{

	public TestNewsMapper() throws DatabaseUnitException, SQLException, IOException {
		super(JdbcUtils.getConnection(), new FlatXmlDataSet(new InputSource(
				TestNewsMapper.class.getClassLoader().getResourceAsStream("Base.xml"))));
	}
	
	@Autowired
	private NewsMapper newsMapper;
	
	private News exNews;
	
	private News parmNews;
	
	@Before
	public void init() throws Exception{
		backOneTable("news");
		insertTestData();
		exNews = new News(1, "新闻标题", "新闻描述", "新闻细节", 1, "news.jpg");
		parmNews = new News(1, "新闻标题", "新闻描述", "新闻细节", 1, "news.jpg");
	}
	
	@Test
	public void testGetList() {
		List<News> list = newsMapper.getList();
		News news = list.get(0);
		Assert.assertEquals(exNews.toString(), news.toString());
	}
	
	@Test
	public void testGetByIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		List<News> list = newsMapper.getByIds(ids);
		News news = list.get(0);
		Assert.assertEquals(exNews.toString(), news.toString());
	}
	
	@Test
	public void testGetById() {
		News news = newsMapper.getById(1);
		Assert.assertEquals(exNews.toString(), news.toString());
	}
	
	@Test
	public void testAdd() {
		int num = newsMapper.add(parmNews);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testUpdate() {
		int num = newsMapper.update(exNews);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testDeleteById() {
		int num = newsMapper.deleteById(1);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testDeleteByIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		int num = newsMapper.deleteByIds(ids);
		Assert.assertEquals(2, num);
	}
	@After
	public void destory() throws Exception{
		resumeTable();
	}

}
