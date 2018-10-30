package com.qf.meeting.service;

import java.util.List;

import com.qf.meeting.bean.Notice;

public interface NoticeService {

public List<Notice> getList();
	
	public List<Notice> getByIds(List<Integer> ids);
	
	public Notice getById(Integer noticeId);
	
	public int add(Notice notice);
	
	public int update(Notice notice);
	
	public int deleteById(Integer noticeId);
	
	public int deleteByIds(List<Integer> ids);
}
