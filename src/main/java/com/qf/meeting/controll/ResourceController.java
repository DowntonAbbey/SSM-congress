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
import com.qf.meeting.bean.Resource;
import com.qf.meeting.service.ResourceService;
import com.qf.meeting.utils.Pager;

@Controller
public class ResourceController {

	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping("/resource/list")
	public String getList(Model model, Integer pageIndex) {
		
		Integer pageSize = 5; // 页面大小
		// 使用分页插件 调用查询方法之前用插件
		Page<?> page = PageHelper.startPage(pageIndex, pageSize); // 插件
		
		List<Resource> list = resourceService.getList();
		model.addAttribute("resources",list);
		
		Integer totalCount = Integer.parseInt(page.getTotal() + ""); // 数目
		int pageCont = page.getPages(); // 总页数
		// 封装数据
		Pager<Resource, String> p = new Pager<Resource, String>(pageIndex, totalCount, pageSize, pageCont,list, null);
		model.addAttribute("p", p);
		return "resource/list";
		
	}
	
	@RequestMapping("resource/updateById")
	public String updateById(Model model,Integer resourceId) {
		Resource resource = resourceService.getById(resourceId);
		model.addAttribute("resource",resource);
		return "resource/edit";
	}
	
	@RequestMapping("resource/add")
	public String add(Model model,Resource resource) {
		int count = resourceService.add(resource);
		if(count>0) {
			return "forward:/resource/list.action";
		}else {
			return "redirect:/resource/add";
		}
	}
	
	@RequestMapping("resource/update")
	public void update(Model model,Resource resource,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int count = resourceService.update(resource);
		if(count>0) {
			response.getWriter().write("<script>alert('update success');location.href='"+request.getServletContext().getContextPath()+"/resource/list.action'</script>");
		}else {
			response.getWriter().write("<script>alert('update failed');location.href='"+request.getServletContext().getContextPath()+"/resource/list.action'</script>");
		}
		
	}
	
	@RequestMapping("/resource/deleteById")
	public void deleteById(Model model, Integer resourceId,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int result = resourceService.deleteById(resourceId);
		if(result>0) {
			response.getWriter().write("<script>alert('delete success');location.href='"+request.getServletContext().getContextPath()+"/resource/list.action'</script>");
		}else {
			response.getWriter().write("<script>alert('delete failed');location.href='"+request.getServletContext().getContextPath()+"/resource/list.action'</script>");
		}
	}
	
	@RequestMapping("/resource/deleteByIds")
	public void deleteByIds(Model model,String idString,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int count=0;
		String[] ids = idString.split(",");
		List<Integer> idIntegers = new ArrayList<>();
		for(String id:ids) {
			idIntegers.add(Integer.parseInt(id));
		}
		count = resourceService.deleteByIds(idIntegers);
		if (count > 0) {
			response.getWriter().write("<script>alert('delete success');location.href='"
					+ request.getServletContext().getContextPath() + "/resource/list.action';</script>");
		} else {
			response.getWriter().write("<script>alert('delete failed');location.href='"
					+ request.getServletContext().getContextPath() + "/resource/list.action';</script>");
		}
	}
	
	@ResponseBody
	@RequestMapping("/resource/resourceType")
	public List<Resource> getType(){
		List<Resource> list = resourceService.getList();
		return list;
	}
}
