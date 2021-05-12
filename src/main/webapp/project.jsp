<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
					        <input class="form-control " type="Search" placeholder="Search items based on ID and Department name" id="searchbox"
					            aria-label="Search">
					    </form>
					</div>

					<div class="col-lg-2">
    					<button class="btn btn-primary btn-sm add-project" data-modal="project-modal">Add New Project</button>
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
					        	<c:forEach var="data" items="${prjdata}" varStatus="theCount">   
								   <tr>  
								   	<td>${theCount.count}</td>  
								   	<td>${data.prj_name}</td> 
								   	<td data-prj_id="${data.prj_id}"
										data-prj_code="${data.prj_code}" 
											data-prj_name="${data.prj_name}"
											data-prj_desc="${data.prj_desc}"
											data-is_active="${data.is_active}"
											>
					                    <button role="button" class="btn btn-link view-project">
					                        <i class="fas fa-eye text-dark"></i>
					                    </button>
					
					                    <button role="button" class="btn btn-link edit-project">
					                        <i class="fas fa-pencil-alt text-warning"></i>
					                    </button>
					                    <button role="button" class="btn btn-link delete-project">
					                        <i class="fas fa-trash text-danger"></i>
					                    </button>
					                </td>   
								   </tr>  
								</c:forEach> 
								 
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
	
	<div id="project-modal" class="modal fade">
    		<div class="modal-dialog">
      			<div class="modal-content">
        			<form id="project-form">
          				<div class="modal-header">
            				<h4 class="modal-title" id="modal-title">Add New Project</h4>
            				<button type="button" id="old" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          				</div>
          				
          				<div class="modal-body">
          					<div class='error-msg' id='validationSummary'></div>
          					<div  id="confirm-msg"></div>
          					<div class="form-group" style="display:none">
              					<label>lastname</label>
              					<input type="text" class="form-control" name="last_name" id="employee-lastname" required>
            				</div>
            				
            				<div class="form-group" id="div1">
              					<label>Name</label>
              					<input type="text" class="form-control" name="prj_name" id="project-name" required>
            				</div>
            				
            				
            				
            				<div class="form-group" id="div2">
              					<label>Description</label>
              					<textarea class="form-control" name="prj_desc" id="project-description" required></textarea>
         					</div>
         					
         					<div class="form-group" id="div3" style="display:none">
							     <label><b>Status</b></label>
							     <div class="radio">
							        <input id="active" class="status" type="radio" value="true" name="status">
							        <label for="active"><b>Active</b> </label>
							        <input id="inactive" class="status" type="radio" value="false" name="status">
							        <label for="inactive"><b>Inactive </b></label>
							     </div>
							</div>
          				</div>
          				
          				<div class="modal-footer">
          					<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
            				<input type="button" class="btn btn-success" value="Add" id="save">
          					<input type="hidden" name="prj_id" id="project-id" >
          					<input type="hidden" name="prj_code" id="project-code" >
          					<input type="hidden" name="action"  id="update-action"/>
          				</div>
          				
        			</form>
      			</div>
    		</div>
  	     </div>
	
	
    <script src="${pageContext.request.contextPath}/resources/javascript/index.js"></script>
	<script src="${pageContext.request.contextPath}/resources/javascript/project.js"></script>
	
</body>
</html>