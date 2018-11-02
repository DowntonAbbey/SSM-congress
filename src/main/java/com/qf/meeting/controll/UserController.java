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
import com.qf.meeting.bean.User;
import com.qf.meeting.bean.UserArgs;
import com.qf.meeting.bean.UserStaff;
import com.qf.meeting.service.UserService;
import com.qf.meeting.service.UserStaffService;
import com.qf.meeting.utils.CommonUtils;
import com.qf.meeting.utils.Pager;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserStaffService userStaffService;

	@RequestMapping("/user/list")
	public String getList(Model model,Integer pageIndex) {
		Integer pageSize = 5; // 页面大小
		// 使用分页插件 调用查询方法之前用插件
		Page<?> page = PageHelper.startPage(pageIndex, pageSize); // 插件
		
		List<User> list = userService.getList();
		model.addAttribute("users", list);
		
		Integer totalCount = Integer.parseInt(page.getTotal() + ""); // 数目
		int pageCont = page.getPages(); // 总页数
		// 封装数据
		Pager<User, String> p = new Pager<User, String>(pageIndex, totalCount, pageSize, pageCont,list, null);
		model.addAttribute("p", p);
		
		return "user/list";
	}

	@RequestMapping("user/updateById")
	public String updateById(Model model, Integer userId) {
		User user = userService.getById(userId);
		model.addAttribute("user", user);
		return "user/edit";
	}

	@RequestMapping("user/add")
	public String add(Model model, UserArgs userArgs,HttpServletRequest request)  {
		User user = userArgs;
		//文件上传
		String photo = CommonUtils.fileUpload(request);
		user.setPhoto(photo);
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
		String fileName = CommonUtils.fileUpload(request);
		user.setPhoto(fileName);
		UserStaff userStaff = new UserStaff(null, user.getUserId(), userArgs.getStaffParam());
		Integer num = userStaffService.updateByUserId(userStaff);
		if (num == 0) {
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
