package com.qf.meeting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.meeting.bean.Delegation;
import com.qf.meeting.mapper.DelegationMapper;
import com.qf.meeting.service.DelegationService;

@Service
public class DelegationServiceImpl implements DelegationService{

	@Autowired
	private DelegationMapper delegationMapper;
	
	@Override
	public List<Delegation> getList() {
		return delegationMapper.getList();
	}

	@Override
	public Delegation getById(Integer id) {
		return delegationMapper.getById(id);
	}

	@Override
	public int add(Delegation delegation) {
		return delegationMapper.add(delegation);
	}

	@Override
	public int update(Delegation delegation) {
		return delegationMapper.update(delegation);
	}

	@Override
	public int deleteById(Integer id) {
		return delegationMapper.deleteById(id);
	}

	@Override
	public int deleteByIds(List<Integer> ids) {
		return delegationMapper.deleteByIds(ids);
	}

}
