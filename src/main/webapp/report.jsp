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
	            	
	            	<div class="col-lg-6">
	        			<h4 style="background-color: rgb(23, 23, 112); border: black; color:white; text-align: center;">Summary</h4>
	        			<form>
							  <div class="form-group row">
							  	<div class="col-sm 6">
								    <label for="exampleInputEmail1">No of employees</label>
								    
								</div>
								<div class="col-sm 6">
									<input type="text" class="form-control" id="exampleInputEmail1">
								</div>    
							  </div>
							  <div class="form-group row">
	                                <label class="col-sm-6 col-form-label">No. of Departs</label>
	                                <div class="col-sm-6">
	                                    <input type="text" class="form-control" id="">
	                                </div> 
	                            </div>
	                            <div class="form-group row">
	                                <label class="col-sm-6 col-form-label">No. of Projects</label>
	                                <div class="col-sm-6">
	                                    <input type="text" class="form-control" id="">
	                                </div>
	                            </div>
	                        </form>
	    			</div>
	    			<div class="col-lg-6">
	                	<div id="summary_graph"></div>
	                </div>
	            </div>	
	            	
	            <div class="row">	
	            	<div class="col-lg-6" style="">
					<h4 style="background-color: rgb(23, 23, 112); border: black; color:white; text-align: center;">Department Summary</h4>
					<table class="table table-striped table-bordered" style="border-width: 1px solid;">
						<tr>
							<th>Department Name</th>
							<th>Count Of Employees</th>
						</tr>
						<tr>
							<td>jack</td>
							<td>dorsey</td>
						</tr>
					</table>
				</div>
					<div class="col-lg-6" style="">
						<h4 style="background-color: rgb(23, 23, 112); border: black; color:white; text-align: center;">Project Summary</h4>
						<table class="table table-striped table-bordered" style="border-width: 1px solid;">
							<tr>
								<th>Project Name</th>
								<th>Count Of Employees</th>
							</tr>
							<tr>
								<td>doesey</td>
								<td>jack</td>
							</tr>
						</table>
					</div>
	            </div>
	            
	            
	            <div class="row">
	            	<div class="col-lg-12">
					<h4 style="background-color: rgb(23, 23, 112); border: black; color:white; text-align: center;">All Details</h4>
					<table class="table table-striped table-bordered" style="border-width: 1px solid;">
						<tr>
							<th>Employee Name</th>
							<th>Employee Details</th>
							<th>Department Name</th>
							<th>Project Name</th>
						</tr>
						<tr>
							<td>jack</td>
							<td>dorsey</td>
							<td>Devops</td>
							<td>pipeline</td>
						</tr>
						<tr>
							<td>jack</td>
							<td>dorsey</td>
							<td>Devops</td>
							<td>pipeline</td>
						</tr>
					</table>
				</div>
				</div>
				
          </div>
		</div>
	</div>
     
	<script src="javascript/ems.js"></script>
	<script src="javascript/reports_chart.js">	</script>        
</body>
</html>