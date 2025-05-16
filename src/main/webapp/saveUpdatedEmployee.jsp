<%@page import="com.employee.entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Employee</title>
<link rel="stylesheet" href="css/editEmployee.css">

</head>
<body>
<%Employee employee=(Employee)request.getAttribute("employee"); %>

<form action="saveUpdatedEmployee" method="post"  >

	<label for="id">Enter Id:</label>
    <input id="id" value=<%=employee.getId() %> type="number" name="id" readonly="true"> <br>

   	<label for="name">Enter Name:</label>
    <input id="name" value=<%=employee.getName() %> type="text" name="name"> <br>
    
    <label for="email">Enter Email:</label>
    <input id="email" value=<%=employee.getEmail() %>  type="email" name="email"> <br>
    
    <label for="dob">Enter DOB:</label>
    <input id="dob" value=<%=employee.getDob() %>  type="date"  name="dob"> <br>
    
    <label for="salary">Enter the Salary:</label>
    <input id="salary" value=<%=employee.getSalary() %>  type="number" name="salary"><br>
    
    <label for="isActive">Is Active</label>
		<label class="switch">
  		<input type="checkbox" id="isActive" name="isActive" value="true">
  		<span class="slider"></span>
	</label>

    <input type="submit" value="Submit" />
    
    
</form>
</body>
</html>