package com.ems.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.EmsDAO;
import com.ems.model.Department;
import com.google.gson.Gson;

/**
 * Servlet implementation class DepartmentServlet
 */
@WebServlet("/departmentservlet")
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmsDAO emsDAO;
	private Gson gson = new Gson();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init() {
		emsDAO = new EmsDAO();
	}

	public DepartmentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null)
			action = "fetch";
		try {
			switch (action) {
			case "fetch":
				fetch(request, response);
				break;

			case "edit":
				edit(request, response);
				break;
			case "delete":
				delete(request, response);
				break;
			case "add":
				add(request, response);
				break;
			}
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void fetch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		List<Department> listDept = emsDAO.selectAllDepartments();
		
		  String deptdata = this.gson.toJson(listDept); PrintWriter out =
		  response.getWriter();
		  
		  response.setContentType("application/json");
		  response.setCharacterEncoding("UTF-8"); 
		  out.print(deptdata); 
		  out.flush();
		 
		/*
		 * request.setAttribute("listDept", listDept); RequestDispatcher rd =
		 * request.getRequestDispatcher("department.jsp"); rd.forward(request,
		 * response);
		 */
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int dept_id = Integer.parseInt(request.getParameter("dept_id"));
		String dept_code = request.getParameter(request.getParameter("dept_code"));
		String dept_name = request.getParameter("dept_name");
		String dept_desc = request.getParameter("dept_desc");
		String dept_loc = request.getParameter("dept_loc");

		Department dept = new Department(dept_id, dept_code, dept_name, dept_desc, dept_loc);
		emsDAO.updateDepartment(dept);
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int dept_id = Integer.parseInt(request.getParameter("dept_id"));
		emsDAO.deleteDepartment(dept_id);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String dept_name = request.getParameter("dept_name");
		String dept_desc = request.getParameter("dept_desc");
		String dept_loc = request.getParameter("dept_loc");
		Department dept = new Department(dept_name, dept_desc, dept_loc);
		emsDAO.insertDepartment(dept);
		// response.sendRedirect("list");

	}
}
