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

import com.qf.meeting.bean.Delegation;
import com.qf.meeting.dbutils.JdbcUtils;
import com.qf.meeting.mapper.DelegationMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-base.xml")
public class TestDelegationMapper extends AbstractDbutilsTestCase{

	public TestDelegationMapper() throws DatabaseUnitException, SQLException, IOException {
		super(JdbcUtils.getConnection(), new FlatXmlDataSet(new InputSource(
				TestDelegationMapper.class.getClassLoader().getResourceAsStream("Delegation.xml"))));
	}
	
	@Autowired
	private DelegationMapper delegationMapper;
	
	private Delegation exDelegation,paramDelegation;
	
	@Before
	public void init() throws Exception {
		backOneTable("delegation");
		insertTestData();
		exDelegation = new Delegation(1, "代表团名", "代表团描述");
		paramDelegation = new Delegation(1, "代表团名", "代表团描述");
	}
	
	@Test
	public void testGetList() {
		List<Delegation> list = delegationMapper.getList();
		Delegation news = list.get(0);
		Assert.assertEquals(exDelegation.toString(), news.toString());
	}
	
	
	
	@Test
	public void testGetById() {
		Delegation news = delegationMapper.getById(1);
		Assert.assertEquals(exDelegation.toString(), news.toString());
	}
	
	@Test
	public void testAdd() {
		int num = delegationMapper.add(paramDelegation);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testUpdate() {
		int num = delegationMapper.update(exDelegation);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testDeleteById() {
		int num = delegationMapper.deleteById(1);
		Assert.assertEquals(1, num);
	}
	
	@Test
	public void testDeleteByIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		int num = delegationMapper.deleteByIds(ids);
		Assert.assertEquals(2, num);
	}

	@After
	public void destory() throws Exception {
		resumeTable();
	}
}
