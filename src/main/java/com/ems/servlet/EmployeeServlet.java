
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
  import com.ems.model.Employee;
  import com.google.gson.Gson;
  
  
  @WebServlet("/employeeservlet") 
  public class EmployeeServlet extends HttpServlet 
  { 
	  private static final long serialVersionUID = 1L; private EmsDAO
	  emsDAO; private Gson gson = new Gson();
	  public void init() { emsDAO = new EmsDAO(); } 
  
	  public EmployeeServlet() {
		  super();  
	  }
    
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  { 
	  String action = request.getParameter("action"); 
	  if(action==null) 
		  action="fetch"; 
	  try {
		  switch(action) { 
		  case "fetch": 
			  fetch(request,response); 
			  break;
		  case "edit": 
			  edit(request,response);
			  break; 
		  case "delete":
			  	delete(request,response); 
			  	break; 
		  case "add": add(request,response); 
		  break; 
		  }
	  	} 
	  catch (ServletException | IOException | SQLException e) { 
		  e.printStackTrace(); 
	  }
  }
  
	private void delete(HttpServletRequest request, HttpServletResponse response) {
	
	
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
	
	
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
			  doGet(request, response); 
	}
		  
	protected void fetch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		/*
		 * List<Employee> listEmp = emsDAO.selectAllEmployees();
		 * request.setAttribute("dd", "hai"); RequestDispatcher rd =
		 * request.getRequestDispatcher("index.jsp"); rd.forward(request, response);
		 */
	}
  }
  
  
  
  
  
  
  
  
  
  
  /*	  String deptdata = this.gson.toJson(listDept); PrintWriter out =
  response.getWriter();

response.setContentType("application/json");
response.setCharacterEncoding("UTF-8"); out.print(deptdata); out.flush();*/

		