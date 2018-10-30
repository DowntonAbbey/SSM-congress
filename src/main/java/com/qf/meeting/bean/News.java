package com.qf.meeting.bean;

import java.io.Serializable;

public class News implements Serializable{


	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = -2206182124790980706L;


	private Integer newsId;
	
	private String newsTitle;
	
	private String newsDes;
	
	private String newsDetail;
	
	private Integer type;
	
	private String photo;

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsDes() {
		return newsDes;
	}

	public void setNewsDes(String newsDes) {
		this.newsDes = newsDes;
	}

	public String getNewsDetail() {
		return newsDetail;
	}

	public void setNewsDetail(String newsDetail) {
		this.newsDetail = newsDetail;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public News(Integer newsId, String newsTitle, String newsDes, String newsDetail, Integer type, String photo) {
		super();
		this.newsId = newsId;
		this.newsTitle = newsTitle;
		this.newsDes = newsDes;
		this.newsDetail = newsDetail;
		this.type = type;
		this.photo = photo;
	}

	public News() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", newsTitle=" + newsTitle + ", newsDes=" + newsDes + ", newsDetail="
				+ newsDetail + ", type=" + type + ", photo=" + photo + "]";
	}
	
	
}
