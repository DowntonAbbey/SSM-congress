package com.qf.meeting.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class User implements Serializable{
	
	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 3842682791022216577L;

	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   


	private Integer userId;
	
	private String userLoginName;
	
	private String telNum;
	
	private String password;
	
	private String photo;
	
	private String userRealName;
	
	private Delegation delegation;
	
	private List<Staff> staffs = new ArrayList<>();

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public Delegation getDelegation() {
		return delegation;
	}

	public void setDelegation(Delegation delegation) {
		this.delegation = delegation;
	}

	public List<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	public User(Integer userId, String userLoginName, String telNum, String password, String photo, String userRealName,
			Delegation delegation, List<Staff> staffs) {
		super();
		this.userId = userId;
		this.userLoginName = userLoginName;
		this.telNum = telNum;
		this.password = password;
		this.photo = photo;
		this.userRealName = userRealName;
		this.delegation = delegation;
		this.staffs = staffs;
	}

	

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userLoginName=" + userLoginName + ", telNum=" + telNum + ", password="
				+ password + ", photo=" + photo + ", userRealName=" + userRealName + ", delegation=" + delegation
				+ ", staffs=" + staffs + "]";
	}

	public User() {
		super();
	}

	
	
	
	
}
