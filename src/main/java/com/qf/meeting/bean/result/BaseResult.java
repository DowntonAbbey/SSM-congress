package com.qf.meeting.bean.result;

import java.io.Serializable;
/**
 * 	结果基础类
 * @ClassName: BaseResult
 * @author: HSK
 * @date:  2018年10月29日 下午8:27:00
 * @Description:TODO
 */
public class BaseResult implements Serializable{

	private static final long serialVersionUID = 4657139470833046263L;
	
	private Integer state;

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "BaseResult [state=" + state + "]";
	}

	public BaseResult(Integer state) {
		super();
		this.state = state;
	}

	public BaseResult() {
		super();
	}

	
	 
	
	
	
}
