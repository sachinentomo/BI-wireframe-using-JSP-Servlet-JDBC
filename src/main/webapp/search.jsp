<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                    <div class="col-sm-8">
                    <!--  <form>
                            <div class="form-group row">
                                <div class="col-sm-6 "> 
                                    <input type="text" class="form-control" id="">
                                </div> 
                                <button type="button" class=" btn btn-primary btn-sm text-right" style="background-color: rgb(23, 23, 112); border: black; color:white; text-align: center;">Search</button>
                            </div>
                        </form> 
                        <div class="row">
                            <div class="col-lg-12 container">
                        <h4 style="background-color: rgb(23, 23, 112); border: black; color:white; text-align: center;">Advanced Search</h4><br>
                        </div>
                        </div> -->
                        <form id="search-form" method="post" ENCTYPE="multipart/form-data">
                              <input type="text" class="form-control" name="emp_name1" id="exampleInputEmail1" style="display:none">
                              <div class="form-group row">
                                <div class="col-lg-6">
                                    <label for="exampleInputEmail1">Employee Name</label>
                                </div>
                                <div class="col-lg-6">
                                    <input type="text" class="form-control" name="emp_name" id="exampleInputEmail1">
                                </div>    
                              </div>


                              <div class="form-group row">
                                <div class="col-lg-6">
                                    <label for="exampleInputEmail1">Employee Code</label>
                                    
                                </div>
                                <div class="col-lg-6">
                                    <input type="text" class="form-control" name="emp_code" id="exampleInputEmail1">
                                </div>    
                              </div>


                              <div class="form-group row">
                                <div class="col-lg-6">
                                    <label for="exampleInputEmail1">Department Code</label>
                                    
                                </div>
                                <div class="col-lg-6">
                                    <input type="text" class="form-control" name="dept_code" id="exampleInputEmail1">
                                </div>    
                              </div>


                              <div class="form-group row">
                                <div class="col-lg-6">
                                    <label for="exampleInputEmail1">Department Name</label>
                                    
                                </div>
                                <div class="col-lg-6">
                                    <input type="text" class="form-control" name="dept_name" id="exampleInputEmail1">
                                </div>    
                              </div>



                              <div class="form-group row">
                                <div class="col-lg-6">
                                    <label for="exampleInputEmail1">Project Code</label>
                                    
                                </div>
                                <div class="col-lg-6">
                                    <input type="text" class="form-control" name="prj_code" id="exampleInputEmail1">
                                </div>    
                              </div>


                              <div class="form-group row">
                                <div class="col-lg-6">
                                    <label for="exampleInputEmail1">Project Name</label>
                                    
                                </div>
                                <div class="col-lg-6">
                                    <input type="text" class="form-control" name="prj_name" id="exampleInputEmail1">
                                </div>    
                              </div>

                              <div class="form-group row">
                                <div class="col-lg-6">
                                    <label for="exampleInputEmail1">Join Date from</label>
                                </div>


                                <div class="col-lg-6">
                                    <div class="input-group date" data-provide="datepicker">
                                        <input type="date" name="date_from" class="form-control">
                                    </div>
                                </div>
                              </div>

                              <div class="form-group row">
                                <div class="col-lg-6">
                                    <label for="exampleInputEmail1">Join Date to</label>
                                </div>

                                <div class="col-lg-6">
                                    <div class="input-group date" data-provide="datepicker">
                                        <input type="date" name="date_to" class="form-control">
                                    </div>
                                </div>
                                
                              </div>
                              
                              <div class="form-group row">
                                <div class="col-lg-5">    
                                </div>
                                <div class="col-lg-4">
                                    <button class="form-group btn btn-lg btn-primary search" >Submit</button>
                                </div>
                                <div class="col-lg-3">    
                                </div>    
                              </div>   
                        </form>

                </div> 
          </div>
		</div>
	</div>
	
			<div class="col-lg-12">
						<h4 style="background-color: rgb(23, 23, 112); border: black; color:white; text-align: center;">Advance Search Result</h4>
						<table id="example" class="table table-hover " style="width:100%">
					        <thead>
					            <tr>
					                <th>Employee Name</th>
									<th>Employee Code</th>
									<th>Project Name</th>
									<th>Project Code</th>
									<th>Department Name</th>
									<th>Department Code</th>
									<th>Joined Date</th>
					            </tr>
					        </thead>
					        <tbody id="tbody">
					        
							<tbody>
						</table>
					</div>
	</div>
    <script src="${pageContext.request.contextPath}/resources/javascript/index.js"></script>
     <script src="${pageContext.request.contextPath}/resources/javascript/search.js"></script>         
</body>
</html>