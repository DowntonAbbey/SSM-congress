package com.qf.meeting.test;

import java.io.IOException;
import java.sql.Connection;
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

import com.qf.meeting.bean.Agenda;
import com.qf.meeting.dbutils.JdbcUtils;
import com.qf.meeting.mapper.AgendaMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-base.xml")
public class TestAgendaMapper extends AbstractDbutilsTestCase{

	public TestAgendaMapper() throws DatabaseUnitException, SQLException, IOException {
		super(JdbcUtils.getConnection(), new FlatXmlDataSet(new InputSource(
				TestAgendaMapper.class.getClassLoader().getResourceAsStream("Base.xml"))));
	}
	
	@Autowired
	private AgendaMapper agendaMapper;
	
	private Agenda exAgenda;
	
	private Agenda parmAgenda;
	
	@Before
	public void init() throws Exception {
		backOneTable("agenda");
		insertTestData();
		exAgenda = new Agenda(1, "通知名", "2018-1-1", "通知地址", "议程细节", 1);
		parmAgenda = new Agenda(1, "通知名", "2018-1-1", "通知地址", "议程细节", 1);
	}
	
	@Test
	public void testGetList() {
		List<Agenda> list = agendaMapper.getList();
		Agenda news = list.get(0);
		Assert.assertEquals(exAgenda.toString(), news.toString());
	}
	
	@Test
	public void testGetByIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		List<Agenda> list = agendaMapper.getByIds(ids);
		Agenda news = list.get(0);
		Assert.assertEquals(exAgenda.toString(), news.toString());
	}
	
	@Test
	public void testGetById() {
		Agenda news = agendaMapper.getById(1);
		Assert.assertEquals(exAgenda.toString(), news.toString());
	}
	
	@Test
	public void testAdd() {
		int num = agendaMapper.add(parmAgenda);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testUpdate() {
		int num = agendaMapper.update(exAgenda);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testDeleteById() {
		int num = agendaMapper.deleteById(1);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testDeleteByIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		int num = agendaMapper.deleteByIds(ids);
		Assert.assertEquals(2, num);
	}
	
	@Test
	public void testgetByNoticeIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		List<Agenda> agendas = agendaMapper.getByNoticeIds(ids);
		Assert.assertEquals(2, agendas.size());
	}
	
	@Test
	public void testDeleteByNoticeIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		int num = agendaMapper.deleteByNoticeIds(ids);
		Assert.assertEquals(2, num);
		
	}

	@After
	public void destory() throws Exception {
		resumeTable();
	}
	
	

}
