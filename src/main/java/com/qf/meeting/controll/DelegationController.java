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
import com.qf.meeting.bean.Delegation;
import com.qf.meeting.service.DelegationService;
import com.qf.meeting.utils.Pager;

@Controller
public class DelegationController {

	@Autowired
	private DelegationService delegationService;
	
	@RequestMapping("/delegation/list")
	public String getList(Model model,Integer pageIndex) {
		Integer pageSize = 5; // 页面大小
		// 使用分页插件 调用查询方法之前用插件
		Page<?> page = PageHelper.startPage(pageIndex, pageSize); // 插件
		
		List<Delegation> list = delegationService.getList();
		model.addAttribute("delegations",list);
		
		Integer totalCount = Integer.parseInt(page.getTotal() + ""); // 数目
		int pageCont = page.getPages(); // 总页数
		// 封装数据
		Pager<Delegation, String> p = new Pager<Delegation, String>(pageIndex, totalCount, pageSize, pageCont,list, null);
		model.addAttribute("p", p);
		return "delegation/list";
		
	}
	
	@RequestMapping("delegation/updateById")
	public String updateById(Model model,Integer delegationId) {
		Delegation delegation = delegationService.getById(delegationId);
		model.addAttribute("delegation",delegation);
		return "delegation/edit";
	}
	
	@RequestMapping("delegation/add")
	public String add(Model model,Delegation delegation) {
		int count = delegationService.add(delegation);
		if(count>0) {
			return "forward:/delegation/list.action";
		}else {
			return "redirect:/delegation/add";
		}
	}
	
	@RequestMapping("delegation/update")
	public void update(Model model,Delegation delegation,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int count = delegationService.update(delegation);
		if(count>0) {
			response.getWriter().write("<script>alert('update success');location.href='"+request.getServletContext().getContextPath()+"/delegation/list.action'</script>");
		}else {
			response.getWriter().write("<script>alert('update failed');location.href='"+request.getServletContext().getContextPath()+"/delegation/list.action'</script>");
		}
		
	}
	
	@RequestMapping("/delegation/deleteById")
	public void deleteById(Model model, Integer delegationId,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int result = delegationService.deleteById(delegationId);
		if(result>0) {
			response.getWriter().write("<script>alert('delete success');location.href='"+request.getServletContext().getContextPath()+"/delegation/list.action'</script>");
		}else {
			response.getWriter().write("<script>alert('delete failed');location.href='"+request.getServletContext().getContextPath()+"/delegation/list.action'</script>");
		}
	}
	
	@RequestMapping("/delegation/deleteByIds")
	public void deleteByIds(Model model,String idString,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int count=0;
		String[] ids = idString.split(",");
		List<Integer> idIntegers = new ArrayList<>();
		for(String id:ids) {
			idIntegers.add(Integer.parseInt(id));
		}
		count = delegationService.deleteByIds(idIntegers);
		if (count > 0) {
			response.getWriter().write("<script>alert('delete success');location.href='"
					+ request.getServletContext().getContextPath() + "/delegation/list.action';</script>");
		} else {
			response.getWriter().write("<script>alert('delete failed');location.href='"
					+ request.getServletContext().getContextPath() + "/delegation/list.action';</script>");
		}
	}
	
	@ResponseBody
	@RequestMapping("/delegation/delegationType")
	public List<Delegation> getList(){
		return delegationService.getList();
	}
}
