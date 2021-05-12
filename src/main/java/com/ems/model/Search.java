package com.ems.model;

import java.util.Date;

public class Search {
	private String emp_name;
	private String emp_code;
	private String dept_name;
	private String dept_code;
	private String prj_name;
	private String prj_code;
	private String date_from;
	private String date_to;
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Search(String emp_name, String emp_code, String dept_name, String dept_code, String prj_name,
			String prj_code, String date_from, String date_to) {
		super();
		this.emp_name = emp_name;
		this.emp_code = emp_code;
		this.dept_name = dept_name;
		this.dept_code = dept_code;
		this.prj_name = prj_name;
		this.prj_code = prj_code;
		this.date_from = date_from;
		this.date_to = date_to;
	}
	
	
	
	
	
	public Search(String emp_name, String emp_code, String dept_name, String dept_code, String prj_name,
			String prj_code, String date_from) {
		super();
		this.emp_name = emp_name;
		this.emp_code = emp_code;
		this.dept_name = dept_name;
		this.dept_code = dept_code;
		this.prj_name = prj_name;
		this.prj_code = prj_code;
		this.date_from = date_from;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getDept_code() {
		return dept_code;
	}
	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}
	public String getPrj_name() {
		return prj_name;
	}
	public void setPrj_name(String prj_name) {
		this.prj_name = prj_name;
	}
	public String getPrj_code() {
		return prj_code;
	}
	public void setPrj_code(String prj_code) {
		this.prj_code = prj_code;
	}
	public String getDate_from() {
		return date_from;
	}
	public void setDate_from(String date_from) {
		this.date_from = date_from;
	}
	public String getDate_to() {
		return date_to;
	}
	public void setDate_to(String date_to) {
		this.date_to = date_to;
	} 
	
	
	@Override
	public String toString() {
		return "Search [emp_name=" + emp_name + ", emp_code=" + emp_code + ", dept_name=" + dept_name + ", dept_code="
				+ dept_code + ", prj_name=" + prj_name + ", prj_code=" + prj_code + ", date_from=" + date_from
				+ ", date_to=" + date_to + "]";
	}
	
	
}
