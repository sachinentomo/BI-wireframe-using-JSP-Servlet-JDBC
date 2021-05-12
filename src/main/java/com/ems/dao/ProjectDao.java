package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ems.model.Project;

public class ProjectDao {
	private final static Connection con= DatabaseConnection.getConnection();
	private static final String SELECT_ALL_PRJ = "select * from project";
	private static final String SELECT_ALL_ACTIVE_PRJ = "select * from project where is_active=true";
	private static final String INSERT_PRJ_SQL = "insert into project (prj_name, prj_desc) values (?,?)";
	private static final String SELECT_BY_PRJ = "select * from project where prj_id=?";
	private static final String UPDATE_PRJ = "update project set prj_name=?, prj_desc=? where prj_id=?";
	
	public List<Project> getAllProjects() throws SQLException {
		List<Project> prj = new ArrayList<>();
		PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_PRJ); 
		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			Long prj_id = rs.getLong("prj_id"); 
			String prj_code = rs.getString("prj_code");
			String prj_name = rs.getString("prj_name");
			String prj_desc = rs.getString("prj_desc");
			boolean is_active = rs.getBoolean("is_active");
			prj.add(new Project(prj_id, prj_code, prj_name, prj_desc,is_active));
		}
		
		return prj;
	}

	public List<Project> getAllActiveProjects() throws SQLException {
		List<Project> prj = new ArrayList<>();
		PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_ACTIVE_PRJ); 
		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			Long prj_id = rs.getLong("prj_id"); 
			String prj_code = rs.getString("prj_code");
			String prj_name = rs.getString("prj_name");
			String prj_desc = rs.getString("prj_desc");
			boolean is_active = rs.getBoolean("is_active");
			prj.add(new Project(prj_id, prj_code, prj_name, prj_desc,is_active));
		}
		
		return prj;
	}
	
	public Project insertProject(Project prj)throws SQLException{
		System.out.print("Checking1 it is workling");
		PreparedStatement preparedStatement =con.prepareStatement(INSERT_PRJ_SQL, PreparedStatement.RETURN_GENERATED_KEYS); 
		preparedStatement.setString(1, prj.getPrj_name());
		preparedStatement.setString(2, prj.getPrj_desc());
		//preparedStatement.setBoolean(3, prj.getIs_active());
		Project inserted;
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
				String prj_code="PRJ"+id;
				PreparedStatement preparedStatement1 =con.prepareStatement("update project set prj_code=? where prj_id=?;");
				preparedStatement1.setString(1,prj_code);
				preparedStatement1.setLong(2,id);
				preparedStatement1.executeUpdate(); 	
				inserted = getPrjByID(id);
				return inserted;
			}
			
		}
		return null;
		
	}
	
	public Project getPrjByID(Long id) throws SQLException {
		 Project prj = null;
		PreparedStatement statement = con.prepareStatement(SELECT_BY_PRJ);
		statement.setLong(1, id);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			Long prj_id = rs.getLong("prj_id");
			String prj_code = rs.getString("prj_code");
			String prj_name = rs.getString("prj_name");
			String prj_desc = rs.getString("prj_desc");
			boolean is_active = rs.getBoolean("is_active");
			prj = new Project(prj_id, prj_code, prj_name, prj_desc, is_active);
		}
		return prj;
	}
	
	public Project updateProject(Project prj)throws SQLException{
		System.out.println("sql update");
		Project updated = null;
		PreparedStatement statement = con.prepareStatement(UPDATE_PRJ);
		statement.setString(1, prj.getPrj_name());
        statement.setString(2, prj.getPrj_desc());
        //statement.setBoolean(3, prj.getIs_active());
        statement.setLong(3, prj.getPrj_id());
        System.out.println(statement);
        System.out.println("sql update finished");
        boolean rowUpdated = statement.executeUpdate() > 0;
        System.out.println(rowUpdated);
        if(rowUpdated) {
        	updated = getPrjByID(prj.getPrj_id());
        	return updated;
        }
       return null;
	} 	
	
	
	public void deleteProject(Long id) throws SQLException {
		PreparedStatement statement = con.prepareStatement("update project set is_active=false where prj_id=?");
		statement.setLong(1,id);
		boolean rowUpdated = statement.executeUpdate() > 0;
	}

	
	
	
}
