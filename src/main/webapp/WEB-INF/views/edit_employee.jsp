<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" 
	  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
	  integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
	  crossorigin="anonymous">

<style type="text/css">
	span {
		color: red;
		font-style: italic;
	}
	option {
  margin: 0.5em;
}
</style>

<style type="text/css">
	/* a:active {
		color: white;
	}
	a:visited {
		color: blue;
	} */
	a {
		display: blue;
	}
</style>

<style type="text/css">
	label {
		display: inline-block;
		width: 200px;
		margin: 5px;
		text-align: left;
	}
	
	button {
		padding: 10px;
		margin: 10px;
	}
</style>
</head>
<body>
</head>
<body>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">Employee Management System</a>

  <!-- Toggler/collapsibe Button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  <!-- Navbar links -->
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="changeable" href = "/employees">Employee Management</a> 
      </li>
    </ul>
  </div>
  </nav>
  
 <br>
<br>
	
	<div class = "container">
		<div class = "row">
			<div class = "col-lg-6 col-md-6 col-sm-6 container justify-content-center-center card">
				<h1 class = "text-center"> Update Employee </h1>
				<div class = "card-body" >
					<form:form action="/employees/${employee.id}" method="POST" modelAttribute="employee">
						
						<form:label path="firstName">Employee First Name</form:label>
						<form:input path="firstName" type="text" field="*{firstName}" placeholder = "Enter Employee First Name"/> <br>
					
						<form:label path="lastName">Employee Last Name</form:label>
						<form:input path="lastName" type="text" field="*{lastName}" placeholder = "Enter Employee Last Name"/> <br>
					
						<form:label path="email">Employee Email</form:label>
						<form:input path="email" type="text" field="*{email}" placeholder = "Enter Employee Email"/> <br>
						
						<form:label path="gender">Employee Gender</form:label>
						<form:radiobutton path="gender"  field="*{gender}" value="Male"/>Male
						<form:radiobutton path="gender"  field="*{gender}" value="Female"/>Female <br>
						
						<form:label path="marriage">Employee Married?</form:label>
						<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.3/jquery.min.js"></script>
						<form:checkbox path="marriage" class="selectOnly" field="*{marriage}" value="Married"/>Married
						<form:checkbox path="marriage" class="selectOnly" field="*{marriage}" value="Un-Married"/>Un-Married
						<script type="text/javascript">
							$('.selectOnly').on('change', function() {
								$('.selectOnly').not(this).prop('checked', false);
							});
							</script> <br>
							
						<form:label path="birthday">Employee birthday</form:label>
						<form:input path="birthday" type="date" field="*{birthday.id}" /> <br>
						
						
						<form:label path="workat">Employee Company</form:label>
						<form:select path="workat">
						<form:option value="">--SELECT COMPANY--</form:option>
                     
                        <c:forEach var="row" items="${workatdropdown}">
                      	<form:option value="${row.id}">${row.CompanyName}</form:option>
            
    				  </c:forEach>
                       </form:select>
						
						
						<form:label path="department">Employee Department</form:label>
						<select name="department" id="department">
						<option>--SELECT DEPARTMENT--</option>
						</select>
						
						<script>
							$(document).ready(function() {
								$('#workat').change(
	        						function() {
	           							 $.getJSON("http://localhost:8086/employees/departments/"+$(this).val()
	            								, function(data) {
	            	
	                						var html = '<option value="">--SELECT DEPARTMENT--</option>';
	                						var len = data.length;
	                						for ( var i = 0; i < len; i++) {
	                    						html += '<option value="' + data[i].id + '">'
	                            						+ data[i].DepartmentName + '</option>';
	               						 }
	               						 html += '</option>';
	                					 $('#department').html(html);
	               						 //alert("h"+data[0].departmentname);
	          					  });
	        				});
   						 });
						</script>
					
					
						<div class = "box-footer">
							<form:button type="submit" class = "btn btn-primary">Submit</form:button>
				 		</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
 



</body>
</html>