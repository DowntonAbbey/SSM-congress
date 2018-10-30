package com.qf.meeting.bean;

import java.io.Serializable;

public class UserStaff implements Serializable{

	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = -4967322390281041027L;
	
	private Integer id;
	
	private Integer userId;
	
	private Integer staffId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public UserStaff(Integer id, Integer userId, Integer staffId) {
		super();
		this.id = id;
		this.userId = userId;
		this.staffId = staffId;
	}

	@Override
	public String toString() {
		return "UserStaff [id=" + id + ", userId=" + userId + ", staffId=" + staffId + "]";
	}

	public UserStaff() {
		super();
	}
	
	

}
