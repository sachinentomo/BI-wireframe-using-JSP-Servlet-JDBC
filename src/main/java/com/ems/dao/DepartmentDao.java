package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ems.model.Department;

public class DepartmentDao {
	private final static Connection con= DatabaseConnection.getConnection();
	private static final String SELECT_ALL_DEPT = "select * from department";
	private static final String SELECT_ALL_ACTIVE_DEPT = "select * from department where is_active=true";
	private static final String INSERT_DEPT_SQL = "insert into department (dept_name, dept_desc, dept_loc) values (?,?,?)";
	private static final String SELECT_BY_DEPT = "select * from department where dept_id=?";
	private static final String UPDATE_DEPT = "update department set dept_name=?, dept_desc=?, dept_loc=?  where dept_id=?";
	
	public List<Department> getAllDepartments() throws SQLException {
		List<Department> dept = new ArrayList<>();
		PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_DEPT); 
		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			Long dept_id = rs.getLong("dept_id"); 
			String dept_code = rs.getString("dept_code");
			String dept_name = rs.getString("dept_name");
			String dept_desc = rs.getString("dept_desc");
			String dept_loc = rs.getString("dept_loc");
			boolean is_active = rs.getBoolean("is_active");
			dept.add(new Department(dept_id, dept_code, dept_name, dept_desc, dept_loc,is_active));
		}
		
		return dept;
	}
	
	public List<Department> getAllActiveDepartments() throws SQLException {
		List<Department> dept = new ArrayList<>();
		PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_ACTIVE_DEPT); 
		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			Long dept_id = rs.getLong("dept_id"); 
			String dept_code = rs.getString("dept_code");
			String dept_name = rs.getString("dept_name");
			String dept_desc = rs.getString("dept_desc");
			String dept_loc = rs.getString("dept_loc");
			boolean is_active = rs.getBoolean("is_active");
			dept.add(new Department(dept_id, dept_code, dept_name, dept_desc, dept_loc,is_active));
		}
		
		return dept;
	}
	
	public Department insertDepartment(Department dept)throws SQLException{
		System.out.print("Checking1 it is workling");
		PreparedStatement preparedStatement =con.prepareStatement(INSERT_DEPT_SQL, PreparedStatement.RETURN_GENERATED_KEYS); 
		preparedStatement.setString(1, dept.getDept_name());
		preparedStatement.setString(2, dept.getDept_desc());
		preparedStatement.setString(3, dept.getDept_loc());
		//preparedStatement.setBoolean(4, dept.getIs_active());
		Department inserted;
		System.out.print("Checking2 it is workling");
		int n=preparedStatement.executeUpdate(); 
		System.out.print("Checking3 it is workling");
		System.out.println(n);
		Long id;
		boolean status=n>0;
		if(status)
		{
			ResultSet rs=preparedStatement.getGeneratedKeys();
			if(rs.next()){
				id=rs.getLong(1);
				String dept_code="DEPT"+id;
				PreparedStatement preparedStatement1 =con.prepareStatement("update department set dept_code=? where dept_id=?;");
				preparedStatement1.setString(1,dept_code);
				preparedStatement1.setLong(2,id);
				preparedStatement1.executeUpdate(); 	
				inserted = getDeptByID(id);
				return inserted;
			}
			
		}
		return null;
		
	}
	
	public Department getDeptByID(Long id) throws SQLException {
		Department dept = null;
		PreparedStatement statement = con.prepareStatement(SELECT_BY_DEPT);
		statement.setLong(1, id);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			Long dept_id = rs.getLong("dept_id");
			String dept_code = rs.getString("dept_code");
			String dept_name = rs.getString("dept_name");
			String dept_desc = rs.getString("dept_desc");
			String dept_loc = rs.getString("dept_loc");
			boolean is_active = rs.getBoolean("is_active");
			dept = new Department(dept_id, dept_code, dept_name, dept_desc, dept_loc, is_active);
		}
		return dept;
	}
	
	public Department updateDepartment(Department dept)throws SQLException{
		System.out.println("sql update");
		Department updated = null;
		PreparedStatement statement = con.prepareStatement(UPDATE_DEPT);
		statement.setString(1, dept.getDept_name());
        statement.setString(2, dept.getDept_desc());
        statement.setString(3, dept.getDept_loc());
        statement.setLong(4, dept.getDept_id());
        System.out.println(statement);
        System.out.println("sql update finished");
        boolean rowUpdated = statement.executeUpdate() > 0;
        System.out.println(rowUpdated);
        if(rowUpdated) {
        	updated = getDeptByID(dept.getDept_id());
        	return updated;
        }
       return null;
	}
	
	public void deleteDepartment(Long id) throws SQLException {
		PreparedStatement statement = con.prepareStatement("update department set is_active=false where dept_id=?");
		statement.setLong(1,id);
		boolean rowUpdated = statement.executeUpdate() > 0;
	}
}
