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

import com.qf.meeting.bean.Notice;
import com.qf.meeting.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("/notice/list")
	public String getList(Model model) {
		List<Notice> list = noticeService.getList();
		model.addAttribute("notices",list);
		return "notice/list";
		
	}
	
	@RequestMapping("notice/updateById")
	public String updateById(Model model,Integer noticeId) {
		Notice notice = noticeService.getById(noticeId);
		model.addAttribute("notice",notice);
		return "notice/edit";
	}
	
	@RequestMapping("notice/add")
	public String add(Model model,Notice notice) {
		int count = noticeService.add(notice);
		if(count>0) {
			return "forward:/notice/list.action";
		}else {
			return "redirect:/notice/add";
		}
	}
	
	@RequestMapping("notice/update")
	public void update(Model model,Notice notice,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int count = noticeService.update(notice);
		if(count>0) {
			response.getWriter().write("<script>alert('update success');location.href='"+request.getServletContext().getContextPath()+"/notice/list.action'</script>");
		}else {
			response.getWriter().write("<script>alert('update failed');location.href='"+request.getServletContext().getContextPath()+"/notice/list.action'</script>");
		}
		
	}
	
	@RequestMapping("/notice/deleteById")
	public void deleteById(Model model, Integer noticeId,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int result = noticeService.deleteById(noticeId);
		if(result>0) {
			response.getWriter().write("<script>alert('delete success');location.href='"+request.getServletContext().getContextPath()+"/notice/list.action'</script>");
		}else {
			response.getWriter().write("<script>alert('delete failed');location.href='"+request.getServletContext().getContextPath()+"/notice/list.action'</script>");
		}
	}
	
	@RequestMapping("/notice/deleteByIds")
	public void deleteByIds(Model model,String idString,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int count=0;
		String[] ids = idString.split(",");
		List<Integer> idIntegers = new ArrayList<>();
		for(String id:ids) {
			idIntegers.add(Integer.parseInt(id));
		}
		count = noticeService.deleteByIds(idIntegers);
		if (count > 0) {
			response.getWriter().write("<script>alert('delete success');location.href='"
					+ request.getServletContext().getContextPath() + "/notice/list.action';</script>");
		} else {
			response.getWriter().write("<script>alert('delete failed');location.href='"
					+ request.getServletContext().getContextPath() + "/notice/list.action';</script>");
		}
	}
}
