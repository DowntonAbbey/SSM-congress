package com.qf.meeting.service;

import java.util.List;

import com.qf.meeting.bean.Staff;

public interface StaffService {
	
	public List<Staff> getList();

	public Staff getById(Integer id);

	public int add(Staff staff);

	public int update(Staff staff);

	public int deleteById(Integer id);

	public int deleteByIds(List<Integer> ids);
}
