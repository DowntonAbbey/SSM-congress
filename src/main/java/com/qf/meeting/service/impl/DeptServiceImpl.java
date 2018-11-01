package com.qf.meeting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.meeting.bean.Dept;
import com.qf.meeting.mapper.DeptMapper;
import com.qf.meeting.service.DeptService;

@Service
@Transactional
public class DeptServiceImpl implements DeptService{

	@Autowired
	private DeptMapper deptMapper;
	
	@Override
	public List<Dept> getList() {
		return deptMapper.getList();
	}

	@Override
	public Dept getById(Integer id) {
		return deptMapper.getById(id);
	}

	@Override
	public int add(Dept dept) {
		return deptMapper.add(dept);
	}

	@Override
	public int update(Dept dept) {
		return deptMapper.update(dept);
	}

	@Override
	public int deleteById(Integer id) {
		return deptMapper.deleteById(id);
	}

	@Override
	public int deleteByIds(List<Integer> ids) {
		return deptMapper.deleteByIds(ids);
	}
}
