package com.qf.meeting.mapper;

import java.util.List;

import com.qf.meeting.bean.Staff;

public interface StaffMapper {
	
	public List<Staff> getList();

	public Staff getById(Integer id);

	public int add(Staff staff);

	public int update(Staff staff);

	public int deleteById(Integer id);

	public int deleteByIds(List<Integer> ids);
}
