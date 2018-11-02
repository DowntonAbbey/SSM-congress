package com.qf.meeting.mapper;

import java.util.List;


import com.qf.meeting.bean.Resource;




public interface ResourceMapper {

	public List<Resource> getList();

	public List<Resource> getByIds(List<Integer> ids);
	
	public List<Resource> getByNoticeIds(List<Integer> noticeIds);

	public Resource getByNoticeId(Integer noticeId);
	
	public Resource getById(Integer resourceId);

	public int add(Resource resource);

	public int update(Resource resource);

	public int deleteById(Integer resourceId);

	public int deleteByIds(List<Integer> ids);
	
	public int deleteByNoticeIds(List<Integer> noticeIds);
}
