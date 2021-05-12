package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ems.model.Department;
import com.ems.model.Search;

public class CustomeSearchDao {
	private final static Connection con= DatabaseConnection.getConnection();
	
	public List<Search> getCustomeSearch(Search search)throws SQLException, ParseException{
		
			List<Search> search1 = new ArrayList<>();
			String query="select e.emp_code,e.emp_name,d.dept_name,d.dept_code,p.prj_name,p.prj_code,e.emp_join from employee e inner join department d ON e.emp_dept=d.dept_id inner join project p on e.emp_prj=p.prj_id where e.is_active=true ";
			System.out.println(search.getEmp_name());
			if(search.getEmp_name()!="")
			{
				System.out.println("entered if statement");
				query = query + " and e.emp_name like '%"+ search.getEmp_name() +"%' "; 
				System.out.println(query);
			}
			
			if(search.getEmp_code()!="")
			{
				System.out.println(search.getEmp_code());
				query = query + " and e.emp_code = '"+ search.getEmp_code() +"' "; 
				System.out.println(query);
			}
			
			if(search.getDept_name()!="")
			{
				System.out.println(search.getDept_name());
				query = query + " and d.dept_name like '%"+ search.getDept_name() +"%'"; 
				System.out.println(query);
			}
			
			if(search.getDept_code()!="")
			{
				System.out.println(search.getDept_code());
				query = query + " and d.dept_code = '"+ search.getDept_code() +"' "; 
				System.out.println(query);
			}
			
			if(search.getPrj_name()!="")
			{
				System.out.println(search.getPrj_name());
				query = query + " and p.prj_name like '%"+ search.getPrj_name() +"%' "; 
				System.out.println(query);
			}
			
			if(search.getPrj_code()!="")
			{
				System.out.println(search.getDept_code());
				query = query + " and p.prj_code = '"+ search.getPrj_code() +"' "; 
				System.out.println(query);
			}
			
			if(search.getDate_from() != null)
			{
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//				Date date_from1 = null;
//				date_from1 = sdf.parse(search.getDate_from());
				System.out.println("Inseide customeSearch" + search.getDate_from());
				query = query + " and e.emp_join >= '"+ search.getDate_from() +"' "; 
				System.out.println(query);
			}
			
			if(search.getDate_to() != null)
			{
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//				Date date_from1 = null;
//				date_from1 = sdf.parse(search.getDate_from());
				System.out.println("Inseide customeSearch" + search.getDate_to());
				query = query + " and e.emp_join <= '"+ search.getDate_to() + "'"; 
				System.out.println(query);
			}
			
			
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				String emp_code = rs.getString("emp_code");
				String emp_name = rs.getString("emp_name"); 
				String dept_code = rs.getString("dept_code");
				String dept_name = rs.getString("dept_name");
				String prj_code = rs.getString("prj_code");
				String prj_name = rs.getString("prj_name");
				String emp_join = rs.getDate("emp_join").toString();
				
				search1.add(new Search(emp_name,emp_code,dept_name,dept_code,prj_name,prj_code,emp_join));
			}
			System.out.println(search1);
			return search1;
			
		}
		
	}


