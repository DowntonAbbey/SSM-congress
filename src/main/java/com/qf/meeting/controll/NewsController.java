package com.qf.meeting.controll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qf.meeting.bean.News;
import com.qf.meeting.service.NewsService;

@Controller
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	
	@RequestMapping("/news/list")
	public String getList(Model model) {
		List<News> list = newsService.getList();
		model.addAttribute("list", list);
		return "news/list";
	}
	

	@RequestMapping("/news/add")
	public String add(Model model,News news) {
		int result = newsService.add(news);
		if(result>0) {
			return "forward:/news/list.action";
		}else {
			return "redirect:/news/add";
		}
	}
	
	@RequestMapping("/news/updateById")
	public String getById(Model model,Integer newsId) {
		News news = newsService.getById(newsId);
		model.addAttribute("news", news);
		return "news/edit";
	}
	
	@RequestMapping("/news/update")
	public void updateById(Model model,News news,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int result = newsService.update(news);
		if(result>0) {
			response.getWriter().write("<script>alert('update success');location.href='"+request.getServletContext().getContextPath()+"/news/list.action'</script>");
		}else {
			response.getWriter().write("<script>alert('update failed');location.href='"+request.getServletContext().getContextPath()+"/news/list.action'</script>");
		}
	}
	
	@RequestMapping("/news/deleteById")
	public void deleteById(Model model, Integer newsId,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int result = newsService.deleteById(newsId);
		if(result>0) {
			response.getWriter().write("<script>alert('delete success');location.href='"+request.getServletContext().getContextPath()+"/news/list.action'</script>");
		}else {
			response.getWriter().write("<script>alert('delete failed');location.href='"+request.getServletContext().getContextPath()+"/news/list.action'</script>");
		}
	}
	
	@RequestMapping("/news/deleteByIds")
	public void deleteByIds(Model model,String idString,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int count=0;
		String[] ids = idString.split(",");
		List<Integer> idIntegers = new ArrayList<>();
		for(String id:ids) {
			idIntegers.add(Integer.parseInt(id));
		}
		count = newsService.deleteByIds(idIntegers);
		if (count > 0) {
			response.getWriter().write("<script>alert('delete success');location.href='"
					+ request.getServletContext().getContextPath() + "/news/list.action';</script>");
		} else {
			response.getWriter().write("<script>alert('delete failed');location.href='"
					+ request.getServletContext().getContextPath() + "/news/list.action';</script>");
		}
	}
}
