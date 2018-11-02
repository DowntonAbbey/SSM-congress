package com.qf.meeting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.meeting.bean.Agenda;
import com.qf.meeting.bean.Notice;
import com.qf.meeting.bean.Resource;
import com.qf.meeting.bean.Seat;
import com.qf.meeting.mapper.AgendaMapper;
import com.qf.meeting.mapper.NoticeMapper;
import com.qf.meeting.mapper.ResourceMapper;
import com.qf.meeting.mapper.SeatMapper;
import com.qf.meeting.mapper.UserNoticeMapper;
import com.qf.meeting.service.NoticeService;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Autowired
	private UserNoticeMapper userNoticeMapper;
	
	@Autowired
	private ResourceMapper resourceMapper;
	
	@Autowired
	private SeatMapper seatMapper;
	
	@Autowired
	private AgendaMapper agendaMapper;
	
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
		
		//删除连接表中的关系
		userNoticeMapper.deleteByNoticeId(noticeId);
		
		//会议议程外键置空
		Agenda agenda = agendaMapper.getByNoticeId(noticeId);
		if(agenda != null) {
			agenda.setNoticeId(null);
			agendaMapper.update(agenda);
		}
		
		
		//会议资料外键置空
		Resource resource = resourceMapper.getByNoticeId(noticeId);
		if(resource!=null) {
			resource.setNoticeId(null);
			resourceMapper.update(resource);
		}
		
		
		//座次外键置空
		Seat seat = seatMapper.getByNoticeId(noticeId);
		if(seat!=null) {
			seat.setNoticeId(null);
			seatMapper.update(seat);
		}
		
		
		
		return noticeMapper.deleteById(noticeId);
	}

	@Override
	public int deleteByIds(List<Integer> ids) {
		
		for(Integer noticeId:ids) {
			//删除连接表中的关系
			userNoticeMapper.deleteByNoticeId(noticeId);
			
			//会议议程外键置空
			Agenda agenda = agendaMapper.getByNoticeId(noticeId);
			if(agenda != null) {
				agenda.setNoticeId(null);
				agendaMapper.update(agenda);
			}
			
			
			//会议资料外键置空
			Resource resource = resourceMapper.getByNoticeId(noticeId);
			if(resource!=null) {
				resource.setNoticeId(null);
				resourceMapper.update(resource);
			}
			
			
			//座次外键置空
			Seat seat = seatMapper.getByNoticeId(noticeId);
			if(seat!=null) {
				seat.setNoticeId(null);
				seatMapper.update(seat);
			}
		}
		
		userNoticeMapper.deleteByNoticeIds(ids);
		return noticeMapper.deleteByIds(ids);
	}

}
