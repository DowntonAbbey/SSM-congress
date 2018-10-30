package com.qf.meeting.mapper;

import java.util.List;

import com.qf.meeting.bean.Agenda;

public interface AgendaMapper {

	public List<Agenda> getList();

	public List<Agenda> getByIds(List<Integer> ids);
	
	public List<Agenda> getByNoticeIds(List<Integer> noticeIds);

	public Agenda getById(Integer agendaId);

	public int add(Agenda agenda);

	public int update(Agenda agenda);

	public int deleteById(Integer agendaId);

	public int deleteByIds(List<Integer> ids);
	
	public int deleteByNoticeIds(List<Integer> noticeIds);
}
