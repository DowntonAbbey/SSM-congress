package com.qf.meeting.bean;

import java.io.Serializable;

/**
 * 
 * @ClassName: Dept
 * @author: HSK
 * @date: 2018年10月22日 下午8:50:06
 * @Description:部门实体类
 */
public class Dept implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -2708542358317396723L;

	private Integer deptId;
	
	private String deptName;
	
	private String deptDes;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptDes() {
		return deptDes;
	}

	public void setDeptDes(String deptDes) {
		this.deptDes = deptDes;
	}

	public Dept(Integer deptId, String deptName, String deptDes) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptDes = deptDes;
	}

	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", deptName=" + deptName + ", deptDes=" + deptDes + "]";
	}
	
	

}
