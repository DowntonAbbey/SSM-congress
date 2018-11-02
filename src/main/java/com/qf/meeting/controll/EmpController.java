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
import com.qf.meeting.bean.Emp;
import com.qf.meeting.service.EmpService;
import com.qf.meeting.utils.CommonUtils;
import com.qf.meeting.utils.Pager;

@Controller
public class EmpController {

	@Autowired
	private EmpService empService;
	
	@RequestMapping("/emp/list")
	public String getList(Model model, Integer pageIndex) {
		Integer pageSize = 5; // 页面大小
		// 使用分页插件 调用查询方法之前用插件
		Page<?> page = PageHelper.startPage(pageIndex, pageSize); // 插件
		
		List<Emp> list = empService.getList();
		model.addAttribute("emps",list);
		
		Integer totalCount = Integer.parseInt(page.getTotal() + ""); // 数目
		int pageCont = page.getPages(); // 总页数
		// 封装数据
		Pager<Emp, String> p = new Pager<Emp, String>(pageIndex, totalCount, pageSize, pageCont,list, null);
		model.addAttribute("p", p);
		return "emp/list";
		
	}
	
	@RequestMapping("emp/updateById")
	public String updateById(Model model,Integer empId) {
		Emp emp = empService.getById(empId);
		model.addAttribute("emp",emp);
		return "emp/edit";
	}
	
	@RequestMapping("emp/add")
	public String add(Model model,Emp emp,HttpServletRequest request) {
		String fileName = CommonUtils.fileUpload(request);
		emp.setPhoto(fileName);
		int count = empService.add(emp);
		if(count>0) {
			return "forward:/emp/list.action";
		}else {
			return "redirect:/emp/add";
		}
	}
	
	@RequestMapping("emp/update")
	public void update(Model model,Emp emp,HttpServletRequest request,HttpServletResponse response) throws IOException {
		String fileName = CommonUtils.fileUpload(request);
		emp.setPhoto(fileName);
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
