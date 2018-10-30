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

import com.qf.meeting.bean.Seat;
import com.qf.meeting.dbutils.JdbcUtils;
import com.qf.meeting.mapper.SeatMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-base.xml")
public class TestSeatMapper extends AbstractDbutilsTestCase{

	public TestSeatMapper() throws DatabaseUnitException, SQLException, IOException {
		super(JdbcUtils.getConnection(), new FlatXmlDataSet(new InputSource(
				TestSeatMapper.class.getClassLoader().getResourceAsStream("Base.xml"))));
	}
	
	@Autowired
	private SeatMapper seatMapper;
	
	private Seat exSeat;
	
	private Seat parmSeat;
	
	@Before
	public void init() throws Exception {
		backOneTable("seat");
		insertTestData();
		exSeat = new Seat(1, "通知名", "2018-1-1", "通知地址", "座位号", 1);
		parmSeat = new Seat(1, "通知名", "2018-1-1", "通知地址", "座位号", 1);
	}
	
	@Test
	public void testGetList() {
		List<Seat> list = seatMapper.getList();
		Seat news = list.get(0);
		Assert.assertEquals(exSeat.toString(), news.toString());
	}
	
	@Test
	public void testGetByIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		List<Seat> list = seatMapper.getByIds(ids);
		Seat news = list.get(0);
		Assert.assertEquals(exSeat.toString(), news.toString());
	}
	
	@Test
	public void testGetById() {
		Seat news = seatMapper.getById(1);
		Assert.assertEquals(exSeat.toString(), news.toString());
	}
	
	@Test
	public void testAdd() {
		int num = seatMapper.add(parmSeat);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testUpdate() {
		int num = seatMapper.update(exSeat);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testDeleteById() {
		int num = seatMapper.deleteById(1);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testDeleteByIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		int num = seatMapper.deleteByIds(ids);
		Assert.assertEquals(2, num);
	}
	
	@Test
	public void testgetByNoticeIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		List<Seat> seats = seatMapper.getByNoticeIds(ids);
		Assert.assertEquals(2, seats.size());
	}
	
	@Test
	public void testDeleteByNoticeIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		int num = seatMapper.deleteByNoticeIds(ids);
		Assert.assertEquals(2, num);
		
	}

	@After
	public void destory() throws Exception {
		resumeTable();
	}
	
}
