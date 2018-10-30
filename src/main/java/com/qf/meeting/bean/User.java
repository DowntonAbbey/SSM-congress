package com.qf.meeting.bean;

import java.io.Serializable;


public class User implements Serializable{
	
	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = -5238360899448629315L;

	private Integer userId;
	
	private String userLoginName;
	
	private String telNum;
	
	private String password;
	
	private String photo;
	
	private String userRealName;
	
	private Integer delegationId;

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

	public Integer getDelegationId() {
		return delegationId;
	}

	public void setDelegationId(Integer delegationId) {
		this.delegationId = delegationId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userLoginName=" + userLoginName + ", telNum=" + telNum + ", password="
				+ password + ", photo=" + photo + ", userRealName=" + userRealName + ", delegationId=" + delegationId
				+ "]";
	}

	public User(Integer userId, String userLoginName, String telNum, String password, String photo, String userRealName,
			Integer delegationId) {
		super();
		this.userId = userId;
		this.userLoginName = userLoginName;
		this.telNum = telNum;
		this.password = password;
		this.photo = photo;
		this.userRealName = userRealName;
		this.delegationId = delegationId;
	}

	public User() {
		super();
	}
	
	
	
}
