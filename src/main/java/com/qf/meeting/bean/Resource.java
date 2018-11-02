package com.qf.meeting.bean;

import java.io.Serializable;

public class Resource implements Serializable{

	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 7713165920151747317L;

	private Integer resourceId;
	
	private String noticeName;
	
	private String noticeAddress;
	
	private String resourceDetail;
	
	private Integer noticeId;

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public String getNoticeName() {
		return noticeName;
	}

	public void setNoticeName(String noticeName) {
		this.noticeName = noticeName;
	}

	public String getNoticeAddress() {
		return noticeAddress;
	}

	public void setNoticeAddress(String noticeAddress) {
		this.noticeAddress = noticeAddress;
	}

	public String getResourceDetail() {
		return resourceDetail;
	}

	public void setResourceDetail(String resourceDetail) {
		this.resourceDetail = resourceDetail;
	}

	public Integer getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	@Override
	public String toString() {
		return "Resource [resourceId=" + resourceId + ", noticeName=" + noticeName + ", noticeAddress=" + noticeAddress
				+ ", resourceDetail=" + resourceDetail + ", noticeId=" + noticeId + "]";
	}

	public Resource(Integer resourceId, String noticeName, String noticeAddress, String resourceDetail,
			Integer noticeId) {
		super();
		this.resourceId = resourceId;
		this.noticeName = noticeName;
		this.noticeAddress = noticeAddress;
		this.resourceDetail = resourceDetail;
		this.noticeId = noticeId;
	}

	public Resource() {
		super();
	}
	
	
	
}
