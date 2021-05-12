package com.ems.model;

public class AllDetails {
	String emp_code;
	String emp_name;
	String emp_email;
	String dept_name;
	String prj_name;
	
	
	
	public AllDetails() {
		super();
		// TODO Auto-generated constructor stub
	}



	public AllDetails(String emp_code, String emp_name, String emp_email, String dept_name, String prj_name) {
		super();
		this.emp_code = emp_code;
		this.emp_name = emp_name;
		this.emp_email = emp_email;
		this.dept_name = dept_name;
		this.prj_name = prj_name;
	}

	

	public String getEmp_code() {
		return emp_code;
	}



	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}



	public String getEmp_name() {
		return emp_name;
	}



	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}



	public String getEmp_email() {
		return emp_email;
	}



	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}



	public String getDept_name() {
		return dept_name;
	}



	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}



	public String getPrj_name() {
		return prj_name;
	}



	public void setPrj_name(String prj_name) {
		this.prj_name = prj_name;
	}



	@Override
	public String toString() {
		return "AllDetails [emp_code=" + emp_code + ", emp_name=" + emp_name + ", emp_email=" + emp_email
				+ ", dept_name=" + dept_name + ", prj_name=" + prj_name + "]";
	}
	
}
