$(document).ready(function(){
	$('.add-project').click(function(){
		$('#save').val('Add');
		$('#save').removeAttr('disabled');
		$('#save').show();
		$('#div1').show();
	   	$('#div2').show();
	   	//$('#div3').show();
     	$('#modal-title').text('Add New Project');
    	$('#update-action').val('ADD'); 
    	$('#validationSummary').hide();
    	$('#project-name').focus();
    	$('#project-id').val('');
    	$('#project-code').val('');
    	$('#project-name').val('');
    	$('#project-description').val('');
    	$("#active").prop("checked", true);
		$('#project-modal').modal('show');	
	});
		    
	function projectOperation(){
		//View Popup
		$("#example").on("click", ".view-project", function(){
			//var prj_id=$(this).parent().data('prj_id');
	     	//var prj_code=$(this).parent().data('prj_code');
	     	var prj_name = $(this).parent().data('prj_name');
	     	var prj_desc = $(this).parent().data('prj_desc');
	     	var is_active = $(this).parent().data('is_active');
			$('#save').hide();
			$('#div1').show();
	   		$('#div2').show();
	   		//$('#div3').show();
	     	$('#modal-title').text('Project Details');
	    	$('#update-action').hide(); 
	    	$('#validationSummary').hide();
	    	$('#project-name').focus();
	    	$('#project-name').val(prj_name);
	    	$('#project-description').val(prj_desc);
	    	$("input[name=status][value=" + is_active + "]").prop('checked', true);
			$('#project-modal').modal('show');	
		});
		
		//Edit Popup
		$("#example").on("click", ".edit-project", function(){
			var prj_id=$(this).parent().data('prj_id');
	     	var prj_code=$(this).parent().data('prj_code');
	     	var prj_name = $(this).parent().data('prj_name');
	     	var prj_desc = $(this).parent().data('prj_desc');
	     	var is_active = $(this).parent().data('is_active');
			$('#save').show();
			$('#save').val('Save Changes');
			$('#save').removeAttr('disabled');
			$('#div1').show();
	   		$('#div2').show();
	     	$('#modal-title').text('Edit Project Details');
	     	$('#update-action').val('UPDATE');
	    	$('#validationSummary').hide();
	    	$('#employee-name').focus();
	    	$('#project-id').val(prj_id);
	    	$('#project-code').val(prj_code);
	    	$('#project-name').val(prj_name);
	    	$('#project-description').val(prj_desc);	
	    	$("input[name=status][value=" + is_active + "]").prop('checked', true);
			$('#project-modal').modal('show');	
		});
		
		$('.delete-project').click(function(){
			var prj_id = $(this).parent().data('prj_id');
	     	$('#div1').hide();
	    	$('#div2').hide();
			$('#save').val('Delete');
			$('#save').removeAttr('disabled');
	     	$('#save').show();
	     	$('#modal-title').text('Delete Project');
	     	$("#confirm-msg").html("<b>Are Sure you want to Delele?</b>");
			$("#confirm-msg").show();
			$('#validationSummary').hide();
	     	$('#project-id').val(prj_id);
	     	$('#update-action').val('DELETE');
			$('#project-modal').modal('show');	
		});
	}
	projectOperation();
		    
	$('#save').click(function(){
		var prj_id = $('#project-id').val();
		var prj_code = $('#project-code').val();
		var prj_name = $('#project-name').val();
		var prj_desc = $('#project-description').val();
		var is_active = $("input[name=status]").val();
		var action = $('#update-action').val();
		var last_id = parseInt($('table tbody tr:last td:first').text());
		if(prj_id=='' && prj_code=='' && action=='ADD')
		{
			$("#validationSummary").attr("class","alert alert-warning");
	        $("#validationSummary").html("<b>Please wait...</b>");
	        $("#validationSummary").show();
	       	var formData = $('#project-form').serialize();
	        $.ajax({
	         	type: "post",
	        	url: "/employeemanagement/UpdateProject",
	        	dataType: "json",
	        	data : JSON.stringify(formData),
	        	success: function(data){
	        		var result = '<tr>';
	        		result+= '<td>'+ (last_id+1) +'</td>';
	        		result+= '<td>'+ data.prj_name + '</td>';
	        		result+= '<td data-prj_id="'+ data.prj_id +'"';
	        		result+= ' data-prj_code="'+ data.prj_code  +'"';
	        		result+= ' data-prj_name="'+ data.prj_name  +'"';
	        		result+= ' data-prj_desc="'+ data.prj_desc  +'"';
	        		result+= '><button role="button" class="btn btn-link view-project" data-modal="project-modal">';
			        result+= '<i class="fas fa-eye text-dark"></i>';
			        result+= '</button>';
			        result+= '<button role="button" class="btn btn-link edit-project">';
			        result+= '<i class="fas fa-pencil-alt text-warning"></i>';
			        result+= '</button>';
		        	result+= '<button role="button" class="btn btn-link delete-project">';
			        result+= '<i class="fas fa-trash text-danger"></i>';
			        result+= '</button>';
	        		result+= '</td>';	
	        		result+= '</tr>';
	        		$('#example').append(result);
	        		projectOperation();
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
		else if(prj_id!=''  && action=='UPDATE' ){
			$("#validationSummary").attr("class","alert alert-warning");
	        $("#validationSummary").html("<b>Please wait...</b>");
	        $("#validationSummary").show();
	       var formData = $('#project-form').serialize();
	        $.ajax({
	         	type: "post",
	        	url: "/employeemanagement/UpdateProject",
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
		if(prj_id!='' && action=='DELETE')
		{
			$("#validationSummary").attr("class","alert alert-warning");
	         	$("#validationSummary").html("<b>Please wait...</b>");
	         	$("#validationSummary").show();
	         $.ajax({
	         	type: "post",
	        	url: "/employeemanagement/UpdateProject",
	        	data: {prj_id:prj_id,action:action},
	        	success: function(data){
	        		$("#confirm-msg").hide();
	        		$("#validationSummary").attr("class","alert alert-success");
	         		$("#validationSummary").html("<b>Deleted Successfully</b>");
	         		$("#validationSummary").show();
	         		$('#save').attr("disabled", "enabled");
	         		$('table tbody tr td[data-prj_id="'+prj_id+'"]').parents('tr').remove();
	         		console.log(data);
	         		}
	 			});
	 	}
	});
});