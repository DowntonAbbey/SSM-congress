package com.qf.meeting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.meeting.bean.Notice;
import com.qf.meeting.mapper.NoticeMapper;
import com.qf.meeting.service.NoticeService;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Override
	public List<Notice> getList() {
		return noticeMapper.getList();
	}

	@Override
	public List<Notice> getByIds(List<Integer> ids) {
		return noticeMapper.getByIds(ids);
	}

	@Override
	public Notice getById(Integer noticeId) {
		return noticeMapper.getById(noticeId);
	}

	@Override
	public int add(Notice notice) {
		return noticeMapper.add(notice);
	}

	@Override
	public int update(Notice notice) {
		return noticeMapper.update(notice);
	}

	@Override
	public int deleteById(Integer noticeId) {
		return noticeMapper.deleteById(noticeId);
	}

	@Override
	public int deleteByIds(List<Integer> ids) {
		return noticeMapper.deleteByIds(ids);
	}

}
