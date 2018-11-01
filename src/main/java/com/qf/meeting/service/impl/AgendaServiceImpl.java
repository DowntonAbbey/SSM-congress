package com.qf.meeting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.meeting.bean.Agenda;
import com.qf.meeting.mapper.AgendaMapper;

@Service
@Transactional
public class AgendaServiceImpl implements AgendaMapper{

	@Autowired
	private AgendaMapper agendaMapper;
	
	@Override
	public List<Agenda> getList() {
		return agendaMapper.getList();
	}

	@Override
	public List<Agenda> getByIds(List<Integer> ids) {
		return agendaMapper.getByIds(ids);
	}

	@Override
	public List<Agenda> getByNoticeIds(List<Integer> noticeIds) {
		return agendaMapper.getByNoticeIds(noticeIds);
	}

	@Override
	public Agenda getById(Integer agendaId) {
		return agendaMapper.getById(agendaId);
	}

	@Override
	public int add(Agenda agenda) {
		return agendaMapper.add(agenda);
	}

	@Override
	public int update(Agenda agenda) {
		return agendaMapper.update(agenda);
	}

	@Override
	public int deleteById(Integer agendaId) {
		return agendaMapper.deleteById(agendaId);
	}

	@Override
	public int deleteByIds(List<Integer> ids) {
		return agendaMapper.deleteByIds(ids);
	}

	@Override
	public int deleteByNoticeIds(List<Integer> noticeIds) {
		return agendaMapper.deleteByNoticeIds(noticeIds);
	}
	
}
