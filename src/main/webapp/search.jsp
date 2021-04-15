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
                    <div class="col-sm-8">
                     <form>
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
                        </div>
                        <form>
                              <div class="form-group row">
                                <div class="col-lg-6">
                                    <label for="exampleInputEmail1">Employee Name</label>
                                    
                                </div>
                                <div class="col-lg-6">
                                    <input type="text" class="form-control" id="exampleInputEmail1">
                                </div>    
                              </div>


                              <div class="form-group row">
                                <div class="col-lg-6">
                                    <label for="exampleInputEmail1">Employee Code</label>
                                    
                                </div>
                                <div class="col-lg-6">
                                    <input type="text" class="form-control" id="exampleInputEmail1">
                                </div>    
                              </div>


                              <div class="form-group row">
                                <div class="col-lg-6">
                                    <label for="exampleInputEmail1">Department Code</label>
                                    
                                </div>
                                <div class="col-lg-6">
                                    <input type="text" class="form-control" id="exampleInputEmail1">
                                </div>    
                              </div>


                              <div class="form-group row">
                                <div class="col-lg-6">
                                    <label for="exampleInputEmail1">Department Name</label>
                                    
                                </div>
                                <div class="col-lg-6">
                                    <input type="text" class="form-control" id="exampleInputEmail1">
                                </div>    
                              </div>



                              <div class="form-group row">
                                <div class="col-lg-6">
                                    <label for="exampleInputEmail1">Project Code</label>
                                    
                                </div>
                                <div class="col-lg-6">
                                    <input type="text" class="form-control" id="exampleInputEmail1">
                                </div>    
                              </div>


                              <div class="form-group row">
                                <div class="col-lg-6">
                                    <label for="exampleInputEmail1">Project Name</label>
                                    
                                </div>
                                <div class="col-lg-6">
                                    <input type="text" class="form-control" id="exampleInputEmail1">
                                </div>    
                              </div>

                              <div class="form-group row">
                                <div class="col-lg-6">
                                    <label for="exampleInputEmail1">Join Date from</label>
                                    
                                </div>


                                <div class="col-lg-6">
                                    <div class="input-group date" data-provide="datepicker">
                                        <input type="date" class="form-control">
                                    </div>
                                </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-lg-6">
                                    <label for="exampleInputEmail1">Join Date to</label>
                                </div>

                                <div class="col-lg-6">
                                    <div class="input-group date" data-provide="datepicker">
                                        <input type="date" class="form-control">
                                    </div>
                                </div>
                                
                                </div>
                                <div class="form-group row">
                                <div class="col-lg-5">    
                                </div>
                                <div class="col-lg-4">
                                    <button class="form-group btn btn-lg btn-primary">Submit</button>
                                </div>
                                <div class="col-lg-3">    
                                </div>    
                              </div>

                              </div>


                        </form>

                </div> 
          </div>
		</div>
	</div>
     
	<script src="javascript/ems.js"></script>
           
</body>
</html>