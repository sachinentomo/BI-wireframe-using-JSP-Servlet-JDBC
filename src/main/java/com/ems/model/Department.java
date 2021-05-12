package com.ems.model;

public class Department {
	private Long dept_id;
	private String dept_code;
	private String dept_name;
	private String dept_desc;
	private String dept_loc;
	private boolean is_active;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String dept_name, String dept_desc, String dept_loc, boolean is_active) {
		super();
		this.dept_name = dept_name;
		this.dept_desc = dept_desc;
		this.dept_loc = dept_loc;
		this.is_active = is_active;
	}
	
	
	
	

	public Department(String dept_name, String dept_desc, String dept_loc) {
		super();
		this.dept_name = dept_name;
		this.dept_desc = dept_desc;
		this.dept_loc = dept_loc;
	}
	
	

	public Department(Long dept_id, String dept_name, String dept_desc, String dept_loc) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.dept_desc = dept_desc;
		this.dept_loc = dept_loc;
	}

	public Department(Long dept_id, String dept_name, String dept_desc, String dept_loc, boolean is_active) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.dept_desc = dept_desc;
		this.dept_loc = dept_loc;
		this.is_active = is_active;
	}

	public Department(Long dept_id, String dept_code, String dept_name, String dept_desc, String dept_loc,
			boolean is_active) {
		super();
		this.dept_id = dept_id;
		this.dept_code = dept_code;
		this.dept_name = dept_name;
		this.dept_desc = dept_desc;
		this.dept_loc = dept_loc;
		this.is_active = is_active;
	}

	public Long getDept_id() {
		return dept_id;
	}

	public void setDept_id(Long dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_code() {
		return dept_code;
	}

	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getDept_desc() {
		return dept_desc;
	}

	public void setDept_desc(String dept_desc) {
		this.dept_desc = dept_desc;
	}

	public String getDept_loc() {
		return dept_loc;
	}

	public void setDept_loc(String dept_loc) {
		this.dept_loc = dept_loc;
	}

	public boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	@Override
	public String toString() {
		return "Department [dept_id=" + dept_id + ", dept_code=" + dept_code + ", dept_name=" + dept_name
				+ ", dept_desc=" + dept_desc + ", dept_loc=" + dept_loc + ", is_active=" + is_active + "]";
	}
	
	
	
}
	