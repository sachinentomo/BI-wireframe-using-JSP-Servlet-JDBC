$(document).ready(function(){ 
		//Add Popup
		$('.add-employee').click(function(){
			$('#save').val('Add');
			$('#save').removeAttr('disabled');
			$('#save').show();
			$('#div1').show();
        	$('#div2').show();
        	$('#div3').show();
        	$('#div4').show();
        	$('#div5').show();
        	$('#div6').show();
         	$('#modal-title').text('Add New Employee');
        	$('#update-action').val('ADD'); 
        	$('#validationSummary').hide();
        	$('#employee-name').focus();
        	$('#employee-id').val('');
        	$('#employee-code').val('');
        	$('#employee-name').val('');
        	$('#employee-email').val('');
        	$('#employee-username').val('');
        	$('#employee-password').val('');
        	$('#employee-department').val('');
        	$('#employee-project').val('');
        	$("#active").prop("checked", true);
			$('#employee-modal').modal('show');	
		});
		
		function employeeOperation(){
			//View Popup
			$('.view-employee').click(function(){
				//var emp_id=$(this).parent().data('emp_id');
	         	//var emp_code=$(this).parent().data('emp_code');
	         	var emp_name = $(this).parent().data('emp_name');
	         	var emp_email = $(this).parent().data('emp_email');
	         	var emp_username = $(this).parent().data('emp_username');
	         	var emp_pass = $(this).parent().data('emp_pass');
	         	var emp_dept = $(this).parent().data('emp_dept');
	         	var emp_prj = $(this).parent().data('emp_prj');
	         	var emp_join = $(this).parent().data('emp_join');
	         	var is_active = $(this).parent().data('is_active');
	         	$('#div1').show();
	        	$('#div2').show();
	        	$('#div3').show();
	        	$('#div4').show();
	        	$('#div5').show();
	        	$('#div6').show();
				$('#save').hide();
				$('#save').removeAttr('disabled');
	         	$('#modal-title').text('Employee Details');
	        	$('#update-action').hide(); 
	        	$('#validationSummary').hide();
	        	$('#employee-name').focus();
	        	$('#employee-name').val(emp_name);
	        	$('#employee-email').val(emp_email);
	        	$('#employee-username').val(emp_username);
	        	$('#employee-password').val(emp_pass);
	        	$('#employee-department').val(emp_dept);
	        	$('#employee-project').val(emp_prj);
	        	$("input[name=status][value=" + is_active + "]").prop('checked', true);	
				$('#employee-modal').modal('show');	
			});
			
			//Edit Popup
			$('.edit-employee').click(function(){
				var emp_id = $(this).parent().data('emp_id');
	         	var emp_code = $(this).parent().data('emp_code');
	         	var emp_name = $(this).parent().data('emp_name');
	         	var emp_email = $(this).parent().data('emp_email');
	         	var emp_username = $(this).parent().data('emp_username');
	         	var emp_pass = $(this).parent().data('emp_pass');
	         	var emp_dept = $(this).parent().data('emp_dept');
	         	var emp_prj = $(this).parent().data('emp_prj');
	         	var emp_join = $(this).parent().data('emp_join');
	         	var is_active = $(this).parent().data('is_active');
	         	$('#div1').show();
	        	$('#div2').show();
	        	$('#div3').show();
	        	$('#div4').show();
	        	$('#div5').show();
	        	$('#div6').show();
				$('#save').show();
				$('#save').val('Save Changes');
				$('#save').removeAttr('disabled');
	         	$('#modal-title').text('Edit Employee Details');
	         	$('#update-action').val('UPDATE');
	        	$('#validationSummary').hide();
	        	$('#employee-name').focus();
	        	$('#employee-id').val(emp_id);
	        	$('#employee-code').val(emp_code);
	        	$('#employee-name').val(emp_name);
	        	$('#employee-username').val(emp_username);
	        	$('#employee-email').val(emp_email);
	        	$('#employee-password').val(emp_pass);
	        	$('#employee-department').val(emp_dept);
	        	$('#employee-project').val(emp_prj);
	        	$('#employee-join').val(emp_join);
	        	$("input[name=status][value=" + is_active + "]").prop('checked', true);
				$('#employee-modal').modal('show');	
			});
			$("#example").on("click", ".delete-employee", function(){
				var emp_id = $(this).parent().data('emp_id');
				var delete_parent = $(this).parent().parent();
	         	$('#div1').hide();
	        	$('#div2').hide();
	        	$('#div3').hide();
	        	$('#div4').hide();
	        	$('#div5').hide();
	        	$('#div6').hide();
				$('#save').val('Delete');
				$('#save').removeAttr('disabled');
	         	$('#save').show();
	         	$('#modal-title').text('Delete Employee');
	         	$("#confirm-msg").html("<b>Are Sure you want to Delele?</b>");
		   	    $("#confirm-msg").show();
		   	    $('#validationSummary').hide();
	         	$('#employee-id').val(emp_id);
	         	$('#update-action').val('DELETE');
				$('#employee-modal').modal('show');	
			});
		}
		
		employeeOperation();
		
		$('#save').click(function(){
			var emp_id = $('#employee-id').val();
		 	var emp_code = $('#employee-code').val();
			var emp_name = $('#employee-name').val();
        	var emp_email = $('#employee-email').val();
        	var emp_pass = $('#employee-password').val();
        	var emp_dept = $('#employee-department').val();
        	var emp_prj = $('#employee-project').val();
        	var emp_join = $('#employee-join').val();
        	var is_active = $("input[name=status]").val();
			var action = $('#update-action').val();
			var last_id = parseInt($('table tbody tr:last td:first').text());
        	if(emp_id=='' && emp_code=='' && action=='ADD')
        	{
        		alert("new Employee clicked");
        		$("#validationSummary").attr("class","alert alert-warning");
	   	        $("#validationSummary").html("<b>Please wait...</b>");
	   	        $("#validationSummary").show();
	   	       	var formData = $('#employee-form').serialize();
	   	        $.ajax({
	 	         	type: "post",
	 	        	url: "/employeemanagement/UpdateEmployee",
	 	        	dataType: "json",
	 	        	data : JSON.stringify(formData),
	 	        	success: function(data){
	 	        		var result = '<tr>';
	 	        		result+= '<td>'+ (last_id+1) +'</td>';
	 	        		result+= '<td>'+ data.emp_name + '</td>';
	 	        		result+= '<td data-emp_id="'+ data.emp_id +'"';
	 	        		result+= ' data-emp_code="'+ data.emp_code  +'"';
	 	        		result+= ' data-emp_name="'+ data.emp_name  +'"';
	 	        		result+= ' data-emp_email="'+ data.emp_email  +'"';
	 	        		result+= ' data-emp_username="'+ data.emp_username  +'"';
	 	        		result+= ' data-emp_pass="'+ data.emp_pass  +'"';
	 	        		result+= ' data-emp_dept="'+ data.emp_dept  +'"';
	 	        		result+= ' data-emp_prj="'+ data.emp_prj  +'"';
	 	        		result+= ' data-emp_join="'+ data.emp_join  +'"';
	 	        		result+= ' data-is_active="'+ data.is_active  +'"';
	 	        		result+= '><button role="button" class="btn btn-link view-employee" data-modal="employee-modal">';
				        result+= '<i class="fas fa-eye text-dark"></i>';
				        result+= '</button>';
				        result+= '<button role="button" class="btn btn-link edit-employee">';
				        result+= '<i class="fas fa-pencil-alt text-warning"></i>';
				        result+= '</button>';
			        	result+= '<button role="button" class="btn btn-link delete-employee">';
				        result+= '<i class="fas fa-trash text-danger"></i>';
				        result+= '</button>';
	 	        		result+= '</td>';	
	 	        		result+= '</tr>';
	 	        		$('#example').append(result);
	 	        		employeeOperation();
	 	        		$("#validationSummary").attr("class","alert alert-success");
	 	        		$("#validationSummary").html("<b>Added Successfully</b>");
	 	        		$("#validationSummary").show();
	 	        		$('#save').attr("disabled", "disabled");
	 	        	},
	 	        	error: function(err){
	 	        		$("#validationSummary").attr("class","alert alert-success");
	 	        		$("#validationSummary").html("<b>Someting went wrong! Please try again</b>");
	 	        		$("#validationSummary").show();
	 	        		$('#save').attr("disabled", "disabled");	
	 	        	}
	 	        });
        	}
        	if(emp_id!='' && emp_code!='' && action=='UPDATE' ){
        		alert("edit employee clicked");
        		$("#validationSummary").attr("class","alert alert-warning");
	   	        $("#validationSummary").html("<b>Please wait...</b>");
	   	        $("#validationSummary").show();
	   	       	var formData = $('#employee-form').serialize();
	   	       	console.log(formData);
	   	        $.ajax({
	 	         	type: "post",
	 	        	url: "/employeemanagement/UpdateEmployee",
	 	        	dataType: "json",
	 	        	data : JSON.stringify(formData),
	 	        	success: function(data){
	 	        		$("#validationSummary").attr("class","alert alert-success");
	 	        		$("#validationSummary").html("<b>Edited Successfully</b>");
	 	        		$("#validationSummary").show();
	 	        		$('#save').attr("disabled", "disabled");
	 	        	},
	 	        	error: function(err){
	 	        		$("#validationSummary").attr("class","alert alert-success");
	 	        		$("#validationSummary").html("<b>Something went Wrong! please try again later</b>");
	 	        		$("#validationSummary").show();	
	 	        		$('#save').attr("disabled", "disabled");
	 	        	
	 	        	}
	 	 
		 			}); 
        
        	}
        	if(emp_id!='' && action=='DELETE'){
        		$("#validationSummary").attr("class","alert alert-warning");
	   	         	$("#validationSummary").html("<img src='../img/6.gif' alt='loading'/> <b>Please wait...</b>");
	   	         	$("#validationSummary").show();
	   	         $.ajax({
	 	         	type: "post",
	 	        	url: "/employeemanagement/UpdateEmployee",
	 	        	data: {emp_id:emp_id,action:action},
	 	        	success: function(data){
	 	        		$("#confirm-msg").hide();
	 	        		$("#validationSummary").attr("class","alert alert-success");
	   	         		$("#validationSummary").html("<b>Deleted Successfully</b>");
	   	         		$("#validationSummary").show();
	   	         		$('#save').attr("disabled", "enabled");
	   	         		$('table tbody tr td[data-emp_id="'+emp_id+'"]').parents('tr').remove();
	   	         		console.log(data);
	   	         		
	 	        	}
		 			});
        	}
		});
		
});
		

