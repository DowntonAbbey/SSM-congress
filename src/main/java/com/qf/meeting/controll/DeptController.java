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
import com.qf.meeting.bean.Dept;
import com.qf.meeting.service.DeptService;
import com.qf.meeting.utils.Pager;

@Controller
public class DeptController {
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("/dept/list")
	public String getList(Model model, Integer pageIndex) {
		
		Integer pageSize = 5; // 页面大小
		// 使用分页插件 调用查询方法之前用插件
		Page<?> page = PageHelper.startPage(pageIndex, pageSize); // 插件
		
		List<Dept> list = deptService.getList();
		model.addAttribute("depts",list);
		
		Integer totalCount = Integer.parseInt(page.getTotal() + ""); // 数目
		int pageCont = page.getPages(); // 总页数
		// 封装数据
		Pager<Dept, String> p = new Pager<Dept, String>(pageIndex, totalCount, pageSize, pageCont,list, null);
		model.addAttribute("p", p);
		return "dept/list";
		
	}
	
	@RequestMapping("dept/updateById")
	public String updateById(Model model,Integer deptId) {
		Dept dept = deptService.getById(deptId);
		model.addAttribute("dept",dept);
		return "dept/edit";
	}
	
	@RequestMapping("dept/add")
	public String add(Model model,Dept dept) {
		int count = deptService.add(dept);
		if(count>0) {
			return "forward:/dept/list.action";
		}else {
			return "redirect:/dept/add";
		}
	}
	
	@RequestMapping("dept/update")
	public void update(Model model,Dept dept,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int count = deptService.update(dept);
		if(count>0) {
			response.getWriter().write("<script>alert('update success');location.href='"+request.getServletContext().getContextPath()+"/dept/list.action'</script>");
		}else {
			response.getWriter().write("<script>alert('update failed');location.href='"+request.getServletContext().getContextPath()+"/dept/list.action'</script>");
		}
		
	}
	
	@RequestMapping("/dept/deleteById")
	public void deleteById(Model model, Integer deptId,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int result = deptService.deleteById(deptId);
		if(result>0) {
			response.getWriter().write("<script>alert('delete success');location.href='"+request.getServletContext().getContextPath()+"/dept/list.action'</script>");
		}else {
			response.getWriter().write("<script>alert('delete failed');location.href='"+request.getServletContext().getContextPath()+"/dept/list.action'</script>");
		}
	}
	
	@RequestMapping("/dept/deleteByIds")
	public void deleteByIds(Model model,String idString,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int count=0;
		String[] ids = idString.split(",");
		List<Integer> idIntegers = new ArrayList<>();
		for(String id:ids) {
			idIntegers.add(Integer.parseInt(id));
		}
		count = deptService.deleteByIds(idIntegers);
		if (count > 0) {
			response.getWriter().write("<script>alert('delete success');location.href='"
					+ request.getServletContext().getContextPath() + "/dept/list.action';</script>");
		} else {
			response.getWriter().write("<script>alert('delete failed');location.href='"
					+ request.getServletContext().getContextPath() + "/dept/list.action';</script>");
		}
	}
	
	@ResponseBody
	@RequestMapping("/dept/deptType")
	public List<Dept> getType(){
		List<Dept> list = deptService.getList();
		return list;
	}
}
