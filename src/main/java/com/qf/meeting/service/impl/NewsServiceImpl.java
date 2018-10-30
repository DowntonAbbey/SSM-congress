package com.qf.meeting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.meeting.bean.News;
import com.qf.meeting.mapper.NewsMapper;
import com.qf.meeting.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsMapper newsMapper;

	@Override
	public List<News> getList() {
		return newsMapper.getList();
	}

	@Override
	public List<News> getByIds(List<Integer> ids) {
		return newsMapper.getByIds(ids);
	}

	@Override
	public News getById(Integer newsId) {
		return newsMapper.getById(newsId);
	}

	@Override
	public int add(News news) {
		return newsMapper.add(news);
	}

	@Override
	public int update(News news) {
		return newsMapper.update(news);
	}

	@Override
	public int deleteById(Integer newsId) {
		return newsMapper.deleteById(newsId);
	}

	@Override
	public int deleteByIds(List<Integer> ids) {
		return newsMapper.deleteByIds(ids);
	}

}
