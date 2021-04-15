<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	            	<div class="col-lg-10" >
					    <form class="form-group mb-0">
					        <input class="form-control " type="Search" placeholder="Search items based on ID and Department name" id="searchbox"
					            aria-label="Search">
					    </form>
					</div>

					<div class="col-lg-2">
    					<!-- <button href="#addDepartmentModel" class="btn btn-primary btn-sm" data-toggle="modal">Add New Department </button> -->
    					<a class="btn btn-primary btn-sm add-details"  href="javascript:;" data-modal="department-model">Add New Department</a>
					</div>
					<p>${deptdata}</p>
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
					         
								 <c:forEach items="${deptdata}" var="data">
									<tr>
								    	<td><c:out value="${data.dept_id}" /></td>
								    	<td><c:out value="${data.dept_name}" /></td>
										<td data-dept_id="${data.dept_id}"
											data-dept-code="${data.dept_code}" 
											data-dept_name="${data.dept_name}"
											data-dept_desc="${data.dept_desc}" 
											data-dept_loc="${data.dept_loc}">
											<a  class="btn btn-link show" href="javascript:;" data-modal="department-model">
												<i class="fas fa-eye text-dark"></i>
											</a>
											
											<a  class="btn btn-link edit" href="javascript:;" data-modal="department-model">
												<i class="fas fa-eye text-dark"></i>
											</a>
											
											<a  class="btn btn-link delete" href="javascript:;" data-modal="department-model">
												<i class="fas fa-eye text-dark"></i>
											</a>
								
										</td>
									</tr>
								</c:forEach> 
								 <%-- <c:forEach var="user" items="${listDept}">

										<tr>
											<td><c:out value="${user.dept_id}" /></td>
											<td><c:out value="${user.dept_name}" /></td>
											<td><c:out value="${user.dept_desc}" /></td>
											<td><c:out value="${user.dept_loc}" /></td>
										</tr>
								</c:forEach> --%>
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
	<div id="department-model" class="modal fade">
    		<div class="modal-dialog">
      			<div class="modal-content">
        			<form id="dept-form" method="post">
          				<div class="modal-header">
            				<h4 class="modal-title" id="modal-title">Add Department</h4>
            				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          				</div>
          				
          				<div class="modal-body">
          				
          					<div class='error-msg' id='validationSummary'></div>
							
            				<div class="form-group">
              					<label>Name</label>
              					<input type="text" class="form-control department-name" name="department-name" id="department-name" required>
            				</div>
            				
            				<div class="form-group">
              					<label>Location</label>
              						<select name="department-location" id="department-location" required class="form-control">
              							<option value="">Select Location</option>
              							<option value="Bangalore">Bangalore</option>
              							<option value="Malaysia">Malaysia</option>
              							<option value="USA">USA</option>
              						</select>
            				</div>

							<div class="form-group">
              					<label>Description</label>
              					<textarea class="form-control" name="department-description" id="department-description" required></textarea>
         					</div>
            				
          				</div>
          				
          				<div class="modal-footer">
            				<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
            				<input type="button" class="btn btn-success" value="Add" id="save">
          					<input type="hidden" name="dept_id" id="dept_id" value=""/>
          					<input type="hidden" name="action" value="" id="update_action"/>
          					
          				</div>
        			</form>
      			</div>
    		</div>
  	</div>             
	
     
	<script>
		$(document).ready(function(){
		    showDate(); 
		    setInterval(showDate,1000);
		    show_dept();
		    function showDate(){
		        var time=new Date();
		        var date=time.getDate();
		        var month=time.getMonth()+1;
		        var year=time.getFullYear();
		        var hour=time.getHours();
		        var minutes=time.getMinutes();
		        var second=time.getSeconds();
		        var am_pm='am';
		        if(hour>12)
		        {
		            hour-=12;
		            am_pm='pm';
		        }
		        else
		        {
		            am_pm='am';
		        }
		        //var hour=hour<10?"0"+hour:hour;
		        minutes=minutes<10?"0"+minutes:minutes  ;
		        second=second<10?"0"+second:second  ;
		        let output=date+"/"+month+"/"+year+"    "+hour+":"+minutes+":"+second+" "+am_pm;
		        document.getElementById("date_time").innerHTML=output;
		    } 
		    
		    function show_dept(){
		    	var action="fetch"
		    	$.ajax({
		    		url: 'departmentservlet',
		    		method: 'post',
		    		data: {action:action},
		    		dataType:"json",
		    		success:function(data)
		    		{
		    			
		    			var html='';
		    			$.each(data,function(key,value){
		    				html +='<tr>';
		    			    html +='<td name="dept_id" id="dept_id">'+ value.dept_id + '</td>';
		    			    html +='<td name="dept_name">'+ value.dept_name + '</td>';
		    			    html +='<td data-dept_id="'+ value.dept_id +'" data-dept-code="'+ value.dept_code  +'" data-dept_name="'+ value.dept_name +'" data-dept_desc="'+ value.dept_desc +'" data-dept_loc="'+ value.dept_loc +'"  >';
		    			    html +='<a  class="btn btn-link show" href="javascript:;" data-modal="department-model">';
		    			    html +='<i class="fas fa-eye text-dark"></i>';
		    			    html +='</a>';
		    			    html +='<a  class="btn btn-link edit" href="javascript:;" data-modal="department-model">';
  			     			html +='<i class="fas fa-pencil-alt text-warning"></i>';
  			     			html +='</a>';
  			     			html +='<a  class="btn btn-link delete" href="javascript:;" data-modal="department-model">';
  			     			html +='<i class="fas fa-trash text-danger"></i>';
  			     			html +='</a>';
		    			    html +='</td>';
		    			    html +='</tr>';
		    			  });
		    			$('table tbody').html(html);
		    		}
		    	});
		    }
		    $(document).on('click', '.add-details', function () {
	         	$('#save').val('Add');
	         	$('#modal-title').text('Add New Caste');
	        	$('#update_action').val('ADD'); 		
	         	$('#department-model').modal('show');
	         	$('#validationSummary').hide();
	         	$('.department-name').focus(); 
	         	$('#department-location').val(''); 
	         	$('select option[value=""]').attr('selected',true);
	         	$('department-description').val('');
		    });
		    
		    
		    $(document).on("click", ".show", function () {
	         	var dept_id=$(this).parent().data('dept_id');
	         	var dept_code=$(this).parent().data('dept_code');
	         	var dept_name=$(this).parent().data('dept_name');
	         	var dept_desc=$(this).parent().data('dept_desc');
	         	var $dept_loc=$(this).parent().data('dept_loc');
	         	
	         	$('#department-name').val(dept_name);
	         	$('#department-description').val(dept_desc);
	         	var test="Bangalore";
	         	$("#department-location option[value='"+test+"']").attr('selected', 'selected');
	         	//$("#department-location option:selected").val('Bangalore');
	         	$('#modal-title').text("View Details");
	         	$("#update_action").val("VIEW"); 
	         	$('#department-model').modal('show');
	         	$('#validationSummary').hide();
	         	$('#save').hide(); 		
		    });
		    
		     $(document).on("click", ".edit", function () {
		    	
		    	var dept_id=$(this).parent().data('dept_id');
	         	var dept_code=$(this).parent().data('dept_code');
	         	var dept_name=$(this).parent().data('dept_name');
	         	var dept_desc=$(this).parent().data('dept_desc');
	         	var dept_loc=$(this).parent().data('dept_loc');
	         	$('#department-name').val(dept_name);
	         	$('#department-description').val(dept_desc);
	         	$('#department-location').val(dept_loc);
	         	$('#save').show();
	         	$("#save").val("Update");
	         	$("#modal-title").text("Update Department");
	         	$('#department-model').modal('show');
	         	$("#validationSummary").hide();
	         	$("#department-focus").focus();
	         	
		    }); 
		    
		   
		    
		    $(document).on('click', '.delete', function () {
	         	var myid = $(this).parent().data('dept_id');	    
		    	console.log(myid);
		    });
		    
		    
		    
		    
		    
		    
		    
		    
			/* $('#dept-form').on('submit', function(e){
			alert('hello');
				e.preventDefault();
				$.ajax({
					type:'POST',
					data:$(this).serialize(),
					url:'./adddept',
					success:function(result){
						$("#addDepartmentModel").removeData();
						$('#addDepartmentModel').modal('toggle');
						
					}
				});
			}); */
			
			
			
			
			
		});
	</script>
</body>
</html>