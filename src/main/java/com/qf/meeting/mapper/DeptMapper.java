package com.qf.meeting.mapper;

import java.util.List;


import com.qf.meeting.bean.Dept;

public interface DeptMapper {
	
	public List<Dept> getList();
	
	public Dept getById(Integer id);
	
	public int add(Dept dept);
	
	public int update(Dept dept);
	
	public int deleteById(Integer id);
	
	public int deleteByIds(List<Integer> ids);
}
