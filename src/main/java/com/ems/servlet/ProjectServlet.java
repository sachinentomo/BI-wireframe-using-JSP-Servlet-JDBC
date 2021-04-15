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

import com.ems.model.Project;
import com.google.gson.Gson;


/**
 * Servlet implementation class DepartmentServlet
 */
@WebServlet("/projectservlet")
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmsDAO emsDAO;
	private Gson gson = new Gson();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		emsDAO = new EmsDAO();
	}
    public ProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action==null)
			action="fetch";
		try {
			switch(action)
			{
			case "fetch":
				fetch(request,response);
				break;
			
			case "edit":
				edit(request,response);
				break;
			case "delete":
				delete(request,response);
				break;
			case "add":
				add(request,response);
				break;
				
			}
		}
		catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void add(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String prj_name = request.getParameter("prj_name");
		String prj_desc = request.getParameter("prj_desc");
		Project prj = new Project(prj_name,prj_desc);
		emsDAO.insertProject(prj);
		
	}
	protected void fetch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<Project> listPrj = emsDAO.selectAllProject();
		
       request.setAttribute("listPrj", listPrj); 
       RequestDispatcher rd = request.getRequestDispatcher("project.jsp");
       rd.forward(request, response);      
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int prj_id=Integer.parseInt(request.getParameter("prj_id"));
		String prj_code=request.getParameter(request.getParameter("prj_code"));
		String prj_name=request.getParameter("prj_name");
		String prj_desc=request.getParameter("prj_desc");
		
		Project prj=new Project(prj_id,prj_code,prj_name,prj_desc);
		emsDAO.updateProject(prj);
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int prj_id=Integer.parseInt(request.getParameter("prj_id"));
		emsDAO.deleteProject(prj_id);
	}
}
