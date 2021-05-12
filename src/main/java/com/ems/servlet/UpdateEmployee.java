package com.ems.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.DepartmentDao;
import com.ems.dao.EmployeeDao;
import com.ems.dao.ProjectDao;
import com.ems.model.Department;
import com.ems.model.Employee;
import com.google.gson.Gson;


@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao employeeDao;
	private DepartmentDao departmentDao;
	private ProjectDao projectDao;
	private Gson gson = new Gson();
	public void init() {
		employeeDao = new EmployeeDao();
		departmentDao = new DepartmentDao();
		projectDao = new ProjectDao();
	}
 
    public UpdateEmployee() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = String.valueOf(request.getParameter("action"));
		String action1 = action.replace("\"","");
		System.out.print(action1);
		Employee emp;
		Employee inserted;
		if(action1.equals("ADD"))
		{
			String emp_name = request.getParameter("emp_name");
			String emp_email = request.getParameter("emp_email");
			String emp_username = request.getParameter("emp_username");
			String emp_pass = request.getParameter("emp_pass");
			Long emp_dept = Long.parseLong(request.getParameter("emp_dept"));
			Long emp_prj = Long.parseLong(request.getParameter("emp_prj"));
			//boolean is_active = Boolean.valueOf(request.getParameter("statu
			emp = new Employee(emp_name, emp_email, emp_username, emp_pass, emp_dept, emp_prj);
			try {
				inserted = employeeDao.insertEmployee(emp);
				String empdata = this.gson.toJson(inserted); 
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8"); 
				out.print(empdata); 
				out.flush();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(action1.equals("UPDATE")) {
			String emp_name = request.getParameter("emp_name");
			String emp_email = request.getParameter("emp_email");
			String emp_username = request.getParameter("emp_username");
			System.out.println("USername:" + emp_username);
			String emp_pass = request.getParameter("emp_pass");
			Long emp_dept = Long.parseLong(request.getParameter("emp_dept"));
			Long emp_prj = Long.parseLong(request.getParameter("emp_prj"));
			//boolean is_active = Boolean.valueOf(request.getParameter("statu
			Long emp_id = Long.parseLong(request.getParameter("emp_id"));
			emp = new Employee(emp_id, emp_name, emp_email, emp_username, emp_pass, emp_dept, emp_prj);
			try {
				inserted = employeeDao.updateEmployee(emp);
				String empdata = this.gson.toJson(inserted); 
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8"); 
				out.print(empdata); 
				out.flush();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("updated() finished");
		}
		
		if(action1.equals("DELETE"))
		{
			Long emp_id = Long.parseLong(request.getParameter("emp_id"));
			try {
				employeeDao.deleteEmployee(emp_id);
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
