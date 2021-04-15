package com.ems.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ems.model.Department;
import com.ems.model.Employee;
import com.ems.model.Project;

public class EmsDAO {
	private final static Connection con= DatabaseConnection.getConnection();
	private static final String INSERT_DEPT_SQL = "INSERT INTO department" +"  (dept_code, dept_name, dept_desc,dept_loc) VALUES " + " (?, ?, ?, ?);";
	private static final String SELECT_ALL_DEPT = "select * from department";
	private static final String UPDATE_DEPT_SQL ="update department set dept_name= ?, dept_desc =?, dept_loc =? where dept_id = ?;";
	private static final String DELETE_DEPT_SQL = "delete from department where dept_id = ?;";
	
	private static final String INSERT_PRJ_SQL = "INSERT INTO project" + "(prj_code, prj_name, prj_desc) VALUES " + " (?, ?, ?);"; 
	//private static final String SELECT_PRJ_BY_ID ="select prj_id,prj_code,prj_name,prj_desc from project where prj_id =?";
	private static final String SELECT_ALL_PRJ = "select * from project";
	private static final String DELETE_PRJ_SQL = "delete from project where prj_id = ?;";
	private static final String UPDATE_PRJ_SQL ="update project set prj_name= ?, prj_desc =? where prj_id = ?;";
	
	
	private static final String INSERT_EMP_SQL = "insert into employee" + "  (emp_code,emp_name,emp_email,emp_pass,emp_dept,emp_prj,emp_join) VALUES "
			+ " (?, ?, ?, ?, ?, ?, now());";
	private static final String SELECT_EMP_BY_ID = "select emp_id,emp_code,emp_name,emp_email,emp_pass,emp_dept,emp_prj,emp_join from employee where emp_id =?";
	private static final String SELECT_ALL_EMP = "select * from employee";
	private static final String DELETE_EMP_SQL = "delete from employee where emp_id = ?;";
	private static final String UPDATE_EMP_SQL = "update employee set emp_code = ?,emp_name = ?,emp_email = ?,emp_pass = ?,emp_dept = ?,emp_prj = ?,emp_join = ? where emp_id = ?;";
	//Department table 
	
	public boolean insertDepartment(Department dept)throws SQLException{
		PreparedStatement preparedStatement =con.prepareStatement(INSERT_DEPT_SQL, PreparedStatement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1,null); 
		preparedStatement.setString(2, dept.getDept_name());
		preparedStatement.setString(3, dept.getDept_desc());
		preparedStatement.setString(4, dept.getDept_loc());
		int n=preparedStatement.executeUpdate(); 
		boolean status=n>0;
		if(status)
		{
			ResultSet rs=preparedStatement.getGeneratedKeys();
			if(rs.next()){
				int id=rs.getInt(1);
				String dept_code="dept"+id;
				PreparedStatement preparedStatement1 =con.prepareStatement("update department set dept_code=? where dept_id=?;");
				preparedStatement1.setString(1,dept_code);
				preparedStatement1.setInt(2,id);
				preparedStatement1.executeUpdate(); 
			}
			
		}
		
		return status;
	}
	public List<Department> selectAllDepartments() throws SQLException {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Department> dept = new ArrayList<>();
		
		
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_DEPT); 
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int dept_id = rs.getInt("dept_id");
				String dept_code = rs.getString("dept_code");
				String dept_name = rs.getString("dept_name");
				String dept_desc = rs.getString("dept_desc");
				String dept_loc = rs.getString("dept_loc");
				dept.add(new Department(dept_id,dept_code, dept_name, dept_desc, dept_loc));
			}
			return dept;
	}
	public boolean updateDepartment(Department dept) throws SQLException {
		boolean rowUpdated;
			PreparedStatement statement = con.prepareStatement(UPDATE_DEPT_SQL);
			System.out.println("updated USer:"+statement);
			statement.setString(1, dept.getDept_name() );
			statement.setString(2, dept.getDept_desc());
			statement.setString(3, dept.getDept_loc());
			statement.setInt(4, dept.getDept_id());

			rowUpdated = statement.executeUpdate() > 0;
		
		return rowUpdated;
	}
	public boolean deleteDepartment(int dept_id) throws SQLException { 
		boolean rowDeleted; 
		PreparedStatement statement =con.prepareStatement(DELETE_DEPT_SQL);
		statement.setInt(1, dept_id); 
		rowDeleted =statement.executeUpdate() > 0; 
		return rowDeleted; 
	}

	
	//Project Table
	public List<Project> selectAllProject() throws SQLException {
		
		List<Project> prj = new ArrayList<>();
		PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_PRJ); 
		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			int prj_id = rs.getInt("prj_id");
			String prj_code = rs.getString("prj_code");
			String prj_name = rs.getString("prj_name");
			String prj_desc = rs.getString("prj_desc");
			prj.add(new Project(prj_id, prj_code, prj_name, prj_desc));
		}
		return prj;
	}
	public boolean updateProject(Project prj) throws SQLException {
		boolean rowUpdated;
			PreparedStatement statement = con.prepareStatement(UPDATE_PRJ_SQL);
			System.out.println("updated USer:"+statement);
			statement.setString(1, prj.getPrj_name());
			statement.setString(2, prj.getPrj_desc());
			statement.setInt(3, prj.getPrj_id());

			rowUpdated = statement.executeUpdate() > 0;
		
		return rowUpdated;
	}
	public boolean deleteProject(int prj_id) throws SQLException { 
		boolean rowDeleted; 
		PreparedStatement statement =con.prepareStatement(DELETE_PRJ_SQL);
		statement.setInt(1, prj_id); rowDeleted =
		statement.executeUpdate() > 0; 
		return rowDeleted; 
	}
	public boolean insertProject(Project dept)throws SQLException{
		PreparedStatement preparedStatement =con.prepareStatement(INSERT_PRJ_SQL, PreparedStatement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1,null); 
		preparedStatement.setString(2, dept.getPrj_name());
		preparedStatement.setString(3, dept.getPrj_desc());
		int n=preparedStatement.executeUpdate(); 
		boolean status=n>0;
		if(status)
		{
			ResultSet rs=preparedStatement.getGeneratedKeys();
			if(rs.next()){
				int id=rs.getInt(1);
				String prj_code="prj"+id;
				PreparedStatement preparedStatement1 =con.prepareStatement("update project set prj_code=? where prj_id=?;");
				preparedStatement1.setString(1,prj_code);
				preparedStatement1.setInt(2,id);
				preparedStatement1.executeUpdate(); 
			}
			
		}
		
		return status;
	}

	//Employee Table
	/*
	 * public List<Employee> selectAllEmployees() throws SQLException {
	 * List<Employee> emp = new ArrayList<>(); PreparedStatement preparedStatement =
	 * con.prepareStatement(SELECT_ALL_EMP);
	 * //System.out.println(preparedStatement); ResultSet rs =
	 * preparedStatement.executeQuery(); while (rs.next()) { int emp_id =
	 * rs.getInt("emp_id"); String emp_code = rs.getString("emp_code"); String
	 * emp_name = rs.getString("emp_name"); String emp_email =
	 * rs.getString("emp_email"); String emp_pass = rs.getString("emp_pass"); int
	 * emp_dept = rs.getInt("emp_dept"); int emp_prj = rs.getInt("emp_prj"); Date d
	 * = rs.getDate("emp_join"); emp.add(new Employee(emp_id, emp_code, emp_name,
	 * emp_email, emp_pass, emp_dept, emp_prj, d)); } return emp; }
	 */

	
	
}