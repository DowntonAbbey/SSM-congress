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
import com.qf.meeting.bean.Seat;
import com.qf.meeting.service.SeatService;
import com.qf.meeting.utils.Pager;

@Controller
public class SeatController {
	@Autowired
	private SeatService seatService;
	
	@RequestMapping("/seat/list")
	public String getList(Model model, Integer pageIndex) {
		Integer pageSize = 5; // 页面大小
		// 使用分页插件 调用查询方法之前用插件
		Page<?> page = PageHelper.startPage(pageIndex, pageSize); // 插件
		
		List<Seat> list = seatService.getList();
		model.addAttribute("seats",list);
		
		Integer totalCount = Integer.parseInt(page.getTotal() + ""); // 数目
		int pageCont = page.getPages(); // 总页数
		// 封装数据
		Pager<Seat, String> p = new Pager<Seat, String>(pageIndex, totalCount, pageSize, pageCont,list, null);
		model.addAttribute("p", p);
		return "seat/list";
		
	}
	
	@RequestMapping("seat/updateById")
	public String updateById(Model model,Integer seatId) {
		Seat seat = seatService.getById(seatId);
		model.addAttribute("seat",seat);
		return "seat/edit";
	}
	
	@RequestMapping("seat/add")
	public String add(Model model,Seat seat) {
		int count = seatService.add(seat);
		if(count>0) {
			return "forward:/seat/list.action";
		}else {
			return "redirect:/seat/add";
		}
	}
	
	@RequestMapping("seat/update")
	public void update(Model model,Seat seat,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int count = seatService.update(seat);
		if(count>0) {
			response.getWriter().write("<script>alert('update success');location.href='"+request.getServletContext().getContextPath()+"/seat/list.action'</script>");
		}else {
			response.getWriter().write("<script>alert('update failed');location.href='"+request.getServletContext().getContextPath()+"/seat/list.action'</script>");
		}
		
	}
	
	@RequestMapping("/seat/deleteById")
	public void deleteById(Model model, Integer seatId,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int result = seatService.deleteById(seatId);
		if(result>0) {
			response.getWriter().write("<script>alert('delete success');location.href='"+request.getServletContext().getContextPath()+"/seat/list.action'</script>");
		}else {
			response.getWriter().write("<script>alert('delete failed');location.href='"+request.getServletContext().getContextPath()+"/seat/list.action'</script>");
		}
	}
	
	@RequestMapping("/seat/deleteByIds")
	public void deleteByIds(Model model,String idString,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int count=0;
		String[] ids = idString.split(",");
		List<Integer> idIntegers = new ArrayList<>();
		for(String id:ids) {
			idIntegers.add(Integer.parseInt(id));
		}
		count = seatService.deleteByIds(idIntegers);
		if (count > 0) {
			response.getWriter().write("<script>alert('delete success');location.href='"
					+ request.getServletContext().getContextPath() + "/seat/list.action';</script>");
		} else {
			response.getWriter().write("<script>alert('delete failed');location.href='"
					+ request.getServletContext().getContextPath() + "/seat/list.action';</script>");
		}
	}
	
	@ResponseBody
	@RequestMapping("/seat/seatType")
	public List<Seat> getType(){
		List<Seat> list = seatService.getList();
		return list;
	}
}
