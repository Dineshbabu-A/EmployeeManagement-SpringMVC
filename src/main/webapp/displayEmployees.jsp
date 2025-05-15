<%@page import="com.employee.entity.Employee" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Details</title>
<link rel="stylesheet" href="css/displayEmployee.css">
</head>
<body>
<div class="container">
	<%List<Employee> list=(List<Employee>)request.getAttribute("employees"); %>
<h1>Employee Details</h1>
<table>

	<thead>
		<tr>
		
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Date Of Birth</th>
			<th>Age</th>
			<th>Salary</th>
			<th>Status</th>
			
		</tr>
	
	</thead>
	<tbody>
		<%for(Employee employee:list){ %>
		<tr>
			<td><%=employee.getId() %> </td>
			<td><%=employee.getName() %> </td>
			<td><%=employee.getEmail() %> </td>
			<td><%=employee.getDob() %> </td>
			<td><%=employee.getAge() %> </td>
			<td><%=employee.getSalary() %> </td>
			<td><%=employee.getStatus() %> </td>
		</tr>
		<% } %>
	
	</tbody>
	
</table>
<a href="index.jsp">Click Here to retun Home</a>
</div>

</body>
</html>