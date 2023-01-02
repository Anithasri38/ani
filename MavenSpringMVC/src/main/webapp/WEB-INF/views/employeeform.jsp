<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
    rel="stylesheet">
</head>
<body>
  <div class="container">
   <form action="/employeeform"  method="post">
   EmployeeId<input type="text" name="employeeId" /><br>
   EmployeeName<input type="text" name="employeeName" /><br>
   EmployeeDepartment<input type="text" name="employeeDepartment" /><br>
   EmployeeDesignation<input type="text" name="employeeDesignation" /><br>
   EmployeeSalary<input type="text" name="employeeSalary" /><br>
   <input type="submit" value="Add" />
   </form>
  </div>
</body>
</html>