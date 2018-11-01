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

import com.qf.meeting.bean.User;
import com.qf.meeting.bean.UserArgs;
import com.qf.meeting.bean.UserStaff;
import com.qf.meeting.mapper.UserStaffMapper;
import com.qf.meeting.bean.User;
import com.qf.meeting.service.UserService;
import com.qf.meeting.service.UserStaffService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserStaffService userStaffService;
	

	@RequestMapping("/user/list")
	public String getList(Model model) {

		List<User> list = userService.getList();
		model.addAttribute("users", list);
		return "user/list";
	}

	@RequestMapping("user/updateById")
	public String updateById(Model model, Integer userId) {
		User user = userService.getById(userId);
		model.addAttribute("user", user);
		return "user/edit";
	}

	@RequestMapping("user/add")
	public String add(Model model, UserArgs userArgs) {
		User user = userArgs;
		int count = userService.add(user);
		if (user.getUserId() > 0) {
			UserStaff userStaff = new UserStaff(null, user.getUserId(), userArgs.getStaffParam());
			userStaffService.add(userStaff);
		}
		if (count > 0) {
			return "forward:/user/list.action";
		} else {
			return "redirect:/user/add";
		}
	}

	@RequestMapping("user/update")
	public void update(Model model, UserArgs userArgs, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		User user = userArgs;
		UserStaff userStaff = new UserStaff(null, user.getUserId(), userArgs.getStaffParam());
		Integer num = userStaffService.updateByUserId(userStaff);
		if(num==0) {
			userStaffService.add(userStaff);
		}
		int count = userService.update(user);
		if (count > 0) {
			response.getWriter().write("<script>alert('update success');location.href='"
					+ request.getServletContext().getContextPath() + "/user/list.action'</script>");
		} else {
			response.getWriter().write("<script>alert('update failed');location.href='"
					+ request.getServletContext().getContextPath() + "/user/list.action'</script>");
		}

	}

	@RequestMapping("/user/deleteById")
	public void deleteById(Model model, Integer userId, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		int result = userService.deleteById(userId);
		if (result > 0) {
			response.getWriter().write("<script>alert('delete success');location.href='"
					+ request.getServletContext().getContextPath() + "/user/list.action'</script>");
		} else {
			response.getWriter().write("<script>alert('delete failed');location.href='"
					+ request.getServletContext().getContextPath() + "/user/list.action'</script>");
		}
	}

	@RequestMapping("/user/deleteByIds")
	public void deleteByIds(Model model, String idString, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		int count = 0;
		String[] ids = idString.split(",");
		List<Integer> idIntegers = new ArrayList<>();
		for (String id : ids) {
			idIntegers.add(Integer.parseInt(id));
		}
		count = userService.deleteByIds(idIntegers);
		if (count > 0) {
			response.getWriter().write("<script>alert('delete success');location.href='"
					+ request.getServletContext().getContextPath() + "/user/list.action';</script>");
		} else {
			response.getWriter().write("<script>alert('delete failed');location.href='"
					+ request.getServletContext().getContextPath() + "/user/list.action';</script>");
		}
	}
	
	
}
