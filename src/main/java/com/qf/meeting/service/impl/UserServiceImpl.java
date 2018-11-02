package com.qf.meeting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.meeting.bean.User;
import com.qf.meeting.mapper.UserMapper;
import com.qf.meeting.mapper.UserNoticeMapper;
import com.qf.meeting.mapper.UserStaffMapper;
import com.qf.meeting.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserNoticeMapper userNoticeMapper;
	
	@Autowired
	private UserStaffMapper userStaffMapper;

	
	@Override
	public User getByUserName(String userName) {
		return userMapper.getByUserName(userName);
	}

	@Override
	public User getById(Integer userId) {
		return userMapper.getById(userId);
	}

	@Override
	public List<User> getList() {
		return userMapper.getList();
	}

	@Override
	public int add(User user) {
		int result = userMapper.add(user);
		return result;
	}

	@Override
	public int update(User user) {
		return userMapper.update(user);
	}

	@Override
	public int deleteById(Integer userId) {
		userStaffMapper.deleteByUserId(userId);
		userNoticeMapper.deleteByUserId(userId);
		return userMapper.deleteById(userId);
	}

	@Override
	public int deleteByIds(List<Integer> ids) {
		userStaffMapper.deleteByUserIds(ids);
		userNoticeMapper.deleteByUserIds(ids);
		return userMapper.deleteByIds(ids);
	}
}
