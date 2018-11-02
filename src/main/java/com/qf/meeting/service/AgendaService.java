package com.qf.meeting.service;

import java.util.List;

import com.qf.meeting.bean.Agenda;

public interface AgendaService {

	public List<Agenda> getList();

	public List<Agenda> getByIds(List<Integer> ids);
	
	public List<Agenda> getByNoticeIds(List<Integer> noticeIds);

	public Agenda getById(Integer agendaId);
	
	public Agenda getByNoticeId(Integer noticeId);

	public int add(Agenda agenda);

	public int update(Agenda agenda);

	public int deleteById(Integer agendaId);

	public int deleteByIds(List<Integer> ids);
	
	public int deleteByNoticeIds(List<Integer> noticeIds);
}
