package com.qf.meeting.service;

import java.util.List;

import com.qf.meeting.bean.News;

public interface NewsService {

	public List<News> getList();

	public List<News> getByIds(List<Integer> ids);

	public News getById(Integer newsId);

	public int add(News news);

	public int update(News news);

	public int deleteById(Integer newsId);

	public int deleteByIds(List<Integer> ids);
}
