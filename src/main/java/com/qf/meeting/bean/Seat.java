package com.qf.meeting.bean;

import java.io.Serializable;

public class Seat implements Serializable{

	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 7537181410670547409L;

	private Integer seatId;
	
	private String noticeName;
	
	private String noticeTime;
	
	private String noticeAddress;
	
	private String seatNum;
	
	private Integer noticeId;

	public Integer getSeatId() {
		return seatId;
	}

	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}

	public String getNoticeName() {
		return noticeName;
	}

	public void setNoticeName(String noticeName) {
		this.noticeName = noticeName;
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

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	public Integer getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", noticeName=" + noticeName + ", noticeTime=" + noticeTime
				+ ", noticeAddress=" + noticeAddress + ", seatNum=" + seatNum + ", noticeId=" + noticeId + "]";
	}

	public Seat() {
		super();
	}

	

	
	
}
