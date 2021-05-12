package com.ems.model;
public class EmployeeByJoinDate {
	int count;
	String emp_join;
	public EmployeeByJoinDate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeByJoinDate(int count, String emp_join) {
		super();
		this.count = count;
		this.emp_join = emp_join;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getEmp_join() {
		return emp_join;
	}
	public void setEmp_join(String emp_join) {
		this.emp_join = emp_join;
	}
	@Override
	public String toString() {
		return "EmployeeByJoinDate [count=" + count + ", emp_join=" + emp_join + "]";
	}
	
	
}
