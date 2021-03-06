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
import com.ems.dao.ProjectDao;
import com.ems.model.Project;
import com.google.gson.Gson;

@WebServlet("/project")
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectDao projectDao;  
	private Gson gson = new Gson();
	
	public void init() {
		projectDao = new ProjectDao();
	}
    
	public ProjectServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Project> prjdata = null;
		try {
			prjdata = projectDao.getAllActiveProjects();
			request.setAttribute("prjdata", prjdata);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("project.jsp");
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
