package com.qf.meeting.bean;

import java.io.Serializable;
/**
 *  通知实体类
 * @ClassName: Notice
 * @author: HSK
 * @date:  2018年10月22日 下午8:43:56
 * @Description:TODO
 */
public class Notice implements Serializable{

	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 5819259773922362663L;
	
	private Integer noticeId; //通知ID
	
	private String noticeTitle; //通知标题
	
	private String noticeTime; //通知时间
	
	private String noticeAddress; //会议地址

	public Integer getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeTime() {
		return noticeTime;
	}

	public void setNoticeTime(String noticeTime) {
		this.noticeTime = noticeTime;
	}

	public String getNoticeAddress() {
		return noticeAddress;
	}

	public void setNoticeAddress(String noticeAddress) {
		this.noticeAddress = noticeAddress;
	}

	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", noticeTitle=" + noticeTitle + ", noticeTime=" + noticeTime
				+ ", noticeAddress=" + noticeAddress + "]";
	}

	public Notice(Integer noticeId, String noticeTitle, String noticeTime, String noticeAddress) {
		super();
		this.noticeId = noticeId;
		this.noticeTitle = noticeTitle;
		this.noticeTime = noticeTime;
		this.noticeAddress = noticeAddress;
	}

	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

}
