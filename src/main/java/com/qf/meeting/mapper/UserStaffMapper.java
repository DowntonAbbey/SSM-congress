package com.qf.meeting.mapper;

import java.util.List;

import com.qf.meeting.bean.UserStaff;

public interface UserStaffMapper {

	public List<UserStaff> getByUserId(Integer userId);

	public List<UserStaff> getByStaffId(Integer staffId);

	public Integer add(UserStaff userStaff);

	public Integer updateByUserId(UserStaff userStaff);

	public Integer updateByStaffId(UserStaff userStaff);

	public Integer deleteByStaffId(Integer staffId);

	public Integer deleteByUserId(Integer userId);

	public Integer deleteByStaffIds(List<Integer> staffIds);

	public Integer deleteByUserIds(List<Integer> userIds);
}
