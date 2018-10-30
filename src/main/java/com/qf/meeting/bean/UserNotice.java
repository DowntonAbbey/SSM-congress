package com.qf.meeting.bean;

import java.io.Serializable;

public class UserNotice implements Serializable{

	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 5676822716722892213L;
	
	private Integer id;
	
	private Integer userId;
	
	private Integer noticeId;

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

	public Integer getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	public UserNotice(Integer id, Integer userId, Integer noticeId) {
		super();
		this.id = id;
		this.userId = userId;
		this.noticeId = noticeId;
	}

	public UserNotice() {
		super();
	}

	@Override
	public String toString() {
		return "User_Notice [id=" + id + ", userId=" + userId + ", noticeId=" + noticeId + "]";
	}
	
	
	
}
