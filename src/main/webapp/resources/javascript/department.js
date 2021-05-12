$(document).ready(function(){
	$('.add-department').click(function(){
		$('#save').val('Add');
		$('#save').removeAttr('disabled');
		$('#save').show();
		$('#div1').show();
	   	$('#div2').show();
	    $('#div3').show();
     	$('#modal-title').text('Add New Department');
    	$('#update-action').val('ADD'); 
    	$('#validationSummary').hide();
    	$('#department-name').focus();
    	$('#department-id').val('');
    	$('#department-code').val('');
    	$('#department-name').val('');
    	$('#department-description').val('');
    	$('#department-location').val('');	
    	$("#active").prop("checked", true);
		$('#department-modal').modal('show');	
	});
		    
	function departmentOperation(){
		//View Popup
		$("#example").on("click", ".view-department", function(){
			//var dept_id=$(this).parent().data('dept_id');
	     	//var dept_code=$(this).parent().data('dept_code');
	     	var dept_name = $(this).parent().data('dept_name');
	     	var dept_desc = $(this).parent().data('dept_desc');
	     	var dept_loc = $(this).parent().data('dept_loc');
	     	var is_active = $(this).parent().data('is_active');
			$('#save').hide();
			$('#div1').show();
	   		$('#div2').show();
	    	$('#div3').show();
	     	$('#modal-title').text('Department Details');
	    	$('#update-action').hide(); 
	    	$('#validationSummary').hide();
	    	$('#department-name').focus();
	    	$('#department-name').val(dept_name);
	    	$('#department-description').val(dept_desc);
	    	$('#department-location').val(dept_loc);
	    	$("input[name=status][value=" + is_active + "]").prop('checked', true);	
			$('#department-modal').modal('show');	
		});
		
		//Edit Popup
		$("#example").on("click", ".edit-department", function(){
			var dept_id=$(this).parent().data('dept_id');
	     	var dept_code=$(this).parent().data('dept_code');
	     	var dept_name = $(this).parent().data('dept_name');
	     	var dept_desc = $(this).parent().data('dept_desc');
	     	var dept_loc = $(this).parent().data('dept_loc');
	     	var is_active = $(this).parent().data('is_active');
			$('#save').show();
			$('#save').val('Save Changes');
			$('#save').removeAttr('disabled');
			$('#div1').show();
	   		$('#div2').show();
	    	$('#div3').show();
	     	$('#modal-title').text('Edit Employee Details');
	     	$('#update-action').val('UPDATE');
	    	$('#validationSummary').hide();
	    	$('#employee-name').focus();
	    	$('#department-id').val(dept_id);
	    	$('#department-code').val(dept_code);
	    	$('#department-name').val(dept_name);
	    	$('#department-description').val(dept_desc);
	    	$('#department-location').val(dept_loc);	
	    	$("input[name=status][value=" + is_active + "]").prop('checked', true);
			$('#department-modal').modal('show');	
		});
		
		$("#example").on("click", ".delete-department", function(){
			var dept_id = $(this).parent().data('dept_id');
	     	$('#div1').hide();
	    	$('#div2').hide();
	    	$('#div3').hide();
			$('#save').val('Delete');
			$('#save').removeAttr('disabled');
	     	$('#save').show();
	     	$('#modal-title').text('Delete Department');
	     	$("#confirm-msg").html("<b>Are Sure you want to Delele?</b>");
			$("#confirm-msg").show();
			$('#validationSummary').hide();
	     	$('#department-id').val(dept_id);
	     	$('#update-action').val('DELETE');
			$('#department-modal').modal('show');	
		});
		
	}
	departmentOperation();
		    
	 $('#save').click(function(){
	 	//alert("success");
		var dept_id = $('#department-id').val();
		var dept_code = $('#department-code').val();
		var dept_name = $('#department-name').val();
		var dept_desc = $('#department-description').val();
		var dept_loc = $('#department-location').val();
		var is_active = $("input[name=status]").val();
		var action = $('#update-action').val();
		var last_id = parseInt($('table tbody tr:last td:first').text());
		if(dept_id=='' && dept_code=='' && action=='ADD')
		{
			$("#validationSummary").attr("class","alert alert-warning");
	        $("#validationSummary").html("<b>Please wait...</b>");
	        $("#validationSummary").show();
	       	var formData = $('#department-form').serialize();
	        $.ajax({
	         	type: "post",
	        	url: "/employeemanagement/UpdateDepartment",
	        	dataType: "json",
	        	data : JSON.stringify(formData),
	        	success: function(data){
	        		var result = '<tr>';
	        		result+= '<td>'+ (last_id+1) +'</td>';
	        		result+= '<td>'+ data.dept_name + '</td>';
	        		result+= '<td data-dept_id="'+ data.dept_id +'"';
	        		result+= ' data-dept_code="'+ data.dept_code  +'"';
	        		result+= ' data-dept_name="'+ data.dept_name  +'"';
	        		result+= ' data-dept_desc="'+ data.dept_desc  +'"';
	        		result+= ' data-dept_loc="'+ data.dept_loc  +'"';
	        		result+= ' data-is_active="'+ data.is_active  +'"';
	        		result+= '><button role="button" class="btn btn-link view-department" data-modal="department-modal">';
			        result+= '<i class="fas fa-eye text-dark"></i>';
			        result+= '</button>';
			        result+= '<button role="button" class="btn btn-link edit-department">';
			        result+= '<i class="fas fa-pencil-alt text-warning"></i>';
			        result+= '</button>';
		        	result+= '<button role="button" class="btn btn-link delete-department">';
			        result+= '<i class="fas fa-trash text-danger"></i>';
			        result+= '</button>';
	        		result+= '</td>';	
	        		result+= '</tr>';
	        		$('#example').append(result);
	        		departmentOperation();
	        		$("#validationSummary").attr("class","alert alert-success");
	        		$("#validationSummary").html("<b>Added Successfully</b>");
	        		$("#validationSummary").show();
	        		$('#save').attr("disabled", "disabled");
	        	}
	        });
	    }
	    if(dept_id!='' && action=='UPDATE')
		{
			$("#validationSummary").attr("class","alert alert-warning");
	        $("#validationSummary").html("<b>Please wait...</b>");
	        $("#validationSummary").show();
	       	var formData = $('#department-form').serialize();
	        $.ajax({
	         	type: "post",
	        	url: "/employeemanagement/UpdateDepartment",
	        	dataType: "json",
	        	data : JSON.stringify(formData),
	        	success: function(data) {
	        		
	           		$("#validationSummary").attr("class","alert alert-success");
	        		$("#validationSummary").html("<b>Edited Successfully</b>");
	        		$("#validationSummary").show();
	        		$('#save').attr("disabled", "disabled");
	        	}
	        });
		}
		
		if(dept_id!='' && action=='DELETE')
		{
			$("#validationSummary").attr("class","alert alert-warning");
	         	$("#validationSummary").html("<b>Please wait...</b>");
	         	$("#validationSummary").show();
	         $.ajax({
	         	type: "post",
	        	url: "/employeemanagement/UpdateDepartment",
	        	data: {dept_id:dept_id,action:action},
	        	success: function(data){
	        		$("#confirm-msg").hide();
	        		$("#validationSummary").attr("class","alert alert-success");
	         		$("#validationSummary").html("<b>Deleted Successfully</b>");
	         		$("#validationSummary").show();
	         		$('#save').attr("disabled", "enabled");
	         		$('table tbody tr td[data-dept_id="'+dept_id+'"]').parents('tr').remove();
	         		console.log(data);
	         		
	        	}
	 			});
		}
	    
    });
  });  
	        