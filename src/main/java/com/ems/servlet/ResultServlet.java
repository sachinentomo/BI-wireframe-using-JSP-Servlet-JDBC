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
import com.ems.dao.ReportDao;
import com.ems.dao.ResultDao;
import com.ems.model.AllDetails;
import com.ems.model.Department;
import com.ems.model.EmployeeByDepartment;
import com.ems.model.EmployeeByJoinDate;
import com.ems.model.EmployeeByProject;
import com.ems.model.TotalCount;
import com.google.gson.Gson;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReportDao reportDao;  
	private ResultDao resultDao;
	private Gson gson = new Gson();
	public void init() {
		reportDao = new ReportDao();
		resultDao = new ResultDao();
	} 
   
    public ResultServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<EmployeeByDepartment> empByDept = null;
		List<EmployeeByProject> empByPrj = null;
		List<AllDetails> allDetails = null;
		List<EmployeeByJoinDate> empByJoin = null;
		try {
			empByDept = reportDao.getEmployeeByDepartment();
			empByPrj = reportDao.getEmployeeByProject();
			allDetails = resultDao.getAllDetails();
			empByJoin = resultDao.getEmployeeByJoin();
			String empByDept1 = this.gson.toJson(empByDept);
			String empByPrj1 = this.gson.toJson(empByPrj);
			String empByJoin1 = this.gson.toJson(empByJoin);
			request.setAttribute("empByDept", empByDept1);
			request.setAttribute("empByPrj", empByPrj1);
			request.setAttribute("allDetails", allDetails);
			request.setAttribute("empByJoin", empByJoin1);
			RequestDispatcher dispatcher = request.getRequestDispatcher("results.jsp");
	        dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
