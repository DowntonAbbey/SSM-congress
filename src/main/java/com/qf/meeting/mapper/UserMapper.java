package com.qf.meeting.mapper;

import java.util.List;

import com.qf.meeting.bean.User;

public interface UserMapper {
	
	//通过用户名查找用户
	public User getByUserName(String userName);
	
	//通过id查找用户
	public User getById(Integer userId);
	
	//查找所有用户
	public List<User> getList();
	
	//添加用户
	public int add(User user);
	
	//修改用户
	public int update(User user);
	
	//删除用户
	public int deleteById(Integer userId);
	
	//批量删除用户
	public int deleteByIds(List<Integer> ids);
}
