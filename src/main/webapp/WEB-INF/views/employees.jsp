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
	  

</head>
<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">Employee Management System --></a>

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
  



  
 <div class ="container">
		<div class = "row">
			<h1> List Employees </h1>
		</div>
		
		<div class = "row" >
			<div class = "col-lg-3">
				<a href = "/employees/new" class = "btn btn-primary btn-sm mb-3"> Add Employee</a>
			</div>
			<!-- <div class = "col-lg-3">
				<a href = "/employees/department/1" class = "btn btn-primary btn-sm mb-3"> Dept 1</a>
			</div>
			<div class = "col-lg-3">
				<a href = "/employees/department/2" class = "btn btn-primary btn-sm mb-3"> Dept 2</a>
			</div> -->
		</div>
	<div>	
		<table class = "table table-striped table-bordered" >
			<thead class = "table-dark">
				<tr>
					<th> Employee ID </th>
					<th> Employee First Name </th> 
					<th> Employee Last Name </th>
					<th> Employee Email </th>
					<th> Employee Gender </th>
					<th> Employee Marriage </th>
					<th> Employee Birthday </th>
					<th> Employee Work At </th>
					<th> Employee Department </th>
					<th> Actions </th>
				</tr>
			</thead>
			
			<tbody>
			
			
				<c:forEach var="employee" items="${employees}" >
				<tr>
					<td> ${employee.id} </td>
					<td> ${employee.firstName} </td> 
					<td> ${employee.lastName} </td>
					<td> ${employee.email} </td>
					<td> ${employee.gender} </td>
					<td> ${employee.marriage} </td>
					<td> ${employee.birthday} </td>
					<td> ${employee.workat} </td>
					<td> ${employee.department} </td>
					<td>
						<a href = "/employees/edit/${employee.id}"
						class = "btn btn-primary">Update</a>
						
						<a href = "/employees/${employee.id}"
						class = "btn btn-danger">Delete</a>
					</td>
					<%-- <td>
						<a href = "/employees/edit/{id} (id=${employee.id})"
						class = "btn btn-primary">Update</a>
						
						<a href = "@{/employees/{id} (id=${employee.id})}"
						class = "btn btn-danger">Delete</a>
					</td> --%>
				</tr>
				</c:forEach>
				
				    
			</tbody> 
		</table>
	</div>	
</div>

</body>
</html>