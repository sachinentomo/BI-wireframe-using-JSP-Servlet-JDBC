$(document).ready(function(){
	$( "#search-form" ).on( "submit", function(e) {
    	e.preventDefault();
		var formData = $('#search-form').serialize();
	        $.ajax({
	         	type: "post",
	        	url: "/employeemanagement/CustomeSearch",
	        	dataType: "json",
	        	data : JSON.stringify(formData),
	        	success: function(data) {
	        	console.log(data);
	        	var rows = "";
			    $.each(data, function(i, val) {
			        rows+= "<tr>"
			        rows+= "<td>" + val.emp_name + "</td>";
			        rows+= "<td>" + val.emp_code + "</td>";
			        rows+= "<td>" + val.prj_name + "</td>";
			        rows+= "<td>" + val.prj_code + "</td>";
			        rows+= "<td>" + val.dept_name + "</td>";
			        rows+= "<td>" + val.dept_code + "</td>";
			        rows+= "<td>" + val.date_from + "</td>";
			        rows+= "</tr>";
			    });
			   $('#example #tbody').html(rows);
	        	}
	        });
	});
});