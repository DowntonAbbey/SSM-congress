package com.qf.meeting.bean;

import java.io.Serializable;

public class Emp implements Serializable{

	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = -6930934007545099699L;

	private Integer empId;    //员工的id
   
    private String photo;    //员工的头像
    
    private String empName;   //员工的名字
    
    private String empTel;    //员工的电话
    
    private Dept dept;//部门的id

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpTel() {
		return empTel;
	}

	public void setEmpTel(String empTel) {
		this.empTel = empTel;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", photo=" + photo + ", empName=" + empName + ", empTel=" + empTel + ", dept="
				+ dept + "]";
	}

	public Emp(Integer empId, String photo, String empName, String empTel, Dept dept) {
		super();
		this.empId = empId;
		this.photo = photo;
		this.empName = empName;
		this.empTel = empTel;
		this.dept = dept;
	}

	public Emp() {
		super();
	}

	
}
