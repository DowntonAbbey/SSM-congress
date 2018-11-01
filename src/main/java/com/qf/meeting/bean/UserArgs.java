package com.qf.meeting.bean;

import java.util.List;

public class UserArgs extends User{

	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 9180217286355384762L;

	private Integer staffParam;

	public Integer getStaffParam() {
		return staffParam;
	}

	public void setStaffParam(Integer staffParam) {
		this.staffParam = staffParam;
	}

	@Override
	public String toString() {
		return "UserArgs [staffParam=" + staffParam + "]";
	}

	public UserArgs() {
		super();
	}

	public UserArgs(Integer userId, String userLoginName, String telNum, String password, String photo,
			String userRealName, Delegation delegation, List<Staff> staffs, Integer staffParam) {
		super(userId, userLoginName, telNum, password, photo, userRealName, delegation, staffs);
		this.staffParam = staffParam;
	}

	public UserArgs(Integer userId, String userLoginName, String telNum, String password, String photo,
			String userRealName, Delegation delegation, List<Staff> staffs) {
		super(userId, userLoginName, telNum, password, photo, userRealName, delegation, staffs);
	}
	
	
}
