package com.qf.meeting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.meeting.bean.UserStaff;
import com.qf.meeting.mapper.UserStaffMapper;
import com.qf.meeting.service.UserStaffService;

@Service
@Transactional
public class UserStaffServiceImpl implements UserStaffService{

	@Autowired
	private UserStaffMapper userStaffMapper;
	@Override
	public List<UserStaff> getByUserId(Integer userId) {
		
		return userStaffMapper.getByUserId(userId);
	}

	@Override
	public List<UserStaff> getByStaffId(Integer staffId) {
		// TODO Auto-generated method stub
		return userStaffMapper.getByStaffId(staffId);
	}

	@Override
	public Integer add(UserStaff userStaff) {
		// TODO Auto-generated method stub
		return userStaffMapper.add(userStaff);
	}

	@Override
	public Integer updateByUserId(UserStaff userStaff) {
		// TODO Auto-generated method stub
		return userStaffMapper.updateByUserId(userStaff);
	}

	@Override
	public Integer updateByStaffId(UserStaff userStaff) {
		// TODO Auto-generated method stub
		return userStaffMapper.updateByStaffId(userStaff);
	}

	@Override
	public Integer deleteByStaffId(Integer staffId) {
		// TODO Auto-generated method stub
		return userStaffMapper.deleteByStaffId(staffId);
	}

	@Override
	public Integer deleteByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return userStaffMapper.deleteByUserId(userId);
	}

	@Override
	public Integer deleteByStaffIds(List<Integer> staffIds) {
		// TODO Auto-generated method stub
		return userStaffMapper.deleteByStaffIds(staffIds);
	}

	@Override
	public Integer deleteByUserIds(List<Integer> userIds) {
		// TODO Auto-generated method stub
		return userStaffMapper.deleteByUserIds(userIds);
	}

}
