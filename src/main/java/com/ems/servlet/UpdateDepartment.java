package com.ems.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ems.dao.DepartmentDao;
import com.ems.model.Department;
import com.google.gson.Gson;

@WebServlet("/UpdateDepartment")
public class UpdateDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private DepartmentDao departmentDao;  
	public void init() {
		departmentDao = new DepartmentDao();
	}
	 	
    
    public UpdateDepartment() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Department details");
		//ArrayList<Department> listDept = new ArrayList<Department>();
		//Long dept_id = Long.parseLong(request.getParameter("dept_id"));
		
		//boolean is_active = Boolean.valueOf(request.getParameter("status"));
		String action = String.valueOf(request.getParameter("action"));
		String action1 = action.replace("\"","");
		System.out.print(action1);
		Department dept;
		Department inserted;
		if(action1.equals("ADD"))
		{
			String dept_name = request.getParameter("dept_name");
			String dept_desc = request.getParameter("dept_desc");
			String dept_loc = request.getParameter("dept_loc");
			dept = new Department(dept_name, dept_desc, dept_loc);
			try {
				inserted = departmentDao.insertDepartment(dept);
				String deptdata = this.gson.toJson(inserted); 
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8"); 
				out.print(deptdata); 
				out.flush();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(action1.equals("UPDATE")) {
			System.out.println("updated() entered");
			String dept_name = request.getParameter("dept_name");
			String dept_desc = request.getParameter("dept_desc");
			String dept_loc = request.getParameter("dept_loc");
			Long dept_id = Long.parseLong(request.getParameter("dept_id"));
			dept = new Department(dept_id, dept_name, dept_desc, dept_loc);
			try {
				inserted = departmentDao.updateDepartment(dept);
				String deptdata = this.gson.toJson(inserted); 
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8"); 
				out.print(deptdata); 
				out.flush();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("updated() finished");
		}
		System.out.println("Testing");
		if(action1.equals("DELETE"))
		{
			Long dept_id = Long.parseLong(request.getParameter("dept_id"));
			try {
				departmentDao.deleteDepartment(dept_id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
