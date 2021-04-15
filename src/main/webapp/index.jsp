<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>    
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
	                <div class="col-lg-10" >
					    <form class="form-group mb-0">
					        <input class="form-control " type="Search" placeholder="Search items based ID and Employee name" id="searchbox"
					            aria-label="Search">
					    </form>
					</div>
	
					<div class="col-lg-2">
					    <button href="#addEmployeeModal" class="btn btn-primary btn-sm" data-toggle="modal">Add New Employee</button>
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
					            <!-- <tr>
					                <td>1</td>
					                <td>SACHIN M</td>
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
					                <td>ADITYA N</td>
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
					            <tr>
					                <td>3</td>
					                <td>IDRIS</td>
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
					            </tr> -->
				
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
         </div>
         
         
          
         <div id="addEmployeeModal" class="modal fade">
    		<div class="modal-dialog">
      			<div class="modal-content">
        			<form>
          				<div class="modal-header">
            				<h4 class="modal-title">Add Employee</h4>
            				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          				</div>
          				
          				<div class="modal-body">
          				
            				<div class="form-group">
              					<label>Name</label>
              					<input type="text" class="form-control" required>
            				</div>
            				
            				<div class="form-group">
              					<label>Email</label>
              					<input type="email" class="form-control" required>
            				</div>
			
							<div class="form-group">
              					<label>Password</label>
              					<input type="password" class="form-control" required>
            				</div>

							<div class="form-group">
              					<label>Department</label>
              					<select class="custom-select">
								  <option selected>Open this select menu</option>
								  <option value="1">One</option>
								  <option value="2">Two</option>
								  <option value="3">Three</option>
								</select>
            				</div>
            				
            				<div class="form-group">
              					<label>Project</label>
              					<select class="custom-select">
								  <option selected>Open this select menu</option>
								  <option value="1">One</option>
								  <option value="2">Two</option>
								  <option value="3">Three</option>
								</select>
            				</div>
            				
           				 	
           				 	
            				<div class="form-group">
								<div class="form-group pmd-textfield pmd-textfield-floating-label">
									<label class="control-label" for="datetimepicker-default">Select Date and Time</label>
									<input type="text" id="datetimepicker-default" class="form-control" />
								</div>
            				</div>
          				</div>
          				
          				<div class="modal-footer">
            				<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
            				<input type="submit" class="btn btn-success" value="Add">
          				</div>
        			</form>
      			</div>
    		</div>
  	</div>             
	
</body>
</html>