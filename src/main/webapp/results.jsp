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
                    <div class="col-sm-12">
                        <h4 style="background-color: rgb(23, 23, 112); border: black; color:white; text-align: center;">Search(Global)</h4><br>
                        <div class="col-sm-12 text-right">
                            <button type="button" class=" btn btn-primary btn-sm text-right" style="background-color: rgb(23, 23, 112); border: black; color:white; text-align: center; width: 15%">Search</button>
                        </div>
                        <table class="table table-striped table-bordered" style="border-width: 1px solid;">
                            <tr>
                                <th>Sl.No</th>
                                <th>Emp.code</th>
                                <th>Emp.name</th>
                                <th>Email</th>
                                <th>Dept.Name</th>
                                <th>Project Name</th>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>emp-1</td>
                                <td>jack</td>
                                <td>jack@email.com</td>
                                <td>BI</td>
                                <td>clone app</td>
                            </tr>
                            
                        </table>

                    </div>
                </div>
            <div class="row">
                <div class="col-sm-6">
                    <div id="employee_department"></div>
                </div>

                <div class="col-sm-6">
                    <div id="employee_project"></div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-10" >
                    <div id="new_join"></div>
                </div>
            </div>
          </div>
		</div>
	</div>
     
	<script src="javascript/ems.js"></script>
 	<script src="javascript/reports_chart.js"></script>
 	<script type="text/javascript">
 	Highcharts.chart('employee_department',	{
 		xAxis:	{
 			categories:	['No. of Employees', 'No. of Departments', 'No. of Projects']		
 		},
 		
 		series: [
 			{
 				name: 'John',
 				data: [1,2,3]
 			},
 			{
 				name: 'Jane',
 				data: [2,4,8]
 			}
 		]  
 		
 	});

 	Highcharts.chart('employee_project',	{
 		xAxis:	{
 			categories:	['No. of Employees', 'No. of Departments', 'No. of Projects']		
 		},
 		
 		series: [
 			{
 				name: 'John',
 				data: [1,2,3]
 			},
 			{
 				name: 'Jane',
 				data: [2,4,8]
 			}
 		]  
 		
 	});

 	Highcharts.chart('new_join',	{
 		xAxis:	{
 			categories:	['No. of Employees', 'No. of Departments', 'No. of Projects']		
 		},
 		
 		series: [
 			{
 				name: 'John',
 				data: [1,2,3]
 			},
 			{
 				name: 'Jane',
 				data: [2,4,8]
 			}
 		]  
 		
 	});
 	</script>         
</body>
</html>