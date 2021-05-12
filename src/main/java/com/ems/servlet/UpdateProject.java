package com.ems.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.ProjectDao;
import com.ems.model.Project;
import com.google.gson.Gson;

@WebServlet("/UpdateProject")
public class UpdateProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private ProjectDao projectDao;  
	
	public void init() {
		projectDao = new ProjectDao();
	}  

    public UpdateProject() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//boolean is_active = Boolean.valueOf(request.getParameter("status"));
		String action = String.valueOf(request.getParameter("action"));
		String action1 = action.replace("\"","");
		System.out.print(action);
		System.out.print(action1);
		Project prj;
		Project inserted;
		if(action1.equals("ADD"))
		{
			String prj_name = request.getParameter("prj_name");
			String prj_desc = request.getParameter("prj_desc");
			prj = new Project(prj_name, prj_desc);
			try {
				inserted = projectDao.insertProject(prj);
				String prjdata = this.gson.toJson(inserted); 
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8"); 
				out.print(prjdata); 
				out.flush();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(action1.equals("UPDATE")) {
			System.out.println("updated() entered");
			String prj_name = request.getParameter("prj_name");
			String prj_desc = request.getParameter("prj_desc");
			Long prj_id = Long.parseLong(request.getParameter("prj_id"));
			prj = new Project(prj_id, prj_name, prj_desc);
			try {
				inserted = projectDao.updateProject(prj);
				String prjdata = this.gson.toJson(inserted); 
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8"); 
				out.print(prjdata); 
				out.flush();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("updated() finished");
		}
		
		if(action1.equals("DELETE"))
		{
			Long prj_id = Long.parseLong(request.getParameter("prj_id"));
			try {
				projectDao.deleteProject(prj_id);
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
