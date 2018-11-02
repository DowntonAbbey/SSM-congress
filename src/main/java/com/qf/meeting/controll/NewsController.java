package com.qf.meeting.controll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qf.meeting.bean.News;
import com.qf.meeting.service.NewsService;
import com.qf.meeting.utils.CommonUtils;
import com.qf.meeting.utils.Pager;

@Controller
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	
	@RequestMapping("/news/list")
	public String getList(Model model, Integer pageIndex) {
		
		Integer pageSize = 5; // 页面大小
		// 使用分页插件 调用查询方法之前用插件
		Page<?> page = PageHelper.startPage(pageIndex, pageSize); // 插件
		
		List<News> list = newsService.getList();
		model.addAttribute("list", list);
		
		Integer totalCount = Integer.parseInt(page.getTotal() + ""); // 数目
		int pageCont = page.getPages(); // 总页数
		// 封装数据
		Pager<News, String> p = new Pager<News, String>(pageIndex, totalCount, pageSize, pageCont,list, null);
		model.addAttribute("p", p);
		return "news/list";
	}
	

	@RequestMapping("/news/add")
	public String add(Model model,News news,HttpServletRequest request) {
		String fileName = CommonUtils.fileUpload(request);
		news.setPhoto(fileName);
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
		String fileName = CommonUtils.fileUpload(request);
		news.setPhoto(fileName);
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
