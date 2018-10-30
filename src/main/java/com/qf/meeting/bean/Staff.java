package com.qf.meeting.bean;

import java.io.Serializable;

public class Staff implements Serializable{
	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 3463384344965672246L;

	private Integer staffId;
	
	private String staffName;

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Staff(Integer staffId, String staffName) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
	}

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", staffName=" + staffName + "]";
	}
	
	
}
