package com.qf.meeting.mapper;

import java.util.List;

import com.qf.meeting.bean.Delegation;

public interface DelegationMapper {
	
	public List<Delegation> getList();

	public Delegation getById(Integer id);

	public int add(Delegation delegation);

	public int update(Delegation delegation);

	public int deleteById(Integer id);

	public int deleteByIds(List<Integer> ids);
}
