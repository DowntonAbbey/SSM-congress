package com.qf.meeting.service;

import java.util.List;

import com.qf.meeting.bean.Emp;

public interface EmpService {

	// 查找所有员工
	public List<Emp> getList();

	// 通过id查找员工
	public Emp getById(Integer empId);

	// 通过部门id查找员工
	public List<Emp> getByDeptId(Integer deptId);

	// 添加员工
	public int add(Emp emp);

	// 修改员工
	public int update(Emp emp);

	// 通过id删除员工
	public int deleteById(Integer id);

	// 批量删除员工
	public int deleteByIds(List<Integer> ids);
}
