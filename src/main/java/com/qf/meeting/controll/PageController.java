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
}