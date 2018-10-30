package com.qf.meeting.bean.result;

import java.util.ArrayList;
import java.util.List;

public class ListResult<T> extends BaseResult{

	  
	private static final long serialVersionUID = 8694539996071066677L;
	
	private List<T> list = new ArrayList<>();

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public ListResult(Integer state, List<T> list) {
		super(state);
		this.list = list;
	}

	public ListResult() {
		super();
	}

	@Override
	public String toString() {
		return "ListResult [list=" + list + "]";
	}

}
