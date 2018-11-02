/**
 * 
 */
package com.qf.meeting.utils;

import java.util.List;

public class Pager<T, V> {

	private Integer pageIndex;
	private Integer pageCount;
	private Integer totalCount;
	private Integer pageSize;

	private List<T> list;
	private V bean; // 回显实体类

	private long startNum; // 开始序号
	private long endNum; // 结束序号

	public Pager(Integer pageIndex, Integer totalCount, Integer pageSize, Integer pageCount, List<T> list, V bean) {
		super();
		this.pageIndex = pageIndex;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.list = list;
		this.bean = bean;
		this.pageCount = pageCount;

		if (pageCount <= 10) {
			this.startNum = 1;
			this.endNum = pageCount;
		} else {
			// 超过了10个页码
			// 默认显示 前4页 + 当前页 + 后5页
			this.startNum = pageIndex - 4;
			this.endNum = pageIndex + 5;
			if (this.startNum < 1) {
				this.startNum = 1;
				this.endNum = 10;
			}// 如果后面不足5个页码时，则显示后10页
			else if (this.endNum > pageCount) {
				this.endNum = pageCount;
				this.startNum = pageCount - 9;
			}
			if (this.endNum >= pageCount) {
				this.endNum = pageCount;
			}
		}

	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public V getBean() {
		return bean;
	}

	public void setBean(V bean) {
		this.bean = bean;
	}

	public long getStartNum() {
		return startNum;
	}

	public void setStartNum(long startNum) {
		this.startNum = startNum;
	}

	public long getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

}
