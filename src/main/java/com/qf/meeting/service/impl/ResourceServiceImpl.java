package com.qf.meeting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.meeting.bean.Resource;
import com.qf.meeting.mapper.ResourceMapper;
import com.qf.meeting.service.ResourceService;

@Service
@Transactional
public class ResourceServiceImpl implements ResourceService{

	@Autowired
	private ResourceMapper resourceMapper;
	
	@Override
	public List<Resource> getList() {
		return resourceMapper.getList();
	}

	@Override
	public List<Resource> getByIds(List<Integer> ids) {
		return resourceMapper.getByIds(ids);
	}

	@Override
	public List<Resource> getByNoticeIds(List<Integer> noticeIds) {
		return resourceMapper.getByNoticeIds(noticeIds);
	}

	@Override
	public Resource getById(Integer resourceId) {
		return resourceMapper.getById(resourceId);
	}

	@Override
	public int add(Resource resource) {
		return resourceMapper.add(resource);
	}

	@Override
	public int update(Resource resource) {
		return resourceMapper.update(resource);
	}

	@Override
	public int deleteById(Integer resourceId) {
		return resourceMapper.deleteById(resourceId);
	}

	@Override
	public int deleteByIds(List<Integer> ids) {
		return resourceMapper.deleteByIds(ids);
	}

	@Override
	public int deleteByNoticeIds(List<Integer> noticeIds) {
		return resourceMapper.deleteByNoticeIds(noticeIds);
	}
}
