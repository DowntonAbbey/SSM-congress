package com.qf.meeting.mapper;

import java.util.List;

import com.qf.meeting.bean.UserNotice;

public interface UserNoticeMapper {

	public List<UserNotice> getByUserId(Integer userId);

	public List<UserNotice> getByNoticeId(Integer noticeId);

	public Integer add(UserNotice userNotice);

	public Integer updateByUserId(UserNotice userNotice);

	public Integer updateByNoticeId(UserNotice userNotice);

	public Integer deleteByNoticeId(Integer noticeId);

	public Integer deleteByUserId(Integer userId);

	public Integer deleteByNoticeIds(List<Integer> noticeIds);

	public Integer deleteByUserIds(List<Integer> userIds);

}
