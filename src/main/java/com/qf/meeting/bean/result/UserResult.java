package com.qf.meeting.bean.result;

import java.io.Serializable;

import com.qf.meeting.bean.Delegation;
import com.qf.meeting.bean.Staff;
import com.qf.meeting.bean.User;

public class UserResult implements Serializable{

	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 5851019690562644098L;
	
	private User user;
	
	private Staff staff;
	
	private Delegation delegation;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Delegation getDelegation() {
		return delegation;
	}

	public void setDelegation(Delegation delegation) {
		this.delegation = delegation;
	}

	@Override
	public String toString() {
		return "UserResult [user=" + user + ", staff=" + staff + ", delegation=" + delegation + "]";
	}

	public UserResult(User user, Staff staff, Delegation delegation) {
		super();
		this.user = user;
		this.staff = staff;
		this.delegation = delegation;
	}

	public UserResult() {
		super();
	}
	
	

}
