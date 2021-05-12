package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ems.model.EmployeeByDepartment;
import com.ems.model.EmployeeByProject;
import com.ems.model.Project;
import com.ems.model.TotalCount;

public class ReportDao {
	private final static Connection con= DatabaseConnection.getConnection();
	
	public List<TotalCount> getTotalCount() throws SQLException {
		String query = "SELECT (SELECT COUNT(emp_id) FROM   employee where is_active=true) AS emp_count, (SELECT COUNT(dept_id) FROM   department where is_active=true) AS dept_count, (SELECT count(prj_id) FROM project where is_active=true) AS prj_count FROM dual;";
		List<TotalCount> totalCount = new ArrayList<>();
		PreparedStatement preparedStatement = con.prepareStatement(query); 
		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			int emp_count = Integer.parseInt(rs.getString("emp_count"));
			int dept_count = Integer.parseInt(rs.getString("dept_count"));
			int prj_count = Integer.parseInt(rs.getString("prj_count"));
			totalCount.add(new TotalCount(emp_count,dept_count,prj_count));
		}
		
		return totalCount;
	}
	
	public List<EmployeeByDepartment> getEmployeeByDepartment() throws SQLException {
		String query = "select count(emp_id) as count, d.dept_name from department d LEFT OUTER JOIN employee e ON d.dept_id=e.emp_dept where e.is_active=true AND d.is_active=true group by d.dept_name;";
		List<EmployeeByDepartment> empByDept = new ArrayList<>();
		PreparedStatement preparedStatement = con.prepareStatement(query); 
		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			int count = Integer.parseInt(rs.getString("count"));
			String dept_name = rs.getString("dept_name");
			
			empByDept.add(new EmployeeByDepartment(dept_name,count));
		}
		
		return empByDept;
	}
	
	public List<EmployeeByProject> getEmployeeByProject() throws SQLException {
		String query = "select count(emp_id) as count, p.prj_name from project p LEFT OUTER JOIN employee e ON p.prj_id=e.emp_prj where e.is_active=true AND p.is_active=true group by p.prj_name ;";
		List<EmployeeByProject> empByPrj = new ArrayList<>();
		PreparedStatement preparedStatement = con.prepareStatement(query); 
		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			int count = Integer.parseInt(rs.getString("count"));
			String prj_name = rs.getString("prj_name");
			
			empByPrj.add(new EmployeeByProject(prj_name,count));
		}
		
		return empByPrj;
	}
	
	

		
}