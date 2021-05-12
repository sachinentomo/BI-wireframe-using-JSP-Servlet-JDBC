package com.ems.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
import com.ems.model.Project;
import com.google.gson.Gson;

@WebServlet("/employee")
public class EmployeeSevlet extends HttpServlet {
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

    public EmployeeSevlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> empList = null;
		List<Department> deptList = null;
		List<Project> prjList =null;
		try {
			empList = employeeDao.getAllActiveEmployees();
			request.setAttribute("empList", empList);
			deptList = departmentDao.getAllActiveDepartments();
			request.setAttribute("deptList", deptList);
			prjList = projectDao.getAllActiveProjects();
			request.setAttribute("prjList", prjList);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	        dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
