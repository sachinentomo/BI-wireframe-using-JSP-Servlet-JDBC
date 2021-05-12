package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ems.model.Department;
import com.ems.model.Employee;
import com.ems.model.Project;

public class EmployeeDao {
	private final static Connection con= DatabaseConnection.getConnection();
	private static final String SELECT_ALL_EMP = "select * from employee";
	private static final String SELECT_ALL_ACTIVE_EMP = "select * from employee where is_active=true";
	private static final String INSERT_EMP_SQL = "insert into employee (emp_name, emp_email, emp_username, emp_password, emp_dept, emp_prj, emp_join) values (?, ?, ?, ?, ?, ?, CURDATE())";
	private static final String SELECT_BY_EMP = "select * from employee where emp_id=?";
	private static final String UPDATE_EMP = "update employee set emp_name=?, emp_email=?, emp_username=?, emp_password=?, emp_dept=?, emp_prj=? where emp_id=?";

	
	public List<Employee> getAllActiveEmployees() throws SQLException {
		List<Employee> emp = new ArrayList<>();
		PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_ACTIVE_EMP); 
		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			Long emp_id = rs.getLong("emp_id"); 
			String emp_code = rs.getString("emp_code");
			String emp_name = rs.getString("emp_name");
			String emp_email = rs.getString("emp_email");
			String emp_username = rs.getString("emp_username");
			String emp_password = rs.getString("emp_password");
			Long emp_dept = rs.getLong("emp_dept");
			Long emp_prj = rs.getLong("emp_prj");
			Date emp_join = rs.getDate("emp_join");
			boolean is_active = rs.getBoolean("is_active");
			
			emp.add(new Employee(emp_id, emp_code, emp_name, emp_email, emp_username, emp_password, emp_dept, emp_prj, emp_join, is_active ));
		}
		return emp;
	}
	
	public List<Employee> getAllEmployees() throws SQLException {
		List<Employee> emp = new ArrayList<>();
		PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_EMP); 
		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			Long emp_id = rs.getLong("emp_id"); 
			String emp_code = rs.getString("emp_code");
			String emp_name = rs.getString("emp_name");
			String emp_email = rs.getString("emp_email");
			String emp_username = rs.getString("emp_username");
			String emp_password = rs.getString("emp_password");
			Long emp_dept = rs.getLong("emp_dept");
			Long emp_prj = rs.getLong("emp_prj");
			Date emp_join = rs.getDate("emp_join");
			boolean is_active = rs.getBoolean("is_active");
			
			emp.add(new Employee(emp_id, emp_code, emp_name, emp_email, emp_username, emp_password, emp_dept, emp_prj, emp_join, is_active ));
		}
		return emp;
	}
	
	public Employee getEmpByID(Long id) throws SQLException {
		Employee emp = null;
		PreparedStatement statement = con.prepareStatement(SELECT_BY_EMP);
		statement.setLong(1, id);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			Long emp_id = rs.getLong("emp_id"); 
			String emp_code = rs.getString("emp_code");
			String emp_name = rs.getString("emp_name");
			String emp_email = rs.getString("emp_email");
			String emp_username = rs.getString("emp_username");
			String emp_password = rs.getString("emp_password");
			Long emp_dept = rs.getLong("emp_dept");
			Long emp_prj = rs.getLong("emp_prj");
			Date emp_join = rs.getDate("emp_join");
			boolean is_active = rs.getBoolean("is_active");
			emp = new Employee(emp_id, emp_code, emp_name, emp_email, emp_username, emp_password, emp_dept, emp_prj, emp_join, is_active );
		}
		return emp;
	}

	public Employee insertEmployee(Employee emp)throws SQLException{
		System.out.print("Checking1 it is workling");
		PreparedStatement preparedStatement =con.prepareStatement(INSERT_EMP_SQL, PreparedStatement.RETURN_GENERATED_KEYS); 
		preparedStatement.setString(1, emp.getEmp_name());
		preparedStatement.setString(2, emp.getEmp_email());
		preparedStatement.setString(3, emp.getEmp_username());
		preparedStatement.setString(4, emp.getEmp_pass());
		preparedStatement.setLong(5, emp.getEmp_dept());
		preparedStatement.setLong(6, emp.getEmp_prj());
		//preparedStatement.setBoolean(7, emp.getIs_active());
		Employee inserted;
		System.out.print("Checking2 it is workling");
		int n=preparedStatement.executeUpdate(); 
		System.out.print("Checking3 it is workling");
		System.out.println(n);
		Long id;
		boolean status=n>0;
		if(status)
		{
			ResultSet rs=preparedStatement.getGeneratedKeys();
			if(rs.next()) {
				id=rs.getLong(1);
				String emp_code="EMP"+id;
				PreparedStatement preparedStatement1 =con.prepareStatement("update employee set emp_code=? where emp_id=?;");
				preparedStatement1.setString(1,emp_code);
				preparedStatement1.setLong(2,id);
				preparedStatement1.executeUpdate(); 	
				inserted = getEmpByID(id);
				return inserted;
			}
			
		}
		return null;
		
	}

	public Employee updateEmployee(Employee emp)throws SQLException{
		System.out.println("sql update");
		Employee updated = null;
		PreparedStatement statement = con.prepareStatement(UPDATE_EMP);
		System.out.println(statement);
		statement.setString(1, emp.getEmp_name());
        statement.setString(2, emp.getEmp_email());
        statement.setString(3, emp.getEmp_username());
        statement.setString(4, emp.getEmp_pass());
        statement.setLong(5, emp.getEmp_dept());
        statement.setLong(6, emp.getEmp_prj());
        //statement.setBoolean(7, emp.getIs_active());
        statement.setLong(7, emp.getEmp_id());
        System.out.println(statement);
        System.out.println("sql update finished");
        boolean rowUpdated = statement.executeUpdate() > 0;
        System.out.println(rowUpdated);
        if(rowUpdated) {
        	updated = getEmpByID(emp.getEmp_id());
        	return updated;
        }
       return null;
	}
	
	public void deleteEmployee(Long id) throws SQLException {
		PreparedStatement statement = con.prepareStatement("update employee set is_active=false where emp_id=?");
		statement.setLong(1,id);
		boolean rowUpdated = statement.executeUpdate() > 0;
	}


	
}
