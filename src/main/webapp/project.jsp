<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
 <%@ include file = "link_file.jsp" %>
  <title>Index file</title>
</head>
<body> 
	<%@ include file = "navbar.jsp" %>
	<div class="container-fluid">
    	<div class="row my-4">
    		<%@ include file = "sidebar.jsp" %>
    		<div class="col-lg-10" id="main_content">
                <div class="row">
                	<div class="col-lg-10">
                	   <form class="form-group mb-0">
        					<input class="form-control " type="Search" placeholder="Search items based on ID and Project name" id="searchbox" aria-label="Search">
    					</form>
					</div>

					<div class="col-lg-2">
					    <button href="#addEmployeeModal" class="btn btn-primary btn-sm" data-toggle="modal">Add New Project</button>
					</div>
					
					<div class="col-lg-12 my-4">
					    <table id="example" class="table table-hover " style="width:100%">
					        <thead>
					            <tr>
					                <th>Sl no</th>
					                <th>Name</th>
					                <th>Action</th>
					            </tr>
					        </thead>
					        <tbody>
					            <tr>
					                <td>1</td>
					                <td>BI Wireframe</td>
					                <td>
					                    <a role="button" class="btn btn-link">
					                        <i class="fas fa-eye text-dark"></i>
					                    </a>
					
					                    <a href="#editEmployeeModal" data-toggle="modal" role="button" class="btn btn-link">
					                        <i class="fas fa-pencil-alt text-warning"></i>
					                    </a>
					                    <a href="#deleteEmployeeModal" data-toggle="modal" role="button" class="btn btn-link">
					                        <i class="fas fa-trash text-danger"></i>
					                    </a>
					                </td>
					            </tr>
					            <tr>
					                <td>2</td>
					                <td>BI Wireframe</td>
					                <td>
					                    <button role="button" class="btn btn-link">
					                        <i class="fas fa-eye text-dark"></i>
					                    </button>
					
					                    <button role="button" class="btn btn-link">
					                        <i class="fas fa-pencil-alt text-warning"></i>
					                    </button>
					                    <button role="button" class="btn btn-link">
					                        <i class="fas fa-trash text-danger"></i>
					                    </button>
					                </td>
					            </tr>
					        </tbody>
					        <tfoot>
					            <tr>
					                <th>Sl no</th>
					                <th>Name</th>
					                <th>Action</th>
					            </tr>
					        </tfoot>
					    </table>
					</div>
					                	
	            </div>
           </div>
          </div>
          <script src="javascript/ems.js">	 
	</script>
         
</body>
</html>