/**
 * 
 */
package com.qf.meeting.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {

	@RequestMapping("/page/{page}")
	public String zhuan(@PathVariable(value="page") String page){
		return page;
	}
	
	@RequestMapping("/page/news/{page}")
	public String newsZhuan(@PathVariable(value="page") String page){
		return "news/"+page;
	}
	
	@RequestMapping("/page/delegation/{page}")
	public String delegationZhuan(@PathVariable(value="page") String page) {
		return "delegation/"+page;
	}
	
	@RequestMapping("/page/emp/{page}")
	public String empZhuan(@PathVariable(value="page") String page) {
		return "emp/"+page;
	}
	
	@RequestMapping("/page/dept/{page}")
	public String deptZhuan(@PathVariable(value="page") String page) {
		return "dept/"+page;
	}
	
	@RequestMapping("/page/notice/{page}")
	public String noticeZhuan(@PathVariable(value="page") String page) {
		return "notice/"+page;
	}
	
	@RequestMapping("/page/seat/{page}")
	public String seatZhuan(@PathVariable(value="page") String page) {
		return "seat/"+page;
	}
	
	@RequestMapping("/page/staff/{page}")
	public String staffZhuan(@PathVariable(value="page") String page) {
		return "staff/"+page;
	}
	
	@RequestMapping("/page/user/{page}")
	public String userZhuan(@PathVariable(value="page") String page) {
		return "user/"+page;
	}
}