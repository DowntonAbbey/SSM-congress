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

import com.qf.meeting.bean.Emp;
import com.qf.meeting.service.EmpService;

@Controller
public class EmpController {

	@Autowired
	private EmpService empService;
	
	@RequestMapping("/emp/list")
	public String getList(Model model) {
		List<Emp> list = empService.getList();
		model.addAttribute("emps",list);
		return "emp/list";
		
	}
	
	@RequestMapping("emp/updateById")
	public String updateById(Model model,Integer empId) {
		Emp emp = empService.getById(empId);
		model.addAttribute("emp",emp);
		return "emp/edit";
	}
	
	@RequestMapping("emp/add")
	public String add(Model model,Emp emp) {
		int count = empService.add(emp);
		if(count>0) {
			return "forward:/emp/list.action";
		}else {
			return "redirect:/emp/add";
		}
	}
	
	@RequestMapping("emp/update")
	public void update(Model model,Emp emp,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int count = empService.update(emp);
		if(count>0) {
			response.getWriter().write("<script>alert('update success');location.href='"+request.getServletContext().getContextPath()+"/emp/list.action'</script>");
		}else {
			response.getWriter().write("<script>alert('update failed');location.href='"+request.getServletContext().getContextPath()+"/emp/list.action'</script>");
		}
		
	}
	
	@RequestMapping("/emp/deleteById")
	public void deleteById(Model model, Integer empId,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int result = empService.deleteById(empId);
		if(result>0) {
			response.getWriter().write("<script>alert('delete success');location.href='"+request.getServletContext().getContextPath()+"/emp/list.action'</script>");
		}else {
			response.getWriter().write("<script>alert('delete failed');location.href='"+request.getServletContext().getContextPath()+"/emp/list.action'</script>");
		}
	}
	
	@RequestMapping("/emp/deleteByIds")
	public void deleteByIds(Model model,String idString,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int count=0;
		String[] ids = idString.split(",");
		List<Integer> idIntegers = new ArrayList<>();
		for(String id:ids) {
			idIntegers.add(Integer.parseInt(id));
		}
		count = empService.deleteByIds(idIntegers);
		if (count > 0) {
			response.getWriter().write("<script>alert('delete success');location.href='"
					+ request.getServletContext().getContextPath() + "/emp/list.action';</script>");
		} else {
			response.getWriter().write("<script>alert('delete failed');location.href='"
					+ request.getServletContext().getContextPath() + "/emp/list.action';</script>");
		}
	}
}
