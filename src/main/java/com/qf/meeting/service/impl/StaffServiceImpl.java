package com.qf.meeting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.meeting.bean.Staff;
import com.qf.meeting.mapper.StaffMapper;
import com.qf.meeting.service.StaffService;

@Service
@Transactional
public class StaffServiceImpl implements StaffService{
	
	@Autowired
	private StaffMapper staffMapper;
	
	@Override
	public List<Staff> getList() {
		return staffMapper.getList();
	}

	@Override
	public Staff getById(Integer id) {
		return staffMapper.getById(id);
	}

	@Override
	public int add(Staff staff) {
		return staffMapper.add(staff);
	}

	@Override
	public int update(Staff staff) {
		return staffMapper.update(staff);
	}

	@Override
	public int deleteById(Integer id) {
		return staffMapper.deleteById(id);
	}

	@Override
	public int deleteByIds(List<Integer> ids) {
		return staffMapper.deleteByIds(ids);
	}

}
