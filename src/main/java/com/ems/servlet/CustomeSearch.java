package com.ems.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.model.Department;
import com.ems.model.Search;
import com.google.gson.Gson;
import com.ems.dao.CustomeSearchDao;

@WebServlet("/CustomeSearch")
public class CustomeSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private Gson gson = new Gson();
	private CustomeSearchDao customeSearchDao;  
	public void init() {
		customeSearchDao = new CustomeSearchDao();
	}
    public CustomeSearch() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Search> searchResult = null;
		System.out.println("Testing");
		String emp_name = request.getParameter("emp_name");
		String emp_code = request.getParameter("emp_code");
		String dept_name = request.getParameter("dept_name");
		String dept_code = request.getParameter("dept_code");
		String prj_name = request.getParameter("prj_name");
		String prj_code = request.getParameter("prj_code");
		String date_from = request.getParameter("date_from");
		String date_to = request.getParameter("date_to");
		System.out.println("date_from:" + date_from);
		
		
		
		//System.out.println(date_from);
		Search search = new Search(emp_name, emp_code, dept_name, dept_code, prj_name, prj_code, date_from,date_to);
		
		//System.out.println(search);
		Search search1=null;
		try {
			searchResult  = customeSearchDao.getCustomeSearch(search);
			System.out.println("checking the result");
			System.out.println(searchResult);
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String successdata = this.gson.toJson(searchResult); 
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8"); 
		out.print(successdata); 
		out.flush();
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
			doGet(request, response);
		
	}

}
