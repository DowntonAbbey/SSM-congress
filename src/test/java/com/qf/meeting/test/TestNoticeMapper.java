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

import com.qf.meeting.bean.Notice;
import com.qf.meeting.bean.Notice;
import com.qf.meeting.dbutils.JdbcUtils;
import com.qf.meeting.mapper.NoticeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-base.xml")
public class TestNoticeMapper extends AbstractDbutilsTestCase {

	public TestNoticeMapper() throws DatabaseUnitException, SQLException, IOException {
		super(JdbcUtils.getConnection(), new FlatXmlDataSet(
				new InputSource(TestNoticeMapper.class.getClassLoader().getResourceAsStream("Notice.xml"))));
	}

	@Autowired
	private NoticeMapper noticeMapper;
	
	private Notice exNotice;
	
	private Notice parmNotice;
	
	@Before
	public void init() throws Exception {
		backOneTable("notice");
		insertTestData();
		exNotice = new Notice(1, "通知标题", "2018-1-1", "通知地址");
		parmNotice = new Notice(1, "通知标题", "2018-1-1", "通知地址");
	}
	
	@Test
	public void testGetList() {
		List<Notice> list = noticeMapper.getList();
		Notice news = list.get(0);
		Assert.assertEquals(exNotice.toString(), news.toString());
	}
	
	@Test
	public void testGetByIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		List<Notice> list = noticeMapper.getByIds(ids);
		Notice news = list.get(0);
		Assert.assertEquals(exNotice.toString(), news.toString());
	}
	
	@Test
	public void testGetById() {
		Notice news = noticeMapper.getById(1);
		Assert.assertEquals(exNotice.toString(), news.toString());
	}
	
	@Test
	public void testAdd() {
		int num = noticeMapper.add(parmNotice);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testUpdate() {
		int num = noticeMapper.update(exNotice);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testDeleteById() {
		int num = noticeMapper.deleteById(1);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testDeleteByIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		int num = noticeMapper.deleteByIds(ids);
		Assert.assertEquals(2, num);
	}

	@After
	public void destory() throws Exception {
		resumeTable();
	}
}
