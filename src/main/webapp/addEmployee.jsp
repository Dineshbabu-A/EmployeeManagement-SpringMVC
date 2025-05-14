<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee Details</title>
<link rel="stylesheet" href="css/addEmployee.css">

</head>
<body>

<form action="addEmployee" method="post"  modelAttribute="employee">

   	<label for="name">Enter Name:</label>
    <input id="name" placeholder="Enter the Name" type="text" name="name"> <br>
    
    <label for="email">Enter Email:</label>
    <input id="email" placeholder="Enter the Email" type="email" name="email"> <br>
    
    <label for="dob">Enter DOB:</label>
    <input id="dob" placeholder="Enter the DOB" type="date"  name="dob"> <br>
    
    <label for="salary">Enter the Salary:</label>
    <input id="salary" placeholder="Enter the Salary" type="number" name="salary"><br>
    
    <label for="isActive">Is Active</label>
		<label class="switch">
  		<input type="checkbox" id="isActive" name="isActive" value="true">
  		<span class="slider"></span>
	</label>

    <input type="submit" value="Submit" />
    
    
</form>
</body>
</html>