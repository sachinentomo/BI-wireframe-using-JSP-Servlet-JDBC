package com.ems.model;

public class Project {
	private Long prj_id;
	private String prj_code;
	private String prj_name;
	private String prj_desc;
	private boolean is_active;
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(String prj_name, String prj_desc, boolean is_active) {
		super();
		this.prj_name = prj_name;
		this.prj_desc = prj_desc;
		this.is_active = is_active;
	}
	
	
	public Project(Long prj_id, String prj_name, String prj_desc, boolean is_active) {
		super();
		this.prj_id = prj_id;
		this.prj_name = prj_name;
		this.prj_desc = prj_desc;
		this.is_active = is_active;
	}
	public Project(Long prj_id, String prj_code, String prj_name, String prj_desc, boolean is_active) {
		super();
		this.prj_id = prj_id;
		this.prj_code = prj_code;
		this.prj_name = prj_name;
		this.prj_desc = prj_desc;
		this.is_active = is_active;
	}
	
	
	public Project(Long prj_id, String prj_code, String prj_name, String prj_desc) {
		super();
		this.prj_id = prj_id;
		this.prj_code = prj_code;
		this.prj_name = prj_name;
		this.prj_desc = prj_desc;
	}
	public Project(String prj_name, String prj_desc) {
		super();
		this.prj_name = prj_name;
		this.prj_desc = prj_desc;
	}
	
	public Project(Long prj_id, String prj_name, String prj_desc) {
		super();
		this.prj_id = prj_id;
		this.prj_name = prj_name;
		this.prj_desc = prj_desc;
	}
	public Long getPrj_id() {
		return prj_id;
	}
	public void setPrj_id(Long prj_id) {
		this.prj_id = prj_id;
	}
	public String getPrj_code() {
		return prj_code;
	}
	public void setPrj_code(String prj_code) {
		this.prj_code = prj_code;
	}
	public String getPrj_name() {
		return prj_name;
	}
	public void setPrj_name(String prj_name) {
		this.prj_name = prj_name;
	}
	public String getPrj_desc() {
		return prj_desc;
	}
	public void setPrj_desc(String prj_desc) {
		this.prj_desc = prj_desc;
	}
	public boolean getIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	
	
}