package com.qf.meeting.service;

import java.util.List;

import com.qf.meeting.bean.Dept;

public interface DeptService {
	
	public List<Dept> getList();

	public Dept getById(Integer id);

	public int add(Dept dept);

	public int update(Dept dept);

	public int deleteById(Integer id);

	public int deleteByIds(List<Integer> ids);
}
