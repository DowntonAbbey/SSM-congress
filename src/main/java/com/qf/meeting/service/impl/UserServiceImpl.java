package com.qf.meeting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.meeting.bean.User;
import com.qf.meeting.mapper.UserMapper;
import com.qf.meeting.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

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
		return userMapper.add(user);
	}

	@Override
	public int update(User user) {
		return userMapper.update(user);
	}

	@Override
	public int deleteById(Integer userId) {
		return userMapper.deleteById(userId);
	}

	@Override
	public int deleteByIds(List<Integer> ids) {
		return userMapper.deleteByIds(ids);
	}
}
