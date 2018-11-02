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
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qf.meeting.bean.Agenda;
import com.qf.meeting.service.AgendaService;
import com.qf.meeting.utils.Pager;

@Controller
public class AgendaController {
	@Autowired
	private AgendaService agendaService;
	
	@RequestMapping("/agenda/list")
	public String getList(Model model,Integer pageIndex) {
		Integer pageSize = 5; // 页面大小
		// 使用分页插件 调用查询方法之前用插件
		Page<?> page = PageHelper.startPage(pageIndex, pageSize); // 插件
		
		List<Agenda> list = agendaService.getList();
		model.addAttribute("agendas",list);
		
		Integer totalCount = Integer.parseInt(page.getTotal() + ""); // 数目
		int pageCont = page.getPages(); // 总页数
		// 封装数据
		Pager<Agenda, String> p = new Pager<Agenda, String>(pageIndex, totalCount, pageSize, pageCont,list, null);
		model.addAttribute("p", p);
		return "agenda/list";
		
	}
	
	@RequestMapping("agenda/updateById")
	public String updateById(Model model,Integer agendaId) {
		Agenda agenda = agendaService.getById(agendaId);
		model.addAttribute("agenda",agenda);
		return "agenda/edit";
	}
	
	@RequestMapping("agenda/add")
	public String add(Model model,Agenda agenda) {
		int count = agendaService.add(agenda);
		if(count>0) {
			return "forward:/agenda/list.action";
		}else {
			return "redirect:/agenda/add";
		}
	}
	
	@RequestMapping("agenda/update")
	public void update(Model model,Agenda agenda,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int count = agendaService.update(agenda);
		if(count>0) {
			response.getWriter().write("<script>alert('update success');location.href='"+request.getServletContext().getContextPath()+"/agenda/list.action'</script>");
		}else {
			response.getWriter().write("<script>alert('update failed');location.href='"+request.getServletContext().getContextPath()+"/agenda/list.action'</script>");
		}
		
	}
	
	@RequestMapping("/agenda/deleteById")
	public void deleteById(Model model, Integer agendaId,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int result = agendaService.deleteById(agendaId);
		if(result>0) {
			response.getWriter().write("<script>alert('delete success');location.href='"+request.getServletContext().getContextPath()+"/agenda/list.action'</script>");
		}else {
			response.getWriter().write("<script>alert('delete failed');location.href='"+request.getServletContext().getContextPath()+"/agenda/list.action'</script>");
		}
	}
	
	@RequestMapping("/agenda/deleteByIds")
	public void deleteByIds(Model model,String idString,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int count=0;
		String[] ids = idString.split(",");
		List<Integer> idIntegers = new ArrayList<>();
		for(String id:ids) {
			idIntegers.add(Integer.parseInt(id));
		}
		count = agendaService.deleteByIds(idIntegers);
		if (count > 0) {
			response.getWriter().write("<script>alert('delete success');location.href='"
					+ request.getServletContext().getContextPath() + "/agenda/list.action';</script>");
		} else {
			response.getWriter().write("<script>alert('delete failed');location.href='"
					+ request.getServletContext().getContextPath() + "/agenda/list.action';</script>");
		}
	}
	
	@ResponseBody
	@RequestMapping("/agenda/agendaType")
	public List<Agenda> getType(){
		List<Agenda> list = agendaService.getList();
		return list;
	}
}
