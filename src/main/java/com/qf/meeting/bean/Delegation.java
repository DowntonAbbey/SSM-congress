package com.qf.meeting.bean;

import java.io.Serializable;
/**
 * 	代表团实体类
 * @ClassName: Delegation
 * @author: HSK
 * @date:  2018年10月23日 下午5:39:39
 * @Description:TODO
 */
public class Delegation implements Serializable{

	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = -5028658969893065172L;
	
	private Integer delegationId;
	
	private String delegationName;
	
	private String delegationDes;

	public Integer getDelegationId() {
		return delegationId;
	}

	public void setDelegationId(Integer delegationId) {
		this.delegationId = delegationId;
	}

	public String getDelegationName() {
		return delegationName;
	}

	public void setDelegationName(String delegationName) {
		this.delegationName = delegationName;
	}

	public String getDelegationDes() {
		return delegationDes;
	}

	public void setDelegationDes(String delegationDes) {
		this.delegationDes = delegationDes;
	}

	public Delegation() {
		super();
	}

	public Delegation(Integer delegationId, String delegationName, String delegationDes) {
		super();
		this.delegationId = delegationId;
		this.delegationName = delegationName;
		this.delegationDes = delegationDes;
	}

	@Override
	public String toString() {
		return "Delegation [delegationId=" + delegationId + ", delegationName=" + delegationName + ", delegationDes="
				+ delegationDes + "]";
	}
	
	

}
