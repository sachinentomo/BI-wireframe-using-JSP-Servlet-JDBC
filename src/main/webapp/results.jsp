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
              		<div class="col-lg-12">
                        <h4 style="background-color: rgb(23, 23, 112); border: black; color:white; text-align: center;">Search(Global)</h4><br>
                    </div>    
                    <div class="col-lg-10" >
					    <form class="form-group mb-0">
					        <input class="form-control " type="Search" placeholder="Search items based on ID and Department name" id="searchbox"
					            aria-label="Search">
					    </form>
					</div>
					
						
					
					
					<div class="col-lg-12 my-4">
					    <table id="example" class="table table-hover " style="width:100%">
					        <thead>
					            <tr>
					                <th>Sl no</th>
					                <th>Employee Code</th>
					                <th>Employee Name</th>
					                <th>Email</th>
					                <th>Department Name</th>
					                <th>Project Name</th>
					            </tr>
					        </thead>
					        <tbody>
					        	<c:forEach var="data" items="${allDetails}" varStatus="theCount">   
								   <tr>  
								   	<td>${theCount.count}</td>  
								   	<td>${data.emp_code}</td> 
								    <td>${data.emp_name}</td>
								    <td>${data.emp_email}</td>
								    <td>${data.dept_name}</td>
								    <td>${data.prj_name}</td>
								</c:forEach>
					        </tbody>
					        <tfoot>
					            <tr>
					                <th>Sl no</th>
					                <th>Employee Code</th>
					                <th>Employee Name</th>
					                <th>Email</th>
					                <th>Department Name</th>
					                <th>Project Name</th>
					            </tr>
					        </tfoot>
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
     
	
 	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  	<script src="${pageContext.request.contextPath}/resources/javascript/index.js"></script>
  	<script type="text/javascript">
 	var empByDept = ${empByDept};
 	var empByPrj = ${empByPrj};
 	var empByJoinDate = ${empByJoin};
    google.charts.load("current", {packages:['corechart']});
    google.charts.setOnLoadCallback(function (){
    	drawChart(empByDept);
    	drawChart1(empByPrj);
    	drawBackgroundColor(empByJoinDate);
    	});
    function drawChart(empByDept) {
      	var data = new google.visualization.DataTable();
    	data.addColumn('string','dept_name');
 		data.addColumn('number','count');
 		var dataArray = [];
 		$.each(empByDept, function(i, obj) {
 			dataArray.push([obj.dept_name, obj.count]);
 		});

 		data.addRows(dataArray);

      	var view = new google.visualization.DataView(data);
      	view.setColumns([0, 1]); 

      	var options = {
        	title: "Employees By Department",
        	width: 600,
        	height: 400,
        	bar: {groupWidth: "95%"},
        	legend: { position: "none" },
      	};
      	var chart = new google.visualization.ColumnChart(document.getElementById("employee_department"));
      	chart.draw(view, options);
  }
    function drawChart1(empByPrj) {
    	var data = new google.visualization.DataTable();
      	data.addColumn('string','prj_name');
   		data.addColumn('number','count');
   		var dataArray = [];
   		$.each(empByPrj, function(i, obj) {
   			dataArray.push([obj.prj_name, obj.count]);
   		});
		data.addRows(dataArray);

        var view = new google.visualization.DataView(data);
        view.setColumns([0, 1]); 

        var options = {
          title: "Employees By Project",
          width: 600,
          height: 400,
          bar: {groupWidth: "95%"},
          legend: { position: "none" },
        };
        var chart = new google.visualization.ColumnChart(document.getElementById("employee_project"));
        chart.draw(view, options);
    }
    function drawBackgroundColor(empByJoinDate) {
        var data = new google.visualization.DataTable();
        data.addColumn('date');
        data.addColumn('number','count');
        var dataArray = [];
   		$.each(empByJoinDate, function(i, obj) {
   			console.log(dataArray.push([new Date(obj.emp_join), obj.count]));
   		});
   		data.addRows(dataArray);
		/*data.addRows([
			[new Date('2021-04-10'),4],
		    [new Date('2021-04-11'),3],
		    [new Date('2021-04-12'),10],
		    [new Date('2021-04-13'),8,],
		    [new Date('2021-04-14'),980],
		    [new Date('2021-04-15'),876],
		    [new Date('2021-04-16'),676],
		    [new Date('2021-04-17'),123],
		    [new Date('2021-04-18'),654],
		    [new Date('2021-04-19'),976],
		    [new Date('2021-04-20'),678],
		    [new Date('2021-04-21'),456],
		    [new Date('2021-04-22'),56],
		    [new Date('2021-04-23'),234],
		    [new Date('2021-04-24'),54],
		    [new Date('2021-04-25'),545],
		    [new Date('2021-04-26'),45],
		    [new Date('2021-04-27'),43],
		    [new Date('2021-04-28'),123],
		    [new Date('2021-04-29'),123],
		    [new Date('2021-04-30'),412],
		    [new Date('2021-05-01'),4123],
		    [new Date('2021-05-14'),123],
		    [new Date('2021-06-13'),100]		    
		  ]);*/
        var options = {
				  
				  title: "New Joiner Trend",
		          width: 600,
		          height: 400,
		          hAxis: {
		            title: 'Date',
		            format: 'M/d/yy',
		            gridlines: {count: 2}
		          },
		          vAxis: {
		            title: 'Count'
		          }
        };

        var chart = new google.visualization.LineChart(document.getElementById('new_join'));
        chart.draw(data, options);
      }
  </script>   
</body>
</html>