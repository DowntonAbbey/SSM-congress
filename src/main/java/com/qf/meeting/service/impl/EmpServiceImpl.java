package com.qf.meeting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.meeting.bean.Emp;
import com.qf.meeting.mapper.EmpMapper;
import com.qf.meeting.service.EmpService;

@Service
@Transactional
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpMapper empMapper;
	
	@Override
	public List<Emp> getList() {
		return empMapper.getList();
	}

	@Override
	public Emp getById(Integer empId) {
		return empMapper.getById(empId);
	}

	@Override
	public List<Emp> getByDeptId(Integer deptId) {
		return empMapper.getByDeptId(deptId);
	}

	@Override
	public int add(Emp emp) {
		return empMapper.add(emp);
	}

	@Override
	public int update(Emp emp) {
		return empMapper.update(emp);
	}

	@Override
	public int deleteById(Integer id) {
		return empMapper.deleteById(id);
	}

	@Override
	public int deleteByIds(List<Integer> ids) {
		return empMapper.deleteByIds(ids);
	}

}
