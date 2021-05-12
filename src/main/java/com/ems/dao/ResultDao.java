package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ems.model.AllDetails;
import com.ems.model.Employee;
import com.ems.model.EmployeeByJoinDate;
import com.ems.model.EmployeeByProject;

public class ResultDao {
	private final static Connection con= DatabaseConnection.getConnection();
	private static final String SELECT_ALL_DETAILS = "select e.emp_code, e.emp_name, e.emp_email, d.dept_name, p.prj_name from employee e INNER JOIN department d ON e.emp_dept=d.dept_id INNER JOIN project p ON e.emp_prj=p.prj_id where e.is_active=true;";
	
	public List<AllDetails> getAllDetails() throws SQLException {
		List<AllDetails> allDetails = new ArrayList<>();
		PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_DETAILS); 
		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next())  {
			String emp_code = rs.getString("emp_code");
			String emp_name = rs.getString("emp_name");
			String emp_email = rs.getString("emp_email");
			String dept_name = rs.getString("dept_name");
			String prj_name = rs.getString("prj_name");
			allDetails.add(new AllDetails(emp_code, emp_name, emp_email, dept_name, prj_name));
		}
		return allDetails;
	}
	
	public List<EmployeeByJoinDate> getEmployeeByJoin() throws SQLException {
		String query = "select count(emp_id) as count, emp_join from employee where is_active=true GROUP BY emp_join;";
		List<EmployeeByJoinDate> empByJoin = new ArrayList<>();
		PreparedStatement preparedStatement = con.prepareStatement(query); 
		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			int count = Integer.parseInt(rs.getString("count"));
			String emp_join = rs.getString("emp_join");
			
			empByJoin.add(new EmployeeByJoinDate(count, emp_join));
		}
		
		return empByJoin;
	}

}

