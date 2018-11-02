package com.qf.meeting.bean;

import java.io.Serializable;
/**
 * 	会议议程
 * @ClassName: Agenda
 * @author: HSK
 * @date:  2018年10月23日 下午5:40:01
 * @Description:TODO
 */
public class Agenda implements Serializable {
	

	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1954573646408746149L;

	private Integer agendaId;
	
	private String noticeName;
	
	private String noticeTime;
	
	private String noticeAddress;
	
	private String agendaDetail;
	
	private Integer noticeId;

	public Integer getAgendaId() {
		return agendaId;
	}

	public void setAgendaId(Integer agendaId) {
		this.agendaId = agendaId;
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

	public String getAgendaDetail() {
		return agendaDetail;
	}

	public void setAgendaDetail(String agendaDetail) {
		this.agendaDetail = agendaDetail;
	}

	public Integer getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	@Override
	public String toString() {
		return "Agenda [agendaId=" + agendaId + ", noticeName=" + noticeName + ", noticeTime=" + noticeTime
				+ ", noticeAddress=" + noticeAddress + ", agendaDetail=" + agendaDetail + ", noticeId=" + noticeId
				+ "]";
	}

	public Agenda(Integer agendaId, String noticeName, String noticeTime, String noticeAddress, String agendaDetail,
			Integer noticeId) {
		super();
		this.agendaId = agendaId;
		this.noticeName = noticeName;
		this.noticeTime = noticeTime;
		this.noticeAddress = noticeAddress;
		this.agendaDetail = agendaDetail;
		this.noticeId = noticeId;
	}

	public Agenda() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
