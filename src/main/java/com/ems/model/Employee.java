package com.ems.model;

import java.util.Date;

public class Employee {
	private Long emp_id;
	private String emp_code;
	private String emp_name;
	private String emp_email;
	private String emp_username;
	private String emp_pass;
	private Long emp_dept;
	private Long emp_prj;
	private Date emp_join;
	private boolean is_active;
	
	public Employee() {
		super();
	}

	public Employee(String emp_name, String emp_email, String emp_username, String emp_pass, Long emp_dept,
			Long emp_prj, boolean is_active) {
		super();
		this.emp_name = emp_name;
		this.emp_email = emp_email;
		this.emp_username = emp_username;
		this.emp_pass = emp_pass;
		this.emp_dept = emp_dept;
		this.emp_prj = emp_prj;
		this.is_active = is_active;
	}

	
	public Employee(Long emp_id, String emp_name, String emp_email, String emp_username, String emp_pass, Long emp_dept,
			Long emp_prj, boolean is_active) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_email = emp_email;
		this.emp_username = emp_username;
		this.emp_pass = emp_pass;
		this.emp_dept = emp_dept;
		this.emp_prj = emp_prj;
		this.is_active = is_active;
	}

	public Employee(Long emp_id, String emp_code, String emp_name, String emp_email, String emp_username,
			String emp_pass, Long emp_dept, Long emp_prj, Date emp_join, boolean is_active) {
		super();
		this.emp_id = emp_id;
		this.emp_code = emp_code;
		this.emp_name = emp_name;
		this.emp_email = emp_email;
		this.emp_username = emp_username;
		this.emp_pass = emp_pass;
		this.emp_dept = emp_dept;
		this.emp_prj = emp_prj;
		this.emp_join = emp_join;
		this.is_active = is_active;
	}

	
	public Employee(String emp_name, String emp_email, String emp_username, String emp_pass, Long emp_dept,
			Long emp_prj, Date emp_join) {
		super();
		this.emp_name = emp_name;
		this.emp_email = emp_email;
		this.emp_username = emp_username;
		this.emp_pass = emp_pass;
		this.emp_dept = emp_dept;
		this.emp_prj = emp_prj;
		this.emp_join = emp_join;
	}

	
	public Employee(Long emp_id, String emp_name, String emp_email, String emp_username, String emp_pass, Long emp_dept,
			Long emp_prj, Date emp_join) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_email = emp_email;
		this.emp_username = emp_username;
		this.emp_pass = emp_pass;
		this.emp_dept = emp_dept;
		this.emp_prj = emp_prj;
		this.emp_join = emp_join;
	}

	
	public Employee(Long emp_id, String emp_name, String emp_email, String emp_username,
			String emp_pass, Long emp_dept, Long emp_prj) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_email = emp_email;
		this.emp_username = emp_username;
		this.emp_pass = emp_pass;
		this.emp_dept = emp_dept;
		this.emp_prj = emp_prj;
	}

	public Employee(String emp_name, String emp_email, String emp_username, String emp_pass, Long emp_dept,
			Long emp_prj) {
		super();
		this.emp_name = emp_name;
		this.emp_email = emp_email;
		this.emp_username = emp_username;
		this.emp_pass = emp_pass;
		this.emp_dept = emp_dept;
		this.emp_prj = emp_prj;
	}

	public Long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
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

	public String getEmp_username() {
		return emp_username;
	}

	public void setEmp_username(String emp_username) {
		this.emp_username = emp_username;
	}

	public String getEmp_pass() {
		return emp_pass;
	}

	public void setEmp_pass(String emp_pass) {
		this.emp_pass = emp_pass;
	}

	public Long getEmp_dept() {
		return emp_dept;
	}

	public void setEmp_dept(Long emp_dept) {
		this.emp_dept = emp_dept;
	}

	public Long getEmp_prj() {
		return emp_prj;
	}

	public void setEmp_prj(Long emp_prj) {
		this.emp_prj = emp_prj;
	}

	public Date getEmp_join() {
		return emp_join;
	}

	public void setEmp_join(Date emp_join) {
		this.emp_join = emp_join;
	}

	public boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	
	
	
}