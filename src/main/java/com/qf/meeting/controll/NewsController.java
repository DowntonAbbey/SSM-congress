package com.qf.meeting.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qf.meeting.bean.News;
import com.qf.meeting.service.NewsService;

@Controller
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	@ResponseBody
	@RequestMapping("/news/list")
	public List<News> getList() {
		List<News> list = newsService.getList();
		return list;
	}
}
