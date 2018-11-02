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
import com.qf.meeting.bean.Staff;
import com.qf.meeting.service.StaffService;
import com.qf.meeting.utils.Pager;

@Controller
public class StaffController {

	@Autowired
	private StaffService staffService;
	
	@RequestMapping("/staff/list")
	public String getList(Model model,Integer pageIndex) {
		
		Integer pageSize = 5; // 页面大小
		// 使用分页插件 调用查询方法之前用插件
		Page<?> page = PageHelper.startPage(pageIndex, pageSize); // 插件
		
		List<Staff> list = staffService.getList();
		model.addAttribute("staffs",list);
		
		Integer totalCount = Integer.parseInt(page.getTotal() + ""); // 数目
		int pageCont = page.getPages(); // 总页数
		// 封装数据
		Pager<Staff, String> p = new Pager<Staff, String>(pageIndex, totalCount, pageSize, pageCont,list, null);
		model.addAttribute("p", p);
		return "staff/list";
		
	}
	
	@RequestMapping("staff/updateById")
	public String updateById(Model model,Integer staffId) {
		Staff staff = staffService.getById(staffId);
		model.addAttribute("staff",staff);
		return "staff/edit";
	}
	
	@RequestMapping("staff/add")
	public String add(Model model,Staff staff) {
		int count = staffService.add(staff);
		if(count>0) {
			return "forward:/staff/list.action";
		}else {
			return "redirect:/staff/add";
		}
	}
	
	@RequestMapping("staff/update")
	public void update(Model model,Staff staff,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int count = staffService.update(staff);
		if(count>0) {
			response.getWriter().write("<script>alert('update success');location.href='"+request.getServletContext().getContextPath()+"/staff/list.action'</script>");
		}else {
			response.getWriter().write("<script>alert('update failed');location.href='"+request.getServletContext().getContextPath()+"/staff/list.action'</script>");
		}
		
	}
	
	@RequestMapping("/staff/deleteById")
	public void deleteById(Model model, Integer staffId,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int result = staffService.deleteById(staffId);
		if(result>0) {
			response.getWriter().write("<script>alert('delete success');location.href='"+request.getServletContext().getContextPath()+"/staff/list.action'</script>");
		}else {
			response.getWriter().write("<script>alert('delete failed');location.href='"+request.getServletContext().getContextPath()+"/staff/list.action'</script>");
		}
	}
	
	@RequestMapping("/staff/deleteByIds")
	public void deleteByIds(Model model,String idString,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int count=0;
		String[] ids = idString.split(",");
		List<Integer> idIntegers = new ArrayList<>();
		for(String id:ids) {
			idIntegers.add(Integer.parseInt(id));
		}
		count = staffService.deleteByIds(idIntegers);
		if (count > 0) {
			response.getWriter().write("<script>alert('delete success');location.href='"
					+ request.getServletContext().getContextPath() + "/staff/list.action';</script>");
		} else {
			response.getWriter().write("<script>alert('delete failed');location.href='"
					+ request.getServletContext().getContextPath() + "/staff/list.action';</script>");
		}
	}
	
	@ResponseBody
	@RequestMapping("/staff/staffType")
	public List<Staff> getList(){
		List<Staff> list = staffService.getList();
		return list;
	}
}
